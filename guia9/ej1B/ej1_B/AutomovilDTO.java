package ej1_B;

// Hereda chasis y año de VehiculoDTO (que es serializable, asi que este tambien).
public class AutomovilDTO extends VehiculoDTO {
    private String marca;
    private String modelo;
    private String patente;
    private MotorDTO motor;              // MotorDTO, no Motor: Motor no es serializable

    public AutomovilDTO() {
    }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }

    public MotorDTO getMotor() { return motor; }
    public void setMotor(MotorDTO motor) { this.motor = motor; }
}
