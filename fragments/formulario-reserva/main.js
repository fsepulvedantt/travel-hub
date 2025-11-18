(function() {
  const API_RESERVAS = '/o/reservas';
  let viajeInfo = {};

  // Obtener parámetros de la URL
  function obtenerParametrosURL() {
    const urlParams = new URLSearchParams(window.location.search);
    return {
      viajeId: urlParams.get('viajeId'),
      origen: urlParams.get('origen'),
      destino: urlParams.get('destino'),
      precio: urlParams.get('precio')
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
    viajeInfo = obtenerParametrosURL();

    if (!viajeInfo.viajeId) {
      mostrarError('No se encontró información del viaje. Por favor, seleccione un viaje desde la lista.');
      return;
    }

    // Mostrar resumen
    document.getElementById('rutaResumen').textContent = 
      `${viajeInfo.origen} → ${viajeInfo.destino}`;
    document.getElementById('precioResumen').textContent = 
      formatearPrecio(parseFloat(viajeInfo.precio));

    // Formateo automático de campos
    const inputTarjeta = document.getElementById('numeroTarjeta');
    inputTarjeta.addEventListener('input', () => formatearTarjeta(inputTarjeta));

    const inputVencimiento = document.getElementById('vencimiento');
    inputVencimiento.addEventListener('input', () => formatearVencimiento(inputVencimiento));

    // Solo números en DNI y CVV
    document.getElementById('dni').addEventListener('input', function(e) {
      this.value = this.value.replace(/\D/g, '');
    });

    document.getElementById('cvv').addEventListener('input', function(e) {
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
      window.location.href = '/';
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
    window.location.href = '/';
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
      const reservaData = {
        idViaje: parseInt(viajeInfo.viajeId),
        origen: viajeInfo.origen,
        destino: viajeInfo.destino,
        fechaSalida: new Date().toISOString(), // En producción vendría del viaje
        fechaLlegada: new Date().toISOString(), // En producción vendría del viaje
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
