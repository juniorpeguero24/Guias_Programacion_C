package paquete;

import excepciones.AtaqueImposibleException;

import interfaces.Movible;

public class Arquero extends Personaje{
	protected int cantFlechas = 20;
	
	public Arquero(String nombre, Movible posicion) {
		super(nombre, posicion);
                this.distanciaMaximaDeDesplazamiento=8;
	}

	@Override
	public void ataca(Personaje p) throws AtaqueImposibleException {
		double dist = this.distancia(p);
 		if (dist <= 100 && this.cantFlechas > 0) {
			p.recibeDanio(15);
			this.cantFlechas--;
		}else
                    if (dist <= 5) 
                        p.recibeDanio(5);
                    else 
                        throw new AtaqueImposibleException(this,p);
	}

	@Override
	public String toString() {
		return "Arquero" + super.toString() + "Flechas=" + cantFlechas ;
	}

	@Override
	public void abrirCofre(Cofre c) {
		c.afectar(this);
	}

	public int getCantFlechas() {
		return cantFlechas;
	}

	public void setCantFlechas(int cantFlechas) {
		this.cantFlechas = cantFlechas;
	}


	
	
}
