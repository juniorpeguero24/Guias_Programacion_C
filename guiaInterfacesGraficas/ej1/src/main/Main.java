package main;

import controlador.Controlador;
import modelo.Mapa;
import modelo.PersonajeFactory;
import modelo.Posicion;
import vista.VentanaPrincipal;

public class Main {

    public static void main(String[] args) {
        // 1. Obtener instancia del Modelo y cargar los personajes
        Mapa mapa = Mapa.getInstance();

        // Arqueros
        mapa.agregarPersonaje(PersonajeFactory.crearPersonaje("Arquero", "Legolas", new Posicion(0, 0)));
        mapa.agregarPersonaje(PersonajeFactory.crearPersonaje("Arquero", "Green Arrow", new Posicion(15, 20)));
        mapa.agregarPersonaje(PersonajeFactory.crearPersonaje("Arquero", "Robin Hood", new Posicion(80, 50)));

        // Guerreros
        mapa.agregarPersonaje(PersonajeFactory.crearPersonaje("Guerrero", "Aragorn", new Posicion(2, 2)));
        mapa.agregarPersonaje(PersonajeFactory.crearPersonaje("Guerrero", "Faramir", new Posicion(8, 5)));
        mapa.agregarPersonaje(PersonajeFactory.crearPersonaje("Guerrero", "Gimli", new Posicion(20, 20)));

        // Caballeros
        mapa.agregarPersonaje(PersonajeFactory.crearPersonaje("Caballero", "Jon Snow", new Posicion(4, 3)));
        mapa.agregarPersonaje(PersonajeFactory.crearPersonaje("Caballero", "Arthur", new Posicion(12, 10)));
        mapa.agregarPersonaje(PersonajeFactory.crearPersonaje("Caballero", "Lancelot", new Posicion(90, 85)));

        // 2. Instanciar Vista y enlazar con el Controlador
        VentanaPrincipal vista = new VentanaPrincipal();
        new Controlador(vista, mapa);
        vista.setVisible(true);
    }
}