package paquete;

import java.util.ArrayList;

public class Torneo {
    private static Torneo _instancia = null;
    private ArrayList<Partido> partidos;

    private Torneo() {
        partidos = new ArrayList<>();
    }

    public static Torneo getInstancia() {
        if (_instancia == null) _instancia = new Torneo();
        return _instancia;
    }

    public boolean registrarPartido(Partido p, int r1, int r2) {
        if (!p.esValidoParaJugar()) {
            System.out.println("Error: Ambos equipos deben tener al menos 4 jugadores.");
            return false;
        }
        p.setResultado(r1, r2);
        partidos.add(p);
        actualizarJugadores(p);
        return true;
    }

    private void actualizarJugadores(Partido p) {
        if (p.getR1() > p.getR2()) { // Gana Equipo 1
            for (Jugador j : p.getEq1().getJugadores().values()) {
                j.setPg(j.getPg() + 1);
                j.setPuntaje(j.getPuntaje() + 3);
            }
            for (Jugador j : p.getEq2().getJugadores().values()) {
                j.setPp(j.getPp() + 1);
            }
        } else if (p.getR1() < p.getR2()) { // Gana Equipo 2
            for (Jugador j : p.getEq2().getJugadores().values()) {
                j.setPg(j.getPg() + 1);
                j.setPuntaje(j.getPuntaje() + 3);
            }
            for (Jugador j : p.getEq1().getJugadores().values()) {
                j.setPp(j.getPp() + 1);
            }
        } else { // Empate
            for (Jugador j : p.getEq1().getJugadores().values()) {
                j.setPe(j.getPe() + 1);
                j.setPuntaje(j.getPuntaje() + 1);
            }
            for (Jugador j : p.getEq2().getJugadores().values()) {
                j.setPe(j.getPe() + 1);
                j.setPuntaje(j.getPuntaje() + 1);
            }
        }
    }

    // Consulta de Juntos vs Enfrentados
    public void consultarHistorialEntre(String nomJ1, String nomJ2) {
        int juntos = 0;
        int enfrentados = 0;

        for (Partido p : partidos) {
            boolean j1EnEq1 = p.getEq1().contieneJugador(nomJ1);
            boolean j1EnEq2 = p.getEq2().contieneJugador(nomJ1);
            boolean j2EnEq1 = p.getEq1().contieneJugador(nomJ2);
            boolean j2EnEq2 = p.getEq2().contieneJugador(nomJ2);

            if ((j1EnEq1 && j2EnEq1) || (j1EnEq2 && j2EnEq2)) {
                juntos++;
            } else if ((j1EnEq1 && j2EnEq2) || (j1EnEq2 && j2EnEq1)) {
                enfrentados++;
            }
        }

        System.out.println("Encuentros entre " + nomJ1 + " y " + nomJ2 + ":");
        System.out.println(" - En el mismo equipo: " + juntos + " veces.");
        System.out.println(" - Enfrentados: " + enfrentados + " veces.");
    }

    public void historico() {
        System.out.println("\n===== HISTÓRICO DE ENCUENTROS =====");
        for (Partido p : partidos) {
            System.out.println("Fecha: " + p.getFechaFormateada());
            System.out.println("Resultado: Equipo 1 (" + p.getR1() + ") vs Equipo 2 (" + p.getR2() + ")");
            System.out.print("Equipo 1: ");
            for (Jugador j : p.getEq1().getJugadores().values()) System.out.print(j.getNombre() + " ");
            System.out.print("\nEquipo 2: ");
            for (Jugador j : p.getEq2().getJugadores().values()) System.out.print(j.getNombre() + " ");
            System.out.println("\n-------------------------------------------");
        }
    }
}