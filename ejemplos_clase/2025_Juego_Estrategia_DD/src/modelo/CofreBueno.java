package modelo;

public class CofreBueno implements ICofre
{

	@Override
	public void hechizar(Hechizable hechizable)
	{
	hechizable.hechizoBueno();
	}

}
