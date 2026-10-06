package excepciones;

public class ContraseniaInvalidaException extends Exception{
    @SuppressWarnings("compatibility:-4444272410079146975")
    private static final long serialVersionUID = 1L;

    public ContraseniaInvalidaException(String motivo) {
        super(motivo);
    }
}
