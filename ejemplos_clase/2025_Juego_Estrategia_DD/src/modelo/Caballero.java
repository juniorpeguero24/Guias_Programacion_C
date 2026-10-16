package modelo;

public class Caballero extends Personaje
{
	private int armadura;

	public Caballero(String nombre, Posicion posicion)
	{
		super(nombre, 800, posicion);
		this.armadura = 400;

	}

	public int getArmadura()
	{
		return armadura;
	}

	public void recuperaArmadura(int cantidad)
	{

		this.armadura += cantidad;
	}

	@Override
	public String ataca(Personaje adversario)
	{
		String respuesta = null;

		if (this.distancia(adversario) <= 5)
		{
			adversario.recibeDano(15);
			respuesta = this.getNombre() + " Ataco con exito a " + adversario.getNombre();
		} else
			respuesta = this.getNombre() + " No pudo atacar a " + adversario.getNombre()
					+ " , distancia demasiado grande " + this.distancia(adversario);
		;
		return respuesta;
	}

	@Override
	public void recibeDano(int cantidad)
	{
		if (cantidad < this.armadura)
			this.armadura -= cantidad;
		else
		{
			this.vitalidad -= (cantidad - this.armadura);
			this.armadura = 0;
		}

	}

	@Override
	public String toString()
	{

		return "Caballero " + super.toString() + " [armadura=" + this.armadura + "]";
	}

	@Override
	public void hechizoBueno()
	{
		this.armadura*=1.5;
		
	}

	@Override
	public void hechizoMalo()
	{
		this.armadura*=0.5;
	}

	

}
