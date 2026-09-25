package paquete;

public class Agua extends ElementoDecorator {

	public Agua(Personaje personajeEvoltorio) {
		super(personajeEvoltorio);
	}

	@Override
	protected double getArmadura() {
		return super.getArmadura()*0.85;
	}

	@Override
	protected double getAtaqueDistante() {
		return super.getAtaqueDistante();
	}

	@Override
	protected double getAtaqueCorto() {
		return super.getAtaqueCorto()*1.2;
	}

	@Override
	public String toString() { return super.toString() + " de Agua"; }
}
