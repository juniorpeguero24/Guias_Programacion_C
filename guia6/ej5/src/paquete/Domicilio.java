package paquete;

public class Domicilio implements Cloneable{
    private String calle;
    private int numero;

    public Domicilio(){}

    public Domicilio(String calle, int numero) {
        this.calle = calle;
        this.numero = numero;
    }


    @Override
    public String toString() {
        return ""+calle+" "+numero;
    }

    @Override
    public Object clone(){
        try{
            Domicilio nObj=(Domicilio)super.clone();
            return nObj;
        }catch(CloneNotSupportedException e){
            throw new InternalError(e.toString());
        }
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCalle() {
        return calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
