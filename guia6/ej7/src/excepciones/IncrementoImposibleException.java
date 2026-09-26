package excepciones;

public class IncrementoImposibleException extends Exception{
    @SuppressWarnings("compatibility:-1031188476351768983")
    private static final long serialVersionUID = 1L;
    private double maxDistanciaSoportada,distanciaPretendida;
    
    public IncrementoImposibleException(double distanciaPretendida, double maxDistanciaSoportada) {
        super("\n[ERROR] Distancia imposible. "+"Distancia pretendida: "+distanciaPretendida+"\nMaxima distancia soportada: "
              +maxDistanciaSoportada+".\n");
        this.distanciaPretendida=distanciaPretendida;
        this.maxDistanciaSoportada=maxDistanciaSoportada;
    }

    public void setMaxDistanciaSoportada(double maxDistanciaSoportada) {
        this.maxDistanciaSoportada = maxDistanciaSoportada;
    }

    public double getMaxDistanciaSoportada() {
        return maxDistanciaSoportada;
    }

    public void setDistanciaPretendida(double distanciaPretendida) {
        this.distanciaPretendida = distanciaPretendida;
    }

    public double getDistanciaPretendida() {
        return distanciaPretendida;
    }
}
