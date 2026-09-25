package paquete;

public class Arquero extends Jugador {
    private double efectividad;

    public Arquero(String nombre, double velocidad, double potencia) {
        this(nombre, velocidad, potencia, 0.5); // Encadenado con efectividad por defecto
    }

    public Arquero(String nombre, double velocidad, double potencia, double efectividad) {
        super(nombre, velocidad, potencia);
        this.efectividad = efectividad;
    }

    @Override
    public double getIndiceDefensa() {
        return efectividad;
    }

    @Override
    public double getIndiceAtaque() {
        return 0.1 * velocidad * potencia;
    }

    @Override
    public String toString() {
        return "Arquero: " + super.toString() + " (Efectividad: " + efectividad + ")";
    }
}