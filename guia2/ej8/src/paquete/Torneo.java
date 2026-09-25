package paquete;

import java.util.HashMap;
import java.util.ArrayList;

public class Torneo {
    private static Torneo instancia = null;
    private HashMap<String, Equipo> equipos;
    private ArrayList<Partido> partidos;

    private Torneo() {
        equipos = new HashMap<>();
        partidos = new ArrayList<>();
    }

    public static Torneo getInstance() {
        if (instancia == null) {
            instancia = new Torneo();
        }
        return instancia;
    }

    public boolean agregarEquipos(Equipo equipo) {
        if (!equipos.containsKey(equipo.getNombre())) {
            equipos.put(equipo.getNombre(), equipo);
            return true;
        }
        return false;
    }

    public void eliminarEquipo(String nombre) {
        equipos.remove(nombre);
    }

    public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }

    public void eliminarPartido(Partido partido) {
        partidos.remove(partido);
    }

    public String maximoGoleador() {
        int max = -1;
        String maxj = "";
        for (Equipo e : equipos.values()) {
            for (Jugador j : e.getJugadores().values()) {
                if (j.getGc() > max) {
                    max = j.getGc();
                    maxj = j.getNombre();
                }
            }
        }
        return maxj;
    }

    public String masGoles(String j1, String j2) {
        Jugador jug1 = buscarJugador(j1);
        Jugador jug2 = buscarJugador(j2);
        
        if (jug1 != null && jug2 != null) {
            if (jug1.getGc() >= jug2.getGc()) {
                return jug1.getNombre();
            } else {
                return jug2.getNombre();
            }
        }
        return "Jugador no encontrado";
    }

    // Lógica de desempate corregida según enunciado (Puntos -> GF -> GC)
    public String mayorPuntaje(String n1, String n2) {
        Equipo eq1 = buscarEquipo(n1);
        Equipo eq2 = buscarEquipo(n2);

        if (eq1 == null || eq2 == null) return "Equipo no encontrado";

        // 1. Comparar Puntos
        if (eq1.puntos() > eq2.puntos()) return eq1.getNombre();
        if (eq2.puntos() > eq1.puntos()) return eq2.getNombre();

        // 2. Desempate por Goles a Favor (GF)
        if (eq1.getGf() > eq2.getGf()) return eq1.getNombre();
        if (eq2.getGf() > eq1.getGf()) return eq2.getNombre();

        // 3. Desempate por Goles en Contra (GC - Menos es mejor)
        if (eq1.getGc() < eq2.getGc()) return eq1.getNombre();
        if (eq2.getGc() < eq1.getGc()) return eq2.getNombre();

        // Si hay coincidencia total, devuelve cualquiera
        return eq1.getNombre();
    }

    public int puntosEquipo(String nombre) {
        Equipo e = buscarEquipo(nombre);
        return (e != null) ? e.puntos() : 0;
    }

    private Equipo buscarEquipo(String nombre) {
        return equipos.get(nombre);
    }

    public double promedioGolesJugador(String nombre) {
        Jugador j = buscarJugador(nombre);
        return (j != null) ? j.promedioGoles() : 0.0;
    }

    private Jugador buscarJugador(String nombre) {
        for (Equipo eq : equipos.values()) {
            if (eq.getJugadores().containsKey(nombre)) {
                return eq.getJugadores().get(nombre);
            }
        }
        return null;
    }
}