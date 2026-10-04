package paquete;

public class FabricaJugadores {

    public static Jugador crearJugador(String tipo, String nombre, double velocidad, double potencia) {
        switch (tipo.toLowerCase()) {
            case "delantero":
                return new Delantero(nombre, velocidad, potencia);
            case "defensor":
                return new Defensor(nombre, velocidad, potencia);
            case "arquero":
                return new Arquero(nombre, velocidad, potencia);
            default:
                throw new IllegalArgumentException("Tipo de jugador invalido.");
        }
    }

}
