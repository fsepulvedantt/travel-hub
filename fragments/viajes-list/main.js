const API_BASE_URL = window.location.origin + '/o/viajes';

// Elementos del DOM
const viajesGrid = fragmentElement.querySelector('#viajesGrid');
const loadingSpinner = fragmentElement.querySelector('#loadingSpinner');
const errorMessage = fragmentElement.querySelector('#errorMessage');
const noResultados = fragmentElement.querySelector('#noResultados');
const btnBuscar = fragmentElement.querySelector('#btnBuscar');
const filtroOrigen = fragmentElement.querySelector('#filtroOrigen');
const filtroDestino = fragmentElement.querySelector('#filtroDestino');

// Función para formatear fecha
function formatearFecha(fechaString) {
  const fecha = new Date(fechaString);
  return fecha.toLocaleDateString('es-AR', {
    day: '2-digit',
    month: '2-digit',
    year: 'numeric',
    hour: '2-digit',
    minute: '2-digit'
  });
}

// Función para formatear precio
function formatearPrecio(precio) {
  return new Intl.NumberFormat('es-AR', {
    style: 'currency',
    currency: 'ARS'
  }).format(precio);
}

// Función para crear una tarjeta de viaje
function crearTarjetaViaje(viaje) {
  return `
    <div class="col-md-6 col-lg-4">
      <div class="card h-100 shadow-sm">
        <div class="card-body">
          <h5 class="card-title">
            <i class="bi bi-geo-fill text-primary"></i>
            ${viaje.origen} → ${viaje.destino}
          </h5>
          
          <div class="mb-3">
            <p class="mb-2">
              <strong>Empresa:</strong> 
              <span class="badge bg-info">${viaje.empresa}</span>
            </p>
            <p class="mb-2">
              <i class="bi bi-calendar-event"></i>
              <strong>Salida:</strong> ${formatearFecha(viaje.fechaSalida)}
            </p>
            <p class="mb-2">
              <i class="bi bi-calendar-check"></i>
              <strong>Llegada:</strong> ${formatearFecha(viaje.fechaLlegada)}
            </p>
          </div>

          <div class="d-flex justify-content-between align-items-center mb-3">
            <div>
              <h4 class="text-success mb-0">${formatearPrecio(viaje.precio)}</h4>
            </div>
            <div>
              <span class="badge ${viaje.asientosDisponibles > 10 ? 'bg-success' : 'bg-warning'}">
                ${viaje.asientosDisponibles} asientos
              </span>
            </div>
          </div>

          <button class="btn btn-primary w-100 btn-reservar" data-viaje-id="${viaje.viajeId}">
            <i class="bi bi-eye"></i> Ver Detalle
          </button>
        </div>
      </div>
    </div>
  `;
}

// Función para mostrar loading
function mostrarLoading(mostrar) {
  if (mostrar) {
    loadingSpinner.classList.remove('d-none');
    viajesGrid.innerHTML = '';
    errorMessage.classList.add('d-none');
    noResultados.classList.add('d-none');
  } else {
    loadingSpinner.classList.add('d-none');
  }
}

// Función para mostrar error
function mostrarError(mensaje) {
  errorMessage.textContent = mensaje;
  errorMessage.classList.remove('d-none');
  viajesGrid.innerHTML = '';
  noResultados.classList.add('d-none');
}

// Función para cargar viajes
async function cargarViajes() {
  mostrarLoading(true);

  try {
    const response = await fetch(API_BASE_URL, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json'
      }
    });

    if (!response.ok) {
      throw new Error(`Error ${response.status}: ${response.statusText}`);
    }

    const viajes = await response.json();
    mostrarLoading(false);

    if (!viajes || viajes.length === 0) {
      noResultados.classList.remove('d-none');
      return;
    }

    // Filtrar viajes si hay criterios de búsqueda
    const origen = filtroOrigen.value.toLowerCase().trim();
    const destino = filtroDestino.value.toLowerCase().trim();

    const viajesFiltrados = viajes.filter(viaje => {
      const coincideOrigen = !origen || viaje.origen.toLowerCase().includes(origen);
      const coincideDestino = !destino || viaje.destino.toLowerCase().includes(destino);
      return coincideOrigen && coincideDestino;
    });

    if (viajesFiltrados.length === 0) {
      noResultados.classList.remove('d-none');
      return;
    }

    // Renderizar viajes
    viajesGrid.innerHTML = viajesFiltrados.map(viaje => crearTarjetaViaje(viaje)).join('');

    // Agregar event listeners a los botones de ver detalle
    const botonesReservar = viajesGrid.querySelectorAll('.btn-reservar');
    botonesReservar.forEach(btn => {
      btn.addEventListener('click', (e) => {
        const viajeId = e.currentTarget.getAttribute('data-viaje-id');
        window.location.href = `/viaje-detalle?viajeId=${viajeId}`;
      });
    });

  } catch (error) {
    console.error('Error al cargar viajes:', error);
    mostrarLoading(false);
    mostrarError('Error al cargar los viajes. Por favor, intente nuevamente.');
  }
}

// Event listener para el botón de búsqueda
btnBuscar.addEventListener('click', cargarViajes);

// Cargar viajes al iniciar
cargarViajes();

// Búsqueda al presionar Enter
filtroOrigen.addEventListener('keypress', (e) => {
  if (e.key === 'Enter') cargarViajes();
});

filtroDestino.addEventListener('keypress', (e) => {
  if (e.key === 'Enter') cargarViajes();
});
