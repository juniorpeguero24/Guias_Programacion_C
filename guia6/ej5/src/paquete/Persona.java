package paquete;


public class Persona implements Cloneable, Comparable<Persona> {
    private int DNI;
    private String apellido;
    private Domicilio domicilio=null;
    private int legajo;
    private Animal mascota=null;
    
    public Persona(){}

    public void setMascota(Animal mascota) {
        this.mascota = mascota;
    }

    public Animal getMascota() {
        return mascota;
    }

    @Override
    public Object clone() {
        try{
            Persona nObj=(Persona)super.clone();
            if (this.domicilio != null)
                nObj.domicilio = (Domicilio) this.domicilio.clone();
            if (this.mascota != null)
                nObj.mascota = (Animal) this.mascota.clone();
            return nObj;
        }catch(CloneNotSupportedException e){
            throw new InternalError(e.toString());
        }
    }

    @Override
    public String toString() {
        return "DNI: "+DNI+" Apellido: "+apellido+" Legajo: "+legajo+" Domicilio: "
               +((domicilio != null) ? domicilio:"No")+" Mascota: "+((mascota!=null) ? mascota:"No");
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public int getDNI() {
        return DNI;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public int getLegajo() {
        return legajo;
    }

    @Override
    public int compareTo(Persona otra) {
        int res= this.apellido.compareTo(otra.getApellido());
        if (res != 0)
            return res;
        else
            return this.DNI - otra.getDNI();
    }
}
