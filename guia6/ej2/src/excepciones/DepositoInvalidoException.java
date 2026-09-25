package excepciones;

public class DepositoInvalidoException extends Exception{
    @SuppressWarnings("compatibility:5777663076883319330")
    private static final long serialVersionUID = 1L;
    private double cantidadInvalida;

    public DepositoInvalidoException(String motivo,double cantidad) {
        super(motivo+" Se intento depositar: "+cantidad);
        this.cantidadInvalida=cantidad;
    }

    public double getCantidadInvalida() {
        return cantidadInvalida;
    }
}
