package paquete;

import vista.VistaPrincipal;

import java.util.Observable;
import java.util.Observer;

public class ObservadorVentana implements Observer {
    private final VistaPrincipal vista;

    public ObservadorVentana(VistaPrincipal vista) {
        this.vista = vista;
    }

    @Override
    public void update(Observable o, Object arg) {
        Mascota mascota = (Mascota) o;
        Estados necesidad = (Estados) arg;
        vista.informar(mascota.getNombre() + " " + necesidad.getTexto());
    }
}