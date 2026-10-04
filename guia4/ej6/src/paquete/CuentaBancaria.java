package paquete;

import excepciones.MontoInvalidoException;

public abstract class CuentaBancaria {
	protected String titular;
	protected double saldo=0;
	
	public CuentaBancaria(String nombre) {
		if (nombre != null && !nombre.isEmpty())
			titular=nombre;
		else
			throw new RuntimeException("Nombre incorrecto");
	}
	
	public final boolean extraer(double monto) throws MontoInvalidoException {
		if (monto > 0 && validaExtraccion(monto)) {
			saldo -= monto;
			notificarExtraccion(monto);
			return true;
		}else
			throw new MontoInvalidoException("\n ERROR Monto invalido.", monto, this.saldo,this.titular);
    }
	
	protected abstract void notificarExtraccion(double monto);

	protected abstract boolean validaExtraccion(double monto);
	
	public void depositar(double monto) throws MontoInvalidoException {
        if (monto >= 0) {
			saldo+=monto;
        }else
			throw new MontoInvalidoException("\nERROR Monto invalido", monto, this.titular);
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public String toString() {
		return "Titular=" + titular + ", saldo=" + saldo;
	}
	
	
}
