# Script para cargar viajes de prueba (ida y vuelta)
# Para probar el sistema de reservas con múltiples opciones por ruta

Write-Host "=== CARGAR VIAJES DE PRUEBA - IDA Y VUELTA ===" -ForegroundColor Cyan
Write-Host "Limpiando base de datos..." -ForegroundColor Yellow

# URL de la API
$API_URL = "http://localhost:8080/o/viajes"

# Limpiar viajes existentes
try {
    $viajesExistentes = Invoke-RestMethod -Uri $API_URL -Method GET
    foreach ($viaje in $viajesExistentes) {
        Invoke-RestMethod -Uri "$API_URL/$($viaje.viajeId)" -Method DELETE | Out-Null
    }
    Write-Host "✓ Base de datos limpia ($($viajesExistentes.Count) viajes eliminados)`n" -ForegroundColor Green
} catch {
    Write-Host "⚠ No se pudieron eliminar viajes existentes`n" -ForegroundColor Yellow
}

# Definir rutas con múltiples opciones de ida y vuelta
$rutas = @(
    # ========== Buenos Aires <-> Córdoba ==========
    @{
        nombre = "Buenos Aires ↔ Córdoba"
        fechaIda = "2025-12-15"
        fechaVuelta = "2025-12-16"
        viajesIda = @(
            @{ hora = "08:00"; duracion = 8; empresa = "Plusmar"; precio = 25000; asientos = 40 },
            @{ hora = "10:00"; duracion = 8; empresa = "Flechabus"; precio = 23000; asientos = 35 },
            @{ hora = "14:00"; duracion = 8; empresa = "Chevallier"; precio = 24500; asientos = 42 },
            @{ hora = "20:00"; duracion = 8; empresa = "Andesmar"; precio = 22000; asientos = 38 }
        )
        viajesVuelta = @(
            @{ hora = "09:00"; duracion = 8; empresa = "Plusmar"; precio = 25000; asientos = 40 },
            @{ hora = "11:00"; duracion = 8; empresa = "Flechabus"; precio = 23500; asientos = 36 },
            @{ hora = "15:00"; duracion = 8; empresa = "Chevallier"; precio = 24000; asientos = 41 },
            @{ hora = "21:00"; duracion = 8; empresa = "Andesmar"; precio = 22500; asientos = 37 }
        )
    },
    
    # ========== Buenos Aires <-> Mendoza ==========
    @{
        nombre = "Buenos Aires ↔ Mendoza"
        fechaIda = "2025-12-18"
        fechaVuelta = "2025-12-19"
        viajesIda = @(
            @{ hora = "22:00"; duracion = 12; empresa = "Andesmar"; precio = 35000; asientos = 35 },
            @{ hora = "23:00"; duracion = 12; empresa = "Cata Internacional"; precio = 38000; asientos = 30 },
            @{ hora = "01:00"; duracion = 12; empresa = "TAC"; precio = 33000; asientos = 32 }
        )
        viajesVuelta = @(
            @{ hora = "20:00"; duracion = 12; empresa = "Andesmar"; precio = 35000; asientos = 33 },
            @{ hora = "21:00"; duracion = 12; empresa = "Cata Internacional"; precio = 37000; asientos = 28 },
            @{ hora = "22:30"; duracion = 12; empresa = "TAC"; precio = 34000; asientos = 31 }
        )
    },
    
    # ========== Buenos Aires <-> Rosario ==========
    @{
        nombre = "Buenos Aires ↔ Rosario"
        fechaIda = "2025-12-20"
        fechaVuelta = "2025-12-21"
        viajesIda = @(
            @{ hora = "07:00"; duracion = 4; empresa = "Flechabus"; precio = 15000; asientos = 45 },
            @{ hora = "09:00"; duracion = 4; empresa = "Chevallier"; precio = 16000; asientos = 42 },
            @{ hora = "11:00"; duracion = 4; empresa = "Plusmar"; precio = 14500; asientos = 48 },
            @{ hora = "17:00"; duracion = 4; empresa = "Flechabus"; precio = 15500; asientos = 44 }
        )
        viajesVuelta = @(
            @{ hora = "08:00"; duracion = 4; empresa = "Flechabus"; precio = 15000; asientos = 44 },
            @{ hora = "10:00"; duracion = 4; empresa = "Chevallier"; precio = 15500; asientos = 41 },
            @{ hora = "12:00"; duracion = 4; empresa = "Plusmar"; precio = 14800; asientos = 47 },
            @{ hora = "18:00"; duracion = 4; empresa = "Flechabus"; precio = 15200; asientos = 43 }
        )
    },
    
    # ========== Buenos Aires <-> Mar del Plata ==========
    @{
        nombre = "Buenos Aires ↔ Mar del Plata"
        fechaIda = "2025-12-22"
        fechaVuelta = "2025-12-23"
        viajesIda = @(
            @{ hora = "06:00"; duracion = 5; empresa = "Plusmar"; precio = 22000; asientos = 50 },
            @{ hora = "08:00"; duracion = 5; empresa = "Chevallier"; precio = 21000; asientos = 48 },
            @{ hora = "14:00"; duracion = 5; empresa = "Rio de la Plata"; precio = 23000; asientos = 45 }
        )
        viajesVuelta = @(
            @{ hora = "10:00"; duracion = 5; empresa = "Plusmar"; precio = 22000; asientos = 48 },
            @{ hora = "16:00"; duracion = 5; empresa = "Chevallier"; precio = 21500; asientos = 46 },
            @{ hora = "20:00"; duracion = 5; empresa = "Rio de la Plata"; precio = 22500; asientos = 44 }
        )
    },
    
    # ========== Córdoba <-> Mendoza ==========
    @{
        nombre = "Córdoba ↔ Mendoza"
        fechaIda = "2025-12-25"
        fechaVuelta = "2025-12-26"
        viajesIda = @(
            @{ hora = "08:00"; duracion = 10; empresa = "Chevallier"; precio = 28000; asientos = 38 },
            @{ hora = "20:00"; duracion = 10; empresa = "TAC"; precio = 27000; asientos = 35 }
        )
        viajesVuelta = @(
            @{ hora = "09:00"; duracion = 10; empresa = "Chevallier"; precio = 28000; asientos = 37 },
            @{ hora = "21:00"; duracion = 10; empresa = "TAC"; precio = 27500; asientos = 34 }
        )
    },
    
    # ========== Buenos Aires <-> Bariloche ==========
    @{
        nombre = "Buenos Aires ↔ Bariloche"
        fechaIda = "2025-12-28"
        fechaVuelta = "2025-12-29"
        viajesIda = @(
            @{ hora = "19:00"; duracion = 19; empresa = "Via Bariloche"; precio = 55000; asientos = 30 },
            @{ hora = "20:00"; duracion = 19; empresa = "Andesmar"; precio = 53000; asientos = 28 }
        )
        viajesVuelta = @(
            @{ hora = "18:00"; duracion = 19; empresa = "Via Bariloche"; precio = 55000; asientos = 28 },
            @{ hora = "19:00"; duracion = 19; empresa = "Andesmar"; precio = 54000; asientos = 26 }
        )
    }
)

