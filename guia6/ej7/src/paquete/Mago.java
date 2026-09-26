package paquete;

import excepciones.AtaqueImposibleException;

import excepciones.IncrementoImposibleException;

import interfaces.Movible;

public class Mago extends Personaje {
    
    public Mago(String nombre, Movible pos) {
        super(nombre, pos);
    }

    @Override
    public void abrirCofre(Cofre c) {
        // TODO Implement this method
    }

    @Override
    public void ataca(Personaje p) throws AtaqueImposibleException {
            if (this.distancia(p) <= 10) {
                    p.recibeDanio(10);
            }else
                throw new AtaqueImposibleException(this,p);
    }


    @Override
    public void incrementaPos(double x, double y){
        try {
            this.posicion.incrementaPos(x, y);
        } catch (IncrementoImposibleException e) {
        }
    }
}
