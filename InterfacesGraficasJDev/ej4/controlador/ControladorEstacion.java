package controlador;

import exception.DatoCargaInvalido;
import exception.FaltaCombustibleException;
import modelo.Combustible;
import modelo.Deposito;
import modelo.Estacion;
import modelo.Surtidor;
import vista.DialogCrear;
import vista.VistaPrincipal;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEstacion implements ActionListener, ListSelectionListener {
    private Estacion modelo;
    private VistaPrincipal vista;
    private DialogCrear dialogCrear;
    private Surtidor surtidorActual;

    public ControladorEstacion(VistaPrincipal vista) {
        this.vista = vista;
        this.vista.setControlador(this);
        this.modelo = new Estacion();
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if ("Crear Surtidor".equals(cmd)) {
            DialogCrear dialogCrear=new DialogCrear();
            this.dialogCrear = dialogCrear;
            this.surtidorActual = new Surtidor();
            this.dialogCrear.setControlador(this);
            dialogCrear.arranca();
        } else if ("Agregar".equals(cmd)) {
            String combustible =this.dialogCrear.getTxtCombustible();
            Double precio=this.dialogCrear.getTxtPrecio();
            int cantidadMaxima=this.dialogCrear.getCantidadMaxima();
            this.surtidorActual.agregarDeposito(new Deposito(cantidadMaxima,new Combustible(combustible,precio)));
            this.dialogCrear.limpiaCampos();
        } else if ("OK".equals(cmd)) {
            this.dialogCrear.dispose();
            this.modelo.agregarSurtidor(surtidorActual);
            this.vista.actualizarSurtidores(this.modelo.getSurtidores());
        } else if ("Reponer".equals(cmd)) {
            this.modelo.reponerSurtidor(this.vista.getSelectedSurtidor(), this.vista.getSelectedCombustible());
            this.vista.actualizarSurtidores(this.modelo.getSurtidores());
        } else if ("Cargar".equals(cmd)) {
            int cantidad = this.vista.getTxtCantidad();
            try {
                this.modelo.cargarCombustible(this.vista.getSelectedCombustible(), cantidad, this.vista.getSelectedSurtidor());
            }catch (FaltaCombustibleException ex){
                DatoCargaInvalido dato = ex.getDato();
                this.vista.mensajeErrorFaltaCombustible(dato);
            }catch (Exception ex) {
                this.vista.errorCantidadNegativa("Cantidad Negativa");
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        Surtidor s = this.vista.getSelectedSurtidor();
        if (s != null) {
            this.vista.habilitarCombustible(true);
            this.vista.cargarComboCombustible(s.getDepositos());
        }
    }
}
