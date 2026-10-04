package paquete;

import java.util.ArrayList;

public class Estacion {
    private ArrayList<Surtidor> surtidores;

    public Estacion() {
        this.surtidores = new ArrayList<>();
    }

    public void agregarSurtidor(Surtidor s) {
        this.surtidores.add(s);
    }

    public ArrayList<Surtidor> getSurtidores() {
        return surtidores;
    }
}
