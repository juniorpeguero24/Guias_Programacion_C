package paquete;

public class Defensor extends Jugador {

    public Defensor(String nombre, double velocidad, double potencia) {
        super(nombre, velocidad, potencia);
    }

    @Override
    public double getIndiceDefensa() {
        return velocidad * velocidad;
    }

    @Override
    public double getIndiceAtaque() {
        return potencia * potencia;
    }

    @Override
    public String toString() {
        return "Defensor: " + super.toString();
    }
}