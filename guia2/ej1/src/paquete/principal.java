package paquete;

public class principal {

	public static void main(String[] args) {
		Punto p1 = new Punto(2,3); //Crea instancia p1 y le asigna x=2 e y=3
		Punto p2; //Crea instancia p2
		Punto p3= newPunto(); //Crea instancia p3 pero falta espacio entre new y Punto() y tampoco compila porque no hay constructor Punto()
		System.out.println("P1="+p1.cartel()); //Imprime cartel p1 (No se si esta bien hecha el metodo cartel
		p3=p2; //Asigna p2 a p3, pero p2 no tiene nada no compila
		p2=p1;	//Asigna p1 a p2
		p1.cambia(8, 5); //invoca setX y setY que no existen, error de compilacion
		System.out.println("P2="+p2.cartel()); //Imprime el mismo cartel que imprimio antes porque p2 ahora es el primer p1
	}

}
