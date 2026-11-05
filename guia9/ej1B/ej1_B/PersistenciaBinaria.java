package ej1_B;

import java.io.*;

// DAO binario: recibe y devuelve una Flota, pero lo que escribe y lee es un FlotaDTO.
public class PersistenciaBinaria implements Persistencia {

    @Override
    public void guardar(Flota flota, String archivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(UtilFlota.flotaToDTO(flota));
        }
    }

    @Override
    public Flota cargar(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            FlotaDTO dto = (FlotaDTO) in.readObject();
            return UtilFlota.dtoToFlota(dto);
        }
    }
}
