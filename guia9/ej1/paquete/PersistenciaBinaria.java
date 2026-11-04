package paquete;

import java.io.*;

public class PersistenciaBinaria implements Persistencia {

    @Override
    public void guardar(Flota flota, String archivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(flota);
        }
    }

    @Override
    public Flota cargar(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Flota) in.readObject();
        }
    }
}