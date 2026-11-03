package paquete;

public abstract class Prestable {
    private final int id;
    private final String titulo;

    // CAMBIO: recibe el id, ya no lo genera
    public Prestable(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}