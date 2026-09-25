package paquete;

public class Cafe extends Infusion {
    protected boolean dulce;

    public Cafe(boolean dulce) {
        this.dulce = dulce;
    }

    @Override
    protected void agregarTipoInfusion() {
        System.out.println("Se agrega Cafe Molido a la taza");
    }

    @Override
    protected void endulzar() {
        if (this.dulce) {
            System.out.println("Se agrega azucar a la bebida");
        } else {
            super.endulzar(); // Reutiliza el comportamiento por defecto del hook
        }
    }
}