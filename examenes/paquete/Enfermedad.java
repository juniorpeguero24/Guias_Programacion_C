package modelo;

public class Enfermedad implements Cloneable{
    private int tipo;
    private String descripcion;
    private boolean contagiosa;

    public Enfermedad(int tipo, String descripcion, boolean contagiosa) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.contagiosa = contagiosa;
    }

    @Override
    public Enfermedad clone() throws CloneNotSupportedException {
            return super.clone();
    }
}
