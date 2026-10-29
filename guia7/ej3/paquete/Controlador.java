package paquete;

import vista.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private VistaPrincipal vista;
    private ConjuntoGenerico modelo;

    public Controlador(VistaPrincipal vista) {
        this.vista = vista;
        this.modelo = new ConjuntoGenerico<>();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Agregar")) {
            try {
                String apellido = this.vista.getTxtApellido();
                String nombre = this.vista.getTxtNombre();
                String domicilio = this.vista.getTxtDomicilio();
                this.modelo.agrega(new Persona(apellido, nombre, domicilio));
                this.vista.actualizarCardinal(this.modelo.getCardinal());
                this.vista.actualizarLista(this.modelo.getIterator());
            } catch (OperacionConjuntosException ex) {
                this.vista.muestraError(ex.getMessage(), ex.getElemento());
            }
        } else if (cmd.equals("Eliminar")) {
                try {
                    Object elemento = this.vista.getElemento();
                    if (elemento != null) {
                        this.modelo.elimina(elemento);
                    }else {
                        String apellido = this.vista.getTxtApellido();
                        String nombre = this.vista.getTxtNombre();
                        String domicilio = this.vista.getTxtDomicilio();
                        Persona p = new Persona(apellido, nombre, domicilio);
                        this.modelo.elimina(p);
                    }
                    this.vista.actualizarCardinal(this.modelo.getCardinal());
                    this.vista.actualizarLista(this.modelo.getIterator());
                } catch (OperacionConjuntosException ex) {
                    this.vista.muestraError(ex.getMessage(), ex.getElemento());
                }
        } else if (cmd.equals("Consultar")) {
            this.vista.actualizarLista(this.modelo.getIterator());
        }
    }
}

