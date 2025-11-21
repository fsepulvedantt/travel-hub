(function() {
  let pasajeros = 1;

  // Inicializar
  function init() {
    try {
      // Establecer fecha mínima como hoy
      const hoy = new Date().toISOString().split('T')[0];
      document.getElementById('fechaPartida').setAttribute('min', hoy);
      document.getElementById('fechaRegreso').setAttribute('min', hoy);

      // Botones de pasajeros
      const btnMenos = document.querySelector('.btn-menos');
      const btnMas = document.querySelector('.btn-mas');
      
      if (btnMenos) btnMenos.addEventListener('click', disminuirPasajeros);
      if (btnMas) btnMas.addEventListener('click', aumentarPasajeros);

      // Submit del formulario
      const formBusqueda = document.getElementById('formBusqueda');
      if (formBusqueda) {
        formBusqueda.addEventListener('submit', buscarViajes);
      }

      // Actualizar fecha mínima de regreso cuando cambia partida
      const fechaPartidaInput = document.getElementById('fechaPartida');
      if (fechaPartidaInput) {
        fechaPartidaInput.addEventListener('change', function() {
          const fechaPartida = this.value;
          if (fechaPartida) {
            document.getElementById('fechaRegreso').setAttribute('min', fechaPartida);
          }
        });
      }

      // Checkbox solo ida
      const soloIdaCheckbox = document.getElementById('soloIda');
      if (soloIdaCheckbox) {
        soloIdaCheckbox.addEventListener('change', function() {
          const fechaRegresoInput = document.getElementById('fechaRegreso');
          if (this.checked) {
            fechaRegresoInput.disabled = true;
            fechaRegresoInput.value = '';
            fechaRegresoInput.style.opacity = '0.5';
          } else {
            fechaRegresoInput.disabled = false;
            fechaRegresoInput.style.opacity = '1';
          }
        });
      }
    } catch (error) {
      console.error('Error en inicialización del formulario:', error);
    }
  }

  // Disminuir pasajeros
  function disminuirPasajeros(e) {
    e.preventDefault();
    e.stopPropagation();
    if (pasajeros > 1) {
      pasajeros--;
      document.getElementById('pasajeros').value = pasajeros;
    }
  }

  // Aumentar pasajeros
  function aumentarPasajeros(e) {
    e.preventDefault();
    e.stopPropagation();
    if (pasajeros < 10) {
      pasajeros++;
      document.getElementById('pasajeros').value = pasajeros;
    }
  }

  // Buscar viajes
  function buscarViajes(e) {
    e.preventDefault();

    const origen = document.getElementById('origen').value.trim();
    const destino = document.getElementById('destino').value.trim();
    const fechaPartida = document.getElementById('fechaPartida').value;
    const fechaRegreso = document.getElementById('fechaRegreso').value;
    const numPasajeros = document.getElementById('pasajeros').value;
    const soloIda = document.getElementById('soloIda').checked;

    // Validaciones
    if (!origen || !destino) {
      alert('Por favor ingrese origen y destino');
      return;
    }

    if (!fechaPartida) {
      alert('Por favor seleccione fecha de partida');
      return;
    }

    if (!soloIda && !fechaRegreso) {
      alert('Por favor seleccione fecha de regreso o marque "Solo ida"');
      return;
    }

    // Limpiar sessionStorage para nueva búsqueda
    sessionStorage.removeItem('viajeIda');
    sessionStorage.removeItem('viajeVuelta');

    // Construir URL con parámetros
    const params = new URLSearchParams({
      origen: origen,
      destino: destino,
      fechaPartida: fechaPartida,
      pasajeros: numPasajeros,
      tipoReserva: soloIda ? 'IDA' : 'IDA_VUELTA'
    });

    if (!soloIda && fechaRegreso) {
      params.append('fechaRegreso', fechaRegreso);
    }

    // Redirigir a página de resultados
    window.location.href = `/web/travelhub/viajes-list?${params.toString()}`;
  }

  // Inicializar inmediatamente (no esperar DOMContentLoaded)
  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', init);
  } else {
    init();
  }
})();
