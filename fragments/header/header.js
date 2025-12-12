(function() {
  'use strict';

  const btnConsultarPasaje = document.getElementById('btnConsultarPasaje');
  const btnBuscarReserva = document.getElementById('btnBuscarReserva');
  const btnCancelar = document.getElementById('btnCancelar');
  const btnCerrarModal = document.getElementById('btnCerrarModal');
  const modal = document.getElementById('modalConsultarPasaje');
  const nroReservaInput = document.getElementById('nroReserva');
  const mensajeError = document.getElementById('mensajeError');
  const btnTexto = document.getElementById('btnTexto');
  const btnSpinner = document.getElementById('btnSpinner');

  let backdrop = null;

  // Función para abrir modal
  function abrirModal() {
    // Limpiar campos
    nroReservaInput.value = '';
    mensajeError.classList.add('d-none');
    resetearBoton();

    // Crear backdrop
    backdrop = document.createElement('div');
    backdrop.className = 'modal-backdrop fade';
    document.body.appendChild(backdrop);

    // Mostrar modal y backdrop
    modal.style.display = 'block';
    document.body.classList.add('modal-open');

    // Activar animaciones
    setTimeout(function() {
      modal.classList.add('show');
      backdrop.classList.add('show');
    }, 150);

    // Focus en el input
    setTimeout(function() {
      nroReservaInput.focus();
    }, 300);
  }

  // Función para cerrar modal
  function cerrarModal() {
    modal.classList.remove('show');
    if (backdrop) {
      backdrop.classList.remove('show');
    }

    setTimeout(function() {
      modal.style.display = 'none';
      document.body.classList.remove('modal-open');
      if (backdrop && backdrop.parentNode) {
        backdrop.parentNode.removeChild(backdrop);
        backdrop = null;
      }
      resetearBoton();
    }, 150);
  }

  // Event listeners para abrir/cerrar modal
  btnConsultarPasaje.addEventListener('click', abrirModal);
  btnCancelar.addEventListener('click', cerrarModal);
  btnCerrarModal.addEventListener('click', cerrarModal);

  // Cerrar modal al hacer click fuera de él
  modal.addEventListener('click', function(e) {
    if (e.target === modal) {
      cerrarModal();
    }
  });

  // Cerrar modal con tecla Escape
  document.addEventListener('keydown', function(e) {
    if (e.key === 'Escape' && modal.classList.contains('show')) {
      cerrarModal();
    }
  });

  // Buscar reserva
  btnBuscarReserva.addEventListener('click', function() {
    buscarReserva();
  });

  // Permitir buscar con Enter
  nroReservaInput.addEventListener('keypress', function(e) {
    if (e.key === 'Enter') {
      e.preventDefault();
      buscarReserva();
    }
  });

  function buscarReserva() {
    const nroReserva = nroReservaInput.value.trim();

    // Validar que no esté vacío
    if (!nroReserva) {
      mostrarError('Por favor ingrese un número de reserva');
      return;
    }

    // Mostrar spinner y deshabilitar botón
    btnTexto.textContent = 'Buscando...';
    btnSpinner.classList.remove('d-none');
    btnBuscarReserva.disabled = true;
    mensajeError.classList.add('d-none');

    // Hacer GET a la API
    fetch('/o/reservas/' + nroReserva)
      .then(function(response) {
        if (response.ok) {
          return response.json();
        } else if (response.status === 404) {
          throw new Error('No se encontró ninguna reserva con ese número');
        } else {
          throw new Error('Error al consultar la reserva. Por favor intente nuevamente.');
        }
      })
      .then(function(reserva) {
        // Reserva encontrada - redirigir a la página de detalle
        window.location.href = '/detalle-pasaje?reservaId=' + reserva.reservaId;
      })
      .catch(function(error) {
        mostrarError(error.message);
        resetearBoton();
      });
  }

  function mostrarError(mensaje) {
    mensajeError.textContent = mensaje;
    mensajeError.classList.remove('d-none');
  }

  function resetearBoton() {
    btnTexto.textContent = 'Buscar';
    btnSpinner.classList.add('d-none');
    btnBuscarReserva.disabled = false;
  }
})();