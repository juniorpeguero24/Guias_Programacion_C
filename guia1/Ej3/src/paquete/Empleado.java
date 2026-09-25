package paquete;

public class Empleado {
	private String nombre;
	private int antiguedad, hstrabajadas;
	private Categoria cat;
	
	
	public Empleado(String nombre, int antiguedad, int hstrabajadas, Categoria cat) {
		super();
		this.nombre = nombre;
		this.antiguedad = antiguedad;
		this.hstrabajadas = hstrabajadas;
		this.cat = cat;
	}


	public String getNombre() {
		return nombre;
	}


	public int getAntiguedad() {
		return antiguedad;
	}


	public int getHstrabajadas() {
		return hstrabajadas;
	}


	public Categoria getCat() {
		return cat;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}


	public void setHstrabajadas(int hstrabajadas) {
		this.hstrabajadas = hstrabajadas;
	}


	public void setCat(Categoria cat) {
		this.cat = cat;
	}

	String detalle() {
		String retorno= "Nombre: " + this.nombre + "\nAntiguedad: " + this.antiguedad + "años\nHoras trabajadas: " + this.hstrabajadas + "\nTipo de categoria: " + this.cat.getNombrecategoria() + "\nSueldo por hora: " + this.cat.getSueldoporhora() + "\nSueldo a cobrar: " + this.getsueldo() + "\n";
		
		return retorno;
	}
	
	public double getsueldo() {
		double aux;
		aux = this.cat.getSueldoporhora() * this.hstrabajadas;
		if (this.antiguedad > 5) {
			if (this.antiguedad < 10)
				aux *= 1.25;
			else
				aux *= 1.35;
		}
		return aux;
	}
	
	public Empleado() {
		// TODO Auto-generated constructor stub
	}

}
