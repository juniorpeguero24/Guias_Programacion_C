package paquete;

import persistencia.IPersistencia;
import persistencia.PersistenciaBin;
import persistencia.PersistenciaXML;

import java.io.IOException;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        cargarDatosDePrueba(empresa);

        // Se atienden 4 llamados antes de guardar
        for (int i = 0; i < 4; i++) {
            empresa.atenderProximoLlamado();
        }

        probar("BINARIO", new PersistenciaBin(), empresa, "empresa.ser");
        probar("XML", new PersistenciaXML(), empresa, "empresa.xml");
    }

    private static void cargarDatosDePrueba(Empresa empresa) {
        Socio mariana = new Socio(30111222, "Av. Colon 2450", "Mariana Rios");
        Socio hector  = new Socio(27555888, "Guemes 3120", "Hector Benitez");
        Socio camila  = new Socio(41222333, "San Martin 1875", "Camila Ferreyra");
        Socio ramiro  = new Socio(35999444, "Independencia 980", "Ramiro Ledesma");
        Socio elena   = new Socio(22333111, "Juan B. Justo 4410", "Elena Sosa");

        empresa.agregarSocio(mariana);
        empresa.agregarSocio(hector);
        empresa.agregarSocio(camila);
        empresa.agregarSocio(ramiro);
        empresa.agregarSocio(elena);

        empresa.registrarLlamado(llamado(hector,  2,  8,  5));
        empresa.registrarLlamado(llamado(mariana, 1,  8, 12));
        empresa.registrarLlamado(llamado(elena,   3,  8, 20));
        empresa.registrarLlamado(llamado(hector,  3,  8, 31));
        empresa.registrarLlamado(llamado(camila,  1,  8, 45));
        empresa.registrarLlamado(llamado(ramiro,  2,  9,  2));
        empresa.registrarLlamado(llamado(elena,   2,  9, 10));
        empresa.registrarLlamado(llamado(hector,  1,  9, 25));
    }

    /** Crea un llamado con hora de pedido fija (05/11/2026), para que no empaten en milisegundos. */
    private static Llamado llamado(Socio socio, int prioridad, int hora, int minuto) {
        Llamado ll = new Llamado(prioridad, socio);
        ll.setFechahoraPedido(new GregorianCalendar(2026, GregorianCalendar.NOVEMBER, 5, hora, minuto));
        return ll;
    }

    private static void probar(String formato, IPersistencia persistencia, Empresa original, String archivo) {
        try {
            guardar(persistencia, original, archivo);
            Empresa leida = cargar(persistencia, archivo);
            System.out.println("############ EMPRESA LEIDA DESDE " + formato + " ############");
            listar(leida);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en " + formato + ": " + e);
        }
    }

    private static void guardar(IPersistencia persistencia, Empresa empresa, String archivo) throws IOException {
        persistencia.abrirOutput(archivo);
        try {
            persistencia.escribir(empresa);
        } finally {
            persistencia.cerrarOutput();
        }
    }

    private static Empresa cargar(IPersistencia persistencia, String archivo)
            throws IOException, ClassNotFoundException {
        persistencia.abrirInput(archivo);
        try {
            return (Empresa) persistencia.leer();
        } finally {
            persistencia.cerrarInput();
        }
    }

    private static void listar(Empresa empresa) {
        System.out.println("\n--- Socios ---");
        for (Socio s : empresa.getSocios()) {
            System.out.println(s);
        }

        System.out.println("\n--- Llamados no atendidos (en orden de atencion) ---");
        for (Llamado ll : empresa.getLlamadosNoAtendidos()) {
            System.out.println(ll);
        }

        System.out.println("\n--- Proximo llamado a atender ---");
        Llamado prox = empresa.getProximoLlamado();
        System.out.println(prox != null ? prox : "No hay llamados pendientes");

        System.out.println("\n--- Historico de llamados atendidos ---");
        for (Llamado ll : empresa.getLlamadosAtendidos()) {
            System.out.println(ll);
        }

        Socio top = empresa.getSocioMasEmergencias();
        System.out.println("\nSocio con mas emergencias atendidas: "
                + (top != null ? top.getNombre() : "ninguno"));
        System.out.println();
    }
}