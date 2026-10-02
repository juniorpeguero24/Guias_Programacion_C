package paquete;

public class CuentaBancaria {
	
	private double saldo;
	private String titular;
	
	public CuentaBancaria(double saldo, String titular) {
		super();
		this.saldo = saldo;
		this.titular = titular;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		if (titular != null) {
			this.titular = titular;
		}else
			throw new IllegalArgumentException("\nERROR titular distinto de null.");
	}

	public void depositar(double cantidad) {
		if (cantidad > 0) {
			this.saldo = this.saldo + cantidad;
		}else
			throw new IllegalArgumentException("\nERROR cantidad menor a cero.");

	}
	
	public void extraer(double cantidad) {

		this.saldo = this.saldo - cantidad;
	}
	
	public CuentaBancaria() {
		this.saldo=0;
		this.titular="";
	}
}
