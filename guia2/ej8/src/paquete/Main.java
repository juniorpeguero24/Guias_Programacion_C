package paquete;

public class Main {

    public static void main(String[] args) {
        Torneo torneo = Torneo.getInstance();

        Equipo e1 = new Equipo("Boca", 1, 1, 0, 3, 2);
        Equipo e2 = new Equipo("River", 1, 0, 1, 4, 3);
        Equipo e3 = new Equipo("Racing", 0, 1, 1, 2, 4);

        Jugador j1 = new Jugador("Cavani", "1987", 10, 9, 10, 8);
        Jugador j2 = new Jugador("Zenon", "2001", 22, 8, 12, 3);
        Jugador j3 = new Jugador("Borja", "1993", 9, 9, 10, 10);
        Jugador j4 = new Jugador("Echeverri", "2006", 19, 10, 8, 2);
        Jugador j5 = new Jugador("Martinez", "1992", 9, 9, 11, 7);

        e1.agregarJugador(j1); e1.agregarJugador(j2);
        e2.agregarJugador(j3); e2.agregarJugador(j4);
        e3.agregarJugador(j5);

        torneo.agregarEquipos(e1);
        torneo.agregarEquipos(e2);
        torneo.agregarEquipos(e3);

        // Crear partido y registrar autores de goles
        Partido p1 = new Partido(e1, e2, "2026-04-15");
        p1.registrarGol(j1); // Gol de Cavani
        p1.registrarGol(j2); // Gol de Zenón
        p1.registrarGol(j3); // Gol de Borja

        torneo.agregarPartido(p1);

        // Imprimir resultados
        System.out.println("Resultado: " + p1.getResultado());
        p1.mostrarDetalleGoles();
        System.out.println();

        System.out.println("Promedio de goles de Cavani: " + torneo.promedioGolesJugador("Cavani"));
        System.out.println("Promedio de goles de Borja: " + torneo.promedioGolesJugador("Borja"));
        System.out.println("Quien hizo mas goles entre Cavani y Borja: " + torneo.masGoles(j1.getNombre(), j3.getNombre()));
        System.out.println("Maximo goleador del torneo: " + torneo.maximoGoleador());
        System.out.println("Equipo con mayor puntaje entre Boca y River: " + torneo.mayorPuntaje(e1.getNombre(), e2.getNombre()));
    }
}