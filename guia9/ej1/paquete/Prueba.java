package paquete;

public class Prueba {
    public static void main(String[] args) {
        Flota flota = new Flota("Transportes del Atlantico");
        flota.agregar(new Automovil("9BWZZZ377VT004251", 2018,
                new Motor("VW-EA211-55821", "Nafta"), "Volkswagen", "Gol Trend", "AC123FD"));
        flota.agregar(new Automovil("8AFDR5AD6C6034417", 2021,
                new Motor("FD-PUMA-90314", "Diesel"), "Ford", "Ranger", "AE456KL"));
        flota.agregar(new Automovil("93YRBB00X5J774102", 2015,
                new Motor("RN-K7M-40277", "GNC"), "Renault", "Kangoo", "OPQ782"));
        flota.agregar(new Automovil("9BD19573NE1144909", 2023,
                new Motor("FT-FIRE-13560", "Nafta"), "Fiat", "Cronos", "AF789TZ"));

        System.out.println("=== ORIGINAL ===");
        System.out.println(flota);

        probar("BINARIO", new PersistenciaBinaria(), flota, "flota.ser");
        probar("XML", new PersistenciaXML(), flota, "flota.xml");
    }

    private static void probar(String formato, Persistencia p, Flota original, String archivo) {
        try {
            p.guardar(original, archivo);
            Flota leida = p.cargar(archivo);
            System.out.println("=== LEIDA DESDE " + formato + " ===");
            System.out.println(leida);
            System.out.println("¿Mismo objeto que el original? " + (leida == original));
            System.out.println("¿Mismo contenido? " + leida.toString().equals(original.toString()));
            System.out.println();
        } catch (Exception e) {
            System.out.println("Error en " + formato + ": " + e);
        }
    }
}