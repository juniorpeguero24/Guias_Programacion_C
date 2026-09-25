package excepciones;

public class TipoCombustibleInvalidoException extends Exception{
    @SuppressWarnings("compatibility:1517111347901476305")
    private static final long serialVersionUID = 1L;

    public TipoCombustibleInvalidoException(String string) {
        super("\n[ERROR] Combustible desconocido: "+string);
    }
}
