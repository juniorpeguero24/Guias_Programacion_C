package excepciones;

public class CargaInvalidaException extends Exception{
    @SuppressWarnings("compatibility:1833934131104922647")
    private static final long serialVersionUID = 1L;

    public CargaInvalidaException(double d) {
        super("\n[ERRROR] Cantidad negativa: "+d);
    }
}
