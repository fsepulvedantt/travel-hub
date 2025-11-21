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
                idViajeIda, // Mantener compatibilidad con idViaje
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

    @DELETE
    @Path("/{idReserva}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteReserva(@PathParam("idReserva") long idReserva) {
        try {
            // Obtener la reserva para recuperar el idViaje antes de eliminarla
            Reserva reserva = _reservaLocalService.getReserva(idReserva);
            long idViaje = reserva.getIdViaje();
            
            // Eliminar la reserva
            _reservaLocalService.deleteReserva(idReserva);
            
            // Incrementar los asientos disponibles del viaje (cancelación)
            _viajeLocalService.incrementarAsientos(idViaje);
            
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
        dto.setIdViaje(reserva.getIdViaje());
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
