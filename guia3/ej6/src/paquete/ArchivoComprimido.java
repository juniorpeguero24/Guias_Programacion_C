package paquete;

import java.util.GregorianCalendar;

public class ArchivoComprimido extends Directorio{
	private double tasaCompresion;
	
	public ArchivoComprimido(String nombre,GregorianCalendar fecha,double tasaCompresion) {
		super(nombre,fecha);
		this.tasaCompresion=tasaCompresion;
	}

	public double getTasaCompresion() {
		return tasaCompresion;
	}

	public void setTasaCompresion(double tasaCompresion) {
		this.tasaCompresion = tasaCompresion;
	}
	
	public double getTamaño() {
		return super.getTamaño()*tasaCompresion;
	}
	
}
