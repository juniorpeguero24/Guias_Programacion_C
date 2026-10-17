package controlador;


import excepciones.FueraTableroException;
import excepciones.ParametrosInvalidosException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Buscaminas;

import vista.VentanaBuscamina;

public class ControladorBuscaminas implements ActionListener,KeyListener{
    private VentanaBuscamina vista;
    private Buscaminas modelo;
    private int casillasDescubiertas=0;

    public ControladorBuscaminas(VentanaBuscamina vista) {
        this.vista = vista;
        this.vista.setControlador(this);
    }


    @Override
    @SuppressWarnings("oracle.jdeveloper.java.insufficient-catch-block")
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        if ("Aceptar".equals(cmd)){
            this.casillasDescubiertas = 0;
            int ancho = Integer.parseInt(this.vista.getTxtAncho());
            int alto= Integer.parseInt(this.vista.getTxtAlto());
            int minas = Integer.parseInt(this.vista.getTxtMinas());
            try {
                this.modelo = new Buscaminas(ancho, alto, minas);
                this.vista.generarTablero(alto, ancho, this);
                this.vista.deshabilitarCampos();
            } catch (ParametrosInvalidosException e) {
            }
        }else{
            String[] pos = actionEvent.getActionCommand().split(",");
            int i = Integer.parseInt(pos[0]);
            int j = Integer.parseInt(pos[1]);

            try {
                if (this.modelo.isMina(i, j)) {
                    marcaTodas();
                    this.vista.mostrarCartelFinJuego("¡Perdiste! Pisaste una mina.", "Fin del juego");
                    this.vista.habilitarCampos();
                }else{
                    int cercas = this.modelo.getMinasCercanas(i, j);
                    this.vista.marcarCasillaNumero(i, j, cercas);
                    this.casillasDescubiertas++;
                    int totalLibres = (this.modelo.getAlto() * this.modelo.getAncho()) - this.modelo.getMinas();
                    if (this.casillasDescubiertas == totalLibres) {
                        this.vista.mostrarCartelFinJuego("¡Felicitaciones! Has ganado el juego.", "Victoria");
                        this.vista.habilitarCampos();
                    }
                }
            } catch (FueraTableroException e) {
            }
        }
    }
    
    private void marcaTodas() throws FueraTableroException {
        for (int i = 0; i < this.modelo.getAlto(); i++) {
            for (int j = 0; j < this.modelo.getAncho();j++) {
                if (this.modelo.isMina(i, j))
                    this.vista.marcarCasillaMina(i, j);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // TODO Implement this method
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        // TODO Implement this method
    }

    @Override
    @SuppressWarnings("oracle.jdeveloper.java.insufficient-catch-block")
    public void keyReleased(KeyEvent keyEvent) {
        String sAncho = this.vista.getTxtAncho();
        String sAlto = this.vista.getTxtAlto();
        String sMinas = this.vista.getTxtMinas();
        boolean esValido=false;
        
        try{
            int ancho = Integer.parseInt(sAncho);
            int alto= Integer.parseInt(sAlto);
            int minas = Integer.parseInt(sMinas);
            if (ancho > 0 && ancho <= 20 && alto > 0 && alto <= 20 && minas >= 0 && minas <= (ancho * alto)) {
                esValido = true;
                }
        }catch (NumberFormatException ex){
            esValido=false;
        }
        this.vista.setAceptarEnabled(esValido);
    }
}
