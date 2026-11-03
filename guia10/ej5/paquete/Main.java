package paquete;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();   // primero la biblioteca, así getSig() ya vale 5
        String[] nombres = {"Ana", "Juan", "Pedro", "Lucia", "Martin",
                "Sofia", "Diego", "Valen", "Tomas", "Caro",
                "Nico", "Flor", "Agus", "Mica", "Facu",
                "Belu", "Santi", "Cami", "Lucho", "Juli"};
        new Thread(new Donador(biblioteca)).start();
        for (String nombre : nombres) {
            new Thread(new Socio(nombre, biblioteca)).start();
        }
    }
}