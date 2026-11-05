package paquete;

import java.io.Serializable;
import java.util.ArrayList;

public class Negocio implements Serializable {
    private ArrayList<Proveedor> proveedores;
    private ArrayList<Producto> productos;
    private ArrayList<Pedido> pedidos;

    public Negocio() {
        proveedores = new ArrayList<>();
        productos = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    // Se llama desde el Main, NO desde el constructor (XMLDecoder usa el constructor vacio).
    public void cargarDatosDePrueba() {
        // Proveedores
        Proveedor papeleraSur = new Proveedor("Distribuidora Papelera Sur", "ventas@papelerasur.com.ar", "2234561234");
        Proveedor lmCentro    = new Proveedor("Libreria Mayorista Centro", "pedidos@lmcentro.com.ar", "2234789012");
        Proveedor atlantica   = new Proveedor("Insumos de Oficina Atlantica", "contacto@ioatlantica.com.ar", "2235123456");
        Proveedor losAndes    = new Proveedor("Comercial Los Andes", "info@losandes.com.ar", "2236347890");

        // Productos
        Producto cuaderno    = new Producto(101, "Cuaderno espiral A4", 4500.0);
        Producto lapicera    = new Producto(102, "Lapicera trazo fino azul", 850.0);
        Producto resma       = new Producto(103, "Resma A4 75g", 8200.0);
        Producto marcador    = new Producto(104, "Marcador permanente negro", 1400.0);
        Producto corrector   = new Producto(105, "Corrector liquido 20ml", 1200.0);
        Producto carpeta     = new Producto(106, "Carpeta A4 3 anillos", 3900.0);
        Producto abrochadora = new Producto(107, "Abrochadora metalica", 7600.0);
        Producto cinta       = new Producto(108, "Cinta adhesiva 18mm", 650.0);

        this.agregarProducto(cuaderno);
        this.agregarProducto(lapicera);
        this.agregarProducto(resma);
        this.agregarProducto(marcador);
        this.agregarProducto(corrector);
        this.agregarProducto(carpeta);
        this.agregarProducto(abrochadora);
        this.agregarProducto(cinta);

        this.agregarProveedor(papeleraSur);
        this.agregarProveedor(lmCentro);
        this.agregarProveedor(atlantica);
        this.agregarProveedor(losAndes);

        Pedido p1 = new Pedido(papeleraSur);
        Pedido p2 = new Pedido(papeleraSur);
        Pedido p3 = new Pedido(lmCentro);
        Pedido p4 = new Pedido(atlantica);
        Pedido p5 = new Pedido(atlantica);
        Pedido p6 = new Pedido(losAndes);
        try {
            p1.agrega(new LineaDePedido(10, cuaderno));
            p1.agrega(new LineaDePedido(50, lapicera));
            p1.entregado();
            p2.agrega(new LineaDePedido(20, resma));
            p3.agrega(new LineaDePedido(5, marcador));
            p3.agrega(new LineaDePedido(5, corrector));
            p3.agrega(new LineaDePedido(10, cinta));
            p3.entregado();
            p4.agrega(new LineaDePedido(2, abrochadora));
            p4.agrega(new LineaDePedido(15, carpeta));
            p5.agrega(new LineaDePedido(30, lapicera));
            p5.entregado();
            p6.agrega(new LineaDePedido(8, cuaderno));
            p6.agrega(new LineaDePedido(3, resma));
            p6.entregado();
        } catch (OperacionConjuntosException e) {
            throw new RuntimeException(e);
        }
        this.agregarPedido(p1);
        this.agregarPedido(p2);
        this.agregarPedido(p3);
        this.agregarPedido(p4);
        this.agregarPedido(p5);
        this.agregarPedido(p6);
    }

    // ===================== LISTADOS =====================

    public ArrayList<Pedido> getPedidosEntregados() {
        ArrayList<Pedido> resultado = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.isEntregado()) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public ArrayList<Pedido> getPedidosNoEntregados() {
        ArrayList<Pedido> resultado = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (!p.isEntregado()) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public ArrayList<Proveedor> getProveedoresQueAdeudan() {
        ArrayList<Proveedor> resultado = new ArrayList<>();
        for (Pedido p : getPedidosNoEntregados()) {
            if (!resultado.contains(p.getProveedor())) {   // usa el equals de Proveedor
                resultado.add(p.getProveedor());
            }
        }
        return resultado;
    }

    // ===================== ALTAS =====================

    public void agregarProveedor(Proveedor proveedor) {
        proveedores.add(proveedor);
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // ===================== GETTERS Y SETTERS (para XML) =====================

    public ArrayList<Proveedor> getProveedores() { return proveedores; }
    public void setProveedores(ArrayList<Proveedor> proveedores) { this.proveedores = proveedores; }

    public ArrayList<Producto> getProductos() { return productos; }
    public void setProductos(ArrayList<Producto> productos) { this.productos = productos; }

    public ArrayList<Pedido> getPedidos() { return pedidos; }
    public void setPedidos(ArrayList<Pedido> pedidos) { this.pedidos = pedidos; }
}