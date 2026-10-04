package paquete;

public class Principal {
    public static void main(String[] args) {
        Equipo equipo = new Equipo("Los Halcones");

        try {
            // La fábrica crea y valida; el equipo solo guarda
            Jugador j1 = FabricaJugadores.crearJugador("delantero", "Messi", 0.9, 0.95);
            Jugador j2 = FabricaJugadores.crearJugador("defensor", "Cuti Romero", 0.8, 0.85);

            equipo.agregarJugador(j1);
            equipo.agregarJugador(j2);
            System.out.println("Jugadores agregados con éxito.");

            // Prueba con valor fuera de rango
            Jugador jInvalido = FabricaJugadores.crearJugador("delantero", "Invalido", 1.5, 0.5);
            equipo.agregarJugador(jInvalido);

        } catch (IllegalArgumentException e) {
            System.out.println("Error al registrar jugador: " + e.getMessage());
        }

        System.out.println("Ataque total: " + equipo.indiceAtaque());
        System.out.println("Defensa total: " + equipo.indiceDefensa());
    }
}