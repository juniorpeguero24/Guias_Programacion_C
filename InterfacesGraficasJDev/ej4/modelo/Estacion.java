package modelo;

import java.util.HashMap;

public class Estacion {
    private HashMap<Integer,Surtidor> surtidores;

    public Estacion() {
        this.surtidores = new HashMap<>();
    }

    public void agregarSurtidor(Surtidor s) {
        this.surtidores.put(s.getId(),s);
    }

    public HashMap<Integer,Surtidor> getSurtidores() {
        return surtidores;
    }

    public void reponerSurtidor(Surtidor s, Deposito c) {
        if (c != null) {
            c.reponer();
            s.getDepositos().replace(c.getCombustible().getNombre(), c);
            this.surtidores.replace(s.getId(), s);
        }
    }

    public void cargarCombustible(Deposito d, int cantidad, Surtidor s) throws Exception {
         if (d != null) {
                d.cargar(cantidad);
                s.getDepositos().replace(d.getCombustible().getNombre(), d);
                this.surtidores.replace(s.getId(), s);
        }
    }

}
