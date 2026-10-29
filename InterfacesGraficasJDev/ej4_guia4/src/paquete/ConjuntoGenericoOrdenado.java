package paquete;

import java.util.Iterator;
import java.util.TreeSet;

public class ConjuntoGenericoOrdenado<T extends Comparable> implements IConjunto<T>{
    protected TreeSet<T> elementos;

    public ConjuntoGenericoOrdenado() {
        this.elementos = new TreeSet<>();
    }

    @Override
    public void agrega(T elemento) throws OperacionConjuntosException {
        if (this.elementos.contains(elemento)) {
            throw new OperacionConjuntosException("No se puede agregar un elemento existente.",elemento);
        }
        this.elementos.add(elemento);
    }

    @Override
    public void elimina(T elemento) throws OperacionConjuntosException {
        if (!this.elementos.contains(elemento)) {
            throw new OperacionConjuntosException("No se puede eliminar un elemento inexistente.",elemento);
        }
        this.elementos.remove(elemento);
    }

    public int cantidad(){
        return this.elementos.size();
    }

    @Override
    public int getCardinal() {
        return this.cantidad();
    }

    @Override
    public Iterator<T> getIterator() {
        return this.elementos.iterator();
    }

    public T getMayor(){
        return this.elementos.last();
    }

    public T getMenor(){
        return this.elementos.first();
    }
}
