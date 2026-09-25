package paquete;

import interfaces.Emisor_de_Sonido;

public class Pollito extends Animal implements Emisor_de_Sonido{

	@Override
	public void emiteSonido() {
		System.out.println("Pio.");		
	}
	
}
