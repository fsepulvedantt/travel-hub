# Script para cargar viajes con múltiples fechas disponibles
# Esto permite buscar cualquier fecha y encontrar resultados

Write-Host "=== CARGAR VIAJES CON MÚLTIPLES FECHAS ===" -ForegroundColor Cyan

$API_URL = "http://localhost:8080/o/viajes"

# Limpiar viajes existentes
Write-Host "`nLimpiando base de datos..." -ForegroundColor Yellow
try {
    $viajesExistentes = Invoke-RestMethod -Uri $API_URL -Method GET
    foreach ($viaje in $viajesExistentes) {
        Invoke-RestMethod -Uri "$API_URL/$($viaje.viajeId)" -Method DELETE | Out-Null
    }
    Write-Host "✓ Base de datos limpia ($($viajesExistentes.Count) viajes eliminados)" -ForegroundColor Green
} catch {
    Write-Host "⚠ Error al limpiar BD" -ForegroundColor Yellow
}

# Definir rutas principales
$rutasPrincipales = @(
    @{ origen = "Buenos Aires"; destino = "Córdoba"; duracion = 8; empresas = @("Plusmar", "Flechabus", "Chevallier") },
    @{ origen = "Córdoba"; destino = "Buenos Aires"; duracion = 8; empresas = @("Plusmar", "Flechabus", "Andesmar") },
    @{ origen = "Buenos Aires"; destino = "Mendoza"; duracion = 12; empresas = @("Andesmar", "Cata Internacional") },
    @{ origen = "Mendoza"; destino = "Buenos Aires"; duracion = 12; empresas = @("Andesmar", "TAC") },
    @{ origen = "Buenos Aires"; destino = "Rosario"; duracion = 4; empresas = @("Flechabus", "Chevallier") },
    @{ origen = "Rosario"; destino = "Buenos Aires"; duracion = 4; empresas = @("Flechabus", "Plusmar") },
    @{ origen = "Córdoba"; destino = "Mendoza"; duracion = 10; empresas = @("Andesmar") },
    @{ origen = "Mendoza"; destino = "Córdoba"; duracion = 10; empresas = @("Andesmar") }
)

# Horarios disponibles
$horariosSalida = @("08:00", "10:00", "14:00", "20:00", "22:00")

# Precios base por distancia
$preciosBase = @{
    4 = 15000   # Corta distancia (Rosario)
    8 = 24000   # Media distancia (Córdoba)
    10 = 30000  # Media-larga (Córdoba-Mendoza)
    12 = 35000  # Larga distancia (Mendoza)
}

# Generar viajes para los próximos 30 días
$fechaInicio = Get-Date
$totalViajes = 0

Write-Host "`nGenerando viajes..." -ForegroundColor Yellow

for ($dia = 0; $dia -lt 30; $dia++) {
    $fecha = $fechaInicio.AddDays($dia)
    $fechaStr = $fecha.ToString("yyyy-MM-dd")
    
    foreach ($ruta in $rutasPrincipales) {
        # Seleccionar 2-3 horarios aleatorios para esta ruta en este día
        $horariosDelDia = $horariosSalida | Get-Random -Count (Get-Random -Minimum 2 -Maximum 4)
        
        foreach ($hora in $horariosDelDia) {
            # Seleccionar empresa aleatoria
            $empresa = $ruta.empresas | Get-Random
            
            # Calcular precio con variación
            $precioBase = $preciosBase[$ruta.duracion]
            $variacion = Get-Random -Minimum -2000 -Maximum 3000
            $precio = $precioBase + $variacion
            
            # Asientos aleatorios
            $asientos = Get-Random -Minimum 25 -Maximum 50
            
            # Calcular fechas
            $fechaSalida = Get-Date "$fechaStr $hora"
            $fechaLlegada = $fechaSalida.AddHours($ruta.duracion)
            
            $viaje = @{
                origen = $ruta.origen
                destino = $ruta.destino
                fechaSalida = $fechaSalida.ToString("yyyy-MM-ddTHH:mm:ss.fffZ")
                fechaLlegada = $fechaLlegada.ToString("yyyy-MM-ddTHH:mm:ss.fffZ")
                empresa = $empresa
                precio = $precio
                asientosDisponibles = $asientos
            } | ConvertTo-Json
            
            try {
                Invoke-RestMethod -Uri $API_URL -Method POST -Body $viaje -ContentType "application/json" | Out-Null
                $totalViajes++
                
                if ($totalViajes % 20 -eq 0) {
                    Write-Host "  ✓ $totalViajes viajes creados..." -ForegroundColor Gray
                }
            } catch {
                Write-Host "  ✗ Error al crear viaje: $($_.Exception.Message)" -ForegroundColor Red
            }
        }
    }
}

Write-Host "`n✅ COMPLETADO: $totalViajes viajes cargados" -ForegroundColor Green
Write-Host "   Fechas disponibles: $($fechaInicio.ToString('dd/MM/yyyy')) a $($fechaInicio.AddDays(29).ToString('dd/MM/yyyy'))" -ForegroundColor Cyan
Write-Host "   Rutas: $($rutasPrincipales.Count)" -ForegroundColor Cyan
Write-Host "`n"
