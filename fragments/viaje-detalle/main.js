(function() {
  const API_BASE = '/o/viajes';
  
  // Obtener viajeId de la URL
  function getViajeId() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get('viajeId');
  }

  // Formatear fecha en español
  function formatearFecha(fecha) {
    const opciones = { 
      weekday: 'long', 
      year: 'numeric', 
      month: 'long', 
      day: 'numeric',
      hour: '2-digit',
      minute: '2-digit'
    };
    return new Date(fecha).toLocaleDateString('es-AR', opciones);
  }

  // Formatear precio en pesos argentinos
  function formatearPrecio(precio) {
    return new Intl.NumberFormat('es-AR', {
      style: 'currency',
      currency: 'ARS',
      minimumFractionDigits: 2
    }).format(precio);
  }

  // Cargar detalle del viaje
  async function cargarViaje() {
    const viajeId = getViajeId();
    
    if (!viajeId) {
      mostrarError('No se especificó un viaje para ver.');
      return;
    }

    try {
      const response = await fetch(`${API_BASE}/${viajeId}`);
      
      if (!response.ok) {
        throw new Error('Viaje no encontrado');
      }

      const viaje = await response.json();
      mostrarViaje(viaje);
      
    } catch (error) {
      console.error('Error al cargar viaje:', error);
      mostrarError('No se pudo cargar la información del viaje. Por favor, intente nuevamente.');
    }
  }

  // Mostrar información del viaje
  function mostrarViaje(viaje) {
    document.getElementById('loadingSpinner').style.display = 'none';
    document.getElementById('viajeDetalle').style.display = 'block';

    // Header
    document.getElementById('origenDestino').textContent = `${viaje.origen} → ${viaje.destino}`;
    document.getElementById('empresa').textContent = viaje.empresa;
    document.getElementById('precio').textContent = formatearPrecio(viaje.precio);
    document.getElementById('precioTotal').textContent = formatearPrecio(viaje.precio);

    // Detalles
    document.getElementById('origenDetalle').textContent = viaje.origen;
    document.getElementById('destinoDetalle').textContent = viaje.destino;
    document.getElementById('fechaSalida').textContent = formatearFecha(viaje.fechaSalida);
    document.getElementById('fechaLlegada').textContent = formatearFecha(viaje.fechaLlegada);

    // Asientos
    const asientosText = viaje.asientosDisponibles === 1 
      ? '1 asiento disponible' 
      : `${viaje.asientosDisponibles} asientos disponibles`;
    
    document.getElementById('asientosDisponibles').textContent = asientosText;

    // Configurar botón de compra
    const btnComprar = document.getElementById('btnComprar');
    
    if (viaje.asientosDisponibles === 0) {
      btnComprar.disabled = true;
      btnComprar.innerHTML = '<i class="fas fa-times-circle"></i> Sin Asientos Disponibles';
      btnComprar.classList.add('btn-disabled');
    } else {
      btnComprar.addEventListener('click', () => {
        // Redirigir a formulario de reserva
        window.location.href = `/formulario-reserva?viajeId=${viaje.viajeId}&origen=${encodeURIComponent(viaje.origen)}&destino=${encodeURIComponent(viaje.destino)}&precio=${viaje.precio}`;
      });
    }
  }

  // Mostrar mensaje de error
  function mostrarError(mensaje) {
    document.getElementById('loadingSpinner').style.display = 'none';
    const errorDiv = document.getElementById('errorMessage');
    errorDiv.textContent = mensaje;
    errorDiv.style.display = 'block';
  }

  // Inicializar cuando carga la página
  document.addEventListener('DOMContentLoaded', cargarViaje);
})();
