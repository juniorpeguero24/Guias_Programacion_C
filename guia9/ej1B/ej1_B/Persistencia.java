package ej1_B;

import java.io.IOException;

public interface Persistencia {
    void guardar(Flota flota, String archivo) throws IOException;
    Flota cargar(String archivo) throws IOException, ClassNotFoundException;
}