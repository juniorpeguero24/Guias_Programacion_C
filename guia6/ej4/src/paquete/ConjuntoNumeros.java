package paquete;

public class ConjuntoNumeros implements Cloneable {
    private Numero[] celda;
    private int largo;
    private String nombre;


    public ConjuntoNumeros(String nombre,int largo) {
        this.largo = largo;
        this.nombre = nombre;
        this.celda= new Numero[largo];
        for (int i=0;i<largo;i++)
            this.celda[i]=new Numero(0);
    }


    @Override
    public Object clone(){
        try{
            ConjuntoNumeros nObj=(ConjuntoNumeros)super.clone();
            nObj.celda=new Numero[this.celda.length];
            for (int i=0;i<this.getLargo();i++)
                nObj.celda[i]=new Numero(this.celda[i].getDato());
            return nObj;
        }catch (CloneNotSupportedException e){
            throw new InternalError(e.toString());
        }
    }

    public Numero[] getCelda() {
        return celda;
    }

    public int getLargo() {
        return largo;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String toString(){
        String vec= "Conjunto: ";
        for (int i=0;i<this.celda.length;i++){
            vec += this.celda[i];
            if (i < this.celda.length -1)
                vec += ", ";
        }
        return "Nombre: "+nombre+" (largo: "+largo+
            ") -> "+vec;
    }
}
