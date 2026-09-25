package paquete;

public class CuentaUniversitaria extends CuentaBancaria{	
	private final double MAXDIARIO=1000.0;
	protected double retirado=0;
	
	public CuentaUniversitaria(String nombre) throws Exception {
		super(nombre);
	}
	
	@Override
	protected boolean validaExtraccion(double monto) {
		return ((retirado + monto) <= MAXDIARIO && monto <= saldo);
	}

	@Override
	protected void notificarExtraccion(double monto) {
		retirado += monto;
	}

	@Override
	public String toString() {
		return "CuentaUniversitaria ["+super.toString()+" retirado=" + retirado + "]";
	}
	
	
}
