package paquete;

public class CuentaCorriente extends CuentaBancaria {
	private double topeDesc;
	
	public CuentaCorriente(String titular,double topeDesc) {
		super(titular);
		this.topeDesc=topeDesc;
	}
	
	public CuentaCorriente(String titular) {
		this(titular,5000);
	}

	public void extraccion(double importe) {
		if (importe <= (saldo+topeDesc) && importe > 0)
			saldo -= importe;
	}
	
	public double getTopeDesc() {
		return topeDesc;
	}

	public void setTopeDesc(double topeDesc) {
		this.topeDesc = topeDesc;
	}
	
}
