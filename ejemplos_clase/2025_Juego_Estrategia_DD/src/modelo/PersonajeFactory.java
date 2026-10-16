package modelo;

public class PersonajeFactory
{
	public static Personaje getPersonaje(String tipo, String nombre, Posicion posicion)
	{
		Personaje respuesta = null;
		if (tipo.equals("Guerrero"))
			respuesta = new Guerrero(nombre, posicion);
		else if (tipo.equals("Arquero"))
			respuesta = new Arquero(nombre, posicion);
		else if (tipo.equals("Caballero"))
			respuesta = new Caballero(nombre, posicion);

		return respuesta;

	}

}
