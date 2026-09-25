package paquete;

import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Torneo torneo = Torneo.getInstancia();

        // Crear plantilla de amigos
        Jugador j1 = new Jugador("Lucas");
        Jugador j2 = new Jugador("Mateo");
        Jugador j3 = new Jugador("Nico");
        Jugador j4 = new Jugador("Franco");
        Jugador j5 = new Jugador("Bruno");
        Jugador j6 = new Jugador("Gonzalo");
        Jugador j7 = new Jugador("Joaquin");
        Jugador j8 = new Jugador("Tomas");

        // PARTIDO 1 (20 de Marzo de 2026)
        GregorianCalendar f1 = new GregorianCalendar(2026, 2, 20);
        Partido p1 = new Partido(f1);

        // Armado de equipos (Mínimo 4 por equipo)
        p1.agregarJugador(j1, 1); p1.agregarJugador(j2, 1);
        p1.agregarJugador(j3, 1); p1.agregarJugador(j4, 1); // Eq 1

        p1.agregarJugador(j5, 2); p1.agregarJugador(j6, 2);
        p1.agregarJugador(j7, 2); p1.agregarJugador(j8, 2); // Eq 2

        System.out.println("Puntaje acumulado Eq 1: " + p1.getEq1().getPuntajeTotal());
        System.out.println("Puntaje acumulado Eq 2: " + p1.getEq2().getPuntajeTotal());

        // Juegan y gana Eq 1 (5 - 3)
        torneo.registrarPartido(p1, 5, 3);

        // PARTIDO 2 (27 de Marzo de 2026)
        GregorianCalendar f2 = new GregorianCalendar(2026, 2, 27);
        Partido p2 = new Partido(f2);

        // Mezclamos jugadores: Lucas y Bruno juegan juntos ahora
        p2.agregarJugador(j1, 1); p2.agregarJugador(j5, 1);
        p2.agregarJugador(j3, 1); p2.agregarJugador(j7, 1);

        p2.agregarJugador(j2, 2); p2.agregarJugador(j4, 2);
        p2.agregarJugador(j6, 2); p2.agregarJugador(j8, 2);

        // Empate 2 - 2
        torneo.registrarPartido(p2, 2, 2);

        // Consultas
        torneo.historico();
        torneo.consultarHistorialEntre("Lucas", "Mateo");
        torneo.consultarHistorialEntre("Lucas", "Bruno");

        System.out.println("\nEstadísticas de Lucas: " + j1);
        System.out.println("Estadísticas de Mateo: " + j2);
    }
}