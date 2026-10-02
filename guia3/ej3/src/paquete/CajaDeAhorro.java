package paquete;

public class CajaDeAhorro extends CuentaBancaria {
	private static final int cantExtractMax=10;
	private int cantActual;
	
	public CajaDeAhorro(String titular) {
		super(titular);
		reiniciarExtracciones();
	}
	
	public void reiniciarExtracciones() {
		cantActual=0;
	}
	
	@Override
	public void extraccion(double importe) {
		if (cantActual < cantExtractMax && saldo >= importe && importe > 0) {
			saldo-=importe;
			cantActual++;
		}
	}
	
	public int getCantExtractMax() {
		return cantExtractMax;
	}

	public int getCantActual() {
		return cantActual;
	}
	
}
