package modelo;

public class Prueba
{

	public static void main(String[] args)
	{
		Nave nave = new Nave("Millenium Falcon", new PosicionConcreta(100,50),new RepresetancionTipo80Sprites());
		Cliente c = new Cliente();

		System.out.println(nave);
		c.metodoQueMueve(nave);
		c.metodoQueDibuja(nave);
		
		System.out.println(nave);

	}

}
