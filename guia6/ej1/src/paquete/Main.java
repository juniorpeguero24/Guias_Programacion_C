package paquete;

import paquete.excepciones.ContraseniaInvalidaException;
import paquete.excepciones.NombreInvalidoException;

public class Main {
    public static void main(String[] args){
        try {
            Usuario user = new Usuario("Junior","chonapeguero");
            System.out.println("Usuario "+user.getNombre()+" creado con exito.");
        } catch (ContraseniaInvalidaException e) {
            System.out.println("Error en la contraseña: "+e.getMessage());
        } catch (NombreInvalidoException e) {
            System.out.println("Error en la contraseña: "+e.getMessage());
        }
        
        try {
            Usuario user2 = new Usuario(null, "chonapeguero");
            System.out.println("Usuario "+user2.getNombre()+" creado con exito.");
        } catch (ContraseniaInvalidaException e) {
            System.out.println("Error en la contraseña: "+e.getMessage());
        } catch (NombreInvalidoException e) {
            System.out.println("Error en la contraseña: "+e.getMessage());
        }
        
        try {
            Usuario user3 = new Usuario("Marcos", "1234");
        } catch (NombreInvalidoException e) {
            System.out.println("Error en nombre: " + e.getMessage());
        } catch (ContraseniaInvalidaException e) {
            System.out.println("Capturado correctamente: " + e.getMessage());
        }
        
        try {
            Usuario user4 = new Usuario("Lucas", "9contrasenia");
        } catch (NombreInvalidoException e) {
            System.out.println("Error en nombre: " + e.getMessage());
        } catch (ContraseniaInvalidaException e) {
            System.out.println("Capturado correctamente: " + e.getMessage());
        }
    }
}
