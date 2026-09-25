package paquete;

public class Chofer {
	private Categoria categoria;
	private Domicilio domicilio;
	private String nombre;
	private Colectivo colectivo;
	
	public Chofer(Categoria categoria, Domicilio domicilio, String nombre) {
		super();
		this.categoria = categoria;
		this.domicilio = domicilio;
		this.nombre = nombre;
		this.colectivo=null;
	}
	
	public void asignarColectivo(Colectivo colectivo) {
		this.colectivo=colectivo;
	}
	
	public void desvincularColectivo() {
		this.colectivo=null;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	public Colectivo getColectivo() {
		return colectivo;
	}
	public void setColectivo(Colectivo colectivo) {
		this.colectivo = colectivo;
	}
	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		String infoColectivo=(colectivo != null) ? colectivo.toString(): "Sin colectivo asignado";
		return "Chofer [categoria=" + categoria + ", domicilio=" + domicilio + ", nombre=" + nombre + " | "+infoColectivo;
	}
	
	
}
