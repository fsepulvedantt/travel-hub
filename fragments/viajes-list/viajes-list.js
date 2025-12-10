const API_BASE_URL = window.location.origin + '/o/viajes';

// Función para normalizar texto (quitar acentos, convertir a minúsculas)
function normalizarTexto(texto) {
  if (!texto) return '';
  return texto.normalize('NFD').replace(/[\u0300-\u036f]/g, '').toLowerCase().trim();
}

// Parámetros de búsqueda
let searchParams = {};

// Elementos del DOM
const viajesGrid = fragmentElement.querySelector('#viajesGrid');
const loadingSpinner = fragmentElement.querySelector('#loadingSpinner');
const errorMessage = fragmentElement.querySelector('#errorMessage');
const noResultados = fragmentElement.querySelector('#noResultados');
const btnBuscar = fragmentElement.querySelector('#btnBuscar');
const btnLimpiarFiltros = fragmentElement.querySelector('#btnLimpiarFiltros');
const filtroOrigen = fragmentElement.querySelector('#filtroOrigen');
const filtroDestino = fragmentElement.querySelector('#filtroDestino');
const filtroEmpresa = fragmentElement.querySelector('#filtroEmpresa');
const filtroPrecioDesde = fragmentElement.querySelector('#filtroPrecioDesde');
const filtroPrecioHasta = fragmentElement.querySelector('#filtroPrecioHasta');
const precioMaximoDisponible = fragmentElement.querySelector('#precioMaximoDisponible');
const ordenamiento = fragmentElement.querySelector('#ordenamiento');
const rutaBusqueda = fragmentElement.querySelector('#rutaBusqueda');

// Obtener parámetros de la URL
function obtenerParametrosURL() {
  const urlParams = new URLSearchParams(window.location.search);
  return {
    origen: urlParams.get('origen') || '',
    destino: urlParams.get('destino') || '',
    fechaPartida: urlParams.get('fechaPartida') || '',
    fechaRegreso: urlParams.get('fechaRegreso') || '',
    pasajeros: urlParams.get('pasajeros') || '1',
    tipoReserva: urlParams.get('tipoReserva') || (urlParams.get('fechaRegreso') ? 'IDA_VUELTA' : 'IDA')
  };
}

// Función para ordenar viajes
function ordenarViajes(viajes, tipoOrdenamiento) {
  const viajesCopia = [...viajes];

  switch (tipoOrdenamiento) {
    case 'precio-asc':
      return viajesCopia.sort((a, b) => a.precio - b.precio);

    case 'precio-desc':
      return viajesCopia.sort((a, b) => b.precio - a.precio);

    case 'asientos':
      return viajesCopia.sort((a, b) => b.asientosDisponibles - a.asientosDisponibles);

    case 'horario-salida':
      return viajesCopia.sort((a, b) => {
        const timestampA = typeof a.fechaSalida === 'string' ? parseInt(a.fechaSalida) : a.fechaSalida;
        const timestampB = typeof b.fechaSalida === 'string' ? parseInt(b.fechaSalida) : b.fechaSalida;
        return timestampA - timestampB;
      });

    case 'relevancia':
    default:
      return viajesCopia;
  }
}

