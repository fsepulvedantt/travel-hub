# Comunicación Entre Fragmentos - Travel Hub

Guía de referencia sobre cómo se pasan datos entre los fragmentos del proyecto.

---

## 🔄 Métodos de Comunicación

### 1. **Parámetros de URL** (Recomendado para datos simples)

**Ventajas:**
- URLs compartibles y bookmarkeable
- Sin estado oculto
- Fácil debugging (se ve en la URL)
- SEO friendly

**Cuándo usar:**
- Datos simples (strings, números, fechas)
- Búsquedas y filtros
- Parámetros de navegación

---

### 2. **SessionStorage** (Para objetos complejos)

**Ventajas:**
- Permite guardar objetos JavaScript completos
- No contamina la URL
- Persiste durante la sesión del navegador

**Cuándo usar:**
- Objetos con muchos campos
- Datos temporales del flujo de usuario
- Cuando la URL se volvería muy larga

---

### 3. **LocalStorage** (Persistencia entre sesiones)

**Ventajas:**
- Persiste incluso cerrando el navegador
- Útil para preferencias del usuario

**Cuándo usar:**
- Configuraciones de usuario
- Carrito de compras
- Favoritos

---

## 📋 Implementación en Travel Hub

### **Fragmento 1: home-landing → viajes-list**

**Método:** Parámetros de URL

**Datos enviados:**
- `origen` (String)
- `destino` (String)
- `fechaPartida` (String ISO date)
- `fechaRegreso` (String ISO date - opcional)
- `pasajeros` (Number)
- `tipoReserva` (String: "IDA" o "IDA_VUELTA")

**Código de envío (home-landing.js):**
```javascript
// Construir parámetros
const params = new URLSearchParams({
    origen: origenInput.value,
    destino: destinoInput.value,
    fechaPartida: fechaPartidaInput.value,
    pasajeros: pasajerosInput.value,
    tipoReserva: soloIda ? 'IDA' : 'IDA_VUELTA'
});

// Agregar fecha de regreso si existe
if (fechaRegresoInput.value) {
    params.append('fechaRegreso', fechaRegresoInput.value);
}

// Navegar con parámetros
window.location.href = `/web/travelhub/viajes-list?${params.toString()}`;
```

**Código de recepción (viajes-list.js):**
```javascript
function obtenerParametrosURL() {
    const urlParams = new URLSearchParams(window.location.search);
    return {
        origen: urlParams.get('origen'),
        destino: urlParams.get('destino'),
        fechaPartida: urlParams.get('fechaPartida'),
        fechaRegreso: urlParams.get('fechaRegreso'),
        pasajeros: parseInt(urlParams.get('pasajeros')) || 1,
        tipoReserva: urlParams.get('tipoReserva') || 
                    (urlParams.get('fechaRegreso') ? 'IDA_VUELTA' : 'IDA')
    };
}

// Uso
const params = obtenerParametrosURL();
console.log(params.origen); // "Buenos Aires"
```

**Ejemplo de URL generada:**
```
/web/travelhub/viajes-list?origen=Buenos%20Aires&destino=C%C3%B3rdoba&fechaPartida=2025-12-25&fechaRegreso=2025-12-28&pasajeros=1&tipoReserva=IDA_VUELTA
```

---

### **Fragmento 2: viajes-list → formulario-reserva**

**Método:** SessionStorage + URL params

**Datos enviados:**
- **SessionStorage:** Objetos completos `viajeIda` y `viajeVuelta`
- **URL params:** IDs de los viajes (`viajeIdIda`, `viajeIdVuelta`)

**¿Por qué SessionStorage?**
Los objetos de viaje contienen muchos campos:
```javascript
{
  viajeId: 1,
  origen: "Buenos Aires",
  destino: "Córdoba",
  fechaSalida: 1735128000000,
  fechaLlegada: 1735156800000,
  empresa: "Plusmar",
  precio: 25000.00,
  asientosDisponibles: 40
}
```
Pasar esto por URL sería muy largo y difícil de manejar.

