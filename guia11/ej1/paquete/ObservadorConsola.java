package paquete;

import java.util.Observable;
import java.util.Observer;

public class ObservadorConsola implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Mascota mascota = (Mascota) o;
        Estados necesidad = (Estados) arg;
        System.out.println(mascota.getNombre() + " " + necesidad.getTexto());
    }
}