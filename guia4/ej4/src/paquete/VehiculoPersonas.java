package paquete;

/**
 * Clase abstracta que agrupa a los vehiculos destinados al transporte de pasajeros.
 */
public abstract class VehiculoPersonas extends Vehiculo {
    protected int plazas;

    /**
     * Inicializa los atributos comunes para vehiculos de pasajeros.
     * 
     * <b>Precondicion:</b> La patente no debe ser nula ni vacia; plazas debe ser mayor a 0.
     * <b>Postcondicion:</b> Vehiculo creado con su capacidad de asientos establecida.
     * 
     * @param patente Identificador del vehiculo.
     * @param plazas  Cantidad de asientos disponibles para pasajeros.
     * @throws Exception Si la patente no es valida o si plazas es menor o igual a cero.
     */
    public VehiculoPersonas(String patente, int plazas) throws Exception {
        super(patente);
        if (plazas <= 0) {
            throw new Exception("Numero invalido de plazas.");
        }
        this.plazas = plazas;
    }

    /**
     * Calcula el precio diario con un incremento del 1.5% por cada plaza.
     * 
     * <b>Postcondicion:</b> Retorna el precio base incrementado segun la formula: base * (1 + 0.015 * plazas).
     * 
     * @return Precio diario correspondiente al vehiculo de personas.
     */
    @Override
    protected double calcularPrecioDiario() {
        return precioBase * (1.0 + (0.015 * plazas));
    }
}