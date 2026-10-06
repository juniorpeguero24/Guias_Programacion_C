package excepciones;

public class NombreInvalidoException extends Exception {
    @SuppressWarnings("compatibility:-7354536345914014285")
    private static final long serialVersionUID = 1L;
    
    public NombreInvalidoException (String motivo){
        super(motivo);
    }
}
