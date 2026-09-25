package paquete;

public class Zafiro extends Gema {

	public Zafiro(String tipo) {
		super(tipo);
	}

	@Override
	public String combinar(Gema otra) {
		return otra.combinarConZafiro(this);
	}

	@Override
	protected String combinarConRubi(Rubi rubi) {
		return "Erupcion volcanica";
	}

	@Override
	protected String combinarConZafiro(Zafiro zafiro) {
		return "Inundacion";
	}

	@Override
	protected String combinarConEsmeralda(Esmeralda esmeralda) {
		return "Huracan";
	}

	@Override
	protected String combinarConDiamante(Diamante diamante) {
		return "Granizo asesino";
	}

}
