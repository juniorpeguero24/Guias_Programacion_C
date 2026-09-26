package paquete;

public class Prueba {
    public static void main(String[] args) {
        Domicilio dom1 = new Domicilio("Av. Colon", 1234);
        Domicilio dom2 = new Domicilio("San Martin", 5678);

        // 1. Caso Persona con Perro (debe permitir la clonación profunda)
        Persona p1 = new Persona();
        p1.setApellido("Gomez");
        p1.setDNI(11111111);
        p1.setLegajo(101);
        p1.setDomicilio(dom1);
        p1.setMascota(new Perro("Bobby", 12));

        System.out.println("--- PRUEBA 1: Persona con Perro ---");
        System.out.println("Original: " + p1);
        try {
            Persona p1Clonada = (Persona) p1.clone();
            System.out.println("Clonada : " + p1Clonada);
            System.out.println("-> Clonacion exitosa de persona con perro.\n");
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage() + "\n");
        }

        // 2. Caso Persona con Gato (debe fallar la clonación)
        Persona p2 = new Persona();
        p2.setApellido("Perez");
        p2.setDNI(22222222);
        p2.setLegajo(102);
        p2.setDomicilio(dom2);
        //p2.setMascota(new Gato("Michi", 15));

        System.out.println("--- PRUEBA 2: Persona con Gato ---");
        System.out.println("Original: " + p2);
        try {
            Persona p2Clonada = (Persona) p2.clone();
            System.out.println("Clonada : " + p2Clonada);
        } catch (Exception e) {
            System.out.println("-> Se impidio la clonacion correctamente:");
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
}