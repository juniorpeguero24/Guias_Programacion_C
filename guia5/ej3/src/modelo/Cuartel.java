package modelo;

public class Cuartel extends Edificio {
	
	public Cuartel(String equipo, int costo, int energia, int tiempoConstruccion) {
		super(equipo, 500, 3000, 60);
	}
	
	@Override
	public void recibeDanio(int cantidad) {
		this.energia -= (cantidad*0.5);
	}

	@Override
	public String toString() {
		return "Cuartel "+super.toString();
	}
}
