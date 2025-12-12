# Métodos Personalizados del Service Builder

Después de ejecutar `.\gradlew buildService`, se generarán las implementaciones base. Si deseas agregar métodos personalizados más robustos, sigue estos pasos:

## Ubicación de los archivos de implementación

Después de ejecutar `buildService`, encontrarás estos archivos:

```
modules/reserva/reserva-service/src/main/java/com/ntt/travelhub/reserva/service/impl/
├── ReservaLocalServiceImpl.java
└── ReservaServiceImpl.java

modules/viaje/viaje-service/src/main/java/com/ntt/travelhub/viaje/service/impl/
├── ViajeLocalServiceImpl.java
└── ViajeServiceImpl.java
```

## Método personalizado para ReservaLocalServiceImpl.java

Agrega este método en `ReservaLocalServiceImpl.java`:

```java
package com.ntt.travelhub.reserva.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.ntt.travelhub.reserva.model.Reserva;
import com.ntt.travelhub.reserva.service.base.ReservaLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;

@Component(
	property = "model.class.name=com.ntt.travelhub.reserva.model.Reserva",
	service = AopService.class
)
public class ReservaLocalServiceImpl extends ReservaLocalServiceBaseImpl {

	/**
	 * Crea una nueva reserva con los datos proporcionados
	 */
	public Reserva createReserva(
			String origen, String destino, Date fechaSalida, Date fechaLlegada,
			String mail, String dni, long idViaje, ServiceContext serviceContext)
			throws PortalException {

		// Generar ID usando el counter
		long reservaId = counterLocalService.increment();

		// Crear la entidad
		Reserva reserva = reservaPersistence.create(reservaId);

		// Setear campos de auditoría
		reserva.setGroupId(serviceContext.getScopeGroupId());
		reserva.setCompanyId(serviceContext.getCompanyId());
		reserva.setUserId(serviceContext.getUserId());
		reserva.setUserName(serviceContext.getUserName());
		reserva.setCreateDate(new Date());
		reserva.setModifiedDate(new Date());

		// Setear campos de negocio
		reserva.setOrigen(origen);
		reserva.setDestino(destino);
		reserva.setFechaSalida(fechaSalida);
		reserva.setFechaLlegada(fechaLlegada);
		reserva.setMail(mail);
		reserva.setDni(dni);
		reserva.setIdViaje(idViaje);

		// Persistir
		return reservaPersistence.update(reserva);
	}

	/**
	 * Actualiza una reserva existente
	 */
	public Reserva updateReserva(
			long reservaId, String origen, String destino, Date fechaSalida,
			Date fechaLlegada, String mail, String dni, long idViaje)
			throws PortalException {

		Reserva reserva = reservaPersistence.findByPrimaryKey(reservaId);

		reserva.setModifiedDate(new Date());
		reserva.setOrigen(origen);
		reserva.setDestino(destino);
		reserva.setFechaSalida(fechaSalida);
		reserva.setFechaLlegada(fechaLlegada);
		reserva.setMail(mail);
		reserva.setDni(dni);
		reserva.setIdViaje(idViaje);

		return reservaPersistence.update(reserva);
	}
}
```

## Método personalizado para ViajeLocalServiceImpl.java

Agrega este método en `ViajeLocalServiceImpl.java`:

```java
package com.ntt.travelhub.viaje.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.ntt.travelhub.viaje.model.Viaje;
import com.ntt.travelhub.viaje.service.base.ViajeLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;

@Component(
	property = "model.class.name=com.ntt.travelhub.viaje.model.Viaje",
	service = AopService.class
)
public class ViajeLocalServiceImpl extends ViajeLocalServiceBaseImpl {

	/**
	 * Crea un nuevo viaje con los datos proporcionados
	 */
	public Viaje createViaje(
			String origen, String destino, Date fechaSalida, Date fechaLlegada,
			String empresa, double precio, int asientosDisponibles,
			ServiceContext serviceContext) throws PortalException {

		// Generar ID usando el counter
		long viajeId = counterLocalService.increment();

		// Crear la entidad
		Viaje viaje = viajePersistence.create(viajeId);

		// Setear campos de auditoría
		viaje.setGroupId(serviceContext.getScopeGroupId());
		viaje.setCompanyId(serviceContext.getCompanyId());
		viaje.setUserId(serviceContext.getUserId());
		viaje.setUserName(serviceContext.getUserName());
		viaje.setCreateDate(new Date());
		viaje.setModifiedDate(new Date());

		// Setear campos de negocio
		viaje.setOrigen(origen);
		viaje.setDestino(destino);
		viaje.setFechaSalida(fechaSalida);
		viaje.setFechaLlegada(fechaLlegada);
		viaje.setEmpresa(empresa);
		viaje.setPrecio(precio);
		viaje.setAsientosDisponibles(asientosDisponibles);

		// Persistir
		return viajePersistence.update(viaje);
	}

	/**
	 * Actualiza un viaje existente
	 */
	public Viaje updateViaje(
			long viajeId, String origen, String destino, Date fechaSalida,
			Date fechaLlegada, String empresa, double precio, int asientosDisponibles)
			throws PortalException {

		Viaje viaje = viajePersistence.findByPrimaryKey(viajeId);

		viaje.setModifiedDate(new Date());
		viaje.setOrigen(origen);
		viaje.setDestino(destino);
		viaje.setFechaSalida(fechaSalida);
		viaje.setFechaLlegada(fechaLlegada);
		viaje.setEmpresa(empresa);
		viaje.setPrecio(precio);
		viaje.setAsientosDisponibles(asientosDisponibles);

		return viajePersistence.update(viaje);
	}

	/**
	 * Busca viajes por origen y destino
	 */
	public List<Viaje> findByOrigenDestino(String origen, String destino) {
		return viajePersistence.findByOrigenDestino(origen, destino);
	}

	/**
	 * Busca viajes disponibles (con asientos)
	 */
	public List<Viaje> findViajesDisponibles() {
		return viajePersistence.findAll()
			.stream()
			.filter(v -> v.getAsientosDisponibles() > 0)
			.collect(java.util.stream.Collectors.toList());
	}
}
```

## Actualizar las aplicaciones REST (Opcional)

Si agregas los métodos personalizados, puedes actualizar las aplicaciones REST para usarlos:

### ReservaRestApplication.java

```java
@POST
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response createReserva(ReservaDTO reservaDTO) {
    try {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(20097L);
        serviceContext.setScopeGroupId(20124L);
        serviceContext.setUserId(0L);
        
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
```

### ViajeRestApplication.java

```java
@POST
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response createViaje(ViajeDTO viajeDTO) {
    try {
        ServiceContext serviceContext = new ServiceContext();
        serviceContext.setCompanyId(20097L);
        serviceContext.setScopeGroupId(20124L);
        serviceContext.setUserId(0L);
        
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
```

## Proceso completo

1. Ejecutar `.\gradlew buildService` (genera las clases base)
2. Agregar métodos personalizados en los archivos `*Impl.java`
3. Ejecutar `.\gradlew buildService` nuevamente (actualiza las interfaces con los nuevos métodos)
4. Opcionalmente actualizar las aplicaciones REST
5. Ejecutar `.\gradlew build` y luego `.\gradlew deploy`

## Notas

- Los métodos personalizados se agregan en los archivos `*Impl.java`
- **NUNCA** editar los archivos generados (BaseImpl, Wrapper, etc.)
- Después de agregar métodos en `*Impl.java`, ejecutar `buildService` para que se propaguen a las interfaces
