package paquete;

import ventana.VentanaPrincipal;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        // Lista de personajes iniciales creados mediante Factory
        Universo universo=new Universo();
        // Arqueros
        universo.agregarPersonaje(PersonajeFactory.crearPersonaje("Arquero", "Legolas", new Posicion(0, 0)));
        universo.agregarPersonaje(PersonajeFactory.crearPersonaje("Arquero", "Green Arrow", new Posicion(15, 20)));
        universo.agregarPersonaje(PersonajeFactory.crearPersonaje("Arquero", "Robin Hood", new Posicion(80, 50)));

        // Guerreros
        universo.agregarPersonaje(PersonajeFactory.crearPersonaje("Guerrero", "Aragorn", new Posicion(2, 2)));
        universo.agregarPersonaje(PersonajeFactory.crearPersonaje("Guerrero", "Faramir", new Posicion(8, 5)));
        universo.agregarPersonaje(PersonajeFactory.crearPersonaje("Guerrero", "Gimli", new Posicion(20, 20)));

        // Caballeros
        universo.agregarPersonaje(PersonajeFactory.crearPersonaje("Caballero", "Jon Snow", new Posicion(4, 3)));
        universo.agregarPersonaje(PersonajeFactory.crearPersonaje("Caballero", "Arthur", new Posicion(12, 10)));
        universo.agregarPersonaje(PersonajeFactory.crearPersonaje("Caballero", "Lancelot", new Posicion(90, 85)));

        // Iniciar GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaPrincipal ventana = new VentanaPrincipal(universo);
                ventana.setVisible(true);
            }
        });
    }
}