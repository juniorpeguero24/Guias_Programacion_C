package modelo;

public interface Movible
{

	double getX();

	void setX(double x);

	double getY();

	void setY(double y);

	double distancia(Movible otro);

	void mueve(double x, double y);

}