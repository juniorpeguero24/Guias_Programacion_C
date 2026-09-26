package excepciones;

public class FaltaCombustibleException extends CargaInvalidaException {
    @SuppressWarnings("compatibility:5131786353337625265")
    private static final long serialVersionUID = 1L;

    public FaltaCombustibleException(String msj, String combustible, double cantidaRequerida, double cantidaDisponible) {
        super(msj, combustible, cantidaRequerida, cantidaDisponible);
    }
}
