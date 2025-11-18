package com.ntt.travelhub.reserva.rest.application;

import com.ntt.travelhub.reserva.rest.dto.ReservaDTO;
import com.ntt.travelhub.reserva.model.Reserva;
import com.ntt.travelhub.reserva.service.ReservaLocalService;
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
            ServiceContext serviceContext = new ServiceContext();
            serviceContext.setCompanyId(20097L); // Ajustar según tu instalación
            serviceContext.setScopeGroupId(20124L); // Ajustar según tu instalación
            serviceContext.setUserId(0L);
            
            // Usar el método personalizado que genera IDs únicos
            Reserva reserva = _reservaLocalService.createReserva(
                reservaDTO.getOrigen(),
                reservaDTO.getDestino(),
                reservaDTO.getFechaSalida(),
                reservaDTO.getFechaLlegada(),
                reservaDTO.getMail(),
                reservaDTO.getDni(),
                reservaDTO.getIdViaje(),
                serviceContext
            );
            
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
            _reservaLocalService.deleteReserva(idReserva);
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
        return dto;
    }

    @Reference
    private ReservaLocalService _reservaLocalService;
}
