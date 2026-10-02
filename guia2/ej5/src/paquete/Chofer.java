package paquete;

public class Chofer {
	private final Categoria categoria;
	private final Domicilio domicilio;
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
	public Domicilio getDomicilio() {
		return domicilio;
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
		return "Categoria= " + categoria + ", domicilio= "
				+ domicilio + ", nombre = " + nombre + " | "+infoColectivo;
	}
	
	
}
