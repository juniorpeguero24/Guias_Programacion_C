package paquete;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        String[] lectoresLibros = {"Ana", "Juan", "Pedro", "Lucia", "Martin", "Sofia", "Diego", "Valen"};
        String[] lectoresRevistas = {"Nico", "Flor", "Agus", "Mica", "Facu", "Belu", "Santi", "Cami"};

        for (String n : lectoresLibros) {
            new Thread(new SocioLibro(n, biblioteca)).start();
        }
        for (String n : lectoresRevistas) {
            new Thread(new SocioRevista(n, biblioteca)).start();
        }
    }
}