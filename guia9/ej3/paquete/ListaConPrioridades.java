package paquete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class ListaConPrioridades<T extends Comparable> implements Serializable {
    private PriorityQueue<T> elementos;

    public ListaConPrioridades() {
        this.elementos = new PriorityQueue<>();
    }

    public void agrega(T elemento) {
        this.elementos.add(elemento);
    }

    /** El próximo elemento SIN sacarlo de la cola. Devuelve null si está vacía. */
    public T consultaElemento() {
        return this.elementos.peek();
    }

    public int getCantidad() {
        return this.elementos.size();
    }

    /** Saca y devuelve el próximo elemento. Devuelve null si está vacía. */
    public T getElemento() {
        return this.elementos.poll();
    }

    /**
     * Todos los elementos en orden de prioridad, sin modificar la cola.
     * (El iterador de PriorityQueue NO recorre en orden, por eso se vacía una copia.)
     */
    public ArrayList<T> listarEnOrden() {
        PriorityQueue<T> copia = new PriorityQueue<>(this.elementos);
        ArrayList<T> resultado = new ArrayList<>();
        while (!copia.isEmpty()) {
            resultado.add(copia.poll());
        }
        return resultado;
    }

    // getter y setter: necesarios para que XMLEncoder guarde la cola
    public PriorityQueue<T> getElementos() {
        return elementos;
    }

    public void setElementos(PriorityQueue<T> elementos) {
        this.elementos = elementos;
    }
}