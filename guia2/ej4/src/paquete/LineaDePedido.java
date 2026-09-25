package paquete;

public class LineaDePedido {
	
	private Producto prod;
	private int cant;

	
	public LineaDePedido(Producto prod, int cant) {
		super();
		this.prod = prod;
		this.cant = cant;
	}
	
	public double calcularSubtotal() {
		if (prod != null) {
			return prod.getPrecio()*cant;
		}
		return 0.0;
	}


	public Producto getProd() {
		return prod;
	}



	public int getCant() {
		return cant;
	}



	public LineaDePedido() {
		// TODO Auto-generated constructor stub
	}

}