**Código de envío (viajes-list.js):**
```javascript
// Guardar viajes completos en SessionStorage
sessionStorage.setItem('viajeIda', JSON.stringify(viajeSeleccionado));
sessionStorage.setItem('tipoReserva', 'IDA_VUELTA');

if (viajeVueltaSeleccionado) {
    sessionStorage.setItem('viajeVuelta', JSON.stringify(viajeVueltaSeleccionado));
}

// Construir URL con IDs
const params = new URLSearchParams({
    viajeIdIda: viajeSeleccionado.viajeId
});

if (viajeVueltaSeleccionado) {
    params.append('viajeIdVuelta', viajeVueltaSeleccionado.viajeId);
}

// Navegar
window.location.href = `/web/travelhub/formulario-reserva?${params.toString()}`;
```

**Código de recepción (formulario-reserva.js):**
```javascript
function inicializarFormulario() {
    // Obtener parámetros de URL
    const urlParams = new URLSearchParams(window.location.search);
    const viajeIdIda = urlParams.get('viajeIdIda');
    const viajeIdVuelta = urlParams.get('viajeIdVuelta');

    // Recuperar objetos completos de SessionStorage
    const viajeIda = JSON.parse(sessionStorage.getItem('viajeIda'));
    const viajeVuelta = viajeIdVuelta ? 
                        JSON.parse(sessionStorage.getItem('viajeVuelta')) : 
                        null;
    const tipoReserva = sessionStorage.getItem('tipoReserva') || 'IDA';

    // Validar que existan
    if (!viajeIda) {
        mostrarError('No se encontró información del viaje de ida.');
        return;
    }

    // Usar los datos
    console.log(`Reservando: ${viajeIda.origen} -> ${viajeIda.destino}`);
}
```

**Ejemplo de URL generada:**
```
/web/travelhub/formulario-reserva?viajeIdIda=1&viajeIdVuelta=11
```

**Contenido de SessionStorage:**
```javascript
// sessionStorage.getItem('viajeIda')
{
  "viajeId": 1,
  "origen": "Buenos Aires",
  "destino": "Córdoba",
  "fechaSalida": 1735128000000,
  "fechaLlegada": 1735156800000,
  "empresa": "Plusmar",
  "precio": 25000.00,
  "asientosDisponibles": 40
}

// sessionStorage.getItem('viajeVuelta')
{
  "viajeId": 11,
  "origen": "Córdoba",
  "destino": "Buenos Aires",
  "fechaSalida": 1735387200000,
  "fechaLlegada": 1735416000000,
  "empresa": "Plusmar",
  "precio": 25000.00,
  "asientosDisponibles": 40
}
```

---

### **Fragmento 3: formulario-reserva → API Backend**

**Método:** HTTP POST (JSON)

**Código de envío (formulario-reserva.js):**
```javascript
async function procesarReserva(e) {
    e.preventDefault();

    const formData = new FormData(e.target);
    const viajeIda = viajeInfo.viajeIda;
    const viajeVuelta = viajeInfo.viajeVuelta;
    
    // Construir payload JSON
    const reservaData = {
        idViajeIda: parseInt(viajeInfo.viajeIdIda),
        idViajeVuelta: viajeInfo.viajeIdVuelta ? parseInt(viajeInfo.viajeIdVuelta) : 0,
        tipoReserva: viajeInfo.tipoReserva,
        origen: viajeIda.origen,
        destino: viajeIda.destino,
        fechaSalida: new Date(viajeIda.fechaSalida).toISOString(),
        fechaLlegada: new Date(viajeIda.fechaLlegada).toISOString(),
        mail: formData.get('mail'),
        dni: formData.get('dni')
    };

    // Enviar a API REST
    const response = await fetch('/o/reservas/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(reservaData)
    });

    const reserva = await response.json();
    console.log('Reserva creada:', reserva.reservaId);
}
```

---

## 🛠️ Utilidades Comunes

### Limpiar SessionStorage

