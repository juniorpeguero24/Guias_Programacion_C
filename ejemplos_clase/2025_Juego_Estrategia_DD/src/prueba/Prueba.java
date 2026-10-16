package prueba;

import controlador.Controlador;
import vista.Ventana;

public class Prueba
{

	public static void main(String[] args)
	{
		Controlador.getInstance().setVista(new Ventana());

	}

}
