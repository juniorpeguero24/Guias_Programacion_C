package excepciones;

public class CargaInvalidaException extends Exception{
    @SuppressWarnings("compatibility:1833934131104922647")
    private static final long serialVersionUID = 1L;
    private DatoCargaInvalido datoCargaInvalido=null;
    
    public CargaInvalidaException(String msj,String combustible,double cantidaRequerida,double cantidaDisponible) {
        super(msj+" Cantidad disponible: "+cantidaDisponible+" Cantidad Requeridad: "+cantidaRequerida+" de "+combustible);
        datoCargaInvalido=new DatoCargaInvalido(cantidaDisponible,cantidaRequerida,combustible);
    }

    public DatoCargaInvalido getDatoCargaInvalido() {
        return datoCargaInvalido;
    }
}
