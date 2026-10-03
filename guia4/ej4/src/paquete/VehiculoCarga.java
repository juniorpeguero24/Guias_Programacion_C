package paquete;

public abstract class VehiculoCarga extends Vehiculo{
	protected double PMA;

    /**
	 * pre: patente != 0
	 * post: se ha creado un vehiculo de carga
	 *
     * @param patente identificador del vehiculo
     * @param PMA peso maximo autorizado en autorizado
     * @throws Exception si el PMA ingresado es negativo
     */
	public VehiculoCarga(String patente,double PMA) throws Exception {
		super(patente);
		if (PMA <= 0)
			throw new Exception("PMA invalido.");
		this.PMA=PMA;
	}
	
	@Override
	public double calcularPrecioDiario() {
	    return super.precioBase * (1.0 + (0.20 * PMA));
	}
	
}
