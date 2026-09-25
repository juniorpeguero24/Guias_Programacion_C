package paquete;

import java.util.Date;

public class Imagen {

    private int cantidaPersonas;
    private String comentarios;
    private Date fecha;
    private Lugar lugar;
    private Persona[] personasenfoto;
    private Persona propietario;

    // Constructor sin parámetros (inicializa el arreglo para evitar errores)
    public Imagen() {
        this.cantidaPersonas = 0;
        this.personasenfoto = new Persona[10];
        this.comentarios = "";
    }

    // Constructor práctico
    public Imagen(Persona propietario, Lugar lugar, Date fecha) {
        this(); // Llama al constructor vacío para inicializar arreglo y contador
        this.propietario = propietario;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public void agregarComentario(String comentario) {
        this.comentarios = comentario;
    }

    public void etiquetarPersona(Persona participante) {
        this.personasenfoto[this.cantidaPersonas] = participante;
        this.cantidaPersonas++;
    }

    public int getCantidaPersonas() {
        return cantidaPersonas;
    }

    public String getComentarios() {
        return comentarios;
    }

    public Date getFecha() {
        return fecha;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public Persona[] getPersonasenfoto() {
        return personasenfoto;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }
}