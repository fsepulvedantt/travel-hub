# Travel Hub - API REST Services

## Estructura del Proyecto

Este proyecto implementa una API REST para la gestión de reservas y viajes, siguiendo el diagrama de arquitectura definido.

### Módulos Creados

#### 1. Service Builder - Reserva
- **reserva-api**: Interfaz de servicios y modelos
- **reserva-service**: Implementación de servicios y persistencia

**Entidad Reserva:**
- reservaId (PK)
- origen
- destino
- fechaSalida
- fechaLlegada
- mail
- dni
- idViaje

#### 2. Service Builder - Viaje
- **viaje-api**: Interfaz de servicios y modelos
- **viaje-service**: Implementación de servicios y persistencia

**Entidad Viaje:**
- viajeId (PK)
- origen
- destino
- fechaSalida
- fechaLlegada
- empresa
- precio
- asientosDisponibles

#### 3. REST API - Reservas
**Base URL:** `/o/reservas`

**Endpoints:**
- `POST /` - Crear reserva
- `GET /{idReserva}` - Obtener reserva por ID
- `DELETE /{idReserva}` - Eliminar reserva

#### 4. REST API - Viajes
**Base URL:** `/o/viajes`

**Endpoints:**
- `GET /` - Listar todos los viajes
- `GET /{idViaje}` - Obtener viaje por ID
- `POST /` - Crear viaje
- `PUT /{idViaje}` - Actualizar viaje
- `DELETE /{idViaje}` - Eliminar viaje

## Pasos para Construir y Desplegar

### 1. Generar el Service Builder

Ejecutar el comando de Gradle para generar las clases del Service Builder:

```powershell
.\gradlew buildService
```

Este comando generará:
- Interfaces de servicios (Local y Remote)
- Modelos de entidades
- Clases de persistencia
- Tablas de base de datos

### 2. Implementar métodos personalizados (Opcional)

Después de ejecutar `buildService`, puedes agregar métodos personalizados en:
- `ReservaLocalServiceImpl.java`
- `ViajeLocalServiceImpl.java`

Por ejemplo, agregar un método para crear reservas:

```java
// En ReservaLocalServiceImpl.java
public Reserva createReserva(
    String origen, String destino, Date fechaSalida, Date fechaLlegada,
    String mail, String dni, long idViaje, ServiceContext serviceContext)
    throws PortalException {
    
    long reservaId = counterLocalService.increment();
    Reserva reserva = reservaPersistence.create(reservaId);
    
    reserva.setGroupId(serviceContext.getScopeGroupId());
    reserva.setCompanyId(serviceContext.getCompanyId());
    reserva.setUserId(serviceContext.getUserId());
    reserva.setCreateDate(new Date());
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
```

Y lo mismo para Viaje:

```java
// En ViajeLocalServiceImpl.java
public Viaje createViaje(
    String origen, String destino, Date fechaSalida, Date fechaLlegada,
    String empresa, double precio, int asientosDisponibles,
    ServiceContext serviceContext) throws PortalException {
    
    long viajeId = counterLocalService.increment();
    Viaje viaje = viajePersistence.create(viajeId);
    
    viaje.setGroupId(serviceContext.getScopeGroupId());
    viaje.setCompanyId(serviceContext.getCompanyId());
    viaje.setUserId(serviceContext.getUserId());
    viaje.setCreateDate(new Date());
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
```

Después de agregar métodos personalizados, ejecutar nuevamente:

```powershell
.\gradlew buildService
```

### 3. Compilar el proyecto

```powershell
.\gradlew build
```

### 4. Desplegar en Liferay

```powershell
.\gradlew deploy
```

Los módulos se desplegarán en la carpeta `bundles/osgi/modules`.

### 5. Verificar el despliegue

Desde la consola Gogo de Liferay:

```
lb | grep -i reserva
lb | grep -i viaje
```

### 6. Probar los endpoints REST

Una vez desplegado, los endpoints estarán disponibles en:

**Reservas:**
```
POST   http://localhost:8080/o/reservas/
GET    http://localhost:8080/o/reservas/{idReserva}
DELETE http://localhost:8080/o/reservas/{idReserva}
```

**Viajes:**
```
GET    http://localhost:8080/o/viajes/
GET    http://localhost:8080/o/viajes/{idViaje}
POST   http://localhost:8080/o/viajes/
PUT    http://localhost:8080/o/viajes/{idViaje}
DELETE http://localhost:8080/o/viajes/{idViaje}
```

### Ejemplo de Request POST para Reserva

```json
{
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": "2025-12-01T08:00:00Z",
  "fechaLlegada": "2025-12-01T16:00:00Z",
  "mail": "usuario@example.com",
  "dni": "12345678",
  "idViaje": 1
}
```

### Ejemplo de Request POST para Viaje

```json
{
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": "2025-12-01T08:00:00Z",
  "fechaLlegada": "2025-12-01T16:00:00Z",
  "empresa": "Chevallier",
  "precio": 15000.50,
  "asientosDisponibles": 40
}
```

## Estructura de Archivos

```
modules/
├── reserva/
│   ├── reserva-api/
│   │   ├── bnd.bnd
│   │   └── build.gradle
│   ├── reserva-service/
│   │   ├── bnd.bnd
│   │   ├── build.gradle
│   │   └── service.xml
│   └── build.gradle
├── viaje/
│   ├── viaje-api/
│   │   ├── bnd.bnd
│   │   └── build.gradle
│   ├── viaje-service/
│   │   ├── bnd.bnd
│   │   ├── build.gradle
│   │   └── service.xml
│   └── build.gradle
├── reserva-rest/
│   ├── bnd.bnd
│   ├── build.gradle
│   └── src/main/java/com/ntt/travelhub/reserva/rest/
│       ├── application/
│       │   └── ReservaRestApplication.java
│       └── dto/
│           └── ReservaDTO.java
└── viaje-rest/
    ├── bnd.bnd
    ├── build.gradle
    └── src/main/java/com/ntt/travelhub/viaje/rest/
        ├── application/
        │   └── ViajeRestApplication.java
        └── dto/
            └── ViajeDTO.java
```

## Notas Importantes

1. **Ejecutar buildService primero**: Antes de compilar, siempre ejecutar `buildService` para generar las clases necesarias.

2. **Ajustar IDs de Company y Group**: Los valores de `companyId` y `groupId` en las clases REST están hardcodeados (20097L y 20124L). Ajustarlos según tu instalación de Liferay.

3. **Seguridad**: Los endpoints están configurados con `auth.verifier.guest.allowed=true` para facilitar las pruebas. Para producción, configurar la autenticación apropiada.

4. **Base de datos**: El Service Builder creará automáticamente las tablas `Reserva_Reserva` y `Viaje_Viaje` en la base de datos configurada.

## Próximos Pasos

1. Agregar validaciones en los endpoints REST
2. Implementar filtros de búsqueda para viajes (por fecha, origen, destino)
3. Agregar manejo de errores más robusto
4. Implementar autenticación y autorización
5. Agregar documentación Swagger/OpenAPI
