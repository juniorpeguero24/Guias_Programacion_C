package modelo;

public class ColectivoLarga extends Colectivo{
	public boolean cocheCama;
	
	public ColectivoLarga(String modelo, int cantidadPasajeros, boolean cocheCama) throws Exception {
		super(modelo, cantidadPasajeros);
		this.cocheCama=cocheCama;
	}

	@Override
	public boolean aceptoChofer(Chofer c) {
		if (c == null || c.getCategoria() == null)
			return false;
		return c.getCategoria().isHabilitaColectivoLarga();
	}

	@Override
	public String toString() {
		return "Larga Distancia " + super.toString() + 
				", cocheCama=" + (cocheCama ? "Si" : "No");
	}
	
}
