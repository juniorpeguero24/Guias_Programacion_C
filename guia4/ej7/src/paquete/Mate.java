package paquete;

public class Mate extends Infusion {

    @Override
    protected void agregarTipoInfusion() {
        System.out.println("Se agrega Yerba al mate");
    }

    // NO implementa endulzar(): usa el hook por defecto del padre
}