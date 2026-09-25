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
		this.titular = titular;
	}

	public void depositar(double cantidad) {
		this.saldo = this.saldo + cantidad;
	}
	
	public void extraer(double cantidad) {
		this.saldo = this.saldo - cantidad;
	}
	
	public CuentaBancaria() {
		// TODO Auto-generated constructor stub
	}

}
