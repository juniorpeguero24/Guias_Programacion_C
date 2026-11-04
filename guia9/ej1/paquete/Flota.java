package paquete;

import java.io.Serializable;
import java.util.ArrayList;

public class Flota implements Serializable {
    private String nombre;
    private ArrayList<Automovil> automoviles;

    public Flota() {                                   // requerido por XMLDecoder
        this.automoviles = new ArrayList<>();
    }

    public Flota(String nombre) {
        this();
        this.nombre = nombre;
    }

    public void agregar(Automovil a) {
        automoviles.add(a);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public ArrayList<Automovil> getAutomoviles() { return automoviles; }
    public void setAutomoviles(ArrayList<Automovil> automoviles) { this.automoviles = automoviles; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Flota: " + nombre + "\n");
        for (Automovil a : automoviles) {
            sb.append("  ").append(a).append("\n");
        }
        return sb.toString();
    }
}