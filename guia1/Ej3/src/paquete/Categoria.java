package paquete;

public class Categoria {
	private String nombrecategoria;
	private double sueldoporhora;
	
	
	public Categoria(String nombrecategoria, double sueldoporhora) {
		super();
		this.nombrecategoria = nombrecategoria;
		this.sueldoporhora = sueldoporhora;
	}


	public String getNombrecategoria() {
		return nombrecategoria;
	}


	public double getSueldoporhora() {
		return sueldoporhora;
	}


	public Categoria() {
		// TODO Auto-generated constructor stub
	}

}
