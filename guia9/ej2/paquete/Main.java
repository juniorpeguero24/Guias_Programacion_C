package paquete;

import controlador.Controlador;
import vista.Vista;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Negocio negocio = new Negocio();
        negocio.cargarDatosDePrueba();
        Controlador controlador = new Controlador(negocio, vista);
        vista.setControlador(controlador);
        vista.arranca();
    }

}