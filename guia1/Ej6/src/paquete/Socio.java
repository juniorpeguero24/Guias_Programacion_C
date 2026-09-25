package paquete;

public class Socio {
    // Declaración de constantes según la consigna
    private static final double CUOTA_BASE = 500.0;
    private static final double DESCUENTO_MAYOR = 0.50;  // 50% de descuento
    private static final double DESCUENTO_JUVENIL = 0.25; // 25% de descuento

    private int edad;
    private boolean torneos;

    public Socio(int edad, boolean torneos) {
        this.edad = edad;
        this.torneos = torneos;
    }

    // El método no recibe parámetros, utiliza los atributos de la propia instancia
    public double calcularCuota() {
        double cuota = CUOTA_BASE;

        if (this.edad >= 65) {
            cuota -= CUOTA_BASE * DESCUENTO_MAYOR; // Queda en $250
        } else if (this.edad < 18 && this.torneos) {
            cuota -= CUOTA_BASE * DESCUENTO_JUVENIL; // Queda en $375
        }

        return cuota;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isTorneos() {
        return torneos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTorneos(boolean torneos) {
        this.torneos = torneos;
    }
}