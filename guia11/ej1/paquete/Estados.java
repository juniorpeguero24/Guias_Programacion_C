package paquete;

public enum Estados {
    SED("tiene sed"),
    HAMBRE("tiene hambre"),
    ABURRIMIENTO("está aburrida y quiere jugar");

    private final String texto;

    Estados(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}