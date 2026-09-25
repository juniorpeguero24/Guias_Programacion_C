package paquete;

import java.util.ArrayList;

import interfaces.Movible;

public abstract class Personaje implements Movible{
	protected String nombre;
	protected int vitalidad=500;
	protected Movible posicion;
	protected ArrayList<Gema> gemas;
	
	public Personaje(String nombre, Movible posicion2) {
		this.nombre = nombre;
		this.posicion = posicion2;
		this.gemas = new ArrayList<>();
	}

	public void agregarGema(Gema g) {
		this.gemas.add(g);
	}
	
	public void sacarGema(Gema g) {
		this.gemas.remove(g);
	}
	
	public void combinarGemas(Gema gema1,Gema gema2) {
		if (this.gemas.contains(gema1) && this.gemas.contains(gema2))
			gema1.combinar(gema2);
	}
	
	public abstract void abrirCofre(Cofre c);
	
	public String getNombre() {
		return nombre;
	}

	public int getVitalidad() {
		return vitalidad;
	}
	
	public abstract boolean ataca(Personaje p);
	
	public void recibeDanio(int cantidad) {
		this.vitalidad = Math.max(0, this.vitalidad-cantidad);
	}
	
	@Override
	public String toString() {
		return nombre + " HP=" + vitalidad + " Pos=" +posicion;
	}

	@Override
	public double getPosx() {
		return this.posicion.getPosx();
	}

	@Override
	public double getPosy() {
		return this.posicion.getPosy();
	}

	@Override
	public void setXY(double x, double y) {
		this.posicion.setXY(x, y);
	}

	@Override
	public void incrementaPos(double x, double y) {
		this.posicion.incrementaPos(x, y);
	}

	@Override
	public double distancia(Movible pos) {
		return this.posicion.distancia(pos);
	}

	public Movible getPosicion() {
		return posicion;
	}

	public void setPosicion(Movible posicion) {
		this.posicion = posicion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setVitalidad(int vitalidad) {
		this.vitalidad = vitalidad;
	}
	
	
}
