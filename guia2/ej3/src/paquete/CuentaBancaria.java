package paquete;

public class CuentaBancaria {
	private double saldo;
	private String titular;
	
	
	
	public CuentaBancaria(String titular) {
		this.titular = titular;
		this.saldo=0.0;
	}

	public void depositar(double monto){
		if (monto > 0)
			this.saldo += monto;
	}
	
	public boolean extraer(double monto) {
		return (this.saldo >= monto) && (monto > 0) ;
	}
	
	public double getSaldo() {
		return saldo;
	}


	public String getTitular() {
		return titular;
	}

}
