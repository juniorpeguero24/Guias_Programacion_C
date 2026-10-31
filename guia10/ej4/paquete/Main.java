package paquete;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();   // primero la biblioteca, así getSig() ya vale 5

        String[] nombres = {"Ana", "Juan", "Pedro", "Lucia", "Martin",
                "Sofia", "Diego", "Valen", "Tomas", "Caro"};

        for (String nombre : nombres) {
            new Thread(new Socio(nombre, biblioteca)).start();
        }
    }
}