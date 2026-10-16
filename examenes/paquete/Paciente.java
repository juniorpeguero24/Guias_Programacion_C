package paquete;

public class Paciente implements Cloneable{
    private Enfermedad enfermedad;
    private String nombre;
    private int edad;

    public Paciente(Enfermedad enfermedad, String nombre, int edad) {
        this.enfermedad = enfermedad;
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    protected Paciente clone() throws CloneNotSupportedException {
        try{
            Paciente obj = (Paciente) super.clone();
            if (enfermedad != null) {
                obj.enfermedad=(Enfermedad) enfermedad.clone();
             }
            return obj;
        }catch (CloneNotSupportedException e){
            throw new InternalError(e.getMessage());
        }
    }
}