```javascript
// Limpiar un item específico
sessionStorage.removeItem('viajeIda');
sessionStorage.removeItem('viajeVuelta');

// Limpiar todo
sessionStorage.clear();
```

**Buena práctica:** Limpiar después de usar:
```javascript
// formulario-reserva.js - Después de confirmar reserva
function limpiarDatos() {
    sessionStorage.removeItem('viajeIda');
    sessionStorage.removeItem('viajeVuelta');
    sessionStorage.removeItem('tipoReserva');
}
```

### Validar Parámetros de URL

```javascript
function validarParametros(params) {
    if (!params.origen || !params.destino) {
        mostrarError('Faltan datos de búsqueda');
        window.location.href = '/web/travelhub';
        return false;
    }
    return true;
}
```

### Manejo de Fechas

```javascript
// Convertir Date a string ISO para URL
const fechaISO = new Date('2025-12-25').toISOString();
// "2025-12-25T00:00:00.000Z"

// Convertir timestamp de API a Date
const fecha = new Date(1735128000000);

// Formatear para mostrar
const fechaFormateada = fecha.toLocaleDateString('es-AR', {
    day: '2-digit',
    month: '2-digit',
    year: 'numeric'
});
// "25/12/2025"
```

---

## 📊 Diagrama de Flujo de Datos

```
┌──────────────┐
│ home-landing │
└──────┬───────┘
       │ URL params: origen, destino, fechas, tipoReserva
       ▼
┌──────────────┐
│ viajes-list  │
└──────┬───────┘
       │ SessionStorage: viajeIda, viajeVuelta
       │ URL params: viajeIdIda, viajeIdVuelta
       ▼
┌────────────────────┐
│ formulario-reserva │
└──────┬─────────────┘
       │ HTTP POST (JSON): reservaData
       ▼
┌──────────────┐
│  API /reservas
└──────────────┘
```

---

## ✅ Mejores Prácticas

### 1. **Usa URL params para:**
- Datos simples (strings, números, fechas)
- Búsquedas y filtros
- Navegación que quieres compartir o guardar en historial

### 2. **Usa SessionStorage para:**
- Objetos complejos con múltiples campos
- Datos temporales del flujo de usuario
- Cuando la URL se volvería muy larga o ilegible

### 3. **Usa LocalStorage para:**
- Preferencias del usuario
- Datos que deben persistir entre sesiones
- Configuraciones (tema, idioma, etc.)

### 4. **Validaciones:**
```javascript
// Siempre validar datos recibidos
const viajeIda = JSON.parse(sessionStorage.getItem('viajeIda'));
if (!viajeIda) {
    mostrarError('No se encontró información del viaje');
    return;
}

// Validar URL params
const origen = urlParams.get('origen');
if (!origen || origen.trim() === '') {
    mostrarError('Origen inválido');
    return;
}
```

### 5. **Limpieza:**
```javascript
// Limpiar datos después de usarlos
window.addEventListener('beforeunload', () => {
    sessionStorage.removeItem('viajeIda');
    sessionStorage.removeItem('viajeVuelta');
});
```

---

## 🐛 Debugging

### Ver todos los datos en SessionStorage
```javascript
// En la consola del navegador
for (let i = 0; i < sessionStorage.length; i++) {
    const key = sessionStorage.key(i);
    console.log(key, sessionStorage.getItem(key));
}
```

### Ver parámetros de URL actuales
```javascript
// En la consola del navegador
const params = new URLSearchParams(window.location.search);
for (const [key, value] of params) {
    console.log(key, value);
}
```

### Inspeccionar Storage en DevTools
1. Abrir DevTools (F12)
2. Ir a pestaña **Application** (Chrome) o **Storage** (Firefox)
3. Expandir **Session Storage** o **Local Storage**
4. Ver/editar/eliminar items

---

## 📞 Referencias

- Fragmentos del proyecto: `fragments/`
- API Documentation: `doc/API-DOCUMENTATION.md`
- Guía de Service Builder: `GUIA_SERVICE_BUILDER.md`

---

**Última actualización:** Diciembre 2025
