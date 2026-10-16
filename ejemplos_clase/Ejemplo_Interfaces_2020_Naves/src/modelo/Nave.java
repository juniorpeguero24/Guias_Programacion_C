package modelo;

public class Nave implements Movible, Dibujable
{
	private String nombre;
	private int energia=500;
	private Movible movible;
	private Dibujable dibujable;
	
	
	

	public Nave(String nombre, Movible movible, Dibujable dibujable)
	{
		super();
		this.nombre = nombre;
		this.movible = movible;
		this.dibujable = dibujable;
	}


	@Override
	public void dibujar()
	{
		this.dibujable.dibujar();
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
		this.movible.setX(x);
		
	}


	@Override
	public double getY()
	{
		
		return this.movible.getY();
	}


	@Override
	public void setY(double y)
	{
		this.movible.setY(y);
	}


	@Override
	public double distancia(Movible otro)
	{
		return this.movible.distancia(otro);
	}


	@Override
	public void mueve(double x, double y)
	{
		this.movible.mueve(x, y);
		
	}


	@Override
	public String toString()
	{
		return "Nave [nombre=" + nombre + ", energia=" + energia + ", movible=" + movible + ", dibujable=" + dibujable
				+ "]";
	}

	

	
	
	

}
