package paquete;

public class Diamante extends Gema {

	public Diamante(String tipo) {
		super(tipo);
	}

	@Override
	public String combinar(Gema otra) {
		return otra.combinarConDiamante(this);
	}

	@Override
	protected String combinarConRubi(Rubi rubi) {
		return "Tormenta de rayos";
	}

	@Override
	protected String combinarConZafiro(Zafiro zafiro) {
		return "Granizo asesino";
	}

	@Override
	protected String combinarConEsmeralda(Esmeralda esmeralda) {
		return "Vientos venenosos";
	}

	@Override
	protected String combinarConDiamante(Diamante diamante) {
		return "Congelamiento";
	}

	
}
