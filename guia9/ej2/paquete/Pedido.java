package paquete;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Date;                        // en vez de java.util.GregorianCalendar

public class Pedido extends ConjuntoGenericoOrdenado<LineaDePedido> implements Serializable {
    private Proveedor proveedor;
    private boolean entregado;
    private Date fecha;                            // el atributo


    public Pedido(Proveedor proveedor) {
        this.proveedor = proveedor;
        this.entregado = false;
        this.fecha = new Date();                       // en el constructor
    }

    public Pedido() {
    }

    public String detalle() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha = (this.fecha != null) ? sdf.format(this.fecha) : "Sin fecha";
        String detalle = "Fecha: " + fecha + "\n" +
                "Proveedor: " + proveedor.toString() + "\n" +
                "Pedido: \n";
        Iterator<LineaDePedido> it = this.getIterator();
        while (it.hasNext()) {
            detalle += it.next().toString() + "\n";
        }
        return detalle;
    }

    public void entregado() {
        entregado = true;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public double precioTotal() {
        Iterator<LineaDePedido> it = this.getIterator();
        double total = 0;
        while (it.hasNext()) {
            LineaDePedido lp = it.next();
            total += (lp.getCantidad() * lp.getProducto().getPrecioUnitario());
        }
        return total;
    }

    public Date getFecha() { return fecha; }       // getter y setter con Date
    public void setFecha(Date fecha) { this.fecha = fecha; }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String f = (fecha != null) ? sdf.format(fecha) : "Sin fecha";
        return proveedor.getNombre() + " – " + f + " – $" + precioTotal()
                + (entregado ? " (entregado)" : " (pendiente)");
    }
}
