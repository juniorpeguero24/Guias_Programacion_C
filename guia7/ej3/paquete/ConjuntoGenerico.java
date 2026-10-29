package paquete;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class ConjuntoGenerico<T> implements IConjunto<T> {
    private LinkedHashSet<T> elementos;

    public ConjuntoGenerico() {
        this.elementos = new LinkedHashSet<>();
    }


    @Override
    public void agrega(T elemento) throws OperacionConjuntosException {
        if (this.elementos.contains(elemento)) {
            throw new OperacionConjuntosException("No se puede agregar un elemento existente.", elemento);
        }
        this.elementos.add(elemento);
    }

    @Override
    public void elimina(T elemento) throws OperacionConjuntosException {
        if (!this.elementos.contains(elemento)) {
            throw new OperacionConjuntosException("No se puede eliminar un elemento inexistente.", elemento);
        }
        this.elementos.remove(elemento);
    }

    @Override
    public int getCardinal() {
        return this.elementos.size();
    }

    @Override
    public Iterator<T> getIterator() {
        return this.elementos.iterator();
    }

}
