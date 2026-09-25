package paquete;

public class Delantero extends Jugador {

    public Delantero(String nombre, double velocidad, double potencia) {
        super(nombre, velocidad, potencia);
    }

    @Override
    public double getIndiceDefensa() {
        return velocidad * 0.5;
    }

    @Override
    public double getIndiceAtaque() {
        return velocidad * potencia;
    }

    @Override
    public String toString() {
        return "Delantero: " + super.toString();
    }
}