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

    private String validarRango(String tipo, double velocidad, double potencia) {
        if (velocidad < 0.0 || velocidad > 1.0) {
            return "Imposible crear un " + tipo + " con velocidad = " + velocidad;
        }
        if (potencia < 0.0 || potencia > 1.0) {
            return "Imposible crear un " + tipo + " con potencia = " + potencia;
        }
        return null;
    }

    public String agregaDelantero(String nombre, double velocidad, double potencia) {
        String error = validarRango("delantero", velocidad, potencia);
        if (error != null) {
            return error;
        }
        jugadores.add(new Delantero(nombre, velocidad, potencia));
        return "Jugador agregado";
    }

    public String agregaDefensor(String nombre, double velocidad, double potencia) {
        String error = validarRango("defensor", velocidad, potencia);
        if (error != null) {
            return error;
        }
        jugadores.add(new Defensor(nombre, velocidad, potencia));
        return "Jugador agregado";
    }

    public String agregaArquero(String nombre, double velocidad, double potencia) {
        String error = validarRango("arquero", velocidad, potencia);
        if (error != null) {
            return error;
        }
        jugadores.add(new Arquero(nombre, velocidad, potencia));
        return "Jugador agregado";
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