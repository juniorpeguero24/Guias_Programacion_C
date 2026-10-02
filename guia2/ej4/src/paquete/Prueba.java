package paquete;

public class Prueba {

	public static void main(String[] args) {
		Empleado e1 = new Empleado("Juan Perez","223123456","juanperez@gmail.com");

		Producto arroz=new Producto(123,"Arroz blanco",2.5);
		Producto fideos=new Producto(456,"Fideos Don Vicente",1.5);
		Producto pan=new Producto(987,"Pan de molde",1.0);

		Pedido p1 = new Pedido(e1,"27/08/2026");

		p1.agregarLinea(arroz,2);
		p1.agregarLinea(fideos,3);

		System.out.println(p1.toString());
		System.out.println("Total: $"+p1.calcularTotal());
	}

}
