package paquete;

public abstract class Jugador {
    private String nombre;
    protected double velocidad;
    protected double potencia;

    public Jugador(String nombre, double velocidad, double potencia) {
        if (velocidad < 0.0 || velocidad > 1.0) {
            throw new IllegalArgumentException("Imposible crear un jugador con velocidad = " + velocidad);
        }
        if (potencia < 0.0 || potencia > 1.0) {
            throw new IllegalArgumentException("Imposible crear un jugador con potencia = " + potencia);
        }
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.potencia = potencia;
    }

    public String getNombre() {
        return nombre;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public double getPotencia() {
        return potencia;
    }

    public abstract double getIndiceDefensa();
    public abstract double getIndiceAtaque();

    @Override
    public String toString() {
        return nombre + " [Vel: " + velocidad + ", Pot: " + potencia + 
               ", Def: " + getIndiceDefensa() + ", Atq: " + getIndiceAtaque() + "]";
    }
}