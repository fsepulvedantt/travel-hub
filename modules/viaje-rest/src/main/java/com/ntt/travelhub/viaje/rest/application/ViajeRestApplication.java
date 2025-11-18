package com.ntt.travelhub.viaje.rest.application;

import com.ntt.travelhub.viaje.rest.dto.ViajeDTO;
import com.ntt.travelhub.viaje.model.Viaje;
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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component(
    property = {
        JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/viajes",
        JaxrsWhiteboardConstants.JAX_RS_NAME + "=Viaje.Rest",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
    },
    service = Application.class
)
public class ViajeRestApplication extends Application {

    public Set<Object> getSingletons() {
        return Collections.<Object>singleton(this);
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getViajes() {
        try {
            List<Viaje> viajes = _viajeLocalService.getViajes(-1, -1);
            List<ViajeDTO> response = viajes.stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
            return Response.ok(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @GET
    @Path("/{idViaje}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getViaje(@PathParam("idViaje") long idViaje) {
        try {
            Viaje viaje = _viajeLocalService.getViaje(idViaje);
            ViajeDTO response = mapToDTO(viaje);
            return Response.ok(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Viaje not found\"}").build();
        }
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createViaje(ViajeDTO viajeDTO) {
        try {
            ServiceContext serviceContext = new ServiceContext();
            serviceContext.setCompanyId(20097L); // Ajustar según tu instalación
            serviceContext.setScopeGroupId(20124L); // Ajustar según tu instalación
            serviceContext.setUserId(0L);
            
            // Usar el método personalizado que genera IDs únicos
            Viaje viaje = _viajeLocalService.createViaje(
                viajeDTO.getOrigen(),
                viajeDTO.getDestino(),
                viajeDTO.getFechaSalida(),
                viajeDTO.getFechaLlegada(),
                viajeDTO.getEmpresa(),
                viajeDTO.getPrecio(),
                viajeDTO.getAsientosDisponibles(),
                serviceContext
            );
            
            ViajeDTO response = mapToDTO(viaje);
            return Response.status(Response.Status.CREATED).entity(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @PUT
    @Path("/{idViaje}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateViaje(@PathParam("idViaje") long idViaje, ViajeDTO viajeDTO) {
        try {
            Viaje viaje = _viajeLocalService.getViaje(idViaje);
            
            viaje.setOrigen(viajeDTO.getOrigen());
            viaje.setDestino(viajeDTO.getDestino());
            viaje.setFechaSalida(viajeDTO.getFechaSalida());
            viaje.setFechaLlegada(viajeDTO.getFechaLlegada());
            viaje.setEmpresa(viajeDTO.getEmpresa());
            viaje.setPrecio(viajeDTO.getPrecio());
            viaje.setAsientosDisponibles(viajeDTO.getAsientosDisponibles());
            
            viaje = _viajeLocalService.updateViaje(viaje);
            
            ViajeDTO response = mapToDTO(viaje);
            return Response.ok(response).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }

    @DELETE
    @Path("/{idViaje}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteViaje(@PathParam("idViaje") long idViaje) {
        try {
            _viajeLocalService.deleteViaje(idViaje);
            return Response.ok("{\"message\": \"Viaje deleted successfully\"}").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"error\": \"" + e.getMessage() + "\"}").build();
        }
    }

    private ViajeDTO mapToDTO(Viaje viaje) {
        ViajeDTO dto = new ViajeDTO();
        dto.setViajeId(viaje.getViajeId());
        dto.setOrigen(viaje.getOrigen());
        dto.setDestino(viaje.getDestino());
        dto.setFechaSalida(viaje.getFechaSalida());
        dto.setFechaLlegada(viaje.getFechaLlegada());
        dto.setEmpresa(viaje.getEmpresa());
        dto.setPrecio(viaje.getPrecio());
        dto.setAsientosDisponibles(viaje.getAsientosDisponibles());
        return dto;
    }

    @Reference
    private ViajeLocalService _viajeLocalService;
}
