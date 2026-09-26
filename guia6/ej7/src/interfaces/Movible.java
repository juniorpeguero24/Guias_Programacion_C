package interfaces;

import excepciones.IncrementoImposibleException;

public interface Movible {
	double getPosx();
	double getPosy();

    /**
     * @param x
     * @param y
     * @throws IncrementoImposibleException
     */
    void incrementaPos(double x,double y) throws IncrementoImposibleException;
	double distancia(Movible pos);
}
