package prueba;

import modelo.Nene;
import modelo.ObservadorConsola;
import modelo.ObservadorVentana;
import modelo.Ventana;

public class Prueba
{
	public static void main(String[] args)
	{
		Nene n1 = new Nene("Thiago");
		Nene n2 = new Nene("Joaquina");
		Nene n3 = new Nene("Francesca");
		Nene n4 = new Nene("Mateo");
		Nene n5 = new Nene("Quique");
		Thread h1 = new Thread(n1);
		Thread h2 = new Thread(n2);
		Thread h3 = new Thread(n3);
		Thread h4 = new Thread(n4);
		Thread h5 = new Thread(n5);

		ObservadorConsola oc1 = new ObservadorConsola(n1);
		ObservadorConsola oc2 = new ObservadorConsola(n2);
		ObservadorConsola oc3 = new ObservadorConsola(n3);
		ObservadorConsola oc4 = new ObservadorConsola(n4);
		ObservadorConsola oc5 = new ObservadorConsola(n5);

		Ventana v = new Ventana();

		ObservadorVentana v1=new ObservadorVentana(n1,v);
		ObservadorVentana v2=new ObservadorVentana(n3,v);
		ObservadorVentana v3=new ObservadorVentana(n4,v);
		
		
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		h5.start();

	}
}
