package modelo;

public abstract class Infusion {

    protected void calentarAgua() {
        System.out.println("Calentando el agua");
    }

    // Paso obligatorio: cada infusi�n pone lo suyo
    protected abstract void agregarTipoInfusion();

    // M�TODO HOOK: comportamiento por defecto (amargo)
    protected void endulzar() {
        System.out.println("La bebida se tomara amarga");
    }

    protected void tomando() {
        System.out.println("Tomando bebida");
    }

    // Template Method (esqueleto del algoritmo)
    public final void preparacion() {
        calentarAgua();
        agregarTipoInfusion();
        endulzar();
        tomando();
    }
}