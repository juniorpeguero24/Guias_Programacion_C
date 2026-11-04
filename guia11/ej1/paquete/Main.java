package paquete;

import vista.VistaPrincipal;

public class Main {
    public static void main(String[] args) {
        VistaPrincipal vista = new VistaPrincipal();
        vista.arranca();                                   // CAMBIO: la ventana primero

        ObservadorConsola obsConsola = new ObservadorConsola();
        ObservadorVentana obsVentana = new ObservadorVentana(vista);

        String[] nombres = {"Pochoclo", "Manchita", "Tito", "Kiwi"};
        for (String nombre : nombres) {
            Mascota m = new Mascota(nombre);
            m.addObserver(obsConsola);
            m.addObserver(obsVentana);
            new Thread(m).start();                         // registrar antes de arrancar
        }
    }
}