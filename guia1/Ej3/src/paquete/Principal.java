package paquete;

public class Principal {

	public static void main(String[] args) {
		Categoria principiante = new Categoria("Principiante",80);
		Categoria operario = new Categoria("Operario",100);
		Categoria experto = new Categoria("Experto",130);
		Empleado e1 = new Empleado("Juan Perez",4,100,principiante);
		Empleado e2 = new Empleado("Roberto Gonzalez",8,120,principiante);
		Empleado e3 = new Empleado("Sandra Lopez",14,120,principiante);
		Empleado e4 = new Empleado("German Gutierrez",16,110,operario);
		Empleado e5 = new Empleado("Vicente Hernandez",9,100,experto);
		Empleado e6 = new Empleado("Carolina Gomez",20,115,experto);
		
		System.out.println(e1.detalle());
		System.out.println(e2.detalle());
		System.out.println(e3.detalle());
		System.out.println(e4.detalle());
		System.out.println(e5.detalle());
		System.out.println(e6.detalle());
	}

}