// Función para cargar y poblar los selects de filtros
async function cargarFiltrosDisponibles() {
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

    // Obtener valores únicos
    const origenesSet = new Set();
    const destinosSet = new Set();
    const empresasSet = new Set();
    let precioMaximo = 0;

    viajes.forEach(viaje => {
      origenesSet.add(viaje.origen);
      destinosSet.add(viaje.destino);
      empresasSet.add(viaje.empresa);
      if (viaje.precio > precioMaximo) {
        precioMaximo = viaje.precio;
      }
    });

    // Convertir a arrays y ordenar
    const origenes = Array.from(origenesSet).sort();
    const destinos = Array.from(destinosSet).sort();
    const empresas = Array.from(empresasSet).sort();

    // Poblar select de origen
    origenes.forEach(origen => {
      const option = document.createElement('option');
      option.value = origen;
      option.textContent = origen;
      filtroOrigen.appendChild(option);
    });

    // Poblar select de destino
    destinos.forEach(destino => {
      const option = document.createElement('option');
      option.value = destino;
      option.textContent = destino;
      filtroDestino.appendChild(option);
    });

    // Poblar select de empresa
    empresas.forEach(empresa => {
      const option = document.createElement('option');
      option.value = empresa;
      option.textContent = empresa;
      filtroEmpresa.appendChild(option);
    });

    // Establecer precio máximo disponible
    filtroPrecioHasta.max = precioMaximo;
    filtroPrecioHasta.value = precioMaximo;
    precioMaximoDisponible.textContent = precioMaximo.toLocaleString('es-AR');

    console.log('Filtros cargados:', { origenes, destinos, empresas, precioMaximo });
  } catch (error) {
    console.error('Error al cargar filtros:', error);
  }
}

// Mostrar información de búsqueda
function mostrarInfoBusqueda() {
  searchParams = obtenerParametrosURL();

  let infoText = `${searchParams.origen} → ${searchParams.destino}`;

  if (searchParams.fechaPartida) {
    const [year, month, day] = searchParams.fechaPartida.split('-');
    const fechaLocal = new Date(year, parseInt(month) - 1, day);
    infoText += ` | ${fechaLocal.toLocaleDateString('es-AR')}`;
  }

  if (searchParams.tipoReserva === 'IDA_VUELTA' && searchParams.fechaRegreso) {
    infoText += ` | Ida y Vuelta`;
  }

  rutaBusqueda.textContent = infoText;
  rutaBusqueda.style.fontSize = '1.1rem';
  rutaBusqueda.style.fontWeight = '600';
}

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

