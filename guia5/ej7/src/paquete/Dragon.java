package paquete;

public class Dragon extends Personaje {

	@Override
	protected double getArmadura() {
		return 10000;
	}

	@Override
	protected double getAtaqueDistante() {
		return 200;
	}

	@Override
	protected double getAtaqueCorto() {
		return 500;
	}
	@Override
	public String toString() { return "Dragon"; }
}
