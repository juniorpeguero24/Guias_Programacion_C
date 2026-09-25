package paquete;

import interfaces.Emisor_de_Sonido;

public class Perro extends Animal implements Emisor_de_Sonido{

	@Override
	public void emiteSonido() {
		System.out.println("Guau.");
	}
	
}
