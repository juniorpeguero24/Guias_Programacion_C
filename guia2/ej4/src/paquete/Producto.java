package paquete;

public class Producto {
	
	private int cod;
	private String descripcion;
	private double precioUnitario;
	
	
	
	public Producto(int cod, String descripcion, double precio) {
		super();
		this.cod = cod;
		this.descripcion = descripcion;
		this.precioUnitario = precio;
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



	public double getPrecioUnitario() {
		return precioUnitario;
	}



	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}



	public int getCod() {
		return cod;
	}



	public Producto() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "cod=" + cod +
				", descripcion='" + descripcion + '\'' +
				", precioUnitario=" + precioUnitario;
	}
}
