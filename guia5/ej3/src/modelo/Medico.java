package modelo;

public class Medico extends Personaje {
	
	public Medico(String equipo, int x, int y) {
		super(equipo, 40, 100, x, y);
	}

	@Override
	public void recibeDanio(int cantidad) {
		this.energia -= (cantidad*1.5);
	}

	@Override
	public String toString() {
		return "Medico "+super.toString();
	}
}

