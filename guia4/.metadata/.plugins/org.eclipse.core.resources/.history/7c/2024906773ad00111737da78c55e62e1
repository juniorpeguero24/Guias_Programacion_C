package paquete;

/**
 * Representa un vehiculo generico dentro del sistema de alquiler de la empresa.
 * Define la estructura general para el calculo de costos mediante el patron Template Method.
 * 
 * @author TuNombre
 * @version 1.0
 */
public abstract class Vehiculo {
    protected String patente;
    protected final double precioBase = 500.0;

    /**
     * Construye un vehiculo a partir de su identificador unico.
     * 
     * <b>Precondicion:</b> La patente no debe ser nula ni ser una cadena vacia.
     * <b>Postcondicion:</b> Se crea la instancia del vehiculo con la patente asignada.
     * 
     * @param patente Identificador alfanumerico del vehiculo.
     * @throws Exception Si la patente no cumple con el formato o es nula.
     */
    public Vehiculo(String patente) throws Exception {
        if (patente != null && !patente.trim().isEmpty()) {
            this.patente = patente;
        } else {
            throw new Exception("Patente invalida.");
        }
    }

    /**
     * Calcula el costo por dia de alquiler especifico de la categoria del vehiculo.
     * 
     * <b>Precondicion:</b> El vehiculo debe haber sido instanciado correctamente.
     * <b>Postcondicion:</b> Retorna un valor monetario positivo correspondiente al costo diario.
     * 
     * @return Costo diario de alquiler.
     */
    protected abstract double calcularPrecioDiario();

    /**
     * Calcula el costo fijo extra que se cobra por unica vez.
     * 
     * <b>Precondicion:</b> El vehiculo debe estar instanciado.
     * <b>Postcondicion:</b> Retorna el cargo fijo adicional (mayor o igual a cero).
     * 
     * @return Monto del recargo fijo.
     */
    protected abstract double calcularRecargoFijo();

    /**
     * Calcula el monto total del alquiler para una cantidad determinada de dias.
     * Metodo plantilla (Template Method).
     * 
     * <b>Precondicion:</b> dias debe ser un numero entero estrictamente mayor a 0.
     * <b>Postcondicion:</b> Retorna el costo final calculado como (precioDiario * dias) + recargoFijo.
     * 
     * @param dias Cantidad de dias corridos de alquiler.
     * @return Costo total a pagar por el periodo de alquiler.
     * @throws IllegalArgumentException Si dias es menor o igual a cero.
     */
    public double calcularPrecioAlquiler(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("La cantidad de dias debe ser mayor a 0.");
        }
        return (calcularPrecioDiario() * dias) + calcularRecargoFijo();
    }

    /**
     * Obtiene la patente del vehiculo.
     * 
     * <b>Postcondicion:</b> Retorna la patente no vacia del vehiculo.
     * 
     * @return Cadena con la patente.
     */
    public String getPatente() {
        return patente;
    }
}