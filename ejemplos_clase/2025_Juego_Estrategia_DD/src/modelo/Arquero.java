package modelo;

public class Arquero extends Personaje
{
	private int cantidadFlechas;

	public Arquero(String nombre, Posicion posicion)
	{
		super(nombre, 400, posicion);
		this.cantidadFlechas = 20;

	}
	
	

	public int getCantidadFlechas()
	{
		return cantidadFlechas;
	}

	
	public void agregarFechas(int cantidad) 
	{
		this.cantidadFlechas+=cantidad;
	}


	@Override
	public String ataca(Personaje adversario)
	{
		String respuesta = null;
		if (this.cantidadFlechas > 0)// tenemos flechas
		{
			if (this.distancia(adversario) < 100)
			{
				this.cantidadFlechas--;
				adversario.recibeDano(20);
				respuesta = this.getNombre() + " lanzo una flecha a " + adversario.getNombre();
			} else
			{

				respuesta = this.getNombre() + " No pudo atacar a " + adversario.getNombre()
						+ " aunque tenia flechas, la distacia es muy grande "+this.distancia(adversario);
			}

		} else
		{
			if (this.distancia(adversario) < 5)
			{
				
				adversario.recibeDano(5);
				respuesta = this.getNombre() + " realizo un ataque corto a " + adversario.getNombre();
			} else
			{

				respuesta = this.getNombre() + " No pudo atacar a " + adversario.getNombre()
						+ " No tenia flechas y la distancia era muy grande para ataques cortos "+this.distancia(adversario);;
			}
			
			
		}

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
		
		
		return "Arquero "+super.toString()+" [cantidadFlechas=" + cantidadFlechas + "]";
	}



	@Override
	public void hechizoBueno()
	{
		this.cantidadFlechas+=10;
	}



	@Override
	public void hechizoMalo()
	{
		this.cantidadFlechas=0;	
	}



	

}
