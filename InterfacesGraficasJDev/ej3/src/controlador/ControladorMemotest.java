package controlador;

import exceptions.ParametrosInvalidosException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.Memotest;
import modelo.Tablero;

import vista.VistaMemotest;

public class ControladorMemotest implements ActionListener,KeyListener{
        private VistaMemotest vista;
        private Memotest modelo;
        private int primerI = -1;
        private int primerJ = -1;
        private boolean esperandoSegundoClic = false;

    public ControladorMemotest(VistaMemotest vista) {
        this.vista = vista;
        this.vista.setControlador(this);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        if ("Aceptar".equals(cmd)){
            int alto = Integer.parseInt(this.vista.getTxtAlto());
            int ancho = Integer.parseInt(this.vista.getTxtAncho());
            try {
                this.modelo = new Memotest(new Tablero(ancho,alto));
                this.vista.generarTablero(alto,ancho,this);
                this.vista.setTurnoActual(this.modelo.getJugadorActual().getNombre());
            } catch (ParametrosInvalidosException e) {
            }
        }else{
            String pos[] = actionEvent.getActionCommand().split(",");
            int i = Integer.parseInt(pos[0]);
            int j = Integer.parseInt(pos[1]);
            if (!this.esperandoSegundoClic){
                int id = this.modelo.getTablero().getFigura(i, j);
                this.vista.mostrarFigura(i, j, id);
                this.primerI=i;
                this.primerJ = j;
                this.esperandoSegundoClic=true;
            }else if (i != this.primerI && j != this.primerJ) {
                int id = this.modelo.getTablero().getFigura(i, j);
                this.vista.mostrarFigura(i, j, id);
                int primerId = this.modelo.getTablero().getFigura(i, j);
                if (primerId == id) {
                    this.vista.deshabilitarCasilla(this.primerI, this.primerJ);
                    this.vista.deshabilitarCasilla(i, j);
                    this.modelo.sumarAcierto();
                    this.esperandoSegundoClic = false;
                    
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int alto = Integer.parseInt(this.vista.getTxtAlto());
        int ancho = Integer.parseInt(this.vista.getTxtAncho());
        boolean esValido=false;
        
        if (ancho > 0 && alto > 0 && ancho*alto % 2 != 0)
            esValido=true;
        this.vista.setAceptarEnabled(esValido);

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        // TODO Implement this method
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        // TODO Implement this method
    }
}
