#!/bin/bash

# Script para cargar viajes de prueba (ida y vuelta)
# Para probar el sistema de reservas con múltiples opciones por ruta

# Colores
CYAN='\033[0;36m'
YELLOW='\033[1;33m'
GREEN='\033[0;32m'
RED='\033[0;31m'
MAGENTA='\033[0;35m'
WHITE='\033[1;37m'
NC='\033[0m' # No Color

echo -e "${CYAN}=== CARGAR VIAJES DE PRUEBA - IDA Y VUELTA ===${NC}"
echo -e "${YELLOW}Limpiando base de datos...${NC}"

# URL de la API
API_URL="http://localhost:9090/o/viajes"

# Limpiar viajes existentes
viajes_eliminados=0
viajes_json=$(curl -s -X GET "$API_URL")

if [ $? -eq 0 ]; then
    viaje_ids=$(echo "$viajes_json" | grep -o '"viajeId":[0-9]*' | grep -o '[0-9]*')

    for viaje_id in $viaje_ids; do
        curl -s -X DELETE "$API_URL/$viaje_id" > /dev/null
        ((viajes_eliminados++))
    done

    echo -e "${GREEN}✓ Base de datos limpia ($viajes_eliminados viajes eliminados)\n${NC}"
else
    echo -e "${YELLOW}⚠ No se pudieron eliminar viajes existentes\n${NC}"
fi

# Función para crear un viaje
crear_viaje() {
    local origen="$1"
    local destino="$2"
    local fecha_salida="$3"
    local hora="$4"
    local duracion="$5"
    local empresa="$6"
    local precio="$7"
    local asientos="$8"

    # Calcular fecha de llegada
    fecha_salida_completa="${fecha_salida}T${hora}:00Z"
    fecha_llegada=$(date -d "$fecha_salida_completa +${duracion} hours" -u +"%Y-%m-%dT%H:%M:%SZ" 2>/dev/null)

    # Si date no soporta -d (macOS), usar alternativa
    if [ $? -ne 0 ]; then
        fecha_llegada=$(date -u -j -f "%Y-%m-%dT%H:%M:%SZ" "$fecha_salida_completa" "+%Y-%m-%dT%H:%M:%SZ" 2>/dev/null)
    fi

    # Crear JSON
    json_body=$(cat <<EOF
{
    "origen": "$origen",
    "destino": "$destino",
    "fechaSalida": "$fecha_salida_completa",
    "fechaLlegada": "$fecha_llegada",
    "empresa": "$empresa",
    "precio": $precio,
    "asientosDisponibles": $asientos
}
EOF
)

    # Enviar petición
    response=$(curl -s -X POST "$API_URL" \
        -H "Content-Type: application/json" \
        -d "$json_body" \
        -w "%{http_code}" \
        -o /dev/null)

    if [ "$response" -eq 200 ] || [ "$response" -eq 201 ]; then
        echo -e "    ${GREEN}✓ $hora | $empresa | \$$precio${NC}"
        return 0
    else
        echo -e "    ${RED}✗ Error: $empresa (HTTP $response)${NC}"
        return 1
    fi
}

# Contador
contador=0

echo -e "${CYAN}Creando viajes..\n${NC}"

# ========== Buenos Aires <-> Córdoba ==========
echo -e "${MAGENTA}━━━ Buenos Aires ↔ Córdoba ━━━${NC}"
echo -e "${CYAN}  IDA (2025-12-15):${NC}"
crear_viaje "Buenos Aires" "Córdoba" "2025-12-15" "08:00" 8 "Plusmar" 25000 40 && ((contador++))
crear_viaje "Buenos Aires" "Córdoba" "2025-12-15" "10:00" 8 "Flechabus" 23000 35 && ((contador++))
crear_viaje "Buenos Aires" "Córdoba" "2025-12-15" "14:00" 8 "Chevallier" 24500 42 && ((contador++))
crear_viaje "Buenos Aires" "Córdoba" "2025-12-15" "20:00" 8 "Andesmar" 22000 38 && ((contador++))

