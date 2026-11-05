package ej1_B;

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

    public Motor getMotor() {
        return motor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPatente() {
        return patente;
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
