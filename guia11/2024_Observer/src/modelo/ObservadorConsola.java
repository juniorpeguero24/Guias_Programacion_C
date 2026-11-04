package modelo;

import java.util.Observable;
import java.util.Observer;

public class ObservadorConsola implements Observer
{
	private Nene observable;

	public ObservadorConsola(Nene observable)
	{
		super();
		this.observable = observable;
		this.observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg)
	{

		if (o == this.observable)
		{
			Nene nene = (Nene) o;
			String cartelito = (String) arg;
			System.out.println(nene.getNombre() + " : " + cartelito);
		}
		else throw new IllegalArgumentException();
	}

}
