package paquete;

public class Persona implements Comparable<Persona>{
    private String apellido,nombre,direccion;

    public Persona(String apellido, String nombre, String direccion) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Persona)) {
            return false;
        }
        final Persona otro = (Persona) o;
        if (otro.apellido.equals(this.apellido) && otro.nombre.equals(this.nombre)) {
            return true;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash=1;
        hash = hash * 31 + ((this.apellido == null) ? 0 : this.apellido.hashCode());
        hash = hash * 17 + ((this.nombre == null) ? 0 : this.nombre.hashCode());
        return hash;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    @Override
    public int compareTo(Persona o) {
        int rta=0;
        if (o.nombre.equals(this.nombre) && o.apellido.equals(this.apellido)) {
            rta = 1;
        } else {
            rta = -1;
        }
        return rta;
    }
}
