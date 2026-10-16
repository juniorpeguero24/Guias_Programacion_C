package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Mapa
{

	private ArrayList<Personaje> personajes = new ArrayList<Personaje>();

	public void agregarPersonaje(Personaje personaje)
	{
		
		this.personajes.add(personaje);
	}

	public void eliminarPersonaje(Personaje personaje)
	{
		this.personajes.remove(personaje);

	}

	public ArrayList<Personaje> getPersonajes()
	{
		return personajes;
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		Iterator it=this.personajes.iterator();
		while(it.hasNext())
		{
			sb.append(it.next().toString());
			sb.append("\n");
			}
		return sb.toString();

	}

}
