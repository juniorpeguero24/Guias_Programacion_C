package ej1_B;

import java.io.Serializable;
import java.util.ArrayList;

public class FlotaDTO implements Serializable {
    private String nombre;
    private ArrayList<AutomovilDTO> automoviles = new ArrayList<>();

    public FlotaDTO() {
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public ArrayList<AutomovilDTO> getAutomoviles() { return automoviles; }
    public void setAutomoviles(ArrayList<AutomovilDTO> automoviles) { this.automoviles = automoviles; }
}
