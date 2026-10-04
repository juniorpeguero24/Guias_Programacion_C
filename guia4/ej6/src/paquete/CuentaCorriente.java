package paquete;

public class CuentaCorriente extends CuentaBancaria{
	protected double topeDescubierto;
	
	public CuentaCorriente(String nombre,double tope) throws Exception {
		super(nombre);
		if (tope <= 0)
			throw new Exception("Tope invalido");
		else
			topeDescubierto = tope;
	}
	
	public CuentaCorriente(String nombre) throws Exception {
		this(nombre, 10000);
	}

	@Override
	protected boolean validaExtraccion(double monto) {
		return (monto <= (saldo + topeDescubierto));
	}

	public double getTopeDescubierto() {
		return topeDescubierto;
	}

	public void setTopeDescubierto(double topeDescubierto) {
		this.topeDescubierto = topeDescubierto;
	}

	@Override
	protected void notificarExtraccion(double monto) {
        if (monto > saldo) {
            this.saldo=0;
			this.topeDescubierto -= (monto - saldo);
        }
	}

	@Override
	public String toString() {
		return "CuentaCorriente ["+super.toString()+ "topeDescubierto=" + topeDescubierto + "]";
	}
	
}
