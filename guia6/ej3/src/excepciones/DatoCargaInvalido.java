package excepciones;

public class DatoCargaInvalido {
    private double cantidaDisponible,cantidadRequerida;
    private String combustible;

    public DatoCargaInvalido(double cantidaDisponible, double cantidadRequerida, String combustible) {
        this.cantidaDisponible = cantidaDisponible;
        this.cantidadRequerida = cantidadRequerida;
        this.combustible = combustible;
    }

    public double getCantidaDisponible() {
        return cantidaDisponible;
    }

    public double getCantidadRequerida() {
        return cantidadRequerida;
    }

    public String getCombustible() {
        return combustible;
    }
}
