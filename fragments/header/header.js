(function() {
  'use strict';
  const btnConsultarPasaje = document.getElementById('btnConsultarPasaje');
  btnConsultarPasaje.addEventListener('click', consultarReserva);

	function consultarReserva(){
	   window.location.href = '/consulta-reserva';
	}
})();