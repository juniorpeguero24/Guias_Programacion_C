package paquete;

import java.util.ArrayList;
import java.util.Iterator;

public class Equipo {
    private String nombre;
    private ArrayList<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(Jugador jugador) {
        if (jugador != null) {
            this.jugadores.add(jugador);
        }
    }

    public void eliminaJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    public Iterator<Jugador> getJugadores() {
        return jugadores.iterator();
    }

    public String getNombre() {
        return nombre;
    }

    public double indiceDefensa() {
        double total = 0.0;
        for (Jugador j : jugadores) {
            total += j.getIndiceDefensa();
        }
        return total;
    }

    public double indiceAtaque() {
        double total = 0.0;
        for (Jugador j : jugadores) {
            total += j.getIndiceAtaque();
        }
        return total;
    }
}