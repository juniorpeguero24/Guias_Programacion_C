package modelo;

public abstract class Personaje implements Movible,Hechizable
{
	private String nombre;
	protected int vitalidad;
	private Movible movible;

	
	
	
	public Personaje(String nombre, int vitalidad, Posicion posicion)
	{
		this.nombre = nombre;
		this.vitalidad = vitalidad;
		this.movible = posicion;
	}

	public String getNombre()
	{
		return nombre;
	}

	public int getVitalidad()
	{
		return vitalidad;
	}

	public Movible getPosicion()
	{
		return movible;
	}

	@Override
	public String toString()
	{
		return "[nombre=" + nombre + ", vitalidad=" + vitalidad + ", posicion=" + movible + "]";
	}

	public void mueve(double x, double y)
	{
		this.movible.mueve(x, y);
	}

	public double distancia(Movible otro)
	{
		return this.movible.distancia(otro);
	}
	
	
	
	
	
	@Override
	public double getX()
	{
		// TODO Auto-generated method stub
		return this.movible.getX();
	}

	@Override
	public void setX(double x)
	{
		this.setX(x);
		
	}

	@Override
	public double getY()
	{
		// TODO Auto-generated method stub
		return this.movible.getY();
	}

	@Override
	public void setY(double y)
	{
	this.movible.setY(y);	
	}

	//El metodo ataca devuelve un String par informar 
	//sobre su xito o fracaso, esto NO ES CORRECTO pero
	// por ahora lo vamos a dejar pasar
	// Este ejemplo lo retomaremos en la clase de Excepciones
	public abstract String ataca(Personaje adversario);
	
	public abstract void recibeDano(int cantidad);
	

}
