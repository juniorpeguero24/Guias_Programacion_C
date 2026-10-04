package paquete;

import java.util.ArrayList;

public class Empresa {
	public ArrayList<Colectivo> colectivos;
	public ArrayList<Chofer> choferes;
	
	public Empresa(){
		this.colectivos=new ArrayList<>();
		this.choferes=new ArrayList<>();
	}
	
	public void agregarColectivo(Colectivo c) {
		colectivos.add(c);
	}
	
	public void agregarChofer(Chofer ch) {
		choferes.add(ch);
	}
	
	public int cantidadChoferesSinColectivo() {
		int cont=0;
		for (Chofer ch:choferes) {
			if(ch.getColectivo()==null) {
				cont++;
			}
		}
		return cont;
	}
	
	public int totalColectivos() {
		return colectivos.size();
	}
	
	public void mostrarChoferesPorCategorias(String categoria) {
		System.out.println("Choferes que pertenen a "+categoria);
		for (Chofer ch:choferes) {
			if (ch.getCategoria().getNombrecategoria().equalsIgnoreCase(categoria)) {
				System.out.println(ch.getNombre());
			}
		}
	}
	
	public void mostrarCategoriaSueldoSuperior(double monto,ArrayList<Categoria> categorias) {
		System.out.println("Categorias con sueldo superior a $"+monto);
		for(Categoria cat:categorias) {
			if (cat.getSueldo()>monto) {
				System.out.println(cat.getNombrecategoria()+" $"+cat.getSueldo());
			}
		}
	}
	
	public void mostrarChoferesSueldoSuperior(double monto) {
		System.out.println("Choferes con sueldo superior a $"+monto);
		for(Chofer ch:choferes) {
			if(ch.getCategoria().getSueldo()>monto) {
				System.out.println(ch.getNombre()+" $"+ch.getCategoria().getSueldo());
			}
		}
	}
	
	public void mostrarTodosLosChoferes() {
		System.out.println("Choferes");
		for (Chofer ch:choferes) {
			System.out.println(ch);
		}
	}
}
