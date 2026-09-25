package paquete;

public abstract class Material {
	protected String color;

	public Material(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	@Override
	public String toString() {
		return color;
	}

	protected abstract String recibir(Artesano artesano);
	
}
