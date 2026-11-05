package ej1_B;

public class Motor{
    private String n_serie;
    private String combustible;

    public Motor(String n_serie, String combustible) {
        this.n_serie = n_serie;
        this.combustible = combustible;
    }

    public String getN_serie() {
        return n_serie;
    }

    public String getCombustible() {
        return combustible;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "n_serie='" + n_serie + '\'' +
                ", combustible='" + combustible + '\'' +
                '}';
    }
}
