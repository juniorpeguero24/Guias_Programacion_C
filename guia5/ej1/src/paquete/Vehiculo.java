package paquete;

public abstract class Vehiculo {
	public String patente;
	public String numeroChasis;
	public String numeroMotor;
	public String modelo;
	
	public Vehiculo() {
	}

	public Vehiculo(String patente, String numeroChasis, String numeroMotor, String modelo) {
		super();
		this.patente = patente;
		this.numeroChasis = numeroChasis;
		this.numeroMotor = numeroMotor;
		this.modelo = modelo;
	}
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getNumeroChasis() {
		return numeroChasis;
	}
	public void setNumeroChasis(String numeroChasis) {
		this.numeroChasis = numeroChasis;
	}
	public String getNumeroMotor() {
		return numeroMotor;
	}
	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
}
