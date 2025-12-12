# Guía Completa: Service Builder y REST APIs en Liferay 7.4

Esta guía detalla el proceso completo para crear servicios con Service Builder y exponerlos mediante REST APIs en Liferay 7.4.

## 📋 Tabla de Contenidos

1. [Prerequisitos](#prerequisitos)
2. [Estructura del Proyecto](#estructura-del-proyecto)
3. [Paso 1: Crear Service Builder](#paso-1-crear-service-builder)
4. [Paso 2: Definir Entidades en service.xml](#paso-2-definir-entidades-en-servicexml)
5. [Paso 3: Generar Clases con buildService](#paso-3-generar-clases-con-buildservice)
6. [Paso 4: Agregar Métodos Personalizados](#paso-4-agregar-métodos-personalizados)
7. [Paso 5: Crear REST APIs](#paso-5-crear-rest-apis)
8. [Paso 6: Compilar y Desplegar](#paso-6-compilar-y-desplegar)
9. [Paso 7: Verificar y Probar](#paso-7-verificar-y-probar)
10. [Solución de Problemas](#solución-de-problemas)

---

## Prerequisitos

- Liferay Workspace configurado
- Liferay 7.4 corriendo (local o Docker)
- Gradle instalado
- Java JDK 11+

---

## Estructura del Proyecto

```
travel-hub/
├── modules/
│   ├── reserva/                    # Service Builder - Reserva
│   │   ├── reserva-api/
│   │   │   ├── bnd.bnd
│   │   │   └── build.gradle
│   │   ├── reserva-service/
│   │   │   ├── bnd.bnd
│   │   │   ├── build.gradle
│   │   │   └── service.xml         # ⭐ IMPORTANTE
│   │   └── build.gradle
│   ├── viaje/                      # Service Builder - Viaje
│   │   ├── viaje-api/
│   │   ├── viaje-service/
│   │   └── build.gradle
│   ├── reserva-rest/               # REST API - Reserva
│   │   ├── bnd.bnd
│   │   ├── build.gradle
│   │   └── src/main/java/...
│   └── viaje-rest/                 # REST API - Viaje
│       ├── bnd.bnd
│       ├── build.gradle
│       └── src/main/java/...
└── build.gradle
```

---

## Paso 1: Crear Service Builder

### 1.1 Crear estructura de carpetas

```bash
mkdir -p modules/viaje/viaje-api
mkdir -p modules/viaje/viaje-service
```

### 1.2 Crear archivo `bnd.bnd` para API

**Ubicación:** `modules/viaje/viaje-api/bnd.bnd`

```properties
Bundle-Name: viaje-api
Bundle-SymbolicName: com.ntt.travelhub.viaje.api
Bundle-Version: 1.0.0
Export-Package:\
	com.ntt.travelhub.viaje.exception,\
	com.ntt.travelhub.viaje.model,\
	com.ntt.travelhub.viaje.service,\
	com.ntt.travelhub.viaje.service.persistence
```

### 1.3 Crear archivo `build.gradle` para API

**Ubicación:** `modules/viaje/viaje-api/build.gradle`

```gradle
dependencies {
	compileOnly group: "com.liferay.portal", name: "release.portal.api"
}
```

### 1.4 Crear archivo `bnd.bnd` para Service

**Ubicación:** `modules/viaje/viaje-service/bnd.bnd`

```properties
Bundle-Name: viaje-service
Bundle-SymbolicName: com.ntt.travelhub.viaje.service
Bundle-Version: 1.0.0
Liferay-Require-SchemaVersion: 1.0.0
Liferay-Service: true
-dsannotations-options: inherit
```

### 1.5 Crear archivo `build.gradle` para Service

**Ubicación:** `modules/viaje/viaje-service/build.gradle`

```gradle
dependencies {
	compileOnly group: "com.liferay.portal", name: "release.portal.api"
	compileOnly project(":modules:viaje:viaje-api")
}

buildService {
	apiDir = "../viaje-api/src/main/java"
}
```

---

## Paso 2: Definir Entidades en service.xml

### 2.1 Crear archivo service.xml

**Ubicación:** `modules/viaje/viaje-service/service.xml`

```xml
<?xml version="1.0"?>
<!DOCTYPE service-builder PUBLIC "-//Liferay//DTD Service Builder 7.4.0//EN" "http://www.liferay.com/dtd/liferay-service-builder_7_4_0.dtd">

<service-builder dependency-injector="ds" package-path="com.ntt.travelhub.viaje">
	<namespace>Viaje</namespace>
	
	<entity local-service="true" name="Viaje" remote-service="true" uuid="true">

		<!-- PK fields -->
		<column name="viajeId" primary="true" type="long" />

		<!-- Group instance -->
		<column name="groupId" type="long" />

		<!-- Audit fields -->
		<column name="companyId" type="long" />
		<column name="userId" type="long" />
		<column name="userName" type="String" />
		<column name="createDate" type="Date" />
		<column name="modifiedDate" type="Date" />

		<!-- Business fields -->
		<column name="origen" type="String" />
		<column name="destino" type="String" />
		<column name="fechaSalida" type="Date" />
		<column name="fechaLlegada" type="Date" />
		<column name="empresa" type="String" />
		<column name="precio" type="double" />
		<column name="asientosDisponibles" type="int" />

		<!-- Order -->
		<order by="asc">
			<order-column name="fechaSalida" />
		</order>

		<!-- Finder methods -->
		<finder name="GroupId" return-type="Collection">
			<finder-column name="groupId" />
		</finder>
		<finder name="Origen" return-type="Collection">
			<finder-column name="origen" />
		</finder>
		<finder name="Destino" return-type="Collection">
			<finder-column name="destino" />
		</finder>
		<finder name="OrigenDestino" return-type="Collection">
			<finder-column name="origen" />
			<finder-column name="destino" />
		</finder>
	</entity>
</service-builder>
```

### 2.2 Elementos importantes del service.xml

| Elemento | Descripción |
|----------|-------------|
| `package-path` | Paquete base para las clases generadas |
| `namespace` | Prefijo para las tablas en base de datos |
| `local-service` | Genera servicios locales (sin seguridad) |
| `remote-service` | Genera servicios remotos (con seguridad) |
| `uuid` | Agrega campo UUID para replicación |
| `<column>` | Define campos de la entidad |
| `<finder>` | Define métodos de búsqueda personalizados |
| `<order>` | Define orden por defecto al listar |

---

## Paso 3: Generar Clases con buildService

### 3.1 Ejecutar buildService

```powershell
.\gradlew buildService
```

Este comando genera automáticamente:

- **Interfaces de servicios:**
  - `ViajeLocalService.java`
  - `ViajeLocalServiceUtil.java`
  - `ViajeService.java`

- **Modelos:**
  - `Viaje.java` (interfaz)
  - `ViajeModel.java`
  - `ViajeWrapper.java`

- **Persistencia:**
  - `ViajePersistence.java`
  - `ViajePersistenceImpl.java`

- **Implementaciones base:**
  - `ViajeLocalServiceBaseImpl.java`
  - `ViajeLocalServiceImpl.java` ⭐ (aquí agregarás métodos personalizados)

### 3.2 Estructura generada

```
viaje-api/src/main/java/com/ntt/travelhub/viaje/
├── exception/
├── model/
│   ├── Viaje.java
│   ├── ViajeModel.java
│   └── ViajeWrapper.java
└── service/
    ├── ViajeLocalService.java
    ├── ViajeLocalServiceUtil.java
    ├── ViajeService.java
    └── persistence/
        └── ViajePersistence.java

viaje-service/src/main/java/com/ntt/travelhub/viaje/
├── model/impl/
│   ├── ViajeBaseImpl.java
│   ├── ViajeCacheModel.java
│   ├── ViajeImpl.java
│   └── ViajeModelImpl.java
└── service/
    ├── base/
    │   ├── ViajeLocalServiceBaseImpl.java
    │   └── ViajeServiceBaseImpl.java
    ├── impl/
    │   ├── ViajeLocalServiceImpl.java ⭐ EDITABLE
    │   └── ViajeServiceImpl.java      ⭐ EDITABLE
    └── persistence/impl/
        └── ViajePersistenceImpl.java
```

---

## Paso 4: Agregar Métodos Personalizados

### 4.1 Editar ViajeLocalServiceImpl.java

**Ubicación:** `modules/viaje/viaje-service/src/main/java/com/ntt/travelhub/viaje/service/impl/ViajeLocalServiceImpl.java`

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
	 * 
	 * @param origen Ciudad de origen
	 * @param destino Ciudad de destino
	 * @param fechaSalida Fecha y hora de salida
	 * @param fechaLlegada Fecha y hora de llegada
	 * @param empresa Nombre de la empresa de transporte
	 * @param precio Precio del viaje
	 * @param asientosDisponibles Cantidad de asientos disponibles
	 * @param serviceContext Contexto del servicio
	 * @return El viaje creado
	 * @throws PortalException Si hay un error al crear el viaje
	 */
	public Viaje createViaje(
			String origen, String destino, Date fechaSalida, Date fechaLlegada,
			String empresa, double precio, int asientosDisponibles,
			ServiceContext serviceContext) throws PortalException {

		// Generar ID único usando el counter
		long viajeId = counterLocalService.increment(Viaje.class.getName());

		// Crear la entidad
		Viaje viaje = viajePersistence.create(viajeId);

		// Setear campos de auditoría
		viaje.setGroupId(serviceContext.getScopeGroupId());
		viaje.setCompanyId(serviceContext.getCompanyId());
		viaje.setUserId(serviceContext.getUserId());
		viaje.setUserName("");
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

### 4.2 Regenerar con buildService

**⚠️ IMPORTANTE:** Después de agregar métodos personalizados, SIEMPRE ejecuta:

```powershell
.\gradlew buildService
```

Esto propaga tus métodos personalizados a las interfaces y wrappers.

---

## Paso 5: Crear REST APIs

### 5.1 Crear módulo REST

```bash
mkdir -p modules/viaje-rest/src/main/java/com/ntt/travelhub/viaje/rest/application
mkdir -p modules/viaje-rest/src/main/java/com/ntt/travelhub/viaje/rest/dto
```

### 5.2 Crear bnd.bnd para REST

**Ubicación:** `modules/viaje-rest/bnd.bnd`

```properties
Bundle-Name: viaje-rest
Bundle-SymbolicName: com.ntt.travelhub.viaje.rest
Bundle-Version: 1.0.0
```

### 5.3 Crear build.gradle para REST

**Ubicación:** `modules/viaje-rest/build.gradle`

```gradle
dependencies {
	compileOnly group: "com.liferay.portal", name: "release.portal.api"
	compileOnly group: "javax.ws.rs", name: "javax.ws.rs-api", version: "2.1.1"
	compileOnly group: "org.osgi", name: "org.osgi.service.component.annotations", version: "1.3.0"
	compileOnly group: "org.osgi", name: "org.osgi.service.jaxrs", version: "1.0.0"
	compileOnly project(":modules:viaje:viaje-api")
}
```

### 5.4 Crear DTO (Data Transfer Object)

**Ubicación:** `modules/viaje-rest/src/main/java/com/ntt/travelhub/viaje/rest/dto/ViajeDTO.java`

```java
package com.ntt.travelhub.viaje.rest.dto;

import java.util.Date;

public class ViajeDTO {
    
    private long viajeId;
    private String origen;
    private String destino;
    private Date fechaSalida;
    private Date fechaLlegada;
    private String empresa;
    private double precio;
    private int asientosDisponibles;

    public ViajeDTO() {
    }

    // Getters y Setters
    public long getViajeId() {
        return viajeId;
    }

    public void setViajeId(long viajeId) {
        this.viajeId = viajeId;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }
}
```

### 5.5 Crear REST Application

**Ubicación:** `modules/viaje-rest/src/main/java/com/ntt/travelhub/viaje/rest/application/ViajeRestApplication.java`

```java
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
```

---

## Paso 6: Compilar y Desplegar

### 6.1 Orden de comandos (CRÍTICO)

```powershell
# 1. Generar clases del Service Builder
.\gradlew buildService

# 2. Compilar todos los módulos
.\gradlew build

# 3. Desplegar en Liferay local
.\gradlew deploy
```

### 6.2 Desplegar en Docker

```powershell
# Compilar
.\gradlew build

# Copiar JARs al contenedor (ajustar nombre del contenedor)
docker cp "modules\viaje\viaje-api\build\libs\com.ntt.travelhub.viaje.api-1.0.0.jar" <container-name>:/opt/liferay/osgi/modules/

docker cp "modules\viaje\viaje-service\build\libs\com.ntt.travelhub.viaje.service-1.0.0.jar" <container-name>:/opt/liferay/osgi/modules/

docker cp "modules\viaje-rest\build\libs\com.ntt.travelhub.viaje.rest-1.0.0.jar" <container-name>:/opt/liferay/osgi/modules/
```

---

## Paso 7: Verificar y Probar

### 7.1 Verificar despliegue en Gogo Shell

```bash
# Conectarse al contenedor
docker exec -it <container-name> bash

# Verificar módulos
telnet localhost 11311

# En Gogo Shell
lb | grep -i viaje
```

Deberías ver algo como:
```
1234 | Active |   10 | com.ntt.travelhub.viaje.api (1.0.0)
1235 | Active |   10 | com.ntt.travelhub.viaje.service (1.0.0)
1236 | Active |   10 | com.ntt.travelhub.viaje.rest (1.0.0)
```

### 7.2 Probar endpoints REST

```powershell
# GET - Listar viajes
curl http://localhost:8080/o/viajes/

# GET - Obtener un viaje
curl http://localhost:8080/o/viajes/1

# POST - Crear viaje
curl -X POST http://localhost:8080/o/viajes/ `
  -H "Content-Type: application/json" `
  -d '{
    "origen": "Buenos Aires",
    "destino": "Córdoba",
    "fechaSalida": "2025-12-01T08:00:00",
    "fechaLlegada": "2025-12-01T18:00:00",
    "empresa": "Chevallier",
    "precio": 15000.50,
    "asientosDisponibles": 40
  }'

# PUT - Actualizar viaje
curl -X PUT http://localhost:8080/o/viajes/1 `
  -H "Content-Type: application/json" `
  -d '{
    "origen": "Buenos Aires",
    "destino": "Mendoza",
    "fechaSalida": "2025-12-15T09:00:00",
    "fechaLlegada": "2025-12-15T20:00:00",
    "empresa": "Andesmar",
    "precio": 22000.00,
    "asientosDisponibles": 35
  }'

# DELETE - Eliminar viaje
curl -X DELETE http://localhost:8080/o/viajes/1
```

### 7.3 Verificar tablas en base de datos

Las tablas generadas serán:

- `Viaje_Viaje` - Tabla principal
- `Counter` - Tabla de contadores (IDs)

```sql
SELECT * FROM Viaje_Viaje;
SELECT * FROM Counter WHERE name = 'com.ntt.travelhub.viaje.model.Viaje';
```

---

## Solución de Problemas

### Error: NoSuchMethodError

**Causa:** No ejecutaste `buildService` después de agregar métodos personalizados.

**Solución:**
```powershell
.\gradlew buildService
.\gradlew build
# Redesplegar
```

### Error: IDs duplicados / viajes se sobrescriben

**Causa:** Uso incorrecto del counter.

**Solución:** Asegúrate de usar:
```java
long id = counterLocalService.increment(Viaje.class.getName());
```

No uses:
```java
long id = counterLocalService.increment(); // ❌ INCORRECTO
long id = _service.getViajesCount() + 1;  // ❌ INCORRECTO
```

### Error: Módulo no se activa (INSTALLED pero no ACTIVE)

**Causa:** Falta dependencia o error en el código.

**Solución:**
```bash
# En Gogo Shell
diag <bundle-id>
```

### Error: 404 en endpoints REST

**Causas posibles:**
1. Módulo REST no está ACTIVE
2. Base path incorrecto
3. Puerto incorrecto

**Solución:**
- Verificar: `lb | grep rest`
- Base URL correcta: `http://localhost:8080/o/viajes/`
- Revisar logs: `docker logs <container-name>`

---

## Checklist de Despliegue

- [ ] Crear estructura de carpetas (api, service, rest)
- [ ] Crear archivos `bnd.bnd` y `build.gradle`
- [ ] Definir `service.xml` con entidades
- [ ] Ejecutar `.\gradlew buildService`
- [ ] Agregar métodos personalizados en `*Impl.java`
- [ ] Ejecutar `.\gradlew buildService` nuevamente
- [ ] Crear DTOs y REST Application
- [ ] Ejecutar `.\gradlew build`
- [ ] Desplegar JARs (deploy o docker cp)
- [ ] Verificar módulos ACTIVE en Gogo Shell
- [ ] Probar endpoints con curl/Postman

---

## Recursos Adicionales

- [Liferay Service Builder Documentation](https://learn.liferay.com/dxp/latest/en/building-applications/data-frameworks/service-builder.html)
- [Liferay REST Builder](https://learn.liferay.com/dxp/latest/en/headless-delivery/apis-with-rest-builder.html)
- [JAX-RS Whiteboard](https://learn.liferay.com/dxp/latest/en/building-applications/developing-a-java-web-application/using-mvc/tag-libraries/liferay-util-tag-library/liferay-util-dynamic-include.html)

---

## Notas Finales

1. **SIEMPRE** ejecuta `buildService` después de modificar `service.xml` o agregar métodos personalizados
2. Los módulos **-api** DEBEN copiarse junto con **-service** y **-rest** al desplegar
3. El orden importa: buildService → build → deploy
4. Usa `Viaje.class.getName()` en el counter para IDs únicos
5. Los endpoints REST requieren que los módulos service estén ACTIVE primero

---

**¡Éxito en tu desarrollo con Liferay!** 🚀
