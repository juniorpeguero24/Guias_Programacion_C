package exception;

public class FaltaCombustibleException extends Exception {
    private DatoCargaInvalido dato;

    public FaltaCombustibleException(int cantidad, int cantCombustible, String combustible) {
        super("Falta " + combustible + ".\nSe tiene " + cantCombustible + " se requiere " + cantidad);
        this.dato = new DatoCargaInvalido(cantidad, cantCombustible,combustible);
    }

    public DatoCargaInvalido getDato() {
        return dato;
    }
}
