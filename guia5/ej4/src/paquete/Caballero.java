package paquete;

import interfaces.Movible;

public class Caballero extends Personaje{
	
	public Caballero(String nombre, Movible posicion) {
		super(nombre, posicion);
	}

	@Override
	public boolean ataca(Personaje p) {
		if (this.posicion.distancia(p.getPosicion()) <= 10 && !this.equals(p)) {
			p.recibeDanio(10);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Caballero "+super.toString();
	}
	
	
}
