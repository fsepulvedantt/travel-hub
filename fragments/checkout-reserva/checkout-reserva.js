(function() {
    'use strict';
    const RESULTADOS_PAGE_URL = '/resultado-de-viajes';
    const form = document.getElementById('formBusquedaViaje');
    const inputOrigen = document.getElementById('inputOrigen');
    const inputDestino = document.getElementById('inputDestino');
    const inputPartida = document.getElementById('inputPartida');
    const inputRegreso = document.getElementById('inputRegreso');
    const inputPasajeros = document.getElementById('inputPasajeros');
    const mensajesAlerta = document.getElementById('mensajesAlerta');


    function mostrarMensaje(mensaje, tipo = 'warning') {
        const alertClass = {
            'success': 'alert-success',
            'error': 'alert-danger',
            'warning': 'alert-warning',
            'info': 'alert-info'
        };

        mensajesAlerta.innerHTML = `
            <div class="alert ${alertClass[tipo]} alert-dismissible fade show" role="alert">
                ${mensaje}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
        `;

        setTimeout(() => {
            mensajesAlerta.innerHTML = '';
        }, 5000);
    }

    function validarFormulario() {
        const origen = inputOrigen.value.trim();
        const destino = inputDestino.value.trim();
        const fechaPartida = inputPartida.value;
        const pasajeros = parseInt(inputPasajeros.value);

        if (!origen || !destino || !fechaPartida || !pasajeros) {
            mostrarMensaje('Por favor, completa todos los campos obligatorios.');
            return false;
        }

        if (pasajeros < 1) {
            mostrarMensaje('El número de pasajeros debe ser al menos 1.');
            return false;
        }

        // Validar que la fecha de partida no sea pasada
        const hoy = new Date();
        hoy.setHours(0, 0, 0, 0);
        const fechaSeleccionada = new Date(fechaPartida);

        if (fechaSeleccionada < hoy) {
            mostrarMensaje('La fecha de partida no puede ser anterior a hoy.');
            return false;
        }

        // Validar fecha de regreso si existe
        const fechaRegreso = inputRegreso.value;
        if (fechaRegreso) {
            const fechaRegresoDate = new Date(fechaRegreso);
            if (fechaRegresoDate < fechaSeleccionada) {
                mostrarMensaje('La fecha de regreso debe ser posterior a la fecha de partida.');
                return false;
            }
        }

        return true;
    }

    function construirURLConParametros() {
        const params = new URLSearchParams();

        params.append('origen', inputOrigen.value.trim());
        params.append('destino', inputDestino.value.trim());
        params.append('fechaPartida', inputPartida.value);
        params.append('pasajeros', inputPasajeros.value);

        // Solo agregar fecha de regreso si se completó
        if (inputRegreso.value) {
            params.append('fechaRegreso', inputRegreso.value);
        }

        return `${RESULTADOS_PAGE_URL}?${params.toString()}`;
    }

    form.addEventListener('submit', function(e) {
        e.preventDefault();

        if (!validarFormulario()) {
            return;
        }

        const url = construirURLConParametros();
        console.log('Redirigiendo a:', url);
        window.location.href = url;
    });

    // Establecer fecha mínima en los inputs de fecha
    const hoy = new Date().toISOString().split('T')[0];
    inputPartida.setAttribute('min', hoy);
    inputRegreso.setAttribute('min', hoy);

    // Actualizar fecha mínima de regreso cuando cambia la fecha de partida
    inputPartida.addEventListener('change', function() {
        if (inputRegreso.value && inputRegreso.value < this.value) {
            inputRegreso.value = '';
        }
    });

})();