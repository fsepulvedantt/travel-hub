(function() {
  const API_RESERVAS = '/o/reservas';
  let viajeInfo = {};

  // Obtener parámetros de la URL
  function obtenerParametrosURL() {
    const urlParams = new URLSearchParams(window.location.search);
    return {
      viajeIdIda: urlParams.get('viajeIdIda'),
      viajeIdVuelta: urlParams.get('viajeIdVuelta')
    };
  }

  // Formatear precio
  function formatearPrecio(precio) {
    return new Intl.NumberFormat('es-AR', {
      style: 'currency',
      currency: 'ARS',
      minimumFractionDigits: 2
    }).format(precio);
  }

  // Formatear fecha completa
  function formatearFechaCompleta(fechaString) {
    const timestamp = typeof fechaString === 'string' ? parseInt(fechaString) : fechaString;
    const fecha = new Date(timestamp);
    return fecha.toLocaleDateString('es-AR', {
      day: '2-digit',
      month: '2-digit',
      year: 'numeric',
      hour: '2-digit',
      minute: '2-digit'
    });
  }

  // Formatear número de tarjeta (agregar espacios)
  function formatearTarjeta(input) {
    let valor = input.value.replace(/\s/g, '');
    let formato = valor.match(/.{1,4}/g);
    input.value = formato ? formato.join(' ') : valor;
  }

  // Formatear vencimiento (agregar /)
  function formatearVencimiento(input) {
    let valor = input.value.replace(/\D/g, '');
    if (valor.length >= 2) {
      input.value = valor.substring(0, 2) + '/' + valor.substring(2, 4);
    } else {
      input.value = valor;
    }
  }

  // Validar formato de DNI
  function validarDNI(dni) {
    return /^[0-9]{7,8}$/.test(dni);
  }

  // Validar formato de email
  function validarEmail(email) {
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
  }

  // Inicializar formulario
  function inicializarFormulario() {
    const urlParams = obtenerParametrosURL();

    if (!urlParams.viajeIdIda) {
      mostrarError('No se encontró información del viaje. Por favor, seleccione un viaje desde la lista.');
      return;
    }

    // Obtener viajes de sessionStorage
    const viajeIda = JSON.parse(sessionStorage.getItem('viajeIda'));
    const viajeVuelta = urlParams.viajeIdVuelta ? JSON.parse(sessionStorage.getItem('viajeVuelta')) : null;
    const tipoReserva = sessionStorage.getItem('tipoReserva') || 'IDA';

    if (!viajeIda) {
      mostrarError('No se encontró información del viaje de ida.');
      return;
    }

    // Guardar en viajeInfo
    viajeInfo = {
      viajeIdIda: viajeIda.viajeId,
      viajeIdVuelta: viajeVuelta ? viajeVuelta.viajeId : null,
      tipoReserva: tipoReserva,
      viajeIda: viajeIda,
      viajeVuelta: viajeVuelta
    };

    // Mostrar resumen
    let resumenHTML = `
      <div class="card border-0 shadow-sm">
        <div class="card-header bg-primary text-white">
          <h6 class="mb-0"><i class="fas fa-ticket-alt"></i> Resumen de tu Viaje</h6>
        </div>
        <div class="card-body p-0">
          <!-- Viaje de Ida -->
          <div class="p-3 border-bottom">
            <div class="d-flex align-items-center mb-2">
              <span class="badge bg-primary text-white me-2">Ida</span>
              <small class="text-muted">${formatearFechaCompleta(viajeIda.fechaSalida)}</small>
            </div>
            <div class="d-flex justify-content-between align-items-center">
              <div>
                <h6 class="mb-1">${viajeIda.origen} <i class="fas fa-arrow-right text-primary"></i> ${viajeIda.destino}</h6>
                <small class="text-muted"><i class="fas fa-building"></i> ${viajeIda.empresa}</small>
              </div>
              <div class="text-end">
                <h6 class="mb-0">${formatearPrecio(viajeIda.precio)}</h6>
              </div>
            </div>
          </div>
    `;

    if (viajeVuelta) {
      resumenHTML += `
          <!-- Viaje de Vuelta -->
          <div class="p-3 border-bottom">
            <div class="d-flex align-items-center mb-2">
              <span class="badge bg-success me-2 text-white">Vuelta</span>
              <small class="text-muted">${formatearFechaCompleta(viajeVuelta.fechaSalida)}</small>
            </div>
            <div class="d-flex justify-content-between align-items-center">
              <div>
                <h6 class="mb-1">${viajeVuelta.origen} <i class="fas fa-arrow-right text-success"></i> ${viajeVuelta.destino}</h6>
                <small class="text-muted"><i class="fas fa-building"></i> ${viajeVuelta.empresa}</small>
              </div>
              <div class="text-end">
                <h6 class="mb-0">${formatearPrecio(viajeVuelta.precio)}</h6>
              </div>
            </div>
          </div>
      `;
    }

    const precioTotal = viajeIda.precio + (viajeVuelta ? viajeVuelta.precio : 0);
    resumenHTML += `
          <!-- Total -->
          <div class="p-3 bg-light">
            <div class="d-flex justify-content-between align-items-center">
              <h5 class="mb-0">Total a Pagar:</h5>
              <h4 class="mb-0 text-success fw-bold">${formatearPrecio(precioTotal)}</h4>
            </div>
          </div>
        </div>
      </div>
    `;

    document.getElementById('rutaResumen').innerHTML = resumenHTML;
    
    // Ocultar el elemento precioResumen ya que ahora lo mostramos en rutaResumen
    const precioResumenElement = document.getElementById('precioResumen');
    if (precioResumenElement) {
      precioResumenElement.style.display = 'none';
    }

    // Formateo automático de campos
    const inputTarjeta = document.getElementById('numeroTarjeta');
    inputTarjeta.addEventListener('input', () => formatearTarjeta(inputTarjeta));

    const inputVencimiento = document.getElementById('vencimiento');
    inputVencimiento.addEventListener('input', () => formatearVencimiento(inputVencimiento));

    // Solo números en DNI y CVV
    document.getElementById('dni').addEventListener('input', function(e) {
      this.value = this.value.replace(/\D/g, '');
    });

    const inputCVV = document.getElementById('cvv');
    inputCVV.addEventListener('input', function(e) {
      this.value = this.value.replace(/\D/g, '');
    });

    // Autocompletar titular con nombre
    document.getElementById('nombre').addEventListener('blur', function() {
      const titular = document.getElementById('titular');
      if (!titular.value && this.value) {
        titular.value = this.value.toUpperCase();
      }
    });

    // Botón cancelar
    document.getElementById('btnCancelar').addEventListener('click', () => {
      window.history.back();
    });

    // Submit del formulario
    document.getElementById('formReserva').addEventListener('submit', procesarReserva);

    // Botón volver al inicio en modal
    document.getElementById('btnVolverInicio').addEventListener('click', () => {
      window.location.href = '/web/travelhub';
    });

    // Cerrar modal al hacer click fuera
    const modal = document.getElementById('modalExito');
    if (modal) {
      modal.addEventListener('click', (e) => {
        if (e.target === modal) {
          cerrarModal();
        }
      });
    }

    // Botón cerrar modal
    const btnCerrarModal = document.getElementById('btnCerrarModal');
    if (btnCerrarModal) {
      btnCerrarModal.addEventListener('click', cerrarModal);
    }
  }

  // Cerrar modal
  function cerrarModal() {
    const modal = document.getElementById('modalExito');
    modal.style.display = 'none';
    document.body.style.overflow = 'auto';
    window.location.href = '/web/travelhub';
  }

  // Procesar reserva
  async function procesarReserva(e) {
    e.preventDefault();

    const form = e.target;
    const formData = new FormData(form);

    // Validaciones
    const dni = formData.get('dni');
    const mail = formData.get('mail');

    if (!validarDNI(dni)) {
      mostrarError('El DNI debe tener 7 u 8 dígitos numéricos.');
      return;
    }

    if (!validarEmail(mail)) {
      mostrarError('Ingrese un email válido.');
      return;
    }

    // Mostrar procesando
    document.getElementById('procesandoMsg').style.display = 'block';
    document.getElementById('errorMsg').style.display = 'none';
    document.getElementById('btnConfirmar').disabled = true;

    // Simular delay de pasarela de pago (1-2 segundos)
    await new Promise(resolve => setTimeout(resolve, 1500));

    try {
      // Crear reserva
      const viajeIda = viajeInfo.viajeIda;
      const viajeVuelta = viajeInfo.viajeVuelta;
      
      const reservaData = {
        idViajeIda: parseInt(viajeInfo.viajeIdIda),
        idViajeVuelta: viajeInfo.viajeIdVuelta ? parseInt(viajeInfo.viajeIdVuelta) : 0,
        tipoReserva: viajeInfo.tipoReserva,
        origen: viajeIda.origen,
        destino: viajeIda.destino,
        fechaSalida: new Date(typeof viajeIda.fechaSalida === 'string' ? parseInt(viajeIda.fechaSalida) : viajeIda.fechaSalida).toISOString(),
        fechaLlegada: new Date(typeof viajeIda.fechaLlegada === 'string' ? parseInt(viajeIda.fechaLlegada) : viajeIda.fechaLlegada).toISOString(),
        mail: mail,
        dni: dni
      };

      const response = await fetch(API_RESERVAS, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(reservaData)
      });

      if (!response.ok) {
        throw new Error('Error al crear la reserva');
      }

      const reserva = await response.json();

      // Ocultar procesando
      document.getElementById('procesandoMsg').style.display = 'none';
      document.getElementById('btnConfirmar').disabled = false;

      // Mostrar modal de éxito
      mostrarExito(reserva.reservaId);

    } catch (error) {
      console.error('Error al procesar reserva:', error);
      document.getElementById('procesandoMsg').style.display = 'none';
      document.getElementById('btnConfirmar').disabled = false;
      mostrarError('Hubo un error al procesar su reserva. Por favor, intente nuevamente.');
    }
  }

  // Mostrar modal de éxito
  function mostrarExito(reservaId) {
    document.getElementById('codigoReserva').textContent = `#${reservaId}`;
    
    // Mostrar modal personalizado
    const modal = document.getElementById('modalExito');
    modal.style.display = 'flex';
    document.body.style.overflow = 'hidden';
  }

  // Mostrar mensaje de error
  function mostrarError(mensaje) {
    const errorDiv = document.getElementById('errorMsg');
    errorDiv.textContent = mensaje;
    errorDiv.style.display = 'block';
    
    // Scroll al error
    errorDiv.scrollIntoView({ behavior: 'smooth', block: 'center' });
  }

  // Inicializar cuando carga la página
  document.addEventListener('DOMContentLoaded', inicializarFormulario);
})();
