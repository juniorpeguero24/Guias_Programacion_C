package paquete;

public class Camion extends VehiculoCarga{

	public Camion(String patente, double PMA) throws Exception {
		super(patente, PMA);
	}

	@Override
	protected double calcularRecargoFijo() {
		return super.precioBase*0.4;
	}

}
