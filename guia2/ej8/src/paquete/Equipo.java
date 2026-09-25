package paquete;

import java.util.HashMap;

public class Equipo {
	private String nombre;
	private HashMap<String,Jugador> jugadores;
	private int pg,pe,pp,gf,gc;
	
	public Equipo(String nombre,int pg,int pe,int pp,int gf,int gc) {
		jugadores = new HashMap<>();
		this.nombre=nombre;
		this.pg=pg;
		this.pe=pe;
		this.pp=pp;
		this.gf=gf;
		this.gc=gc;
	}
	
	public boolean agregarJugador(Jugador jugador) {
		if (!jugadores.containsKey(jugador.getNombre())){
			jugadores.put(jugador.getNombre(), jugador);
			return true;
		}
		return false;
	}
	
	public void eliminarJugador(String nombre) {
		jugadores.remove(nombre);
	}
	
	public int puntos() {
		return (3*pg+1*pe);
	}
	
	public int partidosJugados() {
		return (pg+pe+pp);
	}

	public String getNombre() {
		return nombre;
	}

	public HashMap<String, Jugador> getJugadores() {
		return jugadores;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPg() {
		return pg;
	}

	public void setPg(int pg) {
		this.pg = pg;
	}

	public int getPe() {
		return pe;
	}

	public void setPe(int pe) {
		this.pe = pe;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	public int getGf() {
		return gf;
	}

	public void setGf(int gf) {
		this.gf = gf;
	}

	public int getGc() {
		return gc;
	}

	public void setGc(int gc) {
		this.gc = gc;
	}
	
	
}
