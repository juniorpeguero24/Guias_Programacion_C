package paquete;

import excepciones.ContraseniaInvalidaException;
import excepciones.NombreInvalidoException;

public class Main {
    public static void main(String[] args){
        try {
            Usuario user = new Usuario("Junior","chonapeguero");
            System.out.println("Usuario "+user.getNombre()+" creado con exito.");
        } catch (ContraseniaInvalidaException e) {
            System.out.println("Error en la contrase�a: "+e.getMessage());
        } catch (NombreInvalidoException e) {
            System.out.println("Error en el nombre: "+e.getMessage());
        }
        
        try {
            Usuario user2 = new Usuario(null, "chonapeguero");
            System.out.println("Usuario "+user2.getNombre()+" creado con exito.");
        } catch (ContraseniaInvalidaException e) {
            System.out.println("Error en la contrase�a: "+e.getMessage());
        } catch (NombreInvalidoException e) {
            System.out.println("Error en el nombre: "+e.getMessage());
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
            System.out.println("Usuario "+user4.getNombre()+" creado con exito.");
        } catch (NombreInvalidoException e) {
            System.out.println("Error en nombre: " + e.getMessage());
        } catch (ContraseniaInvalidaException e) {
            System.out.println("Capturado correctamente: " + e.getMessage());
        }
    }
}
