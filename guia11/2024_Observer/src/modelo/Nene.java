package modelo;

import java.awt.Toolkit;
import java.util.Observable;
import java.util.Random;

public class Nene extends Observable implements Runnable
{
    private String estado;
    private String nombre;
    private static Random r = new Random();

    public Nene(String nombre)
    {
	this.nombre = nombre;
    }


	@Override
    public void run()
    {
	for (int i = 0; i < 10; i++)

	{
	    UtilThread.espera();
	    
	    int opcion = r.nextInt(5);
	    switch (opcion)
	    {
	    case 0:
		this.estado = "Aburrido";
		break;
	    case 1:
		this.estado = "Con sueño";
		break;
	    case 2:
		this.estado = "Con hambre";
		break;
	    case 3:
		this.estado = "Con pañal sucio";
		break;
	    case 4:
		this.estado = "Llorando";
		break;
	    }
	    Toolkit.getDefaultToolkit().beep();  
	  
	    this.setChanged();
	    
	    this.notifyObservers(this.estado);
	    
	}
    }

   
    public String getNombre()
    {
	return nombre;
    }

}
