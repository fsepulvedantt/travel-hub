# Script para cargar viajes de ida y vuelta para pruebas

$viajes = @(
    # Buenos Aires → Córdoba (Ida - 2025-12-25)
    @{origen="Buenos Aires"; destino="Córdoba"; fechaSalida="2025-12-25T08:00:00"; fechaLlegada="2025-12-25T18:00:00"; empresa="Chevallier"; precio=15000.00; asientosDisponibles=40},
    @{origen="Buenos Aires"; destino="Córdoba"; fechaSalida="2025-12-25T10:00:00"; fechaLlegada="2025-12-25T20:00:00"; empresa="Andesmar"; precio=16500.00; asientosDisponibles=35},
    @{origen="Buenos Aires"; destino="Córdoba"; fechaSalida="2025-12-25T14:00:00"; fechaLlegada="2025-12-26T00:00:00"; empresa="Via Bariloche"; precio=14500.00; asientosDisponibles=28},
    @{origen="Buenos Aires"; destino="Córdoba"; fechaSalida="2025-12-25T22:00:00"; fechaLlegada="2025-12-26T08:00:00"; empresa="Flecha Bus"; precio=13500.00; asientosDisponibles=45},
    
    # Córdoba → Buenos Aires (Vuelta - 2025-12-28)
    @{origen="Córdoba"; destino="Buenos Aires"; fechaSalida="2025-12-28T08:00:00"; fechaLlegada="2025-12-28T18:00:00"; empresa="Chevallier"; precio=15500.00; asientosDisponibles=38},
    @{origen="Córdoba"; destino="Buenos Aires"; fechaSalida="2025-12-28T12:00:00"; fechaLlegada="2025-12-28T22:00:00"; empresa="Andesmar"; precio=17000.00; asientosDisponibles=30},
    @{origen="Córdoba"; destino="Buenos Aires"; fechaSalida="2025-12-28T16:00:00"; fechaLlegada="2025-12-29T02:00:00"; empresa="Via Bariloche"; precio=14800.00; asientosDisponibles=25},
    @{origen="Córdoba"; destino="Buenos Aires"; fechaSalida="2025-12-28T20:00:00"; fechaLlegada="2025-12-29T06:00:00"; empresa="Flecha Bus"; precio=13800.00; asientosDisponibles=42},
    
    # Buenos Aires → Mendoza (Ida - 2025-12-25)
    @{origen="Buenos Aires"; destino="Mendoza"; fechaSalida="2025-12-25T09:00:00"; fechaLlegada="2025-12-26T01:00:00"; empresa="Andesmar"; precio=22000.00; asientosDisponibles=35},
    @{origen="Buenos Aires"; destino="Mendoza"; fechaSalida="2025-12-25T15:00:00"; fechaLlegada="2025-12-26T07:00:00"; empresa="Chevallier"; precio=23500.00; asientosDisponibles=30},
    @{origen="Buenos Aires"; destino="Mendoza"; fechaSalida="2025-12-25T21:00:00"; fechaLlegada="2025-12-26T13:00:00"; empresa="Via Bariloche"; precio=21500.00; asientosDisponibles=25},
    
    # Mendoza → Buenos Aires (Vuelta - 2025-12-30)
    @{origen="Mendoza"; destino="Buenos Aires"; fechaSalida="2025-12-30T10:00:00"; fechaLlegada="2025-12-31T02:00:00"; empresa="Andesmar"; precio=22500.00; asientosDisponibles=32},
    @{origen="Mendoza"; destino="Buenos Aires"; fechaSalida="2025-12-30T16:00:00"; fechaLlegada="2025-12-31T08:00:00"; empresa="Chevallier"; precio=24000.00; asientosDisponibles=28},
    @{origen="Mendoza"; destino="Buenos Aires"; fechaSalida="2025-12-30T22:00:00"; fechaLlegada="2025-12-31T14:00:00"; empresa="Via Bariloche"; precio=22000.00; asientosDisponibles=20},
    
    # Buenos Aires → Rosario (Ida - 2025-12-26)
    @{origen="Buenos Aires"; destino="Rosario"; fechaSalida="2025-12-26T07:00:00"; fechaLlegada="2025-12-26T11:30:00"; empresa="Flecha Bus"; precio=8500.00; asientosDisponibles=45},
    @{origen="Buenos Aires"; destino="Rosario"; fechaSalida="2025-12-26T11:00:00"; fechaLlegada="2025-12-26T15:30:00"; empresa="Chevallier"; precio=9000.00; asientosDisponibles=40},
    @{origen="Buenos Aires"; destino="Rosario"; fechaSalida="2025-12-26T15:00:00"; fechaLlegada="2025-12-26T19:30:00"; empresa="Andesmar"; precio=8800.00; asientosDisponibles=38},
    
    # Rosario → Buenos Aires (Vuelta - 2025-12-27)
    @{origen="Rosario"; destino="Buenos Aires"; fechaSalida="2025-12-27T08:00:00"; fechaLlegada="2025-12-27T12:30:00"; empresa="Flecha Bus"; precio=8700.00; asientosDisponibles=42},
    @{origen="Rosario"; destino="Buenos Aires"; fechaSalida="2025-12-27T13:00:00"; fechaLlegada="2025-12-27T17:30:00"; empresa="Chevallier"; precio=9200.00; asientosDisponibles=38},
    @{origen="Rosario"; destino="Buenos Aires"; fechaSalida="2025-12-27T18:00:00"; fechaLlegada="2025-12-27T22:30:00"; empresa="Andesmar"; precio=9000.00; asientosDisponibles=35}
)

