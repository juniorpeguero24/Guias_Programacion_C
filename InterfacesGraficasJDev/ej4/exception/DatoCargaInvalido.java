package exception;

public class DatoCargaInvalido {
    private int cantidad;
    private int disponible;
    private String combustible;

    public DatoCargaInvalido(int cantidad, int disponible, String combustible) {
        this.cantidad = cantidad;
        this.disponible = disponible;
        this.combustible = combustible;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getDisponible() {
        return disponible;
    }

    public String getCombustible() {
        return combustible;
    }
}
