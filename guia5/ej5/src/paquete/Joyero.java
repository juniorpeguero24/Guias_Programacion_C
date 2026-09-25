package paquete;

public class Joyero extends Artesano {

	public Joyero(String nombre) {
		super(nombre);
	}

	@Override
	public String conMadera(Material mat) {
		return this.nombre+" fabrico un par de aros de "+mat;
	}

	@Override
	public String conMetal(Material mat) {
		return this.nombre+" fabrico un anillo de "+mat;
	}

	@Override
	public String toString() {
		return "Joyero "+super.toString();
	}
	
}
