package paquete;

public class Lugar {
	
	private String ciudad;
	private double latitud;
	private double longitud;
	private String pais;
	
	
	public Lugar(String ciudad, double latitud, double longitud, String pais) {
		super();
		this.ciudad = ciudad;
		this.latitud = latitud;
		this.longitud = longitud;
		this.pais = pais;
	}


	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public double getLatitud() {
		return latitud;
	}


	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}


	public double getLongitud() {
		return longitud;
	}


	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public Lugar() {
		// TODO Auto-generated constructor stub
	}

}
