package excepciones;

public class MontoInvalidoException extends Exception {
    private String mensaje;

    public MontoInvalidoException(String s, double monto, double saldo, String titular) {
        super(s);
        this.mensaje = "\n"+titular
                +"\nSe intento extraer: " + monto
                + "\nSe tiene: " + saldo;
    }

    public MontoInvalidoException(String s, double monto, String titular) {
        super(s);
        this.mensaje = "\n" + titular
                + "\nSe intento depositar: " + monto;
    }

    public String getMensaje() {
        return mensaje;
    }
}
