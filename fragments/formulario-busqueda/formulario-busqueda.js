(function() {
    'use strict';

    const API_BASE_URL = window.location.origin + '/o/viajes';
    const RESULTADOS_PAGE_URL = '/resultado-de-viajes';

    // Elementos del DOM
    const form = document.getElementById('formBusquedaViaje');
    const inputOrigen = document.getElementById('inputOrigen');
    const inputDestino = document.getElementById('inputDestino');
    const dropdownOrigen = document.getElementById('dropdownOrigen');
    const dropdownDestino = document.getElementById('dropdownDestino');
    const inputPartida = document.getElementById('inputPartida');
    const inputRegreso = document.getElementById('inputRegreso');
    const inputPasajeros = document.getElementById('inputPasajeros');
    const checkboxSoloIda = document.getElementById('checkboxSoloIda');
    const mensajesAlerta = document.getElementById('mensajesAlerta');

    // CACHÉ de ubicaciones
    let ubicacionesCache = {
        origenes: [],
        destinos: [],
        loaded: false
    };

    // ========== AUTOCOMPLETADO ==========

    // Cargar ubicaciones al inicio
    async function cargarUbicaciones() {
        if (ubicacionesCache.loaded) return;

        try {
            const response = await fetch(API_BASE_URL, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }
            });

            if (!response.ok) throw new Error('Error al cargar ubicaciones');

            const viajes = await response.json();

            // Extraer origenes y destinos únicos
            const origenesSet = new Set();
            const destinosSet = new Set();

            viajes.forEach(viaje => {
                if (viaje.origen) origenesSet.add(viaje.origen.trim());
                if (viaje.destino) destinosSet.add(viaje.destino.trim());
            });

            ubicacionesCache.origenes = Array.from(origenesSet).sort();
            ubicacionesCache.destinos = Array.from(destinosSet).sort();
            ubicacionesCache.loaded = true;
        } catch (error) {
            console.error('❌ Error al cargar ubicaciones:', error);
        }
    }

    // Normalizar texto (sin acentos, minúsculas)
    function normalizarTexto(texto) {
        return texto.normalize('NFD')
                   .replace(/[\u0300-\u036f]/g, '')
                   .toLowerCase()
                   .trim();
    }

    // Filtrar ubicaciones
    function filtrarUbicaciones(texto, lista) {
        if (texto.length < 3) return [];

        const textoNormalizado = normalizarTexto(texto);

        return lista.filter(ubicacion => {
            return normalizarTexto(ubicacion).includes(textoNormalizado);
        }).slice(0, 8); // Máximo 8 resultados
    }

    // Highlight del texto coincidente
    function highlightText(texto, busqueda) {
        const regex = new RegExp(`(${busqueda})`, 'gi');
        return texto.replace(regex, '<span class="autocomplete-highlight">$1</span>');
    }

    // Mostrar dropdown
    function mostrarDropdown(dropdown, ubicaciones, busqueda) {
        if (ubicaciones.length === 0) {
            dropdown.innerHTML = '<div class="autocomplete-no-results">No se encontraron ubicaciones</div>';
        } else {
            dropdown.innerHTML = ubicaciones.map(ubicacion => `
                <div class="autocomplete-item" data-value="${ubicacion}">
                    <i class="fas fa-map-marker-alt autocomplete-item-icon"></i>
                    <span class="autocomplete-item-text">${highlightText(ubicacion, busqueda)}</span>
                </div>
            `).join('');
        }

        dropdown.classList.add('show');
    }

    // Ocultar dropdown
    function ocultarDropdown(dropdown) {
        dropdown.classList.remove('show');
    }

    // Seleccionar item
    function seleccionarItem(input, dropdown, valor) {
        input.value = valor;
        ocultarDropdown(dropdown);
        input.focus();
    }

    // Setup autocompletado para un input
    function setupAutocomplete(input, dropdown, tipo) {
        let currentIndex = -1;

        // Input event
        input.addEventListener('input', function() {
            const texto = this.value;
            currentIndex = -1;

            if (texto.length < 3) {
                ocultarDropdown(dropdown);
                return;
            }

            const lista = tipo === 'origen' ? ubicacionesCache.origenes : ubicacionesCache.destinos;
            const resultados = filtrarUbicaciones(texto, lista);

            mostrarDropdown(dropdown, resultados, texto);
        });

        // Click en items
        dropdown.addEventListener('click', function(e) {
            const item = e.target.closest('.autocomplete-item');
            if (item) {
                const valor = item.getAttribute('data-value');
                seleccionarItem(input, dropdown, valor);
                currentIndex = -1;
            }
        });

        // Focus out - cerrar dropdown
        input.addEventListener('blur', function() {
            setTimeout(() => {
                ocultarDropdown(dropdown);
                currentIndex = -1;
            }, 200);
        });

        // Keyboard navigation
        input.addEventListener('keydown', function(e) {
            const items = dropdown.querySelectorAll('.autocomplete-item');

            if (items.length === 0) return;

            if (e.key === 'ArrowDown') {
                e.preventDefault();
                currentIndex = Math.min(currentIndex + 1, items.length - 1);
                updateActiveItem(items, currentIndex);
            } else if (e.key === 'ArrowUp') {
                e.preventDefault();
                currentIndex = Math.max(currentIndex - 1, 0);
                updateActiveItem(items, currentIndex);
            } else if (e.key === 'Enter' && currentIndex >= 0) {
                e.preventDefault();
                const valor = items[currentIndex].getAttribute('data-value');
                seleccionarItem(input, dropdown, valor);
                currentIndex = -1;
            } else if (e.key === 'Escape') {
                ocultarDropdown(dropdown);
                currentIndex = -1;
            }
        });

        function updateActiveItem(items, index) {
            items.forEach((item, i) => {
                item.classList.toggle('active', i === index);
            });
            if (items[index]) {
                items[index].scrollIntoView({ block: 'nearest' });
            }
        }
    }

    // ========== CHECKBOX SOLO IDA ==========

    checkboxSoloIda.addEventListener('change', function() {
        if (this.checked) {
            // Deshabilitar y limpiar el campo de regreso
            inputRegreso.disabled = true;
            inputRegreso.value = '';
            inputRegreso.removeAttribute('required');
        } else {
            // Habilitar el campo de regreso
            inputRegreso.disabled = false;
        }
    });

    // ========== VALIDACIÓN Y SUBMIT ==========

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

        // Validar fecha de regreso si NO es solo ida
        if (!checkboxSoloIda.checked) {
            const fechaRegreso = inputRegreso.value;
            if (fechaRegreso) {
                const fechaRegresoDate = new Date(fechaRegreso);
                if (fechaRegresoDate < fechaSeleccionada) {
                    mostrarMensaje('La fecha de regreso debe ser posterior a la fecha de partida.');
                    return false;
                }
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

        if (checkboxSoloIda.checked) {
            params.append('tipoViaje', 'IDA');
        } else {
            params.append('tipoViaje', 'IDA_VUELTA');
            // Solo agregar fecha de regreso si NO es solo ida y se completó
            if (inputRegreso.value) {
                params.append('fechaRegreso', inputRegreso.value);
            }
        }

        return `${RESULTADOS_PAGE_URL}?${params.toString()}`;
    }

    // ========== EVENT LISTENERS ==========

    form.addEventListener('submit', function(e) {
        e.preventDefault();
        if (!validarFormulario()) return;
        
        const url = construirURLConParametros();
        window.location.href = url;
    });

    // Fechas mínimas
    const hoy = new Date().toISOString().split('T')[0];
    inputPartida.setAttribute('min', hoy);
    inputRegreso.setAttribute('min', hoy);

    inputPartida.addEventListener('change', function() {
        if (inputRegreso.value && inputRegreso.value < this.value) {
            inputRegreso.value = '';
        }
        inputRegreso.setAttribute('min', this.value);
    });

    // ========== INICIALIZACIÓN ==========

    // Setup autocompletado
    setupAutocomplete(inputOrigen, dropdownOrigen, 'origen');
    setupAutocomplete(inputDestino, dropdownDestino, 'destino');

    // Cargar ubicaciones al inicio
    cargarUbicaciones();
})();