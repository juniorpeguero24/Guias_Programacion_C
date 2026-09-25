package paquete;

public class Main {

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        Contacto c1 = new Contacto("Juan", "123456");
        c1.agregarCelular("147852");
        c1.agregarCelular("112233"); // Se pueden agregar varios celulares

        Contacto c2 = new Contacto("Ana", "456789");
        c2.agregarCelular("852147");

        // Agregamos a la agenda
        agenda.agregarContacto(c1);
        agenda.agregarContacto(c2);

        System.out.println("--- Lista Inicial de Contactos ---");
        agenda.mostrarContactos();

        System.out.println("\n--- Intento de agregar duplicado (Ana) ---");
        boolean agrego = agenda.agregarContacto(new Contacto("Ana", "000000"));
        System.out.println("¿Se pudo agregar Ana de nuevo?: " + agrego);

        System.out.println("\n--- Búsqueda de Juan ---");
        Contacto buscado = agenda.busqueda("Juan");
        System.out.println("Encontrado: " + buscado);

        System.out.println("\n--- Modificación de teléfono de Ana ---");
        agenda.modificarTelefonoFijo("Ana", "999999");
        agenda.mostrarContactos();

        System.out.println("\n--- Eliminación de Juan ---");
        agenda.eliminarContacto("Juan");
        agenda.mostrarContactos();
    }
}