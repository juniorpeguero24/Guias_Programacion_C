package paquete;

public class Colectivo {
	private static int siguienteNro=0;
	private String modelo;
	private int numerointerno;
	
	public Colectivo(String modelo) {
		this.modelo=modelo;
		this.numerointerno=++siguienteNro;
	}
	
	public static int getSiguienteNro() {
		return siguienteNro;
	}
	public String getModelo() {
		return modelo;
	}
	public int getNumerointerno() {
		return numerointerno;
	}
	
	public String toString(){
		return "Interno: "+numerointerno+", Modelo: "+modelo;
	}
	
}
