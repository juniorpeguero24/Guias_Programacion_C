package paquete;

public class Empleado {
    private static int nroSig = 0;
    private int nroInterno;
    private String nombre;

    public Empleado(String nombre) {
        this.nombre = nombre;
        this.nroInterno = ++nroSig;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nroInterno=" + nroInterno +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
