package paquete;

public class CamionetaCarga extends	 VehiculoCarga{

	public CamionetaCarga(String patente, double PMA) throws Exception {
		super(patente, PMA);
	}

	@Override
	protected double calcularRecargoFijo() {
		return 0;
	}

}
