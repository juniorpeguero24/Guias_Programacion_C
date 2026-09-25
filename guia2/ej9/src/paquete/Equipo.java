package paquete;

import java.util.HashMap;

public class Equipo {
    private HashMap<String, Jugador> jugadores;

    public Equipo() {
        this.jugadores = new HashMap<>();
    }

    public void agregarJugador(Jugador j) {
        jugadores.put(j.getNombre(), j);
    }

    public void quitarJugador(Jugador j) {
        jugadores.remove(j.getNombre());
    }

    public boolean contieneJugador(String nombre) {
        return jugadores.containsKey(nombre);
    }

    // Puntaje acumulado total del equipo según sus integrantes
    public int getPuntajeTotal() {
        int suma = 0;
        for (Jugador j : jugadores.values()) {
            suma += j.getPuntaje();
        }
        return suma;
    }

    public int cantidadJugadores() {
        return jugadores.size();
    }

    public HashMap<String, Jugador> getJugadores() {
        return jugadores;
    }
}