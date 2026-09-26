package excepciones;

public class TipoCombustibleInvalidoException extends CargaInvalidaException{
    @SuppressWarnings("compatibility:-4484771662921236666")
    private static final long serialVersionUID = 1L;


    public TipoCombustibleInvalidoException(String msj, String combustible, double cantidaRequerida,double cantidaDisponible) {
        super(msj, combustible, cantidaRequerida, cantidaDisponible);
    }
}
