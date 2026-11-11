package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Cliente {
    private int id;
    private String nombre, telefono, direccion, email;
    private ArrayList<Mascota> mascotas = new ArrayList<>();

    public Cliente(String nombre, String telefono, String direccion, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    public Cliente(int id, String nombre, String telefono, String direccion, String email) {
        this(nombre, telefono, direccion, email);
        this.id = id;
    }

    public void agregarMascota(Mascota m) { mascotas.add(m); }
    public void eliminarMascota(Mascota m) { mascotas.remove(m); }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public ArrayList<Mascota> getMascotas() { return mascotas; }
    public void setMascotas(ArrayList<Mascota> mascotas) { this.mascotas = mascotas; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        return id == ((Cliente) o).id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public String toString() {
        return nombre + " - " + email + " - " + telefono;
    }
}