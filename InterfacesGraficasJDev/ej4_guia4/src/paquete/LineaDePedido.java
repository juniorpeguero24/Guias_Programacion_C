package paquete;

import java.util.Objects;

public class LineaDePedido implements Comparable<LineaDePedido> {
    private int cantidad;
    private Producto producto;


    public LineaDePedido(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public LineaDePedido() {
    }

    @Override
    public int compareTo(LineaDePedido o) {
        if (this.producto == null || o.producto == null) {
            return 0;
        }
        return Integer.compare(this.producto.getCodigo(), o.producto.getCodigo());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof LineaDePedido that)) return false;
        return Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(producto);
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "LineaDePedido{" +
                "cantidad=" + cantidad +
                ", producto=" + producto +
                '}';
    }
}
