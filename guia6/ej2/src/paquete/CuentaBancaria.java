package paquete;

import excepciones.DatoInvalido;
import excepciones.DepositoInvalidoException;
import excepciones.ExtraccionInvalidadException;
import excepciones.TitularInvalidoException;

public class CuentaBancaria {
    private double saldo;
    private String titular;
    
    public CuentaBancaria(String titular) throws TitularInvalidoException {
        if (titular == null || titular.isEmpty())
            throw new TitularInvalidoException("Titular distinto de nulo o vacio.");
        this.titular=titular;
        this.saldo=0;
    }

    public void depositar(double cantidad) throws DepositoInvalidoException {
        if (cantidad <= 0)
            throw new DepositoInvalidoException("Cantidad a depositar invalida.",cantidad);
        this.saldo += cantidad;
    }

    public void extraer(double cantidad) throws ExtraccionInvalidadException {
        if (cantidad > this.saldo){
            DatoInvalido dato = new DatoInvalido(cantidad,this.saldo);
            throw new ExtraccionInvalidadException("Extraccion Invalida.",dato);
        }
        if (cantidad > 0)
            this.saldo-=cantidad;
    }

    public double getSaldo() {
        return saldo;
    }


    @Override
    public String toString() {
        return "Titular: "+titular+" Saldo: $"+saldo;
    }

    public String getTitular() {
        return titular;
    }
}
