// JavaScript
(function() {
  'use strict';

  // Datos de ejemplo para la confirmación
  const datosReserva = {
    pasajero: {
      nombre: 'Juan Carlos',
      apellido: 'García Rodríguez',
      tipoDocumento: 'DNI',
      numeroDocumento: '12.345.678',
      fechaNacimiento: '15/03/1985',
      genero: 'Masculino'
    },
    contacto: {
      email: 'juancarlos@email.com',
      telefono: '+54 11 1234-5678',
      nacionalidad: 'Argentina'
    },
    reserva: {
      codigo: 'TH-2025-001234',
      fecha: '10/12/2025 14:30'
    }
  };

  // Función para cargar los datos de la reserva
  function cargarDatosReserva() {
    // Cargar datos del pasajero
    const nombreElem = document.getElementById('nombrePasajero');
    if (nombreElem) nombreElem.textContent = datosReserva.pasajero.nombre;

    const apellidoElem = document.getElementById('apellidoPasajero');
    if (apellidoElem) apellidoElem.textContent = datosReserva.pasajero.apellido;

    const tipoDocElem = document.getElementById('tipoDocumento');
    if (tipoDocElem) tipoDocElem.textContent = datosReserva.pasajero.tipoDocumento;

    const numDocElem = document.getElementById('numeroDocumento');
    if (numDocElem) numDocElem.textContent = datosReserva.pasajero.numeroDocumento;

    const fechaNacElem = document.getElementById('fechaNacimiento');
    if (fechaNacElem) fechaNacElem.textContent = datosReserva.pasajero.fechaNacimiento;

    const generoElem = document.getElementById('genero');
    if (generoElem) generoElem.textContent = datosReserva.pasajero.genero;

    // Cargar datos de contacto
    const emailElem = document.getElementById('email');
    if (emailElem) emailElem.textContent = datosReserva.contacto.email;

    const telefonoElem = document.getElementById('telefono');
    if (telefonoElem) telefonoElem.textContent = datosReserva.contacto.telefono;

    const nacionalidadElem = document.getElementById('nacionalidad');
    if (nacionalidadElem) nacionalidadElem.textContent = datosReserva.contacto.nacionalidad;

    // Cargar datos de la reserva
    const codigoReservaElem = document.getElementById('codigoReserva');
    if (codigoReservaElem) codigoReservaElem.textContent = datosReserva.reserva.codigo;

    const fechaReservaElem = document.getElementById('fechaReserva');
    if (fechaReservaElem) fechaReservaElem.textContent = datosReserva.reserva.fecha;
  }

  // Función para manejar el botón de volver al inicio
  function configurarBotonVolverHome() {
    const botonesVolver = document.querySelectorAll('.travel-hub-btn-volver-home, .travel-hub-btn-volver-home-large');

    botonesVolver.forEach(function(boton) {
      boton.addEventListener('click', function(e) {
        e.preventDefault();
        window.location.href = '/';
        console.log('Redirigiendo al inicio...');
      });
    });
  }

  // Función para copiar el código de reserva al portapapeles
  function configurarCopiaCodigo() {
    const codigoReservaElem = document.getElementById('codigoReserva');

    if (codigoReservaElem) {
      codigoReservaElem.title = 'Haz clic para copiar el código';

      codigoReservaElem.addEventListener('click', function() {
        const codigo = this.textContent;

        // Copiar al portapapeles
        if (navigator.clipboard) {
          navigator.clipboard.writeText(codigo).then(function() {
            mostrarMensajeCopiado(codigoReservaElem);
          }).catch(function(err) {
            console.error('Error al copiar:', err);
          });
        } else {
          // Fallback para navegadores antiguos
          const textarea = document.createElement('textarea');
          textarea.value = codigo;
          textarea.style.position = 'fixed';
          textarea.style.opacity = '0';
          document.body.appendChild(textarea);
          textarea.select();
          try {
            document.execCommand('copy');
            mostrarMensajeCopiado(codigoReservaElem);
          } catch (err) {
            console.error('Error al copiar:', err);
          }
          document.body.removeChild(textarea);
        }
      });
    }
  }

  // Función para mostrar mensaje de copiado
  function mostrarMensajeCopiado(elemento) {
    const textoOriginal = elemento.textContent;
    elemento.textContent = '✓ Copiado!';
    elemento.style.color = '#10b981';

    setTimeout(function() {
      elemento.textContent = textoOriginal;
      elemento.style.color = '';
    }, 2000);
  }


  // Inicialización
  function inicializar() {
    cargarDatosReserva();
    configurarBotonVolverHome();
    configurarCopiaCodigo();

    console.log('Página de confirmación de reserva cargada correctamente');
  }

  // Ejecutar cuando el DOM esté listo
  if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', inicializar);
  } else {
    inicializar();
  }

})();