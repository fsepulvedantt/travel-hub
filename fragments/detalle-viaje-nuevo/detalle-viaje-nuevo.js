(function () {
    'use strict';

    // Funciones de formateo
    function formatDate(timestamp) {
        const date = new Date(timestamp);
        const days = ['Dom', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'];
        const months = ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'];

        const dayName = days[date.getDay()];
        const day = date.getDate().toString().padStart(2, '0');
        const month = months[date.getMonth()];

        return `${dayName} ${day} ${month}`;
    }

    function formatTime(timestamp) {
        const date = new Date(timestamp);
        const hours = date.getHours().toString().padStart(2, '0');
        const minutes = date.getMinutes().toString().padStart(2, '0');
        return `${hours}:${minutes}`;
    }

    function calculateDuration(startTimestamp, endTimestamp) {
        const diff = endTimestamp - startTimestamp;
        const hours = Math.floor(diff / (1000 * 60 * 60));
        const minutes = Math.floor((diff % (1000 * 60 * 60)) / (1000 * 60));
        return `${hours}h ${minutes.toString().padStart(2, '0')}m`;
    }

    function formatPrice(price) {
        return new Intl.NumberFormat('es-AR', {
            style: 'currency',
            currency: 'ARS',
            minimumFractionDigits: 2
        }).format(price);
    }

    // Cargar datos del viaje
    function loadViajeData(viaje, suffix) {
        document.getElementById(`origen${suffix}`).textContent = viaje.origen;
        document.getElementById(`destino${suffix}`).textContent = viaje.destino;
        document.getElementById(`fechaSalida${suffix}`).textContent = formatDate(viaje.fechaSalida);
        document.getElementById(`horaSalida${suffix}`).textContent = formatTime(viaje.fechaSalida);
        document.getElementById(`fechaLlegada${suffix}`).textContent = formatDate(viaje.fechaLlegada);
        document.getElementById(`horaLlegada${suffix}`).textContent = formatTime(viaje.fechaLlegada);
        document.getElementById(`empresa${suffix}`).textContent = viaje.empresa;
        document.getElementById(`duracion${suffix}`).textContent = calculateDuration(viaje.fechaSalida, viaje.fechaLlegada);
        document.getElementById(`precio${suffix}`).textContent = formatPrice(viaje.precio);
    }

    // Función principal
    async function loadTravelDetails() {
        const loadingState = document.getElementById('loadingState');
        const errorState = document.getElementById('errorState');
        const mainContent = document.getElementById('mainContent');
        const viajeIdaEl = document.getElementById('viajeIda');
        const viajeVueltaEl = document.getElementById('viajeVuelta');
        const summaryItems = document.getElementById('summaryItems');

        try {
            // Simular datos de prueba si no hay sessionStorage

            const viajeIdaJson = sessionStorage.getItem('viajeIda');
            const viajeVueltaJson = sessionStorage.getItem('viajeVuelta');

            if (!viajeIdaJson) {
                throw new Error('No se encontró información del viaje de ida en sessionStorage');
            }

            const viajeIda = JSON.parse(viajeIdaJson);
            const viajeVuelta = viajeVueltaJson ? JSON.parse(viajeVueltaJson) : null;

            let total = viajeIda.precio;

            // Cargar viaje de ida
            loadViajeData(viajeIda, 'Ida');
            viajeIdaEl.classList.remove('hidden');

            // Agregar al resumen
            summaryItems.innerHTML = `
            <div class="summary-row">
              <span class="summary-label">
                <i class="bi bi-arrow-right-circle"></i>
                Viaje de Ida
              </span>
              <span class="summary-amount">${formatPrice(viajeIda.precio)}</span>
            </div>
          `;

            // Cargar viaje de vuelta si existe
            if (viajeVuelta) {
                total += viajeVuelta.precio;
                loadViajeData(viajeVuelta, 'Vuelta');
                viajeVueltaEl.classList.remove('hidden');

                summaryItems.innerHTML += `
              <div class="summary-row">
                <span class="summary-label">
                  <i class="bi bi-arrow-left-circle"></i>
                  Viaje de Vuelta
                </span>
                <span class="summary-amount">${formatPrice(viajeVuelta.precio)}</span>
              </div>
            `;
            }

            // Actualizar total
            document.getElementById('totalAmount').textContent = formatPrice(total);

            // Mostrar contenido
            loadingState.classList.add('hidden');
            mainContent.classList.remove('hidden');

            // Configurar botón continuar
            const btnContinuar = document.getElementById('btnContinuar');
            btnContinuar.addEventListener('click', () => {
                const idaId = viajeIda.viajeId;
                const vueltaId = viajeVuelta ? viajeVuelta.viajeId : null;

                if (vueltaId) {
                    window.location.href = `/formulario-reserva?viajeIdIda=${idaId}&viajeIdVuelta=${vueltaId}`;
                } else {
                    window.location.href = `/formulario-reserva?viajeIdIda=${idaId}`;
                }
            });

        } catch (error) {
            console.error('Error al cargar viajes:', error);
            loadingState.classList.add('hidden');
            mainContent.classList.add('hidden');
            errorState.classList.remove('hidden');
        }
    }

    // Inicializar
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', loadTravelDetails);
    } else {
        loadTravelDetails();
    }
})();