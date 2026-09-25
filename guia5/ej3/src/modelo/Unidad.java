package modelo;

import interfaces.IPosicionable;

public abstract class Unidad implements IPosicionable{
	protected String equipo;
	protected int costo,energia,x,y;
	
	public Unidad(String equipo, int costo, int energia) {
		super();
		this.equipo = equipo;
		this.costo = costo;
		this.energia = energia;
	}
	
	public Unidad() {}

	public abstract void recibeDanio(int cantidad);
	
	public String getEquipo() {
		return equipo;
	}

	public int getCosto() {
		return costo;
	}

	public int getEnergia() {
		return energia;
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return "equipo=" + equipo + ", costo=" + costo + ", energia=" + energia;
	}
	
}
