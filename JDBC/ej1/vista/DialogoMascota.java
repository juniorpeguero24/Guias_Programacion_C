package vista;

import modelo.Mascota;

import javax.swing.*;
import java.awt.*;

public class DialogoMascota extends DialogoBase {
    private final JTextField txtNombre = new JTextField(20);
    private final JComboBox<String> cmbAnimal = new JComboBox<>(
            new String[]{"Perro", "Gato", "Conejo", "Ave", "Hámster", "Otro"});
    private final JTextField txtNacimiento = new JTextField(10);
    private final JTextArea txtHistoria = new JTextArea(4, 20);

    public DialogoMascota(Frame padre, String nombreDueño) {
        super(padre, "Alta de mascota de " + nombreDueño);
        cmbAnimal.setEditable(true);                     // permite escribir otro animal
        txtHistoria.setLineWrap(true);
        txtHistoria.setWrapStyleWord(true);
        agregarCampo("Nombre:", txtNombre);
        agregarCampo("Animal:", cmbAnimal);
        agregarCampo("Nacimiento (dd/mm/aaaa):", txtNacimiento);
        agregarCampo("Historia clínica:", new JScrollPane(txtHistoria));
    }

    @Override
    protected boolean validar() {
        if (!obligatorio(txtNombre, "Nombre")) return false;
        Object animal = cmbAnimal.getSelectedItem();
        if (animal == null || animal.toString().trim().isEmpty()) {
            error("El campo \"Animal\" es obligatorio.");
            return false;
        }
        return fechaValida(txtNacimiento, "Nacimiento", false);
    }

    public Mascota getMascota() {
        return new Mascota(txtNombre.getText().trim(), cmbAnimal.getSelectedItem().toString().trim(),
                leerFecha(txtNacimiento), txtHistoria.getText().trim());
    }
}
