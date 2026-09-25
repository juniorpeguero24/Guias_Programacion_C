package paquete;

public class Producto {
	
	private int cod;
	private String descripcion;
	private double precio;
	
	
	
	public Producto(int cod, String descripcion, double precio) {
		super();
		this.cod = cod;
		this.descripcion = descripcion;
		this.precio = precio;
	}



	public void setCod(int cod) {
		this.cod = cod;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public int getCod() {
		return cod;
	}



	public Producto() {
		// TODO Auto-generated constructor stub
	}

}
