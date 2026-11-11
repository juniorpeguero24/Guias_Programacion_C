package controlador;

import paquete.Negocio;
import dao.IPersistencia;
import dao.PersistenciaBIN;
import dao.PersistenciaXML;
import vista.Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controlador implements ActionListener {
    private static final String ARCHIVO_BIN = "negocio.ser";
    private static final String ARCHIVO_XML = "negocio.xml";

    private final Vista vista;
    private Negocio modelo;
    private final IPersistencia pBin = new PersistenciaBIN();
    private final IPersistencia pXML = new PersistenciaXML();

    public Controlador(Negocio modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        listar();                                    // mostrar los datos apenas arranca
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if ("Guardar BIN".equals(cmd)) {
            guardar(pBin, ARCHIVO_BIN);
        } else if ("Guardar XML".equals(cmd)) {
            guardar(pXML, ARCHIVO_XML);
        } else if ("Cargar BIN".equals(cmd)) {
            cargar(pBin, ARCHIVO_BIN);
        } else if ("Cargar XML".equals(cmd)) {
            cargar(pXML, ARCHIVO_XML);
        }
    }

    private void guardar(IPersistencia p, String archivo) {
        try {
            p.abrirOutput(archivo);
            try {
                p.escribir(modelo);
            } finally {
                p.cerrarOutput();                    // se cierra aunque falle la escritura
            }
            vista.aviso("Negocio guardado en " + archivo);
        } catch (IOException ex) {
            vista.aviso("Error al guardar " + archivo + ": " + ex.getMessage());
        }
    }

    private void cargar(IPersistencia p, String archivo) {
        try {
            p.abrirInput(archivo);
            try {
                modelo = (Negocio) p.leer();
            } finally {
                p.cerrarInput();
            }
            listar();                                // refrescar con lo leído
            vista.aviso("Negocio cargado desde " + archivo);
        } catch (IOException ex) {
            vista.aviso("Error al cargar " + archivo + ": " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            vista.aviso("El archivo " + archivo + " no contiene un negocio válido");
        }
    }

    private void listar() {
        vista.listarProveedores(modelo.getProveedores());
        vista.listarProductos(modelo.getProductos());
        vista.listarPedidosNoEntregados(modelo.getPedidosNoEntregados());
        vista.listarDeudores(modelo.getProveedoresQueAdeudan());
    }
}