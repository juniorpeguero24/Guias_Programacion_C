package modelo;

public class Acoplado {
	public double tara, cargaMaxima;
	public int numeroAcoplado;
	public boolean refrigerado,enUso=false;

    /**
	 * pre: los enteros mayores a cero
	 *
	 * post: acoplado creado
	 *
     * @param tara peso
     * @param cargaMaxima carga maxima
     * @param numeroAcoplado numero identificatorio del acoplado
     * @param refrigerado si es refrigerator o no
     */
	public Acoplado(double tara, double cargaMaxima, int numeroAcoplado, boolean refrigerado) {
		this.tara = tara;
		this.cargaMaxima = cargaMaxima;
		this.numeroAcoplado = numeroAcoplado;
		this.refrigerado = refrigerado;
	}

	public void setEnUso(boolean enUso) {
		this.enUso = enUso;
	}

	public double getTara() {
		return tara;
	}

	public double getCargaMaxima() {
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
