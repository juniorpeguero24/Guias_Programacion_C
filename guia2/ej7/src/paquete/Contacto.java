package paquete;

import java.util.ArrayList;

public class Contacto {
	private String nombre,telefono;
	private ArrayList<String> celulares;
	
	public Contacto(String nombre,String telefono) {
		this.nombre=nombre;
		this.telefono=telefono;
		this.celulares=new ArrayList<>();
	}
	
	public void agregarCelular(String celular) {
		celulares.add(celular);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public ArrayList<String> getCelulares() {
		return celulares;
	}
	
	public String toString() {
		return ("Contacto: "+nombre+" Telefono: "+telefono+" Celulares: "+celulares.toString());
	}
	
}
