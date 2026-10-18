package modelo;

public class Combustible {
    private String nombre;
    private double precio;

    public Combustible(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
