import controlador.Controlador;
import modelo.Veterinaria;
import vista.VistaPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Veterinaria modelo = new Veterinaria();
            VistaPrincipal vista = new VistaPrincipal();
            Controlador controlador = new Controlador(modelo, vista);
            vista.setControlador(controlador);
            vista.arranca();
            controlador.iniciar();
        });
    }
}