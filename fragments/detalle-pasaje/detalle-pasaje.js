(function() {
  'use strict';

  function obtenerIdReservaDeURL() {
    // Opción 1: Query parameter (?reservaId=123)
    const urlParams = new URLSearchParams(window.location.search);
    let idReserva = urlParams.get('reservaId') || urlParams.get('id');
    return idReserva;
  }

  function formatearFecha(timestamp) {
    if (!timestamp) return '-';
    const fecha = new Date(timestamp);
    const dia = String(fecha.getDate()).padStart(2, '0');
    const mes = String(fecha.getMonth() + 1).padStart(2, '0');
    const anio = fecha.getFullYear();
    const horas = String(fecha.getHours()).padStart(2, '0');
    const minutos = String(fecha.getMinutes()).padStart(2, '0');
    return dia + '/' + mes + '/' + anio + ', ' + horas + ':' + minutos;
  }

  function formatearPrecio(precio) {
    if (!precio && precio !== 0) return '-';
    return '$' + Number(precio).toLocaleString('es-AR', { minimumFractionDigits: 2, maximumFractionDigits: 2 });
  }

  function formatearTipoReserva(tipo) {
    const tipos = {
      'IDA': 'Solo Ida',
      'VUELTA': 'Solo Vuelta',
      'IDA_VUELTA': 'Ida y Vuelta'
    };
    return tipos[tipo] || tipo;
  }

  function cargarReserva(idReserva) {
    mostrarCargando(true);
    ocultarError();

    fetch('/o/reservas/' + idReserva)
      .then(function(response) {
        if (!response.ok) {
          throw new Error('Error al cargar la reserva: ' + response.status);
        }
        return response.json();
      })
      .then(function(data) {
        mostrarCargando(false);
        llenarDatosReserva(data);

        if (data.idViajeIda) {
          cargarViaje(data.idViajeIda, 'ida');
        }
        if (data.idViajeVuelta) {
          cargarViaje(data.idViajeVuelta, 'vuelta');
        }
      })
      .catch(function(error) {
        console.error('Error:', error);
        mostrarCargando(false);
        mostrarError('No se pudo cargar la información de la reserva. Por favor, intente nuevamente.');
      });
  }

  function cargarViaje(idViaje, tipo) {
    fetch('/o/viajes/' + idViaje)
      .then(function(response) {
        if (!response.ok) {
          throw new Error('Error al cargar el viaje: ' + response.status);
        }
        return response.json();
      })
      .then(function(data) {
        llenarDatosViaje(data, tipo);
      })
      .catch(function(error) {
        console.error('Error al cargar viaje ' + tipo + ':', error);
      });
  }

  function llenarDatosReserva(reserva) {

    const reservaIdElem = document.getElementById('reservaId');
    if (reservaIdElem) reservaIdElem.textContent = reserva.reservaId;

    const tipoReservaElem = document.getElementById('tipoReserva');
    if (tipoReservaElem) tipoReservaElem.textContent = formatearTipoReserva(reserva.tipoReserva);

    // Datos del pasajero
    const dniElem = document.getElementById('dni');
    if (dniElem) dniElem.textContent = reserva.dni || '-';

    const mailElem = document.getElementById('mail');
    if (mailElem) mailElem.textContent = reserva.mail || '-';
  }

  function llenarDatosViaje(viaje, tipo) {
    const sufijo = tipo === 'ida' ? 'Ida' : 'Vuelta';
    const cardId = tipo === 'ida' ? 'viajeIdaCard' : 'viajeVueltaCard';

    const card = document.getElementById(cardId);
    if (card) card.style.display = 'block';

    const origenElem = document.getElementById('origen' + sufijo);
    if (origenElem) origenElem.textContent = viaje.origen || '-';

    const destinoElem = document.getElementById('destino' + sufijo);
    if (destinoElem) destinoElem.textContent = viaje.destino || '-';

    const fechaSalidaElem = document.getElementById('fechaSalida' + sufijo);
    if (fechaSalidaElem) fechaSalidaElem.textContent = formatearFecha(viaje.fechaSalida);

    const fechaLlegadaElem = document.getElementById('fechaLlegada' + sufijo);
    if (fechaLlegadaElem) fechaLlegadaElem.textContent = formatearFecha(viaje.fechaLlegada);

    const empresaElem = document.getElementById('empresa' + sufijo);
    if (empresaElem) empresaElem.textContent = viaje.empresa || viaje.nombreEmpresa || '-';

    const precioElem = document.getElementById('precio' + sufijo);
    if (precioElem) precioElem.textContent = formatearPrecio(viaje.precio);
  }

  function mostrarCargando(mostrar) {
    const loadingMessage = document.getElementById('loadingMessage');
    const contentContainer = document.querySelector('.row.mt-4');

    if (loadingMessage) {
      loadingMessage.style.display = mostrar ? 'block' : 'none';
    }
    if (contentContainer) {
      contentContainer.style.display = mostrar ? 'none' : 'flex';
    }
  }

  function mostrarError(mensaje) {
    const errorMessage = document.getElementById('errorMessage');
    const errorText = document.getElementById('errorText');
    const contentContainer = document.querySelector('.row.mt-4');

    if (errorMessage) {
      errorMessage.style.display = 'block';
    }
    if (errorText) {
      errorText.textContent = mensaje;
    }
    if (contentContainer) {
      contentContainer.style.display = 'none';
    }
  }

  function ocultarError() {
    const errorMessage = document.getElementById('errorMessage');
    if (errorMessage) {
      errorMessage.style.display = 'none';
    }
  }

  function configurarBotonVolverHome() {
    const btnInicio = document.getElementById('btn-inicio');
		btnInicio.addEventListener('click', function(e) {
        e.preventDefault();
        window.location.href = '/';
    });
  }

  function inicializar() {
    const idReserva = obtenerIdReservaDeURL();

    if (!idReserva) {
      mostrarError('No se especificó un ID de reserva válido');
      return;
    }

    configurarBotonVolverHome();
    cargarReserva(idReserva);

    console.log('Página de detalle de reserva cargada - ID:', idReserva);
  }

  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', inicializar);
  } else {
    inicializar();
  }

})();