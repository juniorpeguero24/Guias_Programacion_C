package modelo;

import interfaces.IHostil;

public class TorretaVigilancia extends Edificio implements IHostil{

	public TorretaVigilancia(String equipo) {
		super(equipo, 200, 2000, 40);
	}
	
	@Override
	public void atacar(Unidad adversario) {
		if (adversario != null && adversario != this && !this.equipo.equals(adversario.getEquipo()))
			adversario.recibeDanio(10);
	}

	@Override
	public String toString() {
		return "TorretaVigilancia "+super.toString();
	}
	
}
