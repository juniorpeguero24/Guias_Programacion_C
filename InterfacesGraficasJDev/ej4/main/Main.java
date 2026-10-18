package main;

import controlador.ControladorEstacion;
import vista.VistaPrincipal;

public class Main {
    public static void main(String[] args) {
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        ControladorEstacion controladorEstacion = new ControladorEstacion(vistaPrincipal);
        vistaPrincipal.arranca();
    }
}
