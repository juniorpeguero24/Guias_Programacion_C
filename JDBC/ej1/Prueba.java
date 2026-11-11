import modelo.*;
import java.time.LocalDate;

public class Prueba {
    public static void main(String[] args) throws Exception {
        Veterinaria vet = new Veterinaria();

        Cliente c = new Cliente("Sofia Paz", "2234000000", "Rivadavia 100", "spaz@mail.com");
        vet.agregarCliente(c);
        System.out.println("Cliente insertado con id " + c.getId());

        Mascota m = new Mascota("Firulais", "Perro", LocalDate.of(2020, 4, 1), "Sin antecedentes");
        vet.agregarMascota(c, m);

        vet.agregarPractica(m, new Practica("Vacuna antirrabica", "Refuerzo anual",
                LocalDate.now(), LocalDate.now().plusDays(4)));

        System.out.println("\n--- Clientes ---");
        for (Cliente x : vet.getClientes()) System.out.println(x);

        System.out.println("\n--- Mascotas de " + c.getNombre() + " ---");
        for (Mascota x : vet.getMascotas(c)) {
            System.out.println(x);
            for (Practica p : vet.getPracticas(x)) System.out.println("   " + p);
        }

        System.out.println("\n--- Clientes a notificar (practica a 7 dias de vencer) ---");
        for (Cliente x : vet.getClientesANotificar()) System.out.println(x);
    }
}