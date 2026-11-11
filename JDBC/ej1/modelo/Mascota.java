package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Mascota {
    private int id;
    private String nombre, animal, historiaClinica;
    private LocalDate nacimiento;
    private ArrayList<Practica> practicas = new ArrayList<>();

    public Mascota(String nombre, String animal, LocalDate nacimiento, String historiaClinica) {
        this.nombre = nombre;
        this.animal = animal;
        this.nacimiento = nacimiento;
        this.historiaClinica = historiaClinica;
    }

    public Mascota(int id, String nombre, String animal, LocalDate nacimiento, String historiaClinica) {
        this(nombre, animal, nacimiento, historiaClinica);
        this.id = id;
    }

    public void realizarPractica(Practica p) { practicas.add(p); }

    public void agregarHistoriaClinica(String s) {
        historiaClinica = (historiaClinica == null || historiaClinica.isEmpty()) ? s : historiaClinica + "\n" + s;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public String getAnimal() { return animal; }
    public LocalDate getNacimiento() { return nacimiento; }
    public String getHistoriaClinica() { return historiaClinica; }
    public ArrayList<Practica> getPracticas() { return practicas; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mascota)) return false;
        return id == ((Mascota) o).id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return nombre + " (" + animal + ")";
    }
}