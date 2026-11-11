package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Practica {
    private int id;
    private String descripcion, comentarios;
    private LocalDate fecha, fechaVencimiento;   // fechaVencimiento puede ser null

    // Alta
    public Practica(String descripcion, String comentarios, LocalDate fecha, LocalDate fechaVencimiento) {
        this.descripcion = descripcion;
        this.comentarios = comentarios;
        this.fecha = fecha;
        this.fechaVencimiento = fechaVencimiento;
    }

    // Lectura desde la base
    public Practica(int id, String descripcion, String comentarios, LocalDate fecha, LocalDate fechaVencimiento) {
        this(descripcion, comentarios, fecha, fechaVencimiento);
        this.id = id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getDescripcion() { return descripcion; }
    public String getComentarios() { return comentarios; }
    public LocalDate getFecha() { return fecha; }
    public LocalDate getFechaVencimiento() { return fechaVencimiento; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Practica)) return false;
        return id == ((Practica) o).id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return descripcion + " - " + fecha + (fechaVencimiento != null ? " (vence " + fechaVencimiento + ")" : "");
    }
}