package modelo;

public class Acoplado {
	public int tara, cargaMaxima,numeroAcoplado;
	public boolean refrigerado,enUso=false;
	
	public Acoplado(int tara, int cargaMaxima, int numeroAcoplado, boolean refrigerado) {
		this.tara = tara;
		this.cargaMaxima = cargaMaxima;
		this.numeroAcoplado = numeroAcoplado;
		this.refrigerado = refrigerado;
	}

	public void setEnUso(boolean enUso) {
		this.enUso = enUso;
	}

	public int getTara() {
		return tara;
	}

	public int getCargaMaxima() {
		return cargaMaxima;
	}

	public int getNumeroAcoplado() {
		return numeroAcoplado;
	}

	public boolean isRefrigerado() {
		return refrigerado;
	}

	public boolean isEnUso() {
		return enUso;
	}

	@Override
	public String toString() {
	    return "Acoplado #" + numeroAcoplado + " | Capacidad: " + cargaMaxima + "tn (Tara: " + tara + "tn) | Refrigerado: " 
	           + (refrigerado ? "Sí" : "No") + " | Estado: " + (enUso ? "En uso" : "Disponible");
	}
	
	
}
