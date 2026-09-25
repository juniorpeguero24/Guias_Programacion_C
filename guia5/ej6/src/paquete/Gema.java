package paquete;

public abstract class Gema {
	protected String tipo;
	
	public Gema(String tipo) {
		// SE VALIDARIA OBVIAMENTE QUE EL TIPO INGRESADO SEA IGUAL A LOS 4 TIPOS DE GEMA
		this.tipo = tipo;
	}
	public abstract String combinar(Gema otra);
	protected abstract String combinarConRubi(Rubi rubi);
	protected abstract String combinarConZafiro(Zafiro zafiro);
	protected abstract String combinarConEsmeralda(Esmeralda esmeralda);
	protected abstract String combinarConDiamante(Diamante diamante);
	
}
