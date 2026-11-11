package dao;

import java.io.*;

public class PersistenciaBin implements IPersistencia{
    private FileOutputStream fileOutput;
    private FileInputStream fileInput;
    private ObjectInputStream objectInput;
    private ObjectOutputStream objectOutput;

    @Override
    public void abrirInput(String nombre) throws IOException {
        fileInput = new FileInputStream(nombre);
        objectInput = new ObjectInputStream(fileInput);
    }

    @Override
    public void abrirOutput(String nombre) throws IOException {
        fileOutput = new FileOutputStream(nombre);
        objectOutput = new ObjectOutputStream(fileOutput);
    }

    @Override
    public void cerrarOutput() throws IOException {
        if (objectOutput != null) {
            objectOutput.close();
        }
    }

    @Override
    public void cerrarInput() throws IOException {
        if (objectInput != null) {
            objectInput.close();
        }
    }

    @Override
    public void escribir(Object objeto) throws IOException {
        if  (objectOutput != null) {
            objectOutput.writeObject(objeto);
        }
    }

    @Override
    public Object leer() throws IOException, ClassNotFoundException {
        Object objeto = null;
        if (objectInput != null) {
            objeto = objectInput.readObject();
        }
        return objeto;
    }
}
