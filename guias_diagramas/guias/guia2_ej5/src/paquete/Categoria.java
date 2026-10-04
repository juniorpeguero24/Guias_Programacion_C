package paquete;

public class Categoria {
	private String nombrecategoria;
	private double sueldo;
	
	public Categoria(String nombre,double sueldo) {
		this.nombrecategoria=nombre;
		this.sueldo=sueldo;
	}
	
	public String getNombrecategoria() {
		return nombrecategoria;
	}
	public double getSueldo() {
		return sueldo;
	}
	
	public String toString() {
		return nombrecategoria+" ($"+sueldo+")";
	}
}
