package paquete;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

public class OperadoraEmergencias extends ListaConPrioridades<Llamado>{
    private ArrayList<Llamado> listaAtendidos;

    public OperadoraEmergencias() {
        this.listaAtendidos = new ArrayList<>();
    }

    public int cantidadLlamados(Socio socio) {
        int cont=0;
        for (Llamado ll : this.listaAtendidos) {
            if (socio.equals(ll.getSocio())) {
                cont++;
            }
        }
        return cont;
    }

    public Iterator<Llamado> getLlamadosAtendidos() {
        return this.listaAtendidos.iterator();
    }

    public Socio getSocioMasEmergencias() {
        if (this.listaAtendidos.isEmpty()) {
            return null;
        }
        int max=-1;
        Socio s = null;
        for (Llamado ll : this.listaAtendidos) {
            int actual = cantidadLlamados(ll.getSocio());
            if (actual > max) {
                max = actual;
                s = ll.getSocio();
            }
        }
        return s;
    }

    @Override
    public Llamado getElemento() {
        Llamado llamado= super.getElemento();
        if (llamado != null) {
            llamado.setFechahoraAtendido(new GregorianCalendar());
            this.listaAtendidos.add(llamado);
        }
        return llamado;
    }
}
