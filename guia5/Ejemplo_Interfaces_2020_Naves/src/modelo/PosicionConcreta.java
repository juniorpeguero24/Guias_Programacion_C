package modelo;

public class PosicionConcreta implements Movible
{
	private double x;
	private double y;

	public PosicionConcreta(double x, double y)
	{

		this.x = x;
		this.y = y;
	}

	@Override
	public double getX()
	{
		return x;
	}

	@Override
	public void setX(double x)
	{
		this.x = x;
	}

	@Override
	public double getY()
	{
		return y;
	}

	@Override
	public void setY(double y)
	{
		this.y = y;
	}

	@Override
	public String toString()
	{
		return "[x=" + x + ", y=" + y + "]";
	}

	@Override
	
	public double distancia(Movible otro)
	{
		double respuesta;
		respuesta = (otro.getX() - this.getX()) * (otro.getX() - this.getX()) + (otro.getY() - this.getY()) * (otro.getY() - this.getY());
		respuesta = Math.sqrt(respuesta);
		return respuesta;
	}

	@Override
	public void mueve(double x, double y)
	{
		this.x += x;
		this.y += y;

	}
	

}






