echo -e "${YELLOW}  VUELTA (2025-12-16):${NC}"
crear_viaje "Córdoba" "Buenos Aires" "2025-12-16" "09:00" 8 "Plusmar" 25000 40 && ((contador++))
crear_viaje "Córdoba" "Buenos Aires" "2025-12-16" "11:00" 8 "Flechabus" 23500 36 && ((contador++))
crear_viaje "Córdoba" "Buenos Aires" "2025-12-16" "15:00" 8 "Chevallier" 24000 41 && ((contador++))
crear_viaje "Córdoba" "Buenos Aires" "2025-12-16" "21:00" 8 "Andesmar" 22500 37 && ((contador++))
echo ""

# ========== Buenos Aires <-> Mendoza ==========
echo -e "${MAGENTA}━━━ Buenos Aires ↔ Mendoza ━━━${NC}"
echo -e "${CYAN}  IDA (2025-12-18):${NC}"
crear_viaje "Buenos Aires" "Mendoza" "2025-12-18" "22:00" 12 "Andesmar" 35000 35 && ((contador++))
crear_viaje "Buenos Aires" "Mendoza" "2025-12-18" "23:00" 12 "Cata Internacional" 38000 30 && ((contador++))
crear_viaje "Buenos Aires" "Mendoza" "2025-12-18" "01:00" 12 "TAC" 33000 32 && ((contador++))

echo -e "${YELLOW}  VUELTA (2025-12-19):${NC}"
crear_viaje "Mendoza" "Buenos Aires" "2025-12-19" "20:00" 12 "Andesmar" 35000 33 && ((contador++))
crear_viaje "Mendoza" "Buenos Aires" "2025-12-19" "21:00" 12 "Cata Internacional" 37000 28 && ((contador++))
crear_viaje "Mendoza" "Buenos Aires" "2025-12-19" "22:30" 12 "TAC" 34000 31 && ((contador++))
echo ""

# ========== Buenos Aires <-> Rosario ==========
echo -e "${MAGENTA}━━━ Buenos Aires ↔ Rosario ━━━${NC}"
echo -e "${CYAN}  IDA (2025-12-20):${NC}"
crear_viaje "Buenos Aires" "Rosario" "2025-12-20" "07:00" 4 "Flechabus" 15000 45 && ((contador++))
crear_viaje "Buenos Aires" "Rosario" "2025-12-20" "09:00" 4 "Chevallier" 16000 42 && ((contador++))
crear_viaje "Buenos Aires" "Rosario" "2025-12-20" "11:00" 4 "Plusmar" 14500 48 && ((contador++))
crear_viaje "Buenos Aires" "Rosario" "2025-12-20" "17:00" 4 "Flechabus" 15500 44 && ((contador++))

echo -e "${YELLOW}  VUELTA (2025-12-21):${NC}"
crear_viaje "Rosario" "Buenos Aires" "2025-12-21" "08:00" 4 "Flechabus" 15000 44 && ((contador++))
crear_viaje "Rosario" "Buenos Aires" "2025-12-21" "10:00" 4 "Chevallier" 15500 41 && ((contador++))
crear_viaje "Rosario" "Buenos Aires" "2025-12-21" "12:00" 4 "Plusmar" 14800 47 && ((contador++))
crear_viaje "Rosario" "Buenos Aires" "2025-12-21" "18:00" 4 "Flechabus" 15200 43 && ((contador++))
echo ""

# ========== Buenos Aires <-> Mar del Plata ==========
echo -e "${MAGENTA}━━━ Buenos Aires ↔ Mar del Plata ━━━${NC}"
echo -e "${CYAN}  IDA (2025-12-22):${NC}"
crear_viaje "Buenos Aires" "Mar del Plata" "2025-12-22" "06:00" 5 "Plusmar" 22000 50 && ((contador++))
crear_viaje "Buenos Aires" "Mar del Plata" "2025-12-22" "08:00" 5 "Chevallier" 21000 48 && ((contador++))
crear_viaje "Buenos Aires" "Mar del Plata" "2025-12-22" "14:00" 5 "Rio de la Plata" 23000 45 && ((contador++))

