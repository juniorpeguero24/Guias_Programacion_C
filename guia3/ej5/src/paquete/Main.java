package paquete;

public class    Main {

    public static void main(String[] args) {
        Automovil manual = new AutomovilManual("ABC-123", 180.0);
        Automovil automatico = new AutomovilAutomatico("XYZ-789"); // Default 160 km/h
        
        System.out.println("=== AUTOMÓVIL MANUAL ===");
        manual.acelerar(25.0);
        System.out.println(manual);
        manual.acelerar(30.0);
        System.out.println(manual);
        manual.frenar(100.0); // No debe quedar con velocidad negativa
        System.out.println("Tras frenar a fondo: " + manual);

        System.out.println("\n=== AUTOMÓVIL AUTOMÁTICO ===");
        System.out.println(automatico); // Marcha 0, vel 0
        automatico.acelerar(8.0);
        System.out.println("Acelera a 8 km/h: " + automatico); // Marcha 1
        automatico.acelerar(30.0); // 38 km/h
        System.out.println("Acelera a 38 km/h: " + automatico); // Marcha 3
        automatico.acelerar(60.0); // 98 km/h
        System.out.println("Acelera a 98 km/h: " + automatico); // Marcha 5
        automatico.frenar(98.0); // 0 km/h
        System.out.println("Frena a cero: " + automatico); // Marcha 0
    }
}