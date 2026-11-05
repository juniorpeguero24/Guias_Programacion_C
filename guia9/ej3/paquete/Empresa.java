package paquete;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {
    private ArrayList<Socio> socios;
    private OperadoraEmergencias operadora;   // tiene los pendientes (cola) y los atendidos (historico)

    public Empresa() {                        // requerido por XMLDecoder
        this.socios = new ArrayList<>();
        this.operadora = new OperadoraEmergencias();
    }

    // ===================== OPERACIONES =====================

    public void agregarSocio(Socio socio) {
        this.socios.add(socio);
    }

    public void registrarLlamado(Llamado llamado) {
        this.operadora.agrega(llamado);
    }

    /** Atiende el llamado mas urgente: sale de la cola y pasa al historico. */
    public Llamado atenderProximoLlamado() {
        return this.operadora.getElemento();
    }

    // ===================== LISTADOS DE LA CONSIGNA =====================

    /** Proximo llamado que sera atendido (sin atenderlo). null si no hay pendientes. */
    public Llamado getProximoLlamado() {
        return this.operadora.consultaElemento();
    }

    /** Llamados pendientes, en el orden en que van a ser atendidos. */
    public ArrayList<Llamado> getLlamadosNoAtendidos() {
        return this.operadora.listarEnOrden();
    }

    /** Historico de llamados atendidos, en el orden en que se atendieron. */
    public ArrayList<Llamado> getLlamadosAtendidos() {
        return new ArrayList<>(this.operadora.getListaAtendidos());
    }

    public Socio getSocioMasEmergencias() {
        return this.operadora.getSocioMasEmergencias();
    }

    // ===================== GETTERS Y SETTERS (para XML) =====================

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }

    public OperadoraEmergencias getOperadora() {
        return operadora;
    }

    public void setOperadora(OperadoraEmergencias operadora) {
        this.operadora = operadora;
    }
}