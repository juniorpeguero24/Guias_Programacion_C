package paquete;

public class Automovil implements Cloneable{
    private String marca,modelo,patente;
    private Motor motor=null;
    
    public Automovil() {}

    @Override
    public Object clone(){
        try{
            Automovil obj=(Automovil)super.clone();
            if (this.motor!=null)
                obj.motor = (Motor)super.clone();
            return obj;
        }catch(CloneNotSupportedException e){
            throw new InternalError(e.toString());
        }
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getPatente() {
        return patente;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Motor getMotor() {
        return motor;
    }
}
