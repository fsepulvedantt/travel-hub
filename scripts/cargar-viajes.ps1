# Script para cargar 10 viajes de prueba

$viajes = @(
    @{origen="Buenos Aires"; destino="Córdoba"; fechaSalida="2025-12-01T08:00:00"; fechaLlegada="2025-12-01T18:00:00"; empresa="Chevallier"; precio=15000.50; asientosDisponibles=40},
    @{origen="Buenos Aires"; destino="Mendoza"; fechaSalida="2025-12-02T10:00:00"; fechaLlegada="2025-12-03T02:00:00"; empresa="Andesmar"; precio=22000.00; asientosDisponibles=35},
    @{origen="Córdoba"; destino="Mendoza"; fechaSalida="2025-12-03T14:00:00"; fechaLlegada="2025-12-04T06:00:00"; empresa="Via Bariloche"; precio=18500.75; asientosDisponibles=28},
    @{origen="Buenos Aires"; destino="Rosario"; fechaSalida="2025-12-05T07:30:00"; fechaLlegada="2025-12-05T12:00:00"; empresa="Flecha Bus"; precio=8500.00; asientosDisponibles=45},
    @{origen="Rosario"; destino="Córdoba"; fechaSalida="2025-12-06T09:00:00"; fechaLlegada="2025-12-06T15:00:00"; empresa="Sierras de Córdoba"; precio=12000.00; asientosDisponibles=32},
    @{origen="Buenos Aires"; destino="Mar del Plata"; fechaSalida="2025-12-10T06:00:00"; fechaLlegada="2025-12-10T12:00:00"; empresa="Mar y Sierras"; precio=16500.00; asientosDisponibles=8},
    @{origen="Mendoza"; destino="San Juan"; fechaSalida="2025-12-12T11:00:00"; fechaLlegada="2025-12-12T14:30:00"; empresa="Andesmar"; precio=9800.00; asientosDisponibles=25},
    @{origen="Buenos Aires"; destino="Bariloche"; fechaSalida="2025-12-15T20:00:00"; fechaLlegada="2025-12-16T16:00:00"; empresa="Via Bariloche"; precio=35000.00; asientosDisponibles=15},
    @{origen="Córdoba"; destino="Buenos Aires"; fechaSalida="2025-12-18T19:00:00"; fechaLlegada="2025-12-19T05:00:00"; empresa="Chevallier"; precio=15500.00; asientosDisponibles=5},
    @{origen="Mendoza"; destino="Buenos Aires"; fechaSalida="2025-12-20T22:00:00"; fechaLlegada="2025-12-21T14:00:00"; empresa="Andesmar"; precio=22500.00; asientosDisponibles=12}
)

$contador = 0
foreach ($viaje in $viajes) {
    $body = @{
        origen = $viaje.origen
        destino = $viaje.destino
        fechaSalida = $viaje.fechaSalida
        fechaLlegada = $viaje.fechaLlegada
        empresa = $viaje.empresa
        precio = $viaje.precio
        asientosDisponibles = $viaje.asientosDisponibles
    } | ConvertTo-Json

    $response = Invoke-RestMethod -Uri "http://localhost:32772/o/viajes/" -Method Post -Body $body -ContentType "application/json"
    $contador++
    Write-Host "✓ Viaje $contador creado: $($viaje.origen) → $($viaje.destino)" -ForegroundColor Green
    Start-Sleep -Milliseconds 200
}

Write-Host "`n✅ Se han cargado $contador viajes exitosamente!" -ForegroundColor Cyan
