package paquete;

public class Guerrero extends Personaje{
	protected int armadura;
	
	public Guerrero(String nombre,int armadura ,Posicion posicion) {
		super(nombre, posicion);
		this.vitalidad=800;
		this.armadura = armadura;
	}

	@Override
	public boolean ataca(Personaje p) {
		if (this.posicion.distancia(p.getPosicion()) <= 5) {
			p.recibeDanio(10);
			return true;
		}
		return false;
	}
	
	@Override
	public void recibeDanio(int cantidad) {
		if (this.armadura >= cantidad)
			this.armadura -= cantidad;
		else {
			int restante = (cantidad - this.armadura);
			this.armadura = 0;
			super.recibeDanio(restante);
		}
	}

	public int getArmadura() {
		return armadura;
	}

	@Override
	public String toString() {
		return "Guerrero "+super.toString()+" armadura=" + armadura;
	}
	
	
	
}
