package paquete;

import interfaces.Movible;

public class PersonajeFactory {
	
	public static Personaje crearPersonaje(String tipo, String nombre, Movible pos) {
		switch (tipo) {
			case "Arquero":
				return new Arquero(nombre, pos);
			case "Guerrero":
				return new Guerrero(nombre,50,  pos);
			case "Caballero":
				return new Caballero(nombre,  pos);
            default:
				throw new RuntimeException();
		}
	}
}

