# Documentación de API REST - Travel Hub

## Información General

**Base URL:** `http://localhost:8080/o`

**Formato:** JSON

**Autenticación:** Ninguna (guest.allowed=true)

---

## 📍 Servicio de Viajes

Base Path: `/viajes`

### 1. Listar Todos los Viajes

**Endpoint:** `GET /o/viajes/`

**Descripción:** Obtiene la lista completa de viajes disponibles.

**Parámetros:** Ninguno

**Respuesta Exitosa:** `200 OK`

```json
[
  {
    "viajeId": 1,
    "origen": "Buenos Aires",
    "destino": "Córdoba",
    "fechaSalida": "2025-12-25T10:00:00.000Z",
    "fechaLlegada": "2025-12-25T18:00:00.000Z",
    "empresa": "Plusmar",
    "precio": 25000.00,
    "asientosDisponibles": 40
  },
  {
    "viajeId": 2,
    "origen": "Buenos Aires",
    "destino": "Mendoza",
    "fechaSalida": "2025-12-26T08:00:00.000Z",
    "fechaLlegada": "2025-12-26T20:00:00.000Z",
    "empresa": "Andesmar",
    "precio": 35000.00,
    "asientosDisponibles": 35
  }
]
```

**Ejemplo de uso (PowerShell):**
```powershell
$response = Invoke-WebRequest -Uri "http://localhost:8080/o/viajes/" -Method GET -UseBasicParsing
$viajes = $response.Content | ConvertFrom-Json
$viajes | Format-Table -AutoSize
```

---

### 2. Obtener Viaje por ID

**Endpoint:** `GET /o/viajes/{idViaje}`

**Descripción:** Obtiene los detalles de un viaje específico.

**Parámetros:**
- `idViaje` (path parameter): ID del viaje (tipo: long)

**Respuesta Exitosa:** `200 OK`

```json
{
  "viajeId": 1,
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": "2025-12-25T10:00:00.000Z",
  "fechaLlegada": "2025-12-25T18:00:00.000Z",
  "empresa": "Plusmar",
  "precio": 25000.00,
  "asientosDisponibles": 40
}
```

**Respuesta Error:** `404 Not Found`

```json
{
  "error": "Viaje not found"
}
```

**Ejemplo de uso (PowerShell):**
```powershell
$viaje = Invoke-RestMethod -Uri "http://localhost:8080/o/viajes/1" -Method GET
Write-Host "Viaje: $($viaje.origen) -> $($viaje.destino)"
```

---

### 3. Crear Nuevo Viaje

**Endpoint:** `POST /o/viajes/`

**Descripción:** Crea un nuevo viaje en el sistema.

**Headers:**
- `Content-Type: application/json`

**Body (JSON):**

```json
{
  "origen": "Buenos Aires",
  "destino": "Rosario",
  "fechaSalida": "2025-12-28T09:00:00.000Z",
  "fechaLlegada": "2025-12-28T13:00:00.000Z",
  "empresa": "Flechabus",
  "precio": 18000.00,
  "asientosDisponibles": 45
}
```

**Respuesta Exitosa:** `201 Created`

```json
{
  "viajeId": 31,
  "origen": "Buenos Aires",
  "destino": "Rosario",
  "fechaSalida": "2025-12-28T09:00:00.000Z",
  "fechaLlegada": "2025-12-28T13:00:00.000Z",
  "empresa": "Flechabus",
  "precio": 18000.00,
  "asientosDisponibles": 45
}
```

**Respuesta Error:** `500 Internal Server Error`

```json
{
  "error": "Error message"
}
```

**Ejemplo de uso (PowerShell):**
```powershell
$body = @{
    origen = "Buenos Aires"
    destino = "Rosario"
    fechaSalida = "2025-12-28T09:00:00Z"
    fechaLlegada = "2025-12-28T13:00:00Z"
    empresa = "Flechabus"
    precio = 18000.00
    asientosDisponibles = 45
} | ConvertTo-Json

$viaje = Invoke-RestMethod -Uri "http://localhost:8080/o/viajes/" `
    -Method POST `
    -ContentType "application/json" `
    -Body $body

