package modelo;

public class Guerrero extends Personaje
{

	public Guerrero(String nombre, Posicion posicion)
	{
		super(nombre, 500, posicion);

	}

	@Override
	public String ataca(Personaje adversario)
	{
		String respuesta = null;

		if (this.distancia(adversario) <= 10)
		{
			adversario.recibeDano(10);
			respuesta = this.getNombre() + " Ataco con exito a " + adversario.getNombre();
		} else
			respuesta = this.getNombre() + " No pudo atacar a " + adversario.getNombre()
					+ " , distancia demasiado grande " + this.distancia(adversario);
		return respuesta;
	}

	@Override
	public void recibeDano(int cantidad)
	{
		this.vitalidad -= cantidad;

	}

	@Override
	public String toString()
	{

		return "Guerrero " + super.toString();
	}

	@Override
	public void hechizoBueno()
	{
		this.vitalidad += 100;
	}

	@Override
	public void hechizoMalo()
	{
		this.vitalidad *= .5;
	}

}
