package modelo;

import exception.FaltaCombustibleException;

public class Deposito {
    private Combustible combustible;
    private int capacidadMaxima;
    private int cantCombustible;
    private double monto;
    private double montoHistorico;
    private int cantCombustibleHistorico;

    public Deposito(int capacidadMaxima, Combustible combustible) {
        this.capacidadMaxima = capacidadMaxima;
        this.combustible = combustible;
        this.cantCombustible = capacidadMaxima;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public int getCantCombustible() {
        return cantCombustible;
    }

    public double getMonto() {
        return monto;
    }

    public double getMontoHistorico() {
        return montoHistorico;
    }

    public int getCantCombustibleHistorico() {
        return cantCombustibleHistorico;
    }

    public void reponer() {
        this.cantCombustible = this.capacidadMaxima;
    }

    public void cargar(int cantidad) throws FaltaCombustibleException,Exception {
        if (cantidad<0) {
            throw new Exception("La cantidad de combustible debe ser positiva");
        }
        if (cantidad > this.cantCombustible) {
            int disponible = this.cantCombustible;
            this.cantCombustible = 0;
            throw new FaltaCombustibleException(cantidad, disponible, this.combustible.getNombre());
        } else {
            this.cantCombustible -= cantidad;
        }
    }

    @Override
    public String toString() {
        return combustible +" Cantidad de Combustible Disponible: " + cantCombustible;
    }
}
