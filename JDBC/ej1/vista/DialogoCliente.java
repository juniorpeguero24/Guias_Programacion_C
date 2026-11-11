package vista;

import modelo.Cliente;

import javax.swing.*;
import java.awt.*;

public class DialogoCliente extends DialogoBase {
    private final JTextField txtNombre = new JTextField(20);
    private final JTextField txtTelefono = new JTextField(20);
    private final JTextField txtDireccion = new JTextField(20);
    private final JTextField txtEmail = new JTextField(20);

    public DialogoCliente(Frame padre) {
        super(padre, "Alta de cliente");
        agregarCampo("Nombre:", txtNombre);
        agregarCampo("Teléfono:", txtTelefono);
        agregarCampo("Dirección:", txtDireccion);
        agregarCampo("Email:", txtEmail);
    }

    @Override
    protected boolean validar() {
        if (!obligatorio(txtNombre, "Nombre") || !obligatorio(txtEmail, "Email")) return false;
        if (!txtEmail.getText().contains("@")) {
            error("El email no parece válido.");
            return false;
        }
        return true;
    }

    /** Llamar solo si mostrar() devolvió true. */
    public Cliente getCliente() {
        return new Cliente(txtNombre.getText().trim(), txtTelefono.getText().trim(),
                txtDireccion.getText().trim(), txtEmail.getText().trim());
    }
}
