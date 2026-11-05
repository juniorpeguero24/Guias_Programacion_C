package ej1_B;

import java.util.ArrayList;

// Inciso b: NO es Serializable, no tiene setters ni constructor vacio.
public class Flota {
    private String nombre;
    private ArrayList<Automovil> automoviles;

    public Flota(String nombre, ArrayList<Automovil> automoviles) {
        this.nombre = nombre;
        this.automoviles = automoviles;
    }

    public void agregar(Automovil a) {
        automoviles.add(a);
    }

    public String getNombre() { return nombre; }

    public ArrayList<Automovil> getAutomoviles() { return automoviles; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Flota: " + nombre + "\n");
        for (Automovil a : automoviles) {
            sb.append("  ").append(a).append("\n");
        }
        return sb.toString();
    }
}
