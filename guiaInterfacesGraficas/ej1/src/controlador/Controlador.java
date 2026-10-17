package controlador;

import excepciones.AtaqueImposibleException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Mapa;
import modelo.Personaje;
import modelo.PersonajeFactory;
import modelo.Posicion;
import vista.VentanaPrincipal;

public class Controlador implements ActionListener {

    private VentanaPrincipal vista;
    private Mapa mapa;

    public Controlador(VentanaPrincipal vista, Mapa mapa) {
        this.vista = vista;
        this.mapa = mapa;
        this.vista.setControlador(this);
        this.vista.cargarPersonajesIniciales(this.mapa.getPersonajes());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if ("Atacar".equals(cmd)) {
            this.atacar();
        } else if ("Arquero".equals(cmd) || "Guerrero".equals(cmd) || "Caballero".equals(cmd) || "Dragon".equals(cmd)) {
            this.crearPersonaje(cmd);
        } else if ("Mover".equals(cmd)) {
            this.mover();
        }
    }

    private void atacar() {
        Personaje p1 = this.vista.getPersonajeSeleccionadoAtacante();
        Personaje p2 = this.vista.getPersonajeSeleccionadoDefensor();

        if (p1 != null && p2 != null && p1 != p2) {
            try {
                this.mapa.ataca(p1, p2);
                this.vista.agregarDetalle(p1.getNombre() + " atacó con éxito a " + p2.getNombre() + ".");
            } catch (AtaqueImposibleException ex) {
                this.vista.mostrarError(ex.getMessage(), "Ataque Imposible");
                this.vista.agregarDetalle(p1.getNombre() + " no pudo realizar el ataque.");
            }
            this.vista.refrescarListas();
        } else {
            this.vista.agregarDetalle("Seleccione personajes distintos en ambas listas.");
        }
        this.vista.limpiarSelecciones();
    }

    private void mover() {
        Personaje p1 = this.vista.getPersonajeSeleccionadoAtacante();
        Personaje p2 = this.vista.getPersonajeSeleccionadoDefensor();
        Personaje objetivo = null;

        if ((p1 == null && p2 == null) || (p1 != null && p2 != null)) {
            this.vista.agregarDetalle("Debe seleccionar un único personaje en alguna de las dos listas.");
        } else {
            objetivo = (p1 != null) ? p1 : p2;
            try {
                double x = Double.parseDouble(this.vista.getTextX());
                double y = Double.parseDouble(this.vista.getTextY());

                this.mapa.mueve(objetivo, x, y);
                this.vista.agregarDetalle(objetivo.getNombre() + " se movió a x: " + objetivo.getPosx() + " y: " + objetivo.getPosy() + ".");
                this.vista.refrescarListas();
            } catch (NumberFormatException ex) {
                this.vista.mostrarAviso("Debe ingresar coordenadas numéricas válidas.", "Coordenadas Inválidas");
            } catch (Exception ex) {
                this.vista.mostrarError(ex.getMessage(), "Error al mover");
            }
        }
        this.vista.limpiarSelecciones();
    }

    private void crearPersonaje(String tipo) {
        String nombre = this.vista.getNombreIngresado();

        if (nombre.isEmpty()) {
            this.vista.mostrarAviso("Debe ingresar el nombre", "Aviso");
            return;
        }

        try {
            Posicion pos = new Posicion(0, 0);
            Personaje nuevo = PersonajeFactory.crearPersonaje(tipo, nombre, pos);
            this.mapa.agregarPersonaje(nuevo);
            this.vista.agregarPersonaje(nuevo);
            this.vista.agregarDetalle(tipo + " " + nombre + " creado con éxito.");
            this.vista.limpiarNombre();
        } catch (Exception ex) {
            this.vista.mostrarError(ex.getMessage(), "Error");
        }
    }
}