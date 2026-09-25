package paquete;

import interfaces.Movible;

public class Dragon extends Personaje {
	protected int poderDeFuego;
	
	public Dragon(String nombre, Movible posicion) {
		super(nombre, posicion);
		this.vitalidad=1000;
		this.poderDeFuego=100;
	}

	@Override
	public void abrirCofre(Cofre c) {
		c.afectar(this);
	}

	@Override
	public boolean ataca(Personaje p) {
		if (this.distancia(p) <= 50 && p!=null && p!=this) {
			p.recibeDanio(this.poderDeFuego);
			return true;
		}
		return false;
	}

	@Override
	public void recibeDanio(int cantidad) {
		this.vitalidad -= (int) (cantidad*0.5);
	}

	public int getPoderDeFuego() {
		return poderDeFuego;
	}

	public void setPoderDeFuego(int poderDeFuego) {
		this.poderDeFuego = poderDeFuego;
	}

}
