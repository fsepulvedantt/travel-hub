# Script para agregar las columnas necesarias a la tabla Reserva_Reserva
# usando la consola SQL de Liferay (Script Console)

$url = "http://localhost:8080/o/reservas"

Write-Host "`n🔧 Agregando columnas a la tabla Reserva_Reserva..." -ForegroundColor Cyan
Write-Host "================================================`n" -ForegroundColor Cyan

# Instrucciones para el usuario
Write-Host "📝 INSTRUCCIONES:" -ForegroundColor Yellow
Write-Host ""
Write-Host "Por favor, ejecuta manualmente el siguiente SQL en la consola de Liferay:" -ForegroundColor White
Write-Host "(Control Panel → Server Administration → Script → Groovy)" -ForegroundColor Gray
Write-Host ""
Write-Host "------------------------------------------------" -ForegroundColor Cyan
Write-Host @"
import com.liferay.portal.kernel.dao.jdbc.DataAccess
import java.sql.Connection
import java.sql.Statement

Connection connection = null
Statement statement = null

try {
    connection = DataAccess.getConnection()
    statement = connection.createStatement()
    
    try {
        statement.execute("ALTER TABLE Reserva_Reserva ADD COLUMN idViajeIda BIGINT DEFAULT 0")
        out.println("✅ Columna idViajeIda agregada")
    } catch (Exception e) {
        out.println("⚠️  Columna idViajeIda ya existe o error: " + e.message)
    }
    
    try {
        statement.execute("ALTER TABLE Reserva_Reserva ADD COLUMN idViajeVuelta BIGINT DEFAULT 0")
        out.println("✅ Columna idViajeVuelta agregada")
    } catch (Exception e) {
        out.println("⚠️  Columna idViajeVuelta ya existe o error: " + e.message)
    }
    
    try {
        statement.execute("ALTER TABLE Reserva_Reserva ADD COLUMN tipoReserva VARCHAR(50) DEFAULT 'IDA'")
        out.println("✅ Columna tipoReserva agregada")
    } catch (Exception e) {
        out.println("⚠️  Columna tipoReserva ya existe o error: " + e.message)
    }
    
    // Actualizar registros existentes
    try {
        int updated = statement.executeUpdate("UPDATE Reserva_Reserva SET idViajeIda = idViaje WHERE idViajeIda = 0 OR idViajeIda IS NULL")
        out.println("✅ " + updated + " registros actualizados con idViajeIda")
    } catch (Exception e) {
        out.println("⚠️  Error al actualizar registros: " + e.message)
    }
    
    connection.commit()
    out.println("✅ Cambios confirmados")
    
} catch (Exception e) {
    out.println("❌ Error: " + e.message)
    e.printStackTrace()
} finally {
    DataAccess.cleanUp(connection, statement)
}
"@ -ForegroundColor Green
Write-Host "------------------------------------------------" -ForegroundColor Cyan
Write-Host ""
Write-Host "Después de ejecutar el script, presiona cualquier tecla para continuar con la prueba..." -ForegroundColor Yellow
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")

Write-Host "`n✅ Continuando con la prueba de reserva..." -ForegroundColor Green
