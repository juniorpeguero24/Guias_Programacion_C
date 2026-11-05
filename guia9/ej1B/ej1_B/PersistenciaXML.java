package ej1_B;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

// DAO XML: igual que el binario, se guarda el FlotaDTO (que si cumple las reglas de JavaBeans).
public class PersistenciaXML implements Persistencia {

    @Override
    public void guardar(Flota flota, String archivo) throws IOException {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(archivo)))) {
            encoder.writeObject(UtilFlota.flotaToDTO(flota));
        }
    }

    @Override
    public Flota cargar(String archivo) throws IOException {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(archivo)))) {
            FlotaDTO dto = (FlotaDTO) decoder.readObject();
            return UtilFlota.dtoToFlota(dto);
        }
    }
}
