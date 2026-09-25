package paquete;

/**
 * Representa una combi de transporte de personas.
 */
public class Combi extends VehiculoPersonas {

    /**
     * Construye una combi con su patente y capacidad de pasajeros.
     * 
     * <b>Precondicion:</b> Patente valida y plazas mayor a 0.
     * <b>Postcondicion:</b> Instancia de Combi lista para operar.
     * 
     * @param patente Identificador de la combi.
     * @param plazas  Cantidad de plazas de pasajeros.
     * @throws Exception Si los parametros de entrada son invalidos.
     */
    public Combi(String patente, int plazas) throws Exception {
        super(patente, plazas);
    }

    /**
     * Retorna el recargo fijo unico del 2% del precio base por plaza.
     * 
     * <b>Postcondicion:</b> Retorna precioBase * 0.02 * plazas independientemente de los dias.
     * 
     * @return Monto del recargo fijo.
     */
    @Override
    protected double calcularRecargoFijo() {
        return precioBase * 0.02 * plazas;
    }
}