# Verificar que el endpoint esté disponible
Write-Host "🔍 Verificando endpoint REST..." -ForegroundColor Cyan
try {
    $testResponse = Invoke-WebRequest -Uri "http://localhost:8080/o/viajes/" -Method Get -UseBasicParsing -ErrorAction Stop
    Write-Host "✓ Endpoint disponible`n" -ForegroundColor Green
} catch {
    Write-Host "❌ Error: El endpoint http://localhost:8080/o/viajes/ no está disponible." -ForegroundColor Red
    Write-Host "   Por favor, verifica que Liferay y el módulo viaje-rest estén activos`n" -ForegroundColor Yellow
    exit 1
}

Write-Host "📦 Cargando $($viajes.Count) viajes de ida y vuelta..." -ForegroundColor Cyan
Write-Host ""

$contador = 0
$errores = 0
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

    try {
        $response = Invoke-RestMethod -Uri "http://localhost:8080/o/viajes/" -Method Post -Body $body -ContentType "application/json" -ErrorAction Stop
        $contador++
        Write-Host "✓ Viaje $contador creado: $($viaje.origen) → $($viaje.destino) | $($viaje.fechaSalida.Substring(0,10))" -ForegroundColor Green
    } catch {
        $errores++
        Write-Host "✗ Error al crear viaje: $($viaje.origen) → $($viaje.destino)" -ForegroundColor Red
        Write-Host "  Detalle: $($_.Exception.Message)" -ForegroundColor Yellow
    }
    
    Start-Sleep -Milliseconds 200
}

Write-Host ""
if ($errores -eq 0) {
    Write-Host "✅ Se han cargado $contador viajes exitosamente!" -ForegroundColor Green
    Write-Host ""
    Write-Host "🎯 URLs para probar:" -ForegroundColor Cyan
    Write-Host ""
    Write-Host "📍 Buenos Aires → Córdoba (ida: 25/12, vuelta: 28/12)" -ForegroundColor Yellow
    Write-Host "   http://localhost:8080/web/travelhub/viajes-list?origen=Buenos%20Aires&destino=Córdoba&fechaPartida=2025-12-25&fechaRegreso=2025-12-28&pasajeros=1" -ForegroundColor White
    Write-Host ""
    Write-Host "📍 Buenos Aires → Mendoza (ida: 25/12, vuelta: 30/12)" -ForegroundColor Yellow
    Write-Host "   http://localhost:8080/web/travelhub/viajes-list?origen=Buenos%20Aires&destino=Mendoza&fechaPartida=2025-12-25&fechaRegreso=2025-12-30&pasajeros=1" -ForegroundColor White
    Write-Host ""
    Write-Host "📍 Buenos Aires → Rosario (ida: 26/12, vuelta: 27/12)" -ForegroundColor Yellow
    Write-Host "   http://localhost:8080/web/travelhub/viajes-list?origen=Buenos%20Aires&destino=Rosario&fechaPartida=2025-12-26&fechaRegreso=2025-12-27&pasajeros=1" -ForegroundColor White
    Write-Host ""
} else {
    Write-Host "⚠️  Se cargaron $contador viajes con $errores errores." -ForegroundColor Yellow
}
