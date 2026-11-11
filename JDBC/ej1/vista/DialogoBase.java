package vista;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Diálogo modal genérico: una grilla de "etiqueta + campo" y los botones Aceptar / Cancelar.
 * Cada subclase agrega sus campos y valida/arma el objeto en aceptar().
 */
public abstract class DialogoBase extends JDialog {
    protected static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final JPanel campos = new JPanel(new GridBagLayout());
    private int fila = 0;
    private boolean aceptado = false;

    protected DialogoBase(Frame padre, String titulo) {
        super(padre, titulo, true);                      // true = modal
        JButton btnAceptar = new JButton("Aceptar");
        JButton btnCancelar = new JButton("Cancelar");
        btnAceptar.addActionListener(e -> {
            if (validar()) {
                aceptado = true;
                dispose();
            }
        });
        btnCancelar.addActionListener(e -> dispose());

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botones.add(btnCancelar);
        botones.add(btnAceptar);

        campos.setBorder(BorderFactory.createEmptyBorder(12, 12, 4, 12));
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(campos, BorderLayout.CENTER);
        getContentPane().add(botones, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(btnAceptar);      // Enter = Aceptar
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /** Agrega una fila "etiqueta: campo" al formulario. */
    protected void agregarCampo(String etiqueta, JComponent campo) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = fila++;
        c.insets = new Insets(4, 4, 4, 4);
        c.anchor = GridBagConstraints.NORTHWEST;
        c.gridx = 0;
        campos.add(new JLabel(etiqueta), c);
        c.gridx = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        campos.add(campo, c);
    }

    /** Muestra el diálogo y espera. Devuelve true si el usuario aceptó con datos válidos. */
    public boolean mostrar() {
        pack();
        setMinimumSize(new Dimension(380, getHeight()));
        setLocationRelativeTo(getOwner());
        setVisible(true);                                // bloquea hasta que se cierra (modal)
        return aceptado;
    }

    /** Cada subclase controla sus campos; si algo está mal, avisa y devuelve false. */
    protected abstract boolean validar();

    // ---------- utilidades para las subclases ----------

    protected boolean obligatorio(JTextField campo, String nombre) {
        if (campo.getText().trim().isEmpty()) {
            error("El campo \"" + nombre + "\" es obligatorio.");
            campo.requestFocus();
            return false;
        }
        return true;
    }

    /** Convierte un texto dd/MM/yyyy a LocalDate. Vacío -> null. Lanza excepción si el formato es inválido. */
    protected LocalDate leerFecha(JTextField campo) {
        String t = campo.getText().trim();
        return t.isEmpty() ? null : LocalDate.parse(t, FORMATO);
    }

    protected boolean fechaValida(JTextField campo, String nombre, boolean obligatoria) {
        try {
            LocalDate f = leerFecha(campo);
            if (f == null && obligatoria) {
                error("El campo \"" + nombre + "\" es obligatorio.");
                return false;
            }
            return true;
        } catch (DateTimeParseException ex) {
            error("La fecha \"" + nombre + "\" debe tener el formato dd/mm/aaaa.");
            campo.requestFocus();
            return false;
        }
    }

    protected void error(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Dato inválido", JOptionPane.WARNING_MESSAGE);
    }
}
