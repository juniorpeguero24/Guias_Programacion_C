package ej1_B;

import java.io.Serializable;

public class MotorDTO implements Serializable {
    private String n_serie;
    private String combustible;

    public MotorDTO() {
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
}
