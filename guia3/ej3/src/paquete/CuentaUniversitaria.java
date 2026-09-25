package paquete;

public class CuentaUniversitaria extends Cuenta_Bancaria{
	private static final double tope=1000;
	private double diarioExtraido;
	
	public CuentaUniversitaria(String titular) {
		super(titular);
		diarioExtraido=0;
	}
	
	public void reiniciarDia() {
		diarioExtraido=0;
	}
	
	@Override
	public void extraccion(double importe) {
		if (importe > 0 && importe <= saldo && (diarioExtraido + importe) <= tope) {
			saldo -= importe;
			diarioExtraido += importe;
		}
	}

	public double getDiarioExtraido() {
		return diarioExtraido;
	}
}
