package paquete;

public abstract class CuentaBancaria {
		private final String titular;
		protected double saldo;
		
		public CuentaBancaria(String titular) {
			this.titular=titular;
			this.saldo=0.0;
		}
		
		public void deposito(double ingreso) {
			if (ingreso > 0)
				this.saldo += ingreso;
		}
		
		public abstract void extraccion(double importe);
		
		public String getTitular() {
			return titular;
		}

		public double getSaldo() {
			return saldo;
		}
		
}
