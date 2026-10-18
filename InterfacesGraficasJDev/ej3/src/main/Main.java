package main;

import controlador.ControladorMemotest;
import vista.VistaPrincipal;

public class Main {
    public static void main(String[] args) {
        VistaPrincipal vista = new VistaPrincipal();
        ControladorMemotest controlador = new ControladorMemotest(vista);
    }
}
