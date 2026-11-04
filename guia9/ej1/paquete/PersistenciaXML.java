package paquete;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class PersistenciaXML implements Persistencia {

    @Override
    public void guardar(Flota flota, String archivo) throws IOException {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(archivo)))) {
            encoder.writeObject(flota);
        }
    }

    @Override
    public Flota cargar(String archivo) throws IOException {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(archivo)))) {
            return (Flota) decoder.readObject();
        }
    }
}