Write-Host "Viaje creado con ID: $($viaje.viajeId)"
```

---

### 4. Actualizar Viaje

**Endpoint:** `PUT /o/viajes/{idViaje}`

**Descripción:** Actualiza un viaje existente.

**Parámetros:**
- `idViaje` (path parameter): ID del viaje (tipo: long)

**Headers:**
- `Content-Type: application/json`

**Body (JSON):**

```json
{
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": "2025-12-25T10:00:00.000Z",
  "fechaLlegada": "2025-12-25T18:00:00.000Z",
  "empresa": "Plusmar",
  "precio": 27000.00,
  "asientosDisponibles": 38
}
```

**Respuesta Exitosa:** `200 OK`

```json
{
  "viajeId": 1,
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": "2025-12-25T10:00:00.000Z",
  "fechaLlegada": "2025-12-25T18:00:00.000Z",
  "empresa": "Plusmar",
  "precio": 27000.00,
  "asientosDisponibles": 38
}
```

**Respuesta Error:** `500 Internal Server Error`

**Ejemplo de uso (PowerShell):**
```powershell
$body = @{
    origen = "Buenos Aires"
    destino = "Córdoba"
    fechaSalida = "2025-12-25T10:00:00Z"
    fechaLlegada = "2025-12-25T18:00:00Z"
    empresa = "Plusmar"
    precio = 27000.00
    asientosDisponibles = 38
} | ConvertTo-Json

$viaje = Invoke-RestMethod -Uri "http://localhost:8080/o/viajes/1" `
    -Method PUT `
    -ContentType "application/json" `
    -Body $body
```

---

### 5. Eliminar Viaje

**Endpoint:** `DELETE /o/viajes/{idViaje}`

**Descripción:** Elimina un viaje del sistema.

**Parámetros:**
- `idViaje` (path parameter): ID del viaje (tipo: long)

**Respuesta Exitosa:** `200 OK`

```json
{
  "message": "Viaje deleted successfully"
}
```

**Respuesta Error:** `500 Internal Server Error`

```json
{
  "error": "Error message"
}
```

**Ejemplo de uso (PowerShell):**
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/o/viajes/1" -Method DELETE
```

---

## 📋 Servicio de Reservas

Base Path: `/reservas`

### 1. Crear Nueva Reserva

**Endpoint:** `POST /o/reservas/`

**Descripción:** Crea una nueva reserva de viaje. Soporta reservas de ida simple o ida y vuelta.

**Headers:**
- `Content-Type: application/json`

**Body (JSON) - Reserva Solo Ida:**

```json
{
  "idViajeIda": 1,
  "idViajeVuelta": 0,
  "tipoReserva": "IDA",
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": "2025-12-25T10:00:00.000Z",
  "fechaLlegada": "2025-12-25T18:00:00.000Z",
  "mail": "juan.perez@example.com",
  "dni": "12345678"
}
```

**Body (JSON) - Reserva Ida y Vuelta:**

```json
{
  "idViajeIda": 1,
  "idViajeVuelta": 11,
  "tipoReserva": "IDA_VUELTA",
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": "2025-12-25T10:00:00.000Z",
  "fechaLlegada": "2025-12-25T18:00:00.000Z",
  "mail": "juan.perez@example.com",
  "dni": "12345678"
}
```

**Respuesta Exitosa:** `201 Created`

```json
{
  "reservaId": 5001,
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": "2025-12-25T10:00:00.000Z",
  "fechaLlegada": "2025-12-25T18:00:00.000Z",
  "mail": "juan.perez@example.com",
  "dni": "12345678",
  "idViaje": 1,
  "idViajeIda": 1,
  "idViajeVuelta": 11,
  "tipoReserva": "IDA_VUELTA"
}
```

**Respuesta Error - Sin Asientos:** `400 Bad Request`

```json
{
  "error": "No hay asientos disponibles para el viaje de ida"
}
```

o

```json
{
  "error": "No hay asientos disponibles para el viaje de vuelta"
}
```

**Respuesta Error - Server:** `500 Internal Server Error`

```json
{
  "error": "Error message"
}
```

**Comportamiento:**
- Valida que haya asientos disponibles en el viaje de ida
- Si es `IDA_VUELTA`, valida también el viaje de vuelta
- Decrementa automáticamente los asientos disponibles de los viajes involucrados
- Genera un ID único para la reserva

**Ejemplo de uso (PowerShell) - Solo Ida:**
```powershell
$body = @{
    idViajeIda = 1
    idViajeVuelta = 0
    tipoReserva = "IDA"
    origen = "Buenos Aires"
    destino = "Córdoba"
    fechaSalida = "2025-12-25T10:00:00Z"
    fechaLlegada = "2025-12-25T18:00:00Z"
    mail = "juan.perez@example.com"
    dni = "12345678"
} | ConvertTo-Json

$reserva = Invoke-RestMethod -Uri "http://localhost:8080/o/reservas/" `
    -Method POST `
    -ContentType "application/json" `
    -Body $body

Write-Host "Reserva creada con ID: $($reserva.reservaId)"
```

**Ejemplo de uso (PowerShell) - Ida y Vuelta:**
```powershell
$body = @{
    idViajeIda = 1
    idViajeVuelta = 11
    tipoReserva = "IDA_VUELTA"
    origen = "Buenos Aires"
    destino = "Córdoba"
    fechaSalida = "2025-12-25T10:00:00Z"
    fechaLlegada = "2025-12-25T18:00:00Z"
    mail = "maria.garcia@example.com"
    dni = "87654321"
} | ConvertTo-Json

$reserva = Invoke-RestMethod -Uri "http://localhost:8080/o/reservas/" `
    -Method POST `
    -ContentType "application/json" `
    -Body $body

Write-Host "Reserva ida y vuelta creada con ID: $($reserva.reservaId)"
```

---

### 2. Obtener Reserva por ID

**Endpoint:** `GET /o/reservas/{idReserva}`

**Descripción:** Obtiene los detalles de una reserva específica.

**Parámetros:**
- `idReserva` (path parameter): ID de la reserva (tipo: long)

**Respuesta Exitosa:** `200 OK`

```json
{
  "reservaId": 5001,
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": "2025-12-25T10:00:00.000Z",
  "fechaLlegada": "2025-12-25T18:00:00.000Z",
  "mail": "juan.perez@example.com",
  "dni": "12345678",
  "idViaje": 1,
  "idViajeIda": 1,
  "idViajeVuelta": 11,
  "tipoReserva": "IDA_VUELTA"
}
```

**Respuesta Error:** `404 Not Found`

```json
{
  "error": "Reserva not found"
}
```

**Ejemplo de uso (PowerShell):**
```powershell
$reserva = Invoke-RestMethod -Uri "http://localhost:8080/o/reservas/5001" -Method GET
Write-Host "Reserva para: $($reserva.mail)"
Write-Host "Tipo: $($reserva.tipoReserva)"
```

---

### 3. Cancelar Reserva

**Endpoint:** `DELETE /o/reservas/{idReserva}`

**Descripción:** Cancela una reserva y libera los asientos del viaje.

**Parámetros:**
- `idReserva` (path parameter): ID de la reserva (tipo: long)

**Respuesta Exitosa:** `200 OK`

```json
{
  "message": "Reserva deleted successfully"
}
```

**Respuesta Error:** `500 Internal Server Error`

```json
{
  "error": "Error message"
}
```

**Comportamiento:**
- Elimina la reserva de la base de datos
- Incrementa automáticamente los asientos disponibles del viaje asociado

**Ejemplo de uso (PowerShell):**
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/o/reservas/5001" -Method DELETE
Write-Host "Reserva cancelada exitosamente"
```

---

## 📊 Modelos de Datos

### ViajeDTO

| Campo | Tipo | Descripción | Requerido |
|-------|------|-------------|-----------|
| `viajeId` | long | Identificador único del viaje (auto-generado) | No (solo lectura) |
| `origen` | String | Ciudad de origen del viaje | Sí |
| `destino` | String | Ciudad de destino del viaje | Sí |
| `fechaSalida` | Date | Fecha y hora de salida (ISO 8601) | Sí |
| `fechaLlegada` | Date | Fecha y hora de llegada (ISO 8601) | Sí |
| `empresa` | String | Nombre de la empresa de transporte | Sí |
| `precio` | double | Precio del viaje en ARS | Sí |
| `asientosDisponibles` | int | Cantidad de asientos disponibles | Sí |

**Ejemplo:**
```json
{
  "viajeId": 1,
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": "2025-12-25T10:00:00.000Z",
  "fechaLlegada": "2025-12-25T18:00:00.000Z",
  "empresa": "Plusmar",
  "precio": 25000.00,
  "asientosDisponibles": 40
}
```

---

### ReservaDTO

| Campo | Tipo | Descripción | Requerido |
|-------|------|-------------|-----------|
| `reservaId` | long | Identificador único de la reserva (auto-generado) | No (solo lectura) |
| `origen` | String | Ciudad de origen | Sí |
| `destino` | String | Ciudad de destino | Sí |
| `fechaSalida` | Date | Fecha y hora de salida (ISO 8601) | Sí |
| `fechaLlegada` | Date | Fecha y hora de llegada (ISO 8601) | Sí |
| `mail` | String | Email del pasajero | Sí |
| `dni` | String | DNI del pasajero (7-8 dígitos) | Sí |
| `idViaje` | long | ID del viaje (compatibilidad) | Sí |
| `idViajeIda` | long | ID del viaje de ida | Sí |
| `idViajeVuelta` | long | ID del viaje de vuelta (0 si es solo ida) | Condicional |
| `tipoReserva` | String | Tipo: "IDA" o "IDA_VUELTA" | Sí |

**Ejemplo - Solo Ida:**
```json
{
  "reservaId": 5001,
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": "2025-12-25T10:00:00.000Z",
  "fechaLlegada": "2025-12-25T18:00:00.000Z",
  "mail": "juan.perez@example.com",
  "dni": "12345678",
  "idViaje": 1,
  "idViajeIda": 1,
  "idViajeVuelta": 0,
  "tipoReserva": "IDA"
}
```