echo -e "${YELLOW}  VUELTA (2025-12-23):${NC}"
crear_viaje "Mar del Plata" "Buenos Aires" "2025-12-23" "10:00" 5 "Plusmar" 22000 48 && ((contador++))
crear_viaje "Mar del Plata" "Buenos Aires" "2025-12-23" "16:00" 5 "Chevallier" 21500 46 && ((contador++))
crear_viaje "Mar del Plata" "Buenos Aires" "2025-12-23" "20:00" 5 "Rio de la Plata" 22500 44 && ((contador++))
echo ""

# ========== Córdoba <-> Mendoza ==========
echo -e "${MAGENTA}━━━ Córdoba ↔ Mendoza ━━━${NC}"
echo -e "${CYAN}  IDA (2025-12-25):${NC}"
crear_viaje "Córdoba" "Mendoza" "2025-12-25" "08:00" 10 "Chevallier" 28000 38 && ((contador++))
crear_viaje "Córdoba" "Mendoza" "2025-12-25" "20:00" 10 "TAC" 27000 35 && ((contador++))

echo -e "${YELLOW}  VUELTA (2025-12-26):${NC}"
crear_viaje "Mendoza" "Córdoba" "2025-12-26" "09:00" 10 "Chevallier" 28000 37 && ((contador++))
crear_viaje "Mendoza" "Córdoba" "2025-12-26" "21:00" 10 "TAC" 27500 34 && ((contador++))
echo ""

# ========== Buenos Aires <-> Bariloche ==========
echo -e "${MAGENTA}━━━ Buenos Aires ↔ Bariloche ━━━${NC}"
echo -e "${CYAN}  IDA (2025-12-28):${NC}"
crear_viaje "Buenos Aires" "Bariloche" "2025-12-28" "19:00" 19 "Via Bariloche" 55000 30 && ((contador++))
crear_viaje "Buenos Aires" "Bariloche" "2025-12-28" "20:00" 19 "Andesmar" 53000 28 && ((contador++))

echo -e "${YELLOW}  VUELTA (2025-12-29):${NC}"
crear_viaje "Bariloche" "Buenos Aires" "2025-12-29" "18:00" 19 "Via Bariloche" 55000 28 && ((contador++))
crear_viaje "Bariloche" "Buenos Aires" "2025-12-29" "19:00" 19 "Andesmar" 54000 26 && ((contador++))
echo ""

echo -e "${CYAN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
echo -e "${GREEN}✅ Total de viajes creados: $contador${NC}"
echo -e "${CYAN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n${NC}"

echo -e "${YELLOW}📋 Rutas disponibles para probar:${NC}"
echo -e "${WHITE}  1. Buenos Aires ↔ Córdoba (15-16 Dic) - 4 opciones ida, 4 vuelta${NC}"
echo -e "${WHITE}  2. Buenos Aires ↔ Mendoza (18-19 Dic) - 3 opciones ida, 3 vuelta${NC}"
echo -e "${WHITE}  3. Buenos Aires ↔ Rosario (20-21 Dic) - 4 opciones ida, 4 vuelta${NC}"
echo -e "${WHITE}  4. Buenos Aires ↔ Mar del Plata (22-23 Dic) - 3 opciones ida, 3 vuelta${NC}"
echo -e "${WHITE}  5. Córdoba ↔ Mendoza (25-26 Dic) - 2 opciones ida, 2 vuelta${NC}"
echo -e "${WHITE}  6. Buenos Aires ↔ Bariloche (28-29 Dic) - 2 opciones ida, 2 vuelta${NC}"