package modelo;

public class Inventario implements Dibujable
{
private Dibujable dibujable;

	public Inventario(Dibujable dibujable)
{
	super();
	this.dibujable = dibujable;
}

	@Override
	public void dibujar()
	{
		this.dibujable.dibujar();
	}

}
