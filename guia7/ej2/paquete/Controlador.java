package paquete;

import vista.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private VistaPrincipal vista;
    private ListaConPrioridades<Llamado> modelo;

    public Controlador(VistaPrincipal vista) {
        this.vista = vista;
        this.modelo = new ListaConPrioridades<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Ingresar Llamado")) {
            String dni=
        }
    }
}
