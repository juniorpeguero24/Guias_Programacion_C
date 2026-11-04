package paquete;

import java.io.Serializable;

public class Motor implements Serializable {
    private String n_serie;
    private String combustible;

    public Motor(String n_serie, String combustible) {
        this.n_serie = n_serie;
        this.combustible = combustible;
    }

    public Motor() {
    }

    public String getN_serie() {
        return n_serie;
    }

    public void setN_serie(String n_serie) {
        this.n_serie = n_serie;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "n_serie='" + n_serie + '\'' +
                ", combustible='" + combustible + '\'' +
                '}';
    }
}
