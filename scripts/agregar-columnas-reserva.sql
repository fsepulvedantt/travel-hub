-- Script para agregar las columnas idViajeIda, idViajeVuelta y tipoReserva a la tabla Reserva_Reserva

-- Verificar si las columnas ya existen antes de agregarlas
-- En HyperSQL (base de datos embebida de Liferay), usamos este enfoque

-- Agregar columna idViajeIda si no existe
ALTER TABLE Reserva_Reserva ADD COLUMN idViajeIda BIGINT DEFAULT 0;

-- Agregar columna idViajeVuelta si no existe  
ALTER TABLE Reserva_Reserva ADD COLUMN idViajeVuelta BIGINT DEFAULT 0;

-- Agregar columna tipoReserva si no existe
ALTER TABLE Reserva_Reserva ADD COLUMN tipoReserva VARCHAR(50) DEFAULT 'IDA';

-- Actualizar registros existentes para que idViajeIda tenga el valor de idViaje
UPDATE Reserva_Reserva SET idViajeIda = idViaje WHERE idViajeIda = 0 OR idViajeIda IS NULL;

-- Confirmar cambios
COMMIT;
