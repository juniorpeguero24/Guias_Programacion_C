package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import modelo.Personaje;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelPersonajes;
	private JPanel panelAcciones;
	private JScrollPane scrollPaneL1;
	private JPanel panel;
	private JScrollPane scrollPaneL2;
	private JButton btnAtacar;
	private JList<Personaje> listL1;
	private JList<Personaje> listL2;
	private DefaultListModel<Personaje> modeloPersonaje;
	private JPanel panelCreaPersonaje;
	private JLabel lblNewLabel;
	private JTextField textNombre;
	private JButton btnArquero;
	private JButton btnGuerrero;
	private JButton btnCaballero;
	private JButton btnCrearDragon;
	private JPanel panel_1, panel_2, panel_3, panel_4, panel_11;
	private JPanel panelPosicion;
	private JLabel lblNewLabel_1, lblNewLabel_2;
	private JTextField textX, textY;
	private JButton btnMover;
	private JPanel panel_5, panel_6, panel_7, panel_8, panel_9, panel_10;
	private JPanel panelDetalles;
	private JTextArea textAreaDetalles;
	private JScrollPane scrollPaneDetalles;

	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 409);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);

		this.panelPersonajes = new JPanel();
		this.contentPane.add(this.panelPersonajes, BorderLayout.CENTER);
		this.panelPersonajes.setLayout(new GridLayout(0, 3, 0, 0));

		this.modeloPersonaje = new DefaultListModel<Personaje>();

		this.listL1 = new JList<Personaje>(this.modeloPersonaje);
		this.scrollPaneL1 = new JScrollPane(this.listL1);
		this.panelPersonajes.add(this.scrollPaneL1);

		this.panel = new JPanel();
		this.panelPersonajes.add(this.panel);

		this.btnAtacar = new JButton("Atacar");
		this.panel.add(this.btnAtacar);

		this.listL2 = new JList<Personaje>(this.modeloPersonaje);
		this.scrollPaneL2 = new JScrollPane(this.listL2);
		this.panelPersonajes.add(this.scrollPaneL2);

		this.panelAcciones = new JPanel();
		this.contentPane.add(this.panelAcciones, BorderLayout.EAST);
		this.panelAcciones.setLayout(new GridLayout(0, 1, 0, 0));

		this.panelCreaPersonaje = new JPanel();
		this.panelAcciones.add(this.panelCreaPersonaje);
		this.panelCreaPersonaje.setLayout(new GridLayout(0, 1, 0, 0));

		this.panel_1 = new JPanel();
		this.panelCreaPersonaje.add(this.panel_1);
		this.lblNewLabel = new JLabel("Nombre:");
		this.panel_1.add(this.lblNewLabel);
		this.textNombre = new JTextField();
		this.panel_1.add(this.textNombre);
		this.textNombre.setColumns(10);

		this.panel_2 = new JPanel();
		this.panelCreaPersonaje.add(this.panel_2);
		this.btnArquero = new JButton("Arquero");
		this.panel_2.add(this.btnArquero);

		this.panel_3 = new JPanel();
		this.panelCreaPersonaje.add(this.panel_3);
		this.btnGuerrero = new JButton("Guerrero");
		this.panel_3.add(this.btnGuerrero);

		this.panel_4 = new JPanel();
		this.panelCreaPersonaje.add(this.panel_4);
		this.btnCaballero = new JButton("Caballero");
		this.panel_4.add(this.btnCaballero);

		this.panel_11 = new JPanel();
		this.panelCreaPersonaje.add(this.panel_11);
		this.btnCrearDragon = new JButton("Dragon");
		this.panel_11.add(this.btnCrearDragon);

		this.panelPosicion = new JPanel();
		this.panelAcciones.add(this.panelPosicion);
		this.panelPosicion.setLayout(new GridLayout(0, 1, 0, 0));

		this.panel_10 = new JPanel();
		this.panelPosicion.add(this.panel_10);
		this.panel_10.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_5 = new JPanel();
		this.panel_10.add(this.panel_5);
		this.lblNewLabel_1 = new JLabel("X:");
		this.panel_5.add(this.lblNewLabel_1);
		this.panel_6 = new JPanel();
		this.panel_10.add(this.panel_6);
		this.textX = new JTextField();
		this.panel_6.add(this.textX);
		this.textX.setColumns(10);

		this.panel_7 = new JPanel();
		this.panel_10.add(this.panel_7);
		this.lblNewLabel_2 = new JLabel("Y:");
		this.panel_7.add(this.lblNewLabel_2);
		this.panel_8 = new JPanel();
		this.panel_10.add(this.panel_8);
		this.textY = new JTextField();
		this.panel_8.add(this.textY);
		this.textY.setColumns(10);

		this.panel_9 = new JPanel();
		this.panelPosicion.add(this.panel_9);
		this.btnMover = new JButton("Mover");
		this.panel_9.add(this.btnMover);

		this.panelDetalles = new JPanel();
		this.contentPane.add(this.panelDetalles, BorderLayout.SOUTH);
		this.panelDetalles.setLayout(new GridLayout(0, 1, 0, 0));

		this.textAreaDetalles = new JTextArea();
		this.scrollPaneDetalles = new JScrollPane(this.textAreaDetalles);
		this.panelDetalles.add(this.scrollPaneDetalles);
		this.scrollPaneDetalles.setPreferredSize(new Dimension(100, 100));
	}

	// Registro del listener delegado desde el Controlador
	public void setControlador(ActionListener listener) {
		this.btnAtacar.addActionListener(listener);
		this.btnArquero.addActionListener(listener);
		this.btnGuerrero.addActionListener(listener);
		this.btnCaballero.addActionListener(listener);
		this.btnCrearDragon.addActionListener(listener);
		this.btnMover.addActionListener(listener);
	}

	// Getters para consultar la UI
	public String getNombreIngresado() {
		return this.textNombre.getText().trim();
	}

	public String getTextX() {
		return this.textX.getText().trim();
	}

	public String getTextY() {
		return this.textY.getText().trim();
	}

	public Personaje getPersonajeSeleccionadoAtacante() {
		return this.listL1.getSelectedValue();
	}

	public Personaje getPersonajeSeleccionadoDefensor() {
		return this.listL2.getSelectedValue();
	}

	// Métodos para actualizar elementos visuales
	public void agregarPersonaje(Personaje p) {
		this.modeloPersonaje.addElement(p);
	}

	public void cargarPersonajesIniciales(List<Personaje> lista) {
		this.modeloPersonaje.clear();
		if (lista != null) {
			for (Personaje p : lista) {
				this.modeloPersonaje.addElement(p);
			}
		}
	}

	public void refrescarListas() {
		this.listL1.repaint();
		this.listL2.repaint();
	}

	public void limpiarSelecciones() {
		this.listL1.clearSelection();
		this.listL2.clearSelection();
	}

	public void limpiarNombre() {
		this.textNombre.setText("");
	}

	public void agregarDetalle(String texto) {
		this.textAreaDetalles.append(texto + "\n");
	}

	public void mostrarAviso(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
	}

	public void mostrarError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
}