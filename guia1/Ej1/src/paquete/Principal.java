package paquete;

public class Principal {

	public static void main(String[] args) {
		CuentaBancaria unaCuenta = new CuentaBancaria();
		
		unaCuenta.depositar(1250);
		
		unaCuenta.extraer(450);
		
		double sal = unaCuenta.getSaldo();
		System.out.println("Saldo Actual: " + sal);

		unaCuenta.setTitular("Juan Perez");
		
		String tit = unaCuenta.getTitular();
		System.out.println("Titular recuperado: " + tit);
	}

}