# Crear viajes
$contador = 0

Write-Host "Creando viajes..`n" -ForegroundColor Cyan

foreach ($ruta in $rutas) {
    Write-Host "━━━ $($ruta.nombre) ━━━" -ForegroundColor Magenta
    
    # Extraer origen y destino
    $ciudades = $ruta.nombre -split " ↔ "
    $origen = $ciudades[0]
    $destino = $ciudades[1]
    
    # Crear viajes de IDA
    Write-Host "  IDA ($($ruta.fechaIda)):" -ForegroundColor Cyan
    foreach ($viaje in $ruta.viajesIda) {
        $fechaSalida = "$($ruta.fechaIda)T$($viaje.hora):00Z"
        $fechaLlegada = (Get-Date $fechaSalida).AddHours($viaje.duracion).ToString("yyyy-MM-ddTHH:mm:ssZ")
        
        $body = @{
            origen = $origen
            destino = $destino
            fechaSalida = $fechaSalida
            fechaLlegada = $fechaLlegada
            empresa = $viaje.empresa
            precio = $viaje.precio
            asientosDisponibles = $viaje.asientos
        } | ConvertTo-Json
        
        try {
            Invoke-RestMethod -Uri $API_URL -Method POST -ContentType "application/json" -Body $body | Out-Null
            $contador++
            Write-Host "    ✓ $($viaje.hora) | $($viaje.empresa) | `$$($viaje.precio)" -ForegroundColor Green
        } catch {
            Write-Host "    ✗ Error: $($viaje.empresa)" -ForegroundColor Red
        }
    }
    
    # Crear viajes de VUELTA
    Write-Host "  VUELTA ($($ruta.fechaVuelta)):" -ForegroundColor Yellow
    foreach ($viaje in $ruta.viajesVuelta) {
        $fechaSalida = "$($ruta.fechaVuelta)T$($viaje.hora):00Z"
        $fechaLlegada = (Get-Date $fechaSalida).AddHours($viaje.duracion).ToString("yyyy-MM-ddTHH:mm:ssZ")
        
        $body = @{
            origen = $destino  # Invertido
            destino = $origen  # Invertido
            fechaSalida = $fechaSalida
            fechaLlegada = $fechaLlegada
            empresa = $viaje.empresa
            precio = $viaje.precio
            asientosDisponibles = $viaje.asientos
        } | ConvertTo-Json
        
        try {
            Invoke-RestMethod -Uri $API_URL -Method POST -ContentType "application/json" -Body $body | Out-Null
            $contador++
            Write-Host "    ✓ $($viaje.hora) | $($viaje.empresa) | `$$($viaje.precio)" -ForegroundColor Green
        } catch {
            Write-Host "    ✗ Error: $($viaje.empresa)" -ForegroundColor Red
        }
    }
    
    Write-Host ""
}

Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor Cyan
Write-Host "✅ Total de viajes creados: $contador" -ForegroundColor Green
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━`n" -ForegroundColor Cyan

Write-Host "📋 Rutas disponibles para probar:" -ForegroundColor Yellow
Write-Host "  1. Buenos Aires ↔ Córdoba (15-16 Dic) - 4 opciones ida, 4 vuelta" -ForegroundColor White
Write-Host "  2. Buenos Aires ↔ Mendoza (18-19 Dic) - 3 opciones ida, 3 vuelta" -ForegroundColor White
Write-Host "  3. Buenos Aires ↔ Rosario (20-21 Dic) - 4 opciones ida, 4 vuelta" -ForegroundColor White
Write-Host "  4. Buenos Aires ↔ Mar del Plata (22-23 Dic) - 3 opciones ida, 3 vuelta" -ForegroundColor White
Write-Host "  5. Córdoba ↔ Mendoza (25-26 Dic) - 2 opciones ida, 2 vuelta" -ForegroundColor White
Write-Host "  6. Buenos Aires ↔ Bariloche (28-29 Dic) - 2 opciones ida, 2 vuelta" -ForegroundColor White
