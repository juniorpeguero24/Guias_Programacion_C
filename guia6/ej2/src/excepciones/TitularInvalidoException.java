package excepciones;

public class TitularInvalidoException extends Exception{
    @SuppressWarnings("compatibility:2445980279180818644")
    private static final long serialVersionUID = 1L;

    public TitularInvalidoException(String motivo) {
        super(motivo);
    }
}
