package paquete;

import excepciones.CargaInvalidaException;
import excepciones.FaltaCombustibleException;
import excepciones.TipoCombustibleInvalidoException;

public class Surtidor {
    public static int nro=0;
    private int ns;
    private double cantDiesel;
    private double cantPremium;
    private double cantSuper;
    
    private final double MAX=20000;

    public Surtidor() {
        this.ns = ++nro;
        this.cantDiesel=MAX;
        this.cantPremium=MAX;
        this.cantSuper=MAX;
    }
    
    public void cargarCombustible(String combustible,double cantidad)throws TipoCombustibleInvalidoException,
                                                                              CargaInvalidaException {
        if (combustible.equalsIgnoreCase("DIESEL"))
            cargaDiesel(cantidad,combustible);
        else if (combustible.equalsIgnoreCase("PREMIUM"))
            cargaPremium(cantidad,combustible); 
        else if (combustible.equalsIgnoreCase("SUPER"))
            cargaSuper(cantidad,combustible);
        else
            throw new TipoCombustibleInvalidoException("\n[ERROR] Combustible invalido. ",combustible,cantidad,0);
    }

    private void cargaDiesel(double cantidad, String combustible) throws CargaInvalidaException {
        if (cantidad <= 0)
            throw new CargaInvalidaException("\n[ERROR] Carga Invalida. ",combustible,cantidad,this.cantDiesel);
        if (cantidad > this.cantDiesel){
            double disponible = this.cantDiesel;
            this.cantDiesel=0;
            throw new FaltaCombustibleException("\n[ERROR] Falta combustible. ",combustible,cantidad,disponible);
        }
        this.cantDiesel -= cantidad;
    }

    private void cargaPremium(double cantidad, String combustible) throws CargaInvalidaException {
        if (cantidad <= 0)
            throw new CargaInvalidaException("\n[ERROR] Carga Invalida. ",combustible,cantidad,this.cantPremium);
        if (cantidad > this.cantPremium){
            double disponible=this.cantPremium;
            this.cantPremium=0;
            throw new FaltaCombustibleException("\n[ERROR] Falta combustible. ",combustible,cantidad,disponible);
        }
        this.cantPremium -= cantidad;
    }

    private void cargaSuper(double cantidad, String combustible) throws CargaInvalidaException {
        if (cantidad <= 0)
            throw new CargaInvalidaException("\n[ERROR] Carga Invalida. ",combustible,cantidad,this.cantSuper);
        if (cantidad > this.cantSuper){
            double disponible=this.cantSuper;
            this.cantSuper=0;
            throw new FaltaCombustibleException("\n[ERROR] Falta combustible. ",combustible,cantidad,disponible);
        }
        this.cantSuper -= cantidad;
    }
    
    public void llenarDiesel(){
        this.cantDiesel=MAX;
    }
    public void llenarPremium() {
        this.cantPremium = MAX;
    }
    public void llenarSuper(){
        this.cantSuper=MAX;
    }

    public double getCantDiesel() {
        return cantDiesel;
    }

    public double getCantPremium() {
        return cantPremium;
    }

    public double getCantSuper() {
        return cantSuper;
    }

    public int getNs() {
        return ns;
    }

    @Override
    public String toString() {
        return "\nSurtidor "+ns
                +"\nDiesel: "+cantDiesel+"\n"+
            "\nSuper: "+cantSuper+"\n"+
            "\nPremium: "+cantPremium+"\n";
    }
}
