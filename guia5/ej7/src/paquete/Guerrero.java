package paquete;

public class Guerrero extends Personaje {

	@Override
	protected double getArmadura() {
		return 1500;
	}

	@Override
	protected double getAtaqueDistante() {
		return 100;
	}

	@Override
	protected double getAtaqueCorto() {
		return 100;
	}
	
	@Override
	public String toString() { return "Guerrero"; }
}
