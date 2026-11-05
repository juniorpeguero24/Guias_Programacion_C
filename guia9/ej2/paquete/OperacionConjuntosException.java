package paquete;

public class OperacionConjuntosException extends Exception {
    private Object elemento;

    public OperacionConjuntosException(String s, Object elemento) {
        super(s);
        this.elemento = elemento;
    }

    public Object getElemento() {
        return this.elemento;
    }
}
