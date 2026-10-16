package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.CofreBueno;
import modelo.CofreMalo;
import modelo.ICofre;
import modelo.Mapa;
import modelo.Personaje;
import modelo.PersonajeFactory;
import modelo.Posicion;
import vista.IVista;

public class Controlador implements ActionListener
{

	private static Controlador instance = null;
	private Mapa mapa = new Mapa();
	private IVista vista;

	public static Controlador getInstance()
	{
		if (Controlador.instance == null)
			Controlador.instance = new Controlador();
		return instance;
	}

	private Controlador()
	{
	this.inicializa();
	}

	public IVista getVista()
	{
		return vista;
	}

	public void setVista(IVista vista)
	{
		this.vista = vista;
		vista.actualizarListas(this.mapa.getPersonajes().iterator());
	}

	public Mapa getMapa()
	{
		return mapa;
	}

	public void setMapa(Mapa mapa)
	{
		this.mapa = mapa;
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if (arg0.getActionCommand().equals("NUEVO"))
		{
			this.nuevoPersonaje();

		} else if (arg0.getActionCommand().equals("MOVER"))
		{
			this.moverPersonaje();
		}

		else if (arg0.getActionCommand().equals("ATACAR"))
		{
			this.atacarPersonaje();
		} else if (arg0.getActionCommand().equals("ELIMINAR"))
			this.eliminarPersonaje();
		else if (arg0.getActionCommand().equals("Maldicion"))
			this.abrirCofre(new CofreMalo());

		else if (arg0.getActionCommand().equals("Bendicion"))
			this.abrirCofre(new CofreBueno());
		this.vista.actualizarListas(this.mapa.getPersonajes().iterator());

	}

	private void abrirCofre(ICofre cofre)
	{
		Personaje personaje = this.vista.getPersonajeSeleccionado();
		if (personaje != null)
		{
			cofre.hechizar(personaje);
			this.vista.agregaLog(personaje.getNombre() + " abrio un cofre\n");
		} else
			JOptionPane.showMessageDialog(null, "Debe seleccionar un Personaje para que abrar el cofre");
	}

	private void eliminarPersonaje()
	{
		Personaje personaje = this.vista.getPersonajeSeleccionado();
		if (personaje != null)
		{
			this.mapa.eliminarPersonaje(personaje);

			this.vista.agregaLog("Se elimino a: " + personaje.getNombre() + "\n");
		}

		else
			JOptionPane.showMessageDialog(null, "Debe seleccionar un Personaje para eliminar");
	}

	private void atacarPersonaje()
	{
		Personaje personaje = this.vista.getPersonajeSeleccionado();
		Personaje victima = this.vista.getPersonajeSeleccionadoLista2();

		String cartel;

		if (personaje != null && victima != null)
		{
			cartel = personaje.ataca(victima);
			this.vista.agregaLog(cartel + "\n");
		} else
			JOptionPane.showMessageDialog(null, "Debe seleccionar un Personaje de cada lista");

	}

	private void moverPersonaje()
	{
		Personaje personaje = this.vista.getPersonajeSeleccionado();
		if (personaje != null)
		{
			double x = this.vista.getCoordenadaMovimientoX();
			double y = this.vista.getCoordenadaMovimientoY();
			personaje.mueve(x, y);
			this.vista.agregaLog("Se movio a: " + personaje.getNombre() + "X: " + x + " Y: " + y + "\n");
		} else
			JOptionPane.showMessageDialog(null, "Debe seleccionar un Personaje para mover");

	}

	private void nuevoPersonaje()
	{
		String nombre = this.vista.getNombre();
		double x = this.vista.getCoordenadaX();
		double y = this.vista.getCoordenadaY();
		String tipo = this.vista.getTipo();
		Personaje p = PersonajeFactory.getPersonaje(tipo, nombre, new Posicion(x, y));
		this.mapa.agregarPersonaje(p);
		this.vista.agregaLog("Se agrego a: " + p.getNombre() + "\n");
	}

	private void inicializa() 
	{
		this.mapa.agregarPersonaje(PersonajeFactory.getPersonaje("Guerrero", "Arya", new Posicion(34, 32)));
		this.mapa.agregarPersonaje(PersonajeFactory.getPersonaje("Arquero", "Legolas", new Posicion(14, 3)));
		this.mapa.agregarPersonaje(PersonajeFactory.getPersonaje("Caballero", "Aragorn", new Posicion(-4, 0)));
		
	}
}
