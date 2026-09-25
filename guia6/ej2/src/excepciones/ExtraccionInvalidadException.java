package excepciones;

public class ExtraccionInvalidadException extends Exception{
    @SuppressWarnings("compatibility:8536879474700025802")
    private static final long serialVersionUID = 1L;
    private DatoInvalido dato;

    public ExtraccionInvalidadException(String motivo,DatoInvalido dato) {
        super(motivo+" Se intento extraer "+dato.getExtraccion_solicitada()+" y se tiene "+dato.getSaldo()+".");
        this.dato = dato;
    }

    public DatoInvalido getDato() {
        return dato;
    }
}
