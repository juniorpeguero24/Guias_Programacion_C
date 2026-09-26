package paquete;

public class Motor implements Cloneable{
    private String fabricante,nSerie;
    private double potencia;
    
    public Motor(){}

    @Override
    public Object clone(){
        try{
            Motor obj=(Motor)super.clone();
            return obj;
        }catch(CloneNotSupportedException e){
            throw new InternalError(e.toString());
        }
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setNSerie(String nSerie) {
        this.nSerie = nSerie;
    }

    public String getNSerie() {
        return nSerie;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getPotencia() {
        return potencia;
    }
}
