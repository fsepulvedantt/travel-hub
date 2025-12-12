package com.ntt.travelhub.reserva.rest.application;

import com.ntt.travelhub.reserva.rest.dto.ReservaDTO;
import com.ntt.travelhub.reserva.model.Reserva;
import com.ntt.travelhub.reserva.service.ReservaLocalService;
import com.ntt.travelhub.viaje.service.ViajeLocalService;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@Component(
    property = {
        JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/reservas",
        JaxrsWhiteboardConstants.JAX_RS_NAME + "=Reserva.Rest",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
    },
    service = Application.class
)
public class ReservaRestApplication extends Application {

    public Set<Object> getSingletons() {
        return Collections.<Object>singleton(this);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReserva(ReservaDTO reservaDTO) {
        try {
            long idViajeIda = reservaDTO.getIdViajeIda();
            long idViajeVuelta = reservaDTO.getIdViajeVuelta();
            String tipoReserva = reservaDTO.getTipoReserva();
            
            // Log para debugging
            System.out.println("📥 Recibiendo reserva:");
            System.out.println("  🔹 Tipo de reserva: " + tipoReserva);
            System.out.println("  🔹 ID Viaje Ida: " + idViajeIda);
            System.out.println("  🔹 ID Viaje Vuelta: " + idViajeVuelta);
            System.out.println("  🔹 Origen: " + reservaDTO.getOrigen());
            System.out.println("  🔹 Destino: " + reservaDTO.getDestino());
            
            // Verificar asientos disponibles para viaje de ida
            if (!_viajeLocalService.tieneAsientosDisponibles(idViajeIda)) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"error\": \"No hay asientos disponibles para el viaje de ida\"}").build();
            }
            
            // Si es ida y vuelta, verificar también el viaje de vuelta
            if ("IDA_VUELTA".equals(tipoReserva) && idViajeVuelta > 0) {
                if (!_viajeLocalService.tieneAsientosDisponibles(idViajeVuelta)) {
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity("{\"error\": \"No hay asientos disponibles para el viaje de vuelta\"}").build();
                }
            }
            
            ServiceContext serviceContext = new ServiceContext();
            serviceContext.setCompanyId(20097L);
            serviceContext.setScopeGroupId(20124L);
            serviceContext.setUserId(0L);
            
            // Crear la reserva con ambos viajes
            Reserva reserva = _reservaLocalService.createReserva(
                reservaDTO.getOrigen(),
                reservaDTO.getDestino(),
                reservaDTO.getFechaSalida(),
                reservaDTO.getFechaLlegada(),
                reservaDTO.getMail(),
                reservaDTO.getDni(),
                reservaDTO.getNombre() != null ? reservaDTO.getNombre() : "",
                idViajeIda,
                idViajeVuelta,
                tipoReserva,
                serviceContext
            );
            
            // Decrementar asientos del viaje de ida
            _viajeLocalService.decrementarAsientos(idViajeIda);
            
            // Si es ida y vuelta, decrementar también el viaje de vuelta
            if ("IDA_VUELTA".equals(tipoReserva) && idViajeVuelta > 0) {
                _viajeLocalService.decrementarAsientos(idViajeVuelta);
            }
            
            // Log de confirmación
            System.out.println("✅ Reserva creada exitosamente:");
            System.out.println("  🔹 ID Reserva: " + reserva.getReservaId());
            System.out.println("  🔹 ID Viaje Ida guardado: " + reserva.getIdViajeIda());
            System.out.println("  🔹 ID Viaje Vuelta guardado: " + reserva.getIdViajeVuelta());
            System.out.println("  🔹 Tipo Reserva guardado: " + reserva.getTipoReserva());
            
            ReservaDTO response = mapToDTO(reserva);
            return Response.status(Response.Status.CREATED).entity(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Path("/{idReserva}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReserva(@PathParam("idReserva") long idReserva) {
        try {
            Reserva reserva = _reservaLocalService.getReserva(idReserva);
            ReservaDTO response = mapToDTO(reserva);
            return Response.ok(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Reserva not found\"}").build();
        }
    }

    @GET
    @Path("/buscar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarReserva(
            @QueryParam("codigo") String codigo,
            @QueryParam("dni") String dni) {
        try {
            if (codigo == null || dni == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("{\"error\": \"Se requiere código y DNI\"}").build();
            }

            // Buscar por código usando el LocalService
            Reserva reserva = _reservaLocalService.fetchByCodigoReserva(codigo);
            
            if (reserva == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("{\"error\": \"No se encontró ninguna reserva con ese código\"}").build();
            }

            // Verificar que el DNI coincida
            if (!dni.equals(reserva.getDni())) {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity("{\"error\": \"El DNI no coincide con la reserva\"}").build();
            }

            ReservaDTO response = mapToDTO(reserva);
            return Response.ok(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @DELETE
    @Path("/{idReserva}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteReserva(@PathParam("idReserva") long idReserva) {
        try {
            // Obtener la reserva para recuperar los IDs de viaje antes de eliminarla
            Reserva reserva = _reservaLocalService.getReserva(idReserva);
            long idViajeIda = reserva.getIdViajeIda();
            long idViajeVuelta = reserva.getIdViajeVuelta();
            
            // Eliminar la reserva
            _reservaLocalService.deleteReserva(idReserva);
            
            // Incrementar los asientos disponibles del viaje de ida (cancelación)
            _viajeLocalService.incrementarAsientos(idViajeIda);
            
            // Si tenía viaje de vuelta, también incrementar esos asientos
            if (idViajeVuelta > 0) {
                _viajeLocalService.incrementarAsientos(idViajeVuelta);
            }
            
            return Response.ok("{\"message\": \"Reserva deleted successfully\"}").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }

    private ReservaDTO mapToDTO(Reserva reserva) {
        ReservaDTO dto = new ReservaDTO();
        dto.setReservaId(reserva.getReservaId());
        dto.setOrigen(reserva.getOrigen());
        dto.setDestino(reserva.getDestino());
        dto.setFechaSalida(reserva.getFechaSalida());
        dto.setFechaLlegada(reserva.getFechaLlegada());
        dto.setMail(reserva.getMail());
        dto.setDni(reserva.getDni());
        dto.setNombre(reserva.getNombre());
        dto.setCodigoReserva(reserva.getCodigoReserva());
        dto.setIdViajeIda(reserva.getIdViajeIda());
        dto.setIdViajeVuelta(reserva.getIdViajeVuelta());
        dto.setTipoReserva(reserva.getTipoReserva());
        return dto;
    }

    @Reference
    private ReservaLocalService _reservaLocalService;
    
    @Reference
    private ViajeLocalService _viajeLocalService;
}
