package paquete;

import interfaces.Movible;

public abstract class Personaje {
	protected String nombre;
	protected int vitalidad=500;
	protected Movible posicion;
	
	public Personaje(String nombre, Movible posicion) {
		this.nombre = nombre;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public int getVitalidad() {
		return vitalidad;
	}

	public Movible getPosicion() {
		return posicion;
	}
	
	public abstract boolean ataca(Personaje p);
	
	public void recibeDanio(int cantidad) {
		this.vitalidad = Math.max(0, this.vitalidad-cantidad);
	}
	
	@Override
	public String toString() {
		return nombre + " HP=" + vitalidad + " Pos=" +posicion;
	}

}
