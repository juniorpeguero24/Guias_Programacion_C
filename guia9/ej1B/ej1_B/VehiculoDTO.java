package ej1_B;

import java.io.Serializable;

// DTO de Vehiculo: serializable, constructor vacio, getters y setters.
public class VehiculoDTO implements Serializable {
    private String n_Chasis;
    private int anio_fabricacion;

    public VehiculoDTO() {
    }

    public String getN_Chasis() { return n_Chasis; }
    public void setN_Chasis(String n_Chasis) { this.n_Chasis = n_Chasis; }

    public int getAnio_fabricacion() { return anio_fabricacion; }
    public void setAnio_fabricacion(int anio_fabricacion) { this.anio_fabricacion = anio_fabricacion; }
}
