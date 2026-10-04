package paquete;

import interfaces.Movible;

public class Posicion implements Movible {
	protected double x,y;

	public Posicion(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
        @Override
	public void setXY(double x,double y) {
		this.x = x;
		this.y = y;
	}
	
	public void incrementaPos(double valorX,double valorY) {
		this.x += valorX;
		this.y += valorY;
	}
	
	@Override
	public String toString() {
		return "Posicion [x=" + x + ", y=" + y + "]";
	}

    @Override
    public double getPosx() {
        return this.x;
    }

    @Override
    public double getPosy() {
        return this.y;
    }

    @Override
    public double distancia(interfaces.Movible p) {
        return Math.sqrt(Math.pow(p.getPosx()-this.x,2)+Math.pow(p.getPosy()-this.y,2));
    }
}
