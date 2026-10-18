package modelo;

import exception.FaltaCombustibleException;

import java.util.ArrayList;
import java.util.HashMap;

public class Surtidor {
    public static int nsig = 0;
    private int id;
    private HashMap<String,Deposito> depositos;

    public Surtidor() {
        this.depositos = new HashMap<>();
        this.id = ++nsig;
    }

    public void agregarDeposito(Deposito deposito) {
        this.depositos.put(deposito.getCombustible().getNombre(), deposito);
    }

    public void cargarCombustible(String combustible,int cantidad) throws Exception {
        Deposito d = this.depositos.get(combustible);
        if (d != null) {
            d.cargar(cantidad);
            this.depositos.replace(combustible, d);
        }
    }

    public void reponerCombustible(String combustible) {
        Deposito d = this.depositos.get(combustible);
        if (d != null) {
            d.reponer();
            this.depositos.replace(combustible, d);
        }
    }

    public int getCantidadDisponible(String combustible) {
        Deposito d=this.depositos.get(combustible);
        if (d != null) {
            return d.getCantCombustible();
        }
        return 0;
    }

    public HashMap<String,Deposito> getDepositos() {
        return depositos;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Surtidor "+id +
                "\n"+depositos;
    }
}