// Función para crear una tarjeta de viaje con radio button
function crearTarjetaViaje(viaje, tipo) {
  const tipoClase = tipo === 'ida' ? 'viaje-ida-card' : 'viaje-vuelta-card';
  const tipoLabel = tipo === 'ida' ? 'Ida' : 'Vuelta';
  const colorAccent = tipo === 'ida' ? 'primary' : 'success';

  return `
    <div class="${tipoClase} p-3 border rounded mb-2 viaje-option" data-viaje-id="${viaje.viajeId}" data-tipo="${tipo}" style="cursor: pointer; transition: all 0.2s;">
      <div class="d-flex align-items-center">
        <div class="form-check me-1 mr-2">
          <input class="form-check-input viaje-radio" type="radio" name="viaje${tipo}" id="viaje${tipo}_${viaje.viajeId}" value="${viaje.viajeId}">
        </div>
        <div class="flex-grow-1">
          <div class="row align-items-center">
            <div class="col-md-4">
              <h6 class="mb-2 text-${colorAccent}">
                <i class="bi bi-${tipo === 'ida' ? 'arrow-right' : 'arrow-left'}-circle"></i> ${tipoLabel}
              </h6>
              <p class="mb-1"><strong>${viaje.origen} → ${viaje.destino}</strong></p>
              <p class="mb-0"><span class="badge bg-info">${viaje.empresa}</span></p>
            </div>
            <div class="col-md-4">
              <small class="text-muted d-block mb-1"><i class="bi bi-calendar-event"></i> Salida</small>
              <p class="mb-2">${formatearFecha(viaje.fechaSalida)}</p>
              <small class="text-muted d-block mb-1"><i class="bi bi-calendar-check"></i> Llegada</small>
              <p class="mb-0">${formatearFecha(viaje.fechaLlegada)}</p>
            </div>
            <div class="col-md-2 text-center">
              <h5 class="text-success mb-2">${formatearPrecio(viaje.precio)}</h5>
              <span class="badge ${viaje.asientosDisponibles > 10 ? 'bg-success' : 'bg-warning'}">
                ${viaje.asientosDisponibles} asientos
              </span>
            </div>
          </div>
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
    console.log('✅ Viajes obtenidos del API:', viajes.length);
    console.log('Parámetros de búsqueda:', searchParams);

    mostrarLoading(false);

    if (!viajes || viajes.length === 0) {
      console.log('❌ No hay viajes en la BD');
      noResultados.classList.remove('d-none');
      return;
    }

    const tipoReserva = searchParams.tipoReserva;
    console.log('Tipo de reserva:', tipoReserva);

    // Filtrar viajes de ida
    const viajesIda = viajes.filter(viaje => {
      const coincideOrigen = !searchParams.origen || normalizarTexto(viaje.origen) === normalizarTexto(searchParams.origen);
      const coincideDestino = !searchParams.destino || normalizarTexto(viaje.destino) === normalizarTexto(searchParams.destino);
      const empresaSeleccionada = filtroEmpresa.value;
      const coincideEmpresa = !empresaSeleccionada || viaje.empresa === empresaSeleccionada;
      const precioDesde = parseFloat(filtroPrecioDesde.value) || 0;
      const precioHasta = parseFloat(filtroPrecioHasta.value) || 100000;
      const coincidePrecio = viaje.precio >= precioDesde && viaje.precio <= precioHasta;

      let coincideFecha = true;
      if (searchParams.fechaPartida) {
        // Fecha buscada ya viene como string "yyyy-MM-dd" del formulario
        const fechaBuscada = searchParams.fechaPartida;

        // Convertir timestamp del viaje a string "yyyy-MM-dd" usando toISOString (UTC)
        const timestampSalida = typeof viaje.fechaSalida === 'string' ? parseInt(viaje.fechaSalida) : viaje.fechaSalida;
        const fechaViaje = new Date(timestampSalida);
        const fechaViajeStr = fechaViaje.toISOString().split('T')[0];

        coincideFecha = fechaBuscada === fechaViajeStr;

        if (!coincideFecha) {
          console.log('❌ Viaje ' + viaje.origen + '→' + viaje.destino + ' no coincide en fecha. Buscada: ' + fechaBuscada + ', Viaje: ' + fechaViajeStr);
        }
      }

      const resultado = coincideOrigen && coincideDestino && coincideEmpresa && coincidePrecio && coincideFecha;
      if (!resultado && viaje.origen === searchParams.origen && viaje.destino === searchParams.destino) {
        console.log('❌ Viaje filtrado:', { viaje: viaje.origen + '→' + viaje.destino, coincideOrigen, coincideDestino, coincideEmpresa, coincidePrecio, coincideFecha });
      }
      return resultado;
    });

    console.log('📊 Viajes de ida filtrados: ' + viajesIda.length);

    // Si es ida y vuelta, también filtrar viajes de vuelta
    let viajesVuelta = [];
    if (tipoReserva === 'IDA_VUELTA' && searchParams.fechaRegreso) {
      viajesVuelta = viajes.filter(viaje => {
        // Invertir origen y destino para vuelta
        const coincideOrigen = !searchParams.destino || normalizarTexto(viaje.origen) === normalizarTexto(searchParams.destino);
        const coincideDestino = !searchParams.origen || normalizarTexto(viaje.destino) === normalizarTexto(searchParams.origen);
        const empresaSeleccionada = filtroEmpresa.value;
        const coincideEmpresa = !empresaSeleccionada || viaje.empresa === empresaSeleccionada;
        const precioDesde = parseFloat(filtroPrecioDesde.value) || 0;
        const precioHasta = parseFloat(filtroPrecioHasta.value) || 100000;
        const coincidePrecio = viaje.precio >= precioDesde && viaje.precio <= precioHasta;

        let coincideFecha = true;
        if (searchParams.fechaRegreso) {
          // Fecha buscada ya viene como string "yyyy-MM-dd" del formulario
          const fechaBuscada = searchParams.fechaRegreso;

          // Convertir timestamp del viaje a string "yyyy-MM-dd" usando toISOString (UTC)
          const timestampSalida = typeof viaje.fechaSalida === 'string' ? parseInt(viaje.fechaSalida) : viaje.fechaSalida;
          const fechaViaje = new Date(timestampSalida);
          const fechaViajeStr = fechaViaje.toISOString().split('T')[0];

          coincideFecha = fechaBuscada === fechaViajeStr;

          if (!coincideFecha) {
            console.log('❌ Viaje vuelta ' + viaje.origen + '→' + viaje.destino + ' no coincide en fecha. Buscada: ' + fechaBuscada + ', Viaje: ' + fechaViajeStr);
          }
        }

        return coincideOrigen && coincideDestino && coincideEmpresa && coincidePrecio && coincideFecha;
      });

      console.log('📊 Viajes de vuelta filtrados: ' + viajesVuelta.length);
    }

    if (viajesIda.length === 0 || (tipoReserva === 'IDA_VUELTA' && viajesVuelta.length === 0)) {
      console.log('❌ No hay resultados suficientes:', { viajesIda: viajesIda.length, viajesVuelta: viajesVuelta.length, tipoReserva: tipoReserva });
      noResultados.classList.remove('d-none');
      return;
    }

    // Aplicar ordenamiento
    const viajesIdaOrdenados = ordenarViajes(viajesIda, ordenamiento.value);
    const viajesVueltaOrdenados = tipoReserva === 'IDA_VUELTA' ? ordenarViajes(viajesVuelta, ordenamiento.value) : [];

    // Renderizar según tipo de reserva
    if (tipoReserva === 'IDA') {
      // Solo ida: tarjetas individuales
      viajesGrid.innerHTML = viajesIdaOrdenados.map(viaje => `
        <div class="col-12 mb-3">
          <div class="card shadow-sm">
            <div class="card-body">
              ${crearTarjetaViaje(viaje, 'ida')}
            </div>
          </div>
        </div>
      `).join('');

      // Event listeners para solo ida
      const radiosIda = viajesGrid.querySelectorAll('input[name="viajeida"]');
      const tarjetasIda = viajesGrid.querySelectorAll('.viaje-ida-card');
      
      // Click en el radio button
      radiosIda.forEach(radio => {
        radio.addEventListener('change', (e) => {
          if (e.target.checked) {
            const viajeId = e.target.value;
            const viaje = viajesIdaOrdenados.find(v => v.viajeId == viajeId);
            sessionStorage.setItem('viajeIda', JSON.stringify(viaje));
            window.location.href = `/web/travelhub/formulario-reserva?viajeIdIda=${viajeId}`;
          }
        });
      });
      
      // Click en toda la tarjeta
      tarjetasIda.forEach(tarjeta => {
        tarjeta.addEventListener('click', (e) => {
          // No hacer nada si se clickeó directamente el radio button
          if (e.target.classList.contains('viaje-radio')) return;
          
          const radio = tarjeta.querySelector('.viaje-radio');
          radio.checked = true;
          radio.dispatchEvent(new Event('change'));
        });
        
        // Efecto hover
        tarjeta.addEventListener('mouseenter', () => {
          tarjeta.style.backgroundColor = '#f8f9fa';
          tarjeta.style.borderColor = '#0d6efd';
          tarjeta.style.borderWidth = '2px';
        });
        
        tarjeta.addEventListener('mouseleave', () => {
          const radio = tarjeta.querySelector('.viaje-radio');
          if (!radio.checked) {
            tarjeta.style.backgroundColor = '';
            tarjeta.style.borderColor = '';
            tarjeta.style.borderWidth = '';
          }
        });
      });
    } else {
      // Ida y vuelta: tarjetas apiladas verticalmente
      viajesGrid.innerHTML = `
        <div class="col-12">
          <div class="card shadow-sm mb-4">
            <div class="card-header bg-primary text-white">
              <h5 class="mb-0"><i class="bi bi-arrow-left-right"></i> Selecciona tus viajes de Ida y Vuelta</h5>
            </div>
            <div class="card-body">
              <!-- Viajes de Ida -->
              <div class="mb-4">
                <h6 class="text-primary mb-3 pb-2 border-bottom">
                  <i class="bi bi-arrow-right-circle-fill"></i> Viajes de Ida
                </h6>
                <div id="viajesIdaContainer">
                  ${viajesIdaOrdenados.map(viaje => crearTarjetaViaje(viaje, 'ida')).join('')}
                </div>
              </div>
              
              <!-- Viajes de Vuelta -->
              <div class="mb-3">
                <h6 class="text-success mb-3 pb-2 border-bottom">
                  <i class="bi bi-arrow-left-circle-fill"></i> Viajes de Vuelta
                </h6>
                <div id="viajesVueltaContainer">
                  ${viajesVueltaOrdenados.map(viaje => crearTarjetaViaje(viaje, 'vuelta')).join('')}
                </div>
              </div>
              
              <hr>
              <div class="text-end">
                <button id="btnContinuarReserva" class="btn btn-primary btn-lg" disabled>
                  <i class="bi bi-check-circle"></i> Continuar con la Reserva
                </button>
              </div>
            </div>
          </div>
        </div>
      `;

      // Event listeners para ida y vuelta
      let viajeIdaSeleccionado = null;
      let viajeVueltaSeleccionado = null;

      const radiosIda = viajesGrid.querySelectorAll('input[name="viajeida"]');
      const radiosVuelta = viajesGrid.querySelectorAll('input[name="viajevuelta"]');
      const tarjetasIda = viajesGrid.querySelectorAll('.viaje-ida-card');
      const tarjetasVuelta = viajesGrid.querySelectorAll('.viaje-vuelta-card');
      const btnContinuar = document.getElementById('btnContinuarReserva');

      // Event listeners para radios de ida
      radiosIda.forEach(radio => {
        radio.addEventListener('change', (e) => {
          if (e.target.checked) {
            viajeIdaSeleccionado = viajesIdaOrdenados.find(v => v.viajeId == e.target.value);
            if (viajeIdaSeleccionado && viajeVueltaSeleccionado) {
              btnContinuar.disabled = false;
            }
            // Resaltar tarjeta seleccionada
            tarjetasIda.forEach(t => {
              t.style.backgroundColor = '';
              t.style.borderColor = '';
              t.style.borderWidth = '';
            });
            const tarjetaSeleccionada = e.target.closest('.viaje-ida-card');
            tarjetaSeleccionada.style.backgroundColor = '#e7f3ff';
            tarjetaSeleccionada.style.borderColor = '#0d6efd';
            tarjetaSeleccionada.style.borderWidth = '2px';
          }
        });
      });

      // Event listeners para radios de vuelta
      radiosVuelta.forEach(radio => {
        radio.addEventListener('change', (e) => {
          if (e.target.checked) {
            viajeVueltaSeleccionado = viajesVueltaOrdenados.find(v => v.viajeId == e.target.value);
            if (viajeIdaSeleccionado && viajeVueltaSeleccionado) {
              btnContinuar.disabled = false;
            }
            // Resaltar tarjeta seleccionada
            tarjetasVuelta.forEach(t => {
              t.style.backgroundColor = '';
              t.style.borderColor = '';
              t.style.borderWidth = '';
            });
            const tarjetaSeleccionada = e.target.closest('.viaje-vuelta-card');
            tarjetaSeleccionada.style.backgroundColor = '#e7f7e7';
            tarjetaSeleccionada.style.borderColor = '#198754';
            tarjetaSeleccionada.style.borderWidth = '2px';
          }
        });
      });
      
      // Click en toda la tarjeta de ida
      tarjetasIda.forEach(tarjeta => {
        tarjeta.addEventListener('click', (e) => {
          if (e.target.classList.contains('viaje-radio')) return;
          const radio = tarjeta.querySelector('.viaje-radio');
          radio.checked = true;
          radio.dispatchEvent(new Event('change'));
        });
        
        tarjeta.addEventListener('mouseenter', () => {
          const radio = tarjeta.querySelector('.viaje-radio');
          if (!radio.checked) {
            tarjeta.style.backgroundColor = '#f8f9fa';
            tarjeta.style.borderColor = '#0d6efd';
            tarjeta.style.borderWidth = '2px';
          }
        });
        
        tarjeta.addEventListener('mouseleave', () => {
          const radio = tarjeta.querySelector('.viaje-radio');
          if (!radio.checked) {
            tarjeta.style.backgroundColor = '';
            tarjeta.style.borderColor = '';
            tarjeta.style.borderWidth = '';
          }
        });
      });
      
      // Click en toda la tarjeta de vuelta
      tarjetasVuelta.forEach(tarjeta => {
        tarjeta.addEventListener('click', (e) => {
          if (e.target.classList.contains('viaje-radio')) return;
          const radio = tarjeta.querySelector('.viaje-radio');
          radio.checked = true;
          radio.dispatchEvent(new Event('change'));
        });
        
        tarjeta.addEventListener('mouseenter', () => {
          const radio = tarjeta.querySelector('.viaje-radio');
          if (!radio.checked) {
            tarjeta.style.backgroundColor = '#f8f9fa';
            tarjeta.style.borderColor = '#198754';
            tarjeta.style.borderWidth = '2px';
          }
        });
        
        tarjeta.addEventListener('mouseleave', () => {
          const radio = tarjeta.querySelector('.viaje-radio');
          if (!radio.checked) {
            tarjeta.style.backgroundColor = '';
            tarjeta.style.borderColor = '';
            tarjeta.style.borderWidth = '';
          }
        });
      });

      btnContinuar.addEventListener('click', () => {
        if (viajeIdaSeleccionado && viajeVueltaSeleccionado) {
          sessionStorage.setItem('viajeIda', JSON.stringify(viajeIdaSeleccionado));
          sessionStorage.setItem('viajeVuelta', JSON.stringify(viajeVueltaSeleccionado));
          window.location.href = `/web/travelhub/formulario-reserva?viajeIdIda=${viajeIdaSeleccionado.viajeId}&viajeIdVuelta=${viajeVueltaSeleccionado.viajeId}`;
        }
      });
    }

  } catch (error) {
    console.error('Error al cargar viajes:', error);
    mostrarLoading(false);
    mostrarError('Error al cargar los viajes. Por favor, intente nuevamente.');
  }
}

// Event listener para el botón de búsqueda
btnBuscar.addEventListener('click', cargarViajes);

// Event listener para limpiar filtros
btnLimpiarFiltros.addEventListener('click', () => {
  filtroOrigen.value = '';
  filtroDestino.value = '';
  filtroEmpresa.value = '';
  filtroPrecioDesde.value = '0';
  filtroPrecioHasta.value = parseFloat(filtroPrecioHasta.max) || 100000;
  cargarViajes();
});

// Event listeners para los inputs de precio
filtroPrecioDesde.addEventListener('change', () => {
  const desde = parseInt(filtroPrecioDesde.value) || 0;
  const hasta = parseInt(filtroPrecioHasta.value) || 100000;
  if (desde > hasta) {
    filtroPrecioDesde.value = hasta;
  }
});

filtroPrecioHasta.addEventListener('change', () => {
  const desde = parseInt(filtroPrecioDesde.value) || 0;
  const hasta = parseInt(filtroPrecioHasta.value) || 100000;
  if (hasta < desde) {
    filtroPrecioHasta.value = desde;
  }
});

// Mostrar info de búsqueda y cargar viajes al iniciar
cargarFiltrosDisponibles().then(() => {
  mostrarInfoBusqueda();
  cargarViajes();
});

// Búsqueda al presionar Enter
filtroOrigen.addEventListener('change', cargarViajes);
filtroDestino.addEventListener('change', cargarViajes);

// Event listener para cambiar ordenamiento
ordenamiento.addEventListener('change', cargarViajes);
