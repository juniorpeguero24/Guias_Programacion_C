package paquete;

public class Main {

	public static void main(String[] args) {
		Infusion mate = new Mate();
		Infusion cafeAmargo = new Cafe(false);
		Infusion cafeDulce = new Cafe(true);
		
		mate.preparacion();
		cafeAmargo.preparacion();
		cafeDulce.preparacion();
	}

}
