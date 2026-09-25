package paquete;

import java.util.ArrayList;

public class Partido {
    private Equipo e1, e2;
    private String fecha;
    private ArrayList<Jugador> goleadores; // Guarda cada jugador que convirtió un gol

    public Partido(Equipo e1, Equipo e2, String fecha) {
        if (e1.getNombre().equalsIgnoreCase(e2.getNombre())) {
            throw new IllegalArgumentException("Un partido no puede tener al mismo equipo como local y visitante.");
        }
        this.e1 = e1;
        this.e2 = e2;
        this.fecha = fecha;
        this.goleadores = new ArrayList<>();
    }

    public void registrarGol(Jugador jugador) {
        goleadores.add(jugador);
        jugador.setGc(jugador.getGc() + 1); // Suma un gol al acumulado del jugador
    }

    // Retorna el resultado final basado en la lista de autores
    public String getResultado() {
        int golesE1 = 0;
        int golesE2 = 0;

        for (Jugador j : goleadores) {
            if (e1.getJugadores().containsKey(j.getNombre())) golesE1++;
            if (e2.getJugadores().containsKey(j.getNombre())) golesE2++;
        }
        return e1.getNombre() + " " + golesE1 + " - " + golesE2 + " " + e2.getNombre();
    }

    // Detalle de goles anotados indicando qué jugador lo convirtió
    public void mostrarDetalleGoles() {
        System.out.println("--- Goles del partido (" + fecha + ") ---");
        if (goleadores.isEmpty()) {
            System.out.println("Partido sin goles.");
        } else {
            for (Jugador j : goleadores) {
                System.out.println("Gol de: " + j.getNombre() + " (" + j.getNroCamiseta() + ")");
            }
        }
    }

    public Equipo getE1() { return e1; }
    public Equipo getE2() { return e2; }
    public String getFecha() { return fecha; }
}