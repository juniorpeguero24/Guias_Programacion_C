package paquete;

import excepciones.ContraseniaInvalidaException;
import excepciones.NombreInvalidoException;

public class Usuario {
    private String nombre; 
    private String contrasenia;


    public Usuario(String nombre, String contrasenia) throws NombreInvalidoException, ContraseniaInvalidaException {
        this.setNombre(nombre);
        this.setContrasenia(contrasenia);
    }

    public void setNombre(String nombre) throws NombreInvalidoException {
        if (nombre == null || nombre.isEmpty())
            throw new NombreInvalidoException("Nombre distinto de null o vacio."); 
        this.nombre = nombre;
    }

    public void setContrasenia(String contrasenia) throws ContraseniaInvalidaException {
        if (contrasenia == null)
            throw new ContraseniaInvalidaException("Contrase�a distinta de null.");
        if (contrasenia.length() <= 6)
            throw new ContraseniaInvalidaException("La contrase�a debe tener mas de 6 caracteres.");
        if (!Character.isLetter(contrasenia.charAt(0)))
            throw new ContraseniaInvalidaException("El primer caracter debe ser una letra");
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
