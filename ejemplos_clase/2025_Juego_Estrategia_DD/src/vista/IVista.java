package vista;

import java.util.Iterator;

import modelo.Personaje;

public interface IVista
{
String getNombre();
double getCoordenadaX();
double getCoordenadaY();
String getTipo();

double getCoordenadaMovimientoX();
double getCoordenadaMovimientoY();

void actualizarListas(Iterator<Personaje> iterator);
void agregaLog(String lineaTexto);	

Personaje getPersonajeSeleccionado();
Personaje getPersonajeSeleccionadoLista2();

}
