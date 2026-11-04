package paquete;

public class Automovil extends Vehiculo {
    private Motor motor;
    private String marca,modelo, patente;

    public Automovil(String n_Chasis, int anio_fabricacion, Motor motor, String marca, String modelo, String patente) {
        super(n_Chasis, anio_fabricacion);
        this.motor = motor;
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
    }

    public Automovil() {
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        return "Automovil{" + super.toString() +      // incluye chasis y año de Vehiculo
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", patente='" + patente + '\'' +
                ", motor=" + motor +
                '}';
    }
}