**Ejemplo - Ida y Vuelta:**
```json
{
  "reservaId": 5002,
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": "2025-12-25T10:00:00.000Z",
  "fechaLlegada": "2025-12-25T18:00:00.000Z",
  "mail": "maria.garcia@example.com",
  "dni": "87654321",
  "idViaje": 1,
  "idViajeIda": 1,
  "idViajeVuelta": 11,
  "tipoReserva": "IDA_VUELTA"
}
```

---

## 🔧 Códigos de Estado HTTP

| Código | Descripción | Cuándo se usa |
|--------|-------------|---------------|
| `200 OK` | Solicitud exitosa | GET, PUT, DELETE exitosos |
| `201 Created` | Recurso creado exitosamente | POST exitoso |
| `400 Bad Request` | Datos inválidos o sin asientos | Validación de reserva |
| `404 Not Found` | Recurso no encontrado | GET/DELETE de ID inexistente |
| `500 Internal Server Error` | Error del servidor | Errores de base de datos o lógica |

---

## 📝 Notas Importantes

### Formato de Fechas
Todas las fechas deben enviarse y se reciben en formato ISO 8601:
```
2025-12-25T10:00:00.000Z
```

### Validaciones
- **DNI:** Debe tener 7 u 8 dígitos numéricos
- **Email:** Debe ser una dirección válida
- **Asientos:** Se validan automáticamente antes de crear reserva
- **Tipo Reserva:** Solo acepta "IDA" o "IDA_VUELTA"

### Gestión de Asientos
- **Crear Reserva:** Decrementa asientos automáticamente
- **Cancelar Reserva:** Incrementa asientos automáticamente
- **Validación:** Se verifica disponibilidad antes de confirmar

### Configuración
Los servicios están configurados con:
- `auth.verifier.guest.allowed=true` - No requiere autenticación
- `liferay.access.control.disable=true` - Sin control de acceso adicional

---

## 🧪 Scripts de Prueba

### PowerShell - Flujo Completo de Reserva

```powershell
# 1. Listar viajes disponibles
$viajes = Invoke-RestMethod -Uri "http://localhost:8080/o/viajes/" -Method GET
$viajes | Format-Table viajeId, origen, destino, precio, asientosDisponibles

# 2. Seleccionar viaje de ida (ID 1) y vuelta (ID 11)
$viajeIda = $viajes | Where-Object { $_.viajeId -eq 1 }
$viajeVuelta = $viajes | Where-Object { $_.viajeId -eq 11 }

# 3. Crear reserva ida y vuelta
$bodyReserva = @{
    idViajeIda = $viajeIda.viajeId
    idViajeVuelta = $viajeVuelta.viajeId
    tipoReserva = "IDA_VUELTA"
    origen = $viajeIda.origen
    destino = $viajeIda.destino
    fechaSalida = $viajeIda.fechaSalida
    fechaLlegada = $viajeIda.fechaLlegada
    mail = "test@example.com"
    dni = "12345678"
} | ConvertTo-Json

$reserva = Invoke-RestMethod -Uri "http://localhost:8080/o/reservas/" `
    -Method POST `
    -ContentType "application/json" `
    -Body $bodyReserva

Write-Host "✅ Reserva creada con ID: $($reserva.reservaId)" -ForegroundColor Green

# 4. Consultar reserva
$reservaConsulta = Invoke-RestMethod -Uri "http://localhost:8080/o/reservas/$($reserva.reservaId)" -Method GET
$reservaConsulta | ConvertTo-Json

# 5. Verificar que se decrementaron los asientos
$viajeActualizado = Invoke-RestMethod -Uri "http://localhost:8080/o/viajes/$($viajeIda.viajeId)" -Method GET
Write-Host "Asientos antes: $($viajeIda.asientosDisponibles) | Asientos ahora: $($viajeActualizado.asientosDisponibles)"

# 6. Cancelar reserva
Invoke-RestMethod -Uri "http://localhost:8080/o/reservas/$($reserva.reservaId)" -Method DELETE
Write-Host "✅ Reserva cancelada" -ForegroundColor Green

# 7. Verificar que se incrementaron los asientos
$viajeFinal = Invoke-RestMethod -Uri "http://localhost:8080/o/viajes/$($viajeIda.viajeId)" -Method GET
Write-Host "Asientos después de cancelar: $($viajeFinal.asientosDisponibles)"
```

---

## 📞 Soporte

Para más información sobre el proyecto, consultar:
- `GETTING_STARTED.md` - Guía de inicio
- `GUIA_SERVICE_BUILDER.md` - Documentación de Service Builder
- `modules/CUSTOM_METHODS.md` - Métodos personalizados implementados

---

**Última actualización:** Noviembre 2025
**Versión Liferay:** 7.4 DXP
**Framework:** JAX-RS (OSGi)
