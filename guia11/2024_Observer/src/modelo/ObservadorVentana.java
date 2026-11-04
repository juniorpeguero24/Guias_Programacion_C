package modelo;

import java.util.Observable;
import java.util.Observer;

public class ObservadorVentana implements Observer
{
	private Nene observable;
	private Ventana ventana;

	public ObservadorVentana(Nene observable, Ventana ventana)
	{
		super();
		this.observable = observable;
		this.ventana=ventana;
		this.observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg)
	{

		if (o == this.observable)
		{
			Nene nene = (Nene) o;
			String cartelito = (String) arg;
			this.ventana.appendText(nene.getNombre() + " : " + cartelito);
		}
		else throw new IllegalArgumentException();
	}

}
