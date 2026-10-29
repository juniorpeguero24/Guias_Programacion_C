package paquete;

import vista.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

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
            try {
                String nombre = this.vista.getNombre().trim();
                String domicilio = this.vista.getDomicilio().trim();
                int dni = this.vista.getDni();
                int prioridad = this.vista.getPrioridad();

                if (!nombre.isEmpty() && !domicilio.isEmpty() && dni > 0 && prioridad > 0) {
                    this.modelo.agrega(new Llamado(prioridad, new Socio(dni, domicilio, nombre)));
                    this.vista.actualizaCont(this.modelo.getCantidad());
                } else {
                    this.vista.muestraError("Debe completar todos los campos correctamente.");
                }
            } catch (NumberFormatException ex) {
                this.vista.muestraError("El DNI debe ser un número entero válido.");
            }
        } else if (cmd.equals("Atender llamado más urgente")) {
            if (this.modelo.getCantidad()>0) {
                Llamado llamado=this.modelo.getElemento();
                llamado.setFechahoraAtendido(new GregorianCalendar());
                this.vista.mostrarLlamadoAtendido(llamado);
                this.vista.actualizaCont(this.modelo.getCantidad());
            }else{
                this.vista.muestraError("No hay llamados pendientes.");
            }
        }
    }
}
