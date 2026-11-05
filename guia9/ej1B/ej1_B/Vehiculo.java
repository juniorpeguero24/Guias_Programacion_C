package ej1_B;


public class Vehiculo{
    private String N_Chasis;
    private int anio_fabricacion;

    public Vehiculo(String n_Chasis, int anio_fabricacion) {
        N_Chasis = n_Chasis;
        this.anio_fabricacion = anio_fabricacion;
    }

    public String getN_Chasis() {
        return N_Chasis;
    }

    public int getAnio_fabricacion() {
        return anio_fabricacion;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "N_Chasis='" + N_Chasis + '\'' +
                ", anio_fabricacion=" + anio_fabricacion +
                '}';
    }
}
