package vista;

import modelo.Practica;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class DialogoPractica extends DialogoBase {
    private final JComboBox<String> cmbDescripcion = new JComboBox<>(
            new String[]{"Consulta", "Vacunación", "Vacuna antirrábica", "Desparasitación", "Castración", "Control"});
    private final JTextField txtFecha = new JTextField(10);
    private final JTextField txtVencimiento = new JTextField(10);
    private final JTextArea txtComentarios = new JTextArea(3, 20);

    public DialogoPractica(Frame padre, String nombreMascota) {
        super(padre, "Nueva práctica para " + nombreMascota);
        cmbDescripcion.setEditable(true);                // permite escribir otra práctica
        txtFecha.setText(LocalDate.now().format(FORMATO)); // por defecto, hoy
        txtComentarios.setLineWrap(true);
        txtComentarios.setWrapStyleWord(true);
        agregarCampo("Descripción:", cmbDescripcion);
        agregarCampo("Fecha (dd/mm/aaaa):", txtFecha);
        agregarCampo("Vence (opcional):", txtVencimiento);
        agregarCampo("Comentarios:", new JScrollPane(txtComentarios));
    }

    @Override
    protected boolean validar() {
        Object desc = cmbDescripcion.getSelectedItem();
        if (desc == null || desc.toString().trim().isEmpty()) {
            error("El campo \"Descripción\" es obligatorio.");
            return false;
        }
        if (!fechaValida(txtFecha, "Fecha", true)) return false;
        if (!fechaValida(txtVencimiento, "Vence", false)) return false;
        LocalDate venc = leerFecha(txtVencimiento);
        if (venc != null && venc.isBefore(leerFecha(txtFecha))) {
            error("El vencimiento no puede ser anterior a la fecha de la práctica.");
            return false;
        }
        return true;
    }

    public Practica getPractica() {
        return new Practica(cmbDescripcion.getSelectedItem().toString().trim(), txtComentarios.getText().trim(),
                leerFecha(txtFecha), leerFecha(txtVencimiento));
    }
}
