(function() {
  const API_RESERVAS = window.location.origin + '/o/reservas';
  const API_VIAJES = window.location.origin + '/o/viajes';

  // Elementos del DOM
  const heroSection = fragmentElement.querySelector('.hero-section');
  const formBuscar = fragmentElement.querySelector('#formBuscarReserva');
  const inputCodigo = fragmentElement.querySelector('#inputCodigoReserva');
  const inputDni = fragmentElement.querySelector('#inputDni');
  const loadingMsg = fragmentElement.querySelector('#loadingMsg');
  const errorMsg = fragmentElement.querySelector('#errorMsg');
  const errorText = fragmentElement.querySelector('#errorText');
  const detalleReserva = fragmentElement.querySelector('#detalleReserva');
  const btnNuevaBusqueda = fragmentElement.querySelector('#btnNuevaBusqueda');
  const btnVolver = fragmentElement.querySelector('#btnVolver');

  // Formatear precio
  function formatearPrecio(precio) {
    return new Intl.NumberFormat('es-AR', {
      style: 'currency',
      currency: 'ARS',
      minimumFractionDigits: 0
    }).format(precio);
  }

  // Formatear fecha
  function formatearFecha(fechaString) {
    const timestamp = typeof fechaString === 'string' ? parseInt(fechaString) : fechaString;
    const fecha = new Date(timestamp);
    return fecha.toLocaleDateString('es-AR', {
      weekday: 'long',
      day: '2-digit',
      month: 'long',
      year: 'numeric',
      hour: '2-digit',
      minute: '2-digit'
    });
  }

  // Mostrar/ocultar elementos
  function mostrarLoading(mostrar) {
    if (mostrar) {
      loadingMsg.classList.remove('d-none');
      errorMsg.classList.add('d-none');
      detalleReserva.classList.add('d-none');
    } else {
      loadingMsg.classList.add('d-none');
    }
  }

  function mostrarError(mensaje) {
    errorText.textContent = mensaje;
    errorMsg.classList.remove('d-none');
    loadingMsg.classList.add('d-none');
    detalleReserva.classList.add('d-none');
  }

  // Obtener detalles de un viaje
  async function obtenerViaje(viajeId) {
    try {
      const response = await fetch(`${API_VIAJES}/${viajeId}`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json'
        }
      });

      if (!response.ok) {
        throw new Error('No se pudo obtener información del viaje');
      }

      return await response.json();
    } catch (error) {
      console.error('Error al obtener viaje:', error);
      return null;
    }
  }

  // Crear card de viaje
  function crearViajeCard(viaje, tipo) {
    const tipoLabel = tipo === 'ida' ? 'Ida' : 'Vuelta';
    const tipoClass = tipo === 'ida' ? 'ida' : 'vuelta';

    return `
      <div class="viaje-detalle-card ${tipoClass}">
        <span class="viaje-badge ${tipoClass}">
          <i class="fas fa-${tipo === 'ida' ? 'plane-departure' : 'plane-arrival'}"></i> ${tipoLabel}
        </span>
        
        <div class="ruta-viaje">
          ${viaje.origen}
          <i class="fas fa-arrow-right"></i>
          ${viaje.destino}
        </div>

        <div class="viaje-info-grid">
          <div class="viaje-info-item">
            <div class="viaje-info-label">
              <i class="fas fa-calendar-day"></i> Salida
            </div>
            <div class="viaje-info-value">${formatearFecha(viaje.fechaSalida)}</div>
          </div>

          <div class="viaje-info-item">
            <div class="viaje-info-label">
              <i class="fas fa-calendar-check"></i> Llegada
            </div>
            <div class="viaje-info-value">${formatearFecha(viaje.fechaLlegada)}</div>
          </div>

          <div class="viaje-info-item">
            <div class="viaje-info-label">
              <i class="fas fa-building"></i> Empresa
            </div>
            <div class="viaje-info-value">
              <span class="empresa-badge">${viaje.empresa}</span>
            </div>
          </div>

          <div class="viaje-info-item">
            <div class="viaje-info-label">
              <i class="fas fa-money-bill-wave"></i> Precio
            </div>
            <div class="viaje-info-value precio-viaje">${formatearPrecio(viaje.precio)}</div>
          </div>
        </div>
      </div>
    `;
  }

  // Buscar reserva
  async function buscarReserva(codigoReserva, dni) {
    mostrarLoading(true);

    try {
      // Buscar la reserva con código y DNI
      const responseReserva = await fetch(`${API_RESERVAS}/buscar?codigo=${encodeURIComponent(codigoReserva)}&dni=${encodeURIComponent(dni)}`, {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json'
        }
      });

      if (!responseReserva.ok) {
        if (responseReserva.status === 404) {
          throw new Error('No se encontró ninguna reserva con ese código');
        } else if (responseReserva.status === 401) {
          throw new Error('El DNI no coincide con la reserva. Por favor, verifica tus datos.');
        } else if (responseReserva.status === 400) {
          throw new Error('Datos incompletos. Por favor, ingresa código y DNI.');
        }
        throw new Error('Error al buscar la reserva');
      }

      const reserva = await responseReserva.json();
      console.log('Reserva encontrada:', reserva);

      // Obtener detalles de los viajes
      const viajeIda = await obtenerViaje(reserva.idViajeIda);
      
      let viajeVuelta = null;
      // Verificar si hay viaje de vuelta (por tipo o por ID)
      if ((reserva.tipoReserva === 'IDA_VUELTA' || reserva.idViajeVuelta > 0) && reserva.idViajeVuelta) {
        viajeVuelta = await obtenerViaje(reserva.idViajeVuelta);
      }

      // Mostrar detalles
      mostrarDetalleReserva(reserva, viajeIda, viajeVuelta);

    } catch (error) {
      console.error('Error:', error);
      mostrarError(error.message || 'Ocurrió un error al buscar la reserva');
    }
  }

  // Mostrar detalle de reserva
  function mostrarDetalleReserva(reserva, viajeIda, viajeVuelta) {
    mostrarLoading(false);

    // Código de reserva (mostrar el código alfanumérico)
    fragmentElement.querySelector('#codigoReservaDisplay').textContent = reserva.codigoReserva;

    // Información del pasajero
    fragmentElement.querySelector('#pasajeroDni').textContent = reserva.dni;
    fragmentElement.querySelector('#pasajeroEmail').textContent = reserva.mail;

    // Tipo de viaje
    const tipoViajeBadge = fragmentElement.querySelector('#tipoViajeBadge');
    // Verificar si es ida y vuelta por tipo o por existencia de viaje vuelta
    if (reserva.tipoReserva === 'IDA_VUELTA' || viajeVuelta) {
      tipoViajeBadge.innerHTML = '<i class="fas fa-exchange-alt me-2"></i> Ida y Vuelta';
      tipoViajeBadge.className = 'tipo-viaje-badge ida-vuelta';
    } else {
      tipoViajeBadge.innerHTML = '<i class="fas fa-arrow-right me-2"></i> Solo Ida';
      tipoViajeBadge.className = 'tipo-viaje-badge ida';
    }

    // Viaje de ida
    if (viajeIda) {
      fragmentElement.querySelector('#viajeIdaDetalle').innerHTML = crearViajeCard(viajeIda, 'ida');
    }

    // Viaje de vuelta
    const viajeVueltaDetalle = fragmentElement.querySelector('#viajeVueltaDetalle');
    if (viajeVuelta) {
      viajeVueltaDetalle.innerHTML = crearViajeCard(viajeVuelta, 'vuelta');
      viajeVueltaDetalle.classList.remove('d-none');
    } else {
      viajeVueltaDetalle.classList.add('d-none');
    }

    // Calcular precio total
    let precioTotal = viajeIda ? viajeIda.precio : 0;
    if (viajeVuelta) {
      precioTotal += viajeVuelta.precio;
    }
    fragmentElement.querySelector('#precioTotal').textContent = formatearPrecio(precioTotal);

    // Ocultar formulario y mostrar detalle
    heroSection.classList.add('d-none');
    detalleReserva.classList.remove('d-none');

    // Scroll al detalle
    detalleReserva.scrollIntoView({ behavior: 'smooth', block: 'start' });
  }

  // Formateo automático de campos
  inputCodigo.addEventListener('input', function() {
    this.value = this.value.toUpperCase();
  });

  inputDni.addEventListener('input', function() {
    this.value = this.value.replace(/\D/g, '');
  });

  // Event listeners
  formBuscar.addEventListener('submit', (e) => {
    e.preventDefault();
    const codigo = inputCodigo.value.trim().toUpperCase();
    const dni = inputDni.value.trim();
    
    if (!codigo || codigo.length !== 6) {
      mostrarError('Por favor, ingresa un código de reserva válido (6 caracteres)');
      return;
    }

    if (!dni || !/^[0-9]{7,8}$/.test(dni)) {
      mostrarError('Por favor, ingresa un DNI válido (7 u 8 dígitos)');
      return;
    }

    buscarReserva(codigo, dni);
  });

  btnNuevaBusqueda.addEventListener('click', () => {
    detalleReserva.classList.add('d-none');
    errorMsg.classList.add('d-none');
    heroSection.classList.remove('d-none');
    inputCodigo.value = '';
    inputDni.value = '';
    inputCodigo.focus();
    window.scrollTo({ top: 0, behavior: 'smooth' });
  });

  btnVolver.addEventListener('click', () => {
    window.location.href = '/';
  });

  // Verificar si hay código en la URL
  const urlParams = new URLSearchParams(window.location.search);
  const codigoUrl = urlParams.get('codigo');
  const dniUrl = urlParams.get('dni');
  if (codigoUrl && dniUrl) {
    inputCodigo.value = codigoUrl.toUpperCase();
    inputDni.value = dniUrl;
    buscarReserva(codigoUrl.toUpperCase(), dniUrl);
  }
})();
