(async function () {
    'use strict';

    // Función Formateo Dias
    function formatDate(timestamp) {
        var date = new Date(timestamp);
        var days = ['Dom', 'Lun', 'Mar', 'Mié', 'Jue', 'Vie', 'Sáb'];
        var months = ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun', 'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'];

        var dayName = days[date.getDay()];
        var day = date.getDate().toString().padStart(2, '0');
        var month = months[date.getMonth()];

        return dayName + ' ' + day + ' ' + month;
    }

    // Función Formateo Horas
    function formatTime(timestamp) {
        var date = new Date(timestamp);
        var hours = date.getHours().toString().padStart(2, '0');
        var minutes = date.getMinutes().toString().padStart(2, '0');
        return hours + ':' + minutes;
    }

    // Función Formateo Duración
    function calculateDuration(startTimestamp, endTimestamp) {
        var diff = endTimestamp - startTimestamp;
        var hours = Math.floor(diff / (1000 * 60 * 60));
        var minutes = Math.floor((diff % (1000 * 60 * 60)) / (1000 * 60));
        return hours + 'h-' + minutes.toString().padStart(2, '0') + 'm';
    }

    // Función Formateo Precios
    function formatPrice(price) {
        return 'ARS ' + price.toFixed(2).replace(/\d(?=(\d{3})+\.)/g, '$&.').replace('.', ',').replace(/\.(\d{3})/g, '.$1');
    }

    // Función de actualización de etiquetas segun ID
    function loadViajeData(viaje, suffix) {
        document.getElementById('origen' + suffix).textContent = viaje.origen;
        document.getElementById('destino' + suffix).textContent = viaje.destino;

        document.getElementById('fechaSalida' + suffix).textContent = formatDate(viaje.fechaSalida);
        document.getElementById('horaSalida' + suffix).textContent = formatTime(viaje.fechaSalida);

        document.getElementById('fechaLlegada' + suffix).textContent = formatDate(viaje.fechaLlegada);
        document.getElementById('horaLlegada' + suffix).textContent = formatTime(viaje.fechaLlegada);

        document.getElementById('empresa' + suffix).textContent = viaje.empresa;
        document.getElementById('duracion' + suffix).textContent = 'Duración: ' + calculateDuration(viaje.fechaSalida, viaje.fechaLlegada);

        var precioPasajes = viaje.precio;
        var total = precioPasajes;

        document.getElementById('precioPasajes' + suffix).textContent = formatPrice(precioPasajes);
    }

    // Función principal de carga del detalle
    async function loadTravelDetails() {
        var loadingState = document.getElementById('loadingState');
        var errorState = document.getElementById('errorState');
        var viajeIdaFragment = document.getElementById('viajeIdaFragment');
        var viajeVueltaFragment = document.getElementById('viajeVueltaFragment');

        try {
            var viajeIdaJson = sessionStorage.getItem('viajeIda');
            var viajeVueltaJson = sessionStorage.getItem('viajeVuelta');

            if (!viajeIdaJson) {
                throw new Error('No se encontró información del viaje de ida en sessionStorage');
            }

            var viajeIda = JSON.parse(viajeIdaJson);
            var total = viajeIda.precio;

            loadingState.style.display = 'none';

            // Cargar viaje de ida
            loadViajeData(viajeIda, 'Ida');
            viajeIdaFragment.style.display = 'block';

            // Cargar viaje de vuelta si existe
            if (viajeVueltaJson) {
                var viajeVuelta = JSON.parse(viajeVueltaJson);
                total = total + viajeVuelta.precio;
                loadViajeData(viajeVuelta, 'Vuelta');
                viajeVueltaFragment.style.display = 'block';
            }

            document.getElementById('totalAmount').textContent = formatPrice(total);

        } catch (error) {
            console.error('Error:', error);
            loadingState.style.display = 'none';
					  viajeIdaFragment.style.display = 'none';
            errorState.style.display = 'block';
        }
    }

    // Validación previa antes de cargar la pagina
    if (document.readyState === 'loading') {
        document.addEventListener('DOMContentLoaded', loadTravelDetails);
    } else {
        await loadTravelDetails();
    }
})();