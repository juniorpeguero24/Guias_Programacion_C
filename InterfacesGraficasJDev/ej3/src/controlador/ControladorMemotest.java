package controlador;

import exceptions.ParametrosInvalidosException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import modelo.Memotest;
import modelo.Tablero;

import vista.DialogJugadores;
import vista.VistaPrincipal;

public class ControladorMemotest implements ActionListener,KeyListener{
        private VistaPrincipal vista;
        private Memotest modelo;
        private DialogJugadores dialogJugadores;
        private int primerI = -1;
        private int primerJ = -1;
        private boolean esperandoSegundoClic = false;
        private int parejasDescubiertas=0;
        private int totalParejas;
        private ArrayList<String> nombresJugadores = new ArrayList<>();

    public ControladorMemotest(VistaPrincipal vista) {
        this.vista = vista;
        this.vista.setControlador(this);

        this.dialogJugadores = new DialogJugadores();
        this.dialogJugadores.setControlador(this);
        this.dialogJugadores.arranca();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String cmd = actionEvent.getActionCommand();
        if ("Aceptar".equals(cmd)){
            int alto = Integer.parseInt(this.vista.getTxtAlto());
            int ancho = Integer.parseInt(this.vista.getTxtAncho());
            try {
                this.modelo = new Memotest(new Tablero(ancho, alto));
                for (String nom : this.nombresJugadores) {
                    this.modelo.agregar(nom);
                }
                this.vista.generarTablero(alto, ancho, this);
                this.vista.actualizarLista(this.modelo.getArreglo());
                this.vista.setTurnoActual(this.modelo.getJugadorActual().getNombre());
                this.totalParejas = (alto * ancho) / 2;
            } catch (ParametrosInvalidosException e) {
            }
        }else if ("Agregar".equals(cmd)) {
            String nombre = this.dialogJugadores.getNombre();
            if (!nombre.isEmpty()) {
                this.nombresJugadores.add(nombre);
                this.dialogJugadores.actualizarListaNombres(this.nombresJugadores);
            }
        } else if ("OK".equals(cmd)) {
            if (!this.nombresJugadores.isEmpty()) {
                this.dialogJugadores.dispose();
                this.vista.arranca();
            } else {
                this.dialogJugadores.errorOk("Debe agregar al menos un jugador.", "Aviso");
            }
        } else{
            String[] pos = actionEvent.getActionCommand().split(",");
            int i = Integer.parseInt(pos[0]);
            int j = Integer.parseInt(pos[1]);
            if (!this.esperandoSegundoClic) { //primera eleccion
                int id = this.modelo.getTablero().getFigura(i, j);
                this.vista.mostrarFigura(i, j, id);
                this.primerI = i;
                this.primerJ = j;
                this.esperandoSegundoClic = true;
            } else if (i != this.primerI || j != this.primerJ) {
                int id = this.modelo.getTablero().getFigura(i, j);
                this.vista.mostrarFigura(i, j, id);
                int primerId = this.modelo.getTablero().getFigura(this.primerI, this.primerJ);

                if (primerId == id) {
                    // Coinciden: quedan destapadas y deshabilitadas
                    this.vista.deshabilitarCasilla(this.primerI, this.primerJ);
                    this.vista.deshabilitarCasilla(i, j);
                    this.modelo.sumarAcierto();
                    this.vista.actualizarLista(this.modelo.getArreglo());
                    this.esperandoSegundoClic = false;
                    this.parejasDescubiertas++;
                    if (this.totalParejas == this.parejasDescubiertas) {
                        this.vista.ganador(this.modelo.getGanador());
                    }
                } else {
                    // No coinciden: guardamos las coordenadas para el timer
                    int f1 = this.primerI;
                    int c1 = this.primerJ;
                    int f2 = i;
                    int c2 = j;

                    // Esperar 800 milisegundos para taparlas
                    javax.swing.Timer timer = new javax.swing.Timer(800, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            vista.taparFigura(f1, c1);
                            vista.taparFigura(f2, c2);
                            modelo.avanzaTurno();
                            vista.setTurnoActual(modelo.getJugadorActual().getNombre());
                            esperandoSegundoClic = false; // Recién acá volvemos a habilitar los clics
                        }
                    });
                    timer.setRepeats(false); // Solo se ejecuta una vez
                    timer.start();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        boolean esValido= false;
        try {
            int alto = Integer.parseInt(this.vista.getTxtAlto());
            int ancho = Integer.parseInt(this.vista.getTxtAncho());
            if (ancho > 0 && alto > 0 && (ancho*alto) % 2 == 0)
                esValido=true;
        } catch (NumberFormatException ignored) {
        }
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
