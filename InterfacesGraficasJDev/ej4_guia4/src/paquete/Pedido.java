package paquete;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Pedido extends ConjuntoGenericoOrdenado<LineaDePedido> {
    private Empleado empleado;
    private GregorianCalendar fecha;

    public Pedido(Empleado empleado) {
        this.empleado = empleado;
        this.fecha = new GregorianCalendar();
    }

    public String detalle(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha = (this.fecha != null) ? sdf.format(this.fecha.getTime()):"Sin fecha";
        String detalle= "Fecha: "+fecha+"\n"+
                "Empleado: "+empleado.toString() +"\n"+
                "Pedido: \n";
        Iterator<LineaDePedido> it = this.getIterator();
        while (it.hasNext()) {
            detalle += it.next().toString()+"\n";
        }
        return detalle;
    }

    public double precioTotal(){
        Iterator<LineaDePedido> it = this.getIterator();
        double total=0;
        while (it.hasNext()) {
            LineaDePedido lp = it.next();
            total += (lp.getCantidad() * lp.getProducto().getPrecioUnitario());
        }
        return total;
    }
}
