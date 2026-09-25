package modelo;

public class Cancion {
	private int numeroPista;
	private String titulo;
	private int minutos,segundos;
	
	public Cancion(int numeroPista, String titulo, int minutos, int segundos) {
		super();
		this.numeroPista = numeroPista;
		this.titulo = titulo;
		this.minutos = minutos;
		this.segundos = segundos;
	}
	public int getNumeroPista() {
		return numeroPista;
	}
	public String getTitulo() {
		return titulo;
	}
	
	public int getMinutos() {
		return minutos;
	}
	public int getSegundos() {
		return segundos;
	}
	@Override
	public String toString() {
		return "Cancion [numeroPista=" + numeroPista + ", titulo=" + titulo + ", minutos=" + minutos + ", segundos="
				+ segundos + "]";
	}
	
	
}
