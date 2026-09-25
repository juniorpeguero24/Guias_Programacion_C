package paquete;

import excepciones.CargaInvalidaException;
import excepciones.TipoCombustibleInvalidoException;

public class Surtidor {
    private double cantDiesel;
    private double cantPremium;
    private double cantSuper;
    
    private final double MAX=20000;

    public Surtidor() {
        this.cantDiesel=this.cantPremium=this.cantSuper=MAX;
    }
    
    public void cargarCombustible(String combustible,double cantidad) throws TipoCombustibleInvalidoException,
                                                                              CargaInvalidaException {
        if (combustible.toUpperCase().equals("DIESEL"))
            cargaDiesel(cantidad);
        else if (combustible.toUpperCase().equals("PREMIUM"))
            cargaPremium(cantidad);
        else if (combustible.toUpperCase().equals("SUPER"))
            cargaSuper(cantidad);
        else
            throw new TipoCombustibleInvalidoException(combustible);
    }

    private void cargaDiesel(double cantidad) {
    }

    private void cargaPremium(double cantidad) {
    }

    private void cargaSuper(double cantidad) {
    }
}
