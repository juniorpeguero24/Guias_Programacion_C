package modelo;

import java.util.ArrayList;

public class Empresa {
	protected ArrayList<Chofer> choferes;
	protected ArrayList<Colectivo> colectivos;
	protected ArrayList<Camion> camiones;
	protected ArrayList<Categoria> categorias;
	protected ArrayList<Acoplado> acoplados;
	
	public Empresa() {
		choferes=new ArrayList<>();
		colectivos=new ArrayList<>();
		categorias=new ArrayList<>();
		acoplados=new ArrayList<>();
		camiones = new ArrayList<>();
		// Creamos las 4 categorias fijas del sistema
	    categorias.add(new Categoria("Categoría 1", 10000.0, true, false, false));
	    categorias.add(new Categoria("Categoría 2", 15000.0, true, true, false));
	    categorias.add(new Categoria("Categoría 3", 15000.0, false, false, true));
	    categorias.add(new Categoria("Categoría 4", 17000.0, true, true, true));
	}

	public ArrayList<Colectivo> getColectivos() {
		return colectivos;
	}

	public ArrayList<Camion> getCamiones() {
		return camiones;
	}

	public int cuantosChoferesCat(Categoria c) {
		int tot=0;
		for (Chofer e: choferes)
			if (e.getCategoria() == c)
				tot++;
		return tot;
	}
	
	public int cuantosChofereSinVeh() {
		int tot=0;
		for (Chofer c: choferes)
			if (c.getVehiculoAsignado() == null)
				tot++;
		return tot;
	}

	public void agregarCamion(Camion c) {
		camiones.add(c);
	}
	
	public int cantColectivos() {
		return colectivos.size();
	}
	
	public int cantAcoplados() {
		return acoplados.size();
	}
	
	public void agregarChofer(Chofer c) {
		choferes.add(c);
	}
	
	public void agregarColectivo(Colectivo v) {
		colectivos.add(v);
	}
	
	public void agregarCategoria(Categoria c) {
		categorias.add(c);
	}
	
	public void agregarAcoplado(Acoplado a) {
		acoplados.add(a);
	}
	
	public void eliminarChofer(Chofer c) {
		choferes.remove(c);
	}
	
	public void eliminarColectivo(Colectivo v) {
		colectivos.remove(v);
	}
	
	public void eliminarCategoria(Categoria c) {
		categorias.remove(c);
	}
	
	public void eliminarAcoplado(Acoplado a) {
		acoplados.remove(a);
	}
	
	// Vincular chofer a vehiculo validando la compatibilidad
	public boolean vincularChoferVehiculo(Chofer c, Vehiculo v) {
	    if (c != null && v != null && v.aceptoChofer(c)) {
	        c.asignarVehiculo(v);
	        return true;
	    }
	    return false;
	}

	// Desvincular chofer
	public void desvincularChofer(Chofer c) {
	    if (c != null) {
	        c.desvincularVehiculo();
	    }
	}

	// Enganchar acoplado a camion
	public boolean engancharAcoplado(Camion c, Acoplado a) {
	    if (c != null && a != null && !a.isEnUso() && c.getAcoplado() == null) {
	        c.asignarAcoplado(a);
	        return true;
	    }
	    return false;
	}

	// Desenganchar acoplado
	public void desengancharAcoplado(Camion c) {
	    if (c != null) {
	        c.desacoplar();
	    }
	}

	public ArrayList<Chofer> getChoferes() {
		return choferes;
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public ArrayList<Acoplado> getAcoplados() {
		return acoplados;
	}

	@Override
	public String toString() {
		return "Empresa [choferes=" + choferes + ", colectivos=" + colectivos +", camiones: "+camiones+ ", categorias="
				+ categorias + ", acoplados=" + acoplados + "]";
	}
	
	
	
}
