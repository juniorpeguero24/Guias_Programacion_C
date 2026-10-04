package paquete;

import java.util.ArrayList;

public class Pedido {
	
	private Empleado emp;
	private String fecha;
	private ArrayList<LineaDePedido> lineas;

	public Pedido(Empleado emp, String fecha) {
		super();
		this.emp = emp;
		this.fecha = fecha;
		this.lineas = new ArrayList<>();
	}

	public void agregarLinea(Producto p,int cant) {
		this.lineas.add(new LineaDePedido(p,cant));
	}
	
	public double calcularTotal() {
		double total=0.0;
		for(LineaDePedido linea : lineas) {
			total += linea.calcularSubtotal();
		}
		return total;
	}

	public Empleado getEmp() {
		return emp;
	}



	public String getFecha() {
		return fecha;
	}


	public ArrayList<LineaDePedido> getLineas() {
		return lineas;
	}

	public void setLineas(ArrayList<LineaDePedido> lineas) {
		this.lineas = lineas;
	}

	public void setEmp(Empleado emp) {
		this.emp = emp;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Pedido() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Pedido " +
				"empleado=" + emp +
				", fecha='" + fecha + '\'' +
				", Pedido=" + lineas +
				'}';
	}
}
