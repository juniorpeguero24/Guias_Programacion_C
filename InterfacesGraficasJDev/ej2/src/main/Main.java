package main;

import controlador.ControladorBuscaminas;

import modelo.Buscaminas;

import vista.VentanaBuscamina;

public class Main {

    public static void main(String[] args) {
        VentanaBuscamina vista=new VentanaBuscamina();
        new ControladorBuscaminas(vista);
        vista.setVisible(true);
    }
}
