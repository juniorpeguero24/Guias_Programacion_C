package paquete;

import excepciones.AtaqueImposibleException;

import interfaces.Movible;

public class Caballero extends Personaje{
	
	public Caballero(String nombre,Movible posicion) {
		super(nombre, posicion);
                this.distanciaMaximaDeDesplazamiento=10;
	}

	@Override
        public void ataca(Personaje p) throws AtaqueImposibleException {
		if (this.distancia(p) <= 10) {
			p.recibeDanio(10);
		}else
                    throw new AtaqueImposibleException(this,p);
	}

	@Override
	public String toString() {
		return "Caballero "+super.toString();
	}

	@Override
	public void abrirCofre(Cofre c) {
		c.afectar(this);
	}
	
	
}
