package paquete;

import java.util.GregorianCalendar;

public class PruebaFS {

    public static void main(String[] args) {
        GregorianCalendar hoy = new GregorianCalendar();

        // 1. Directorio: viaje (dentro de fotos)
        Directorio dirViaje = new Directorio("viaje", hoy);
        Archivo dsc08904 = new Archivo("DSC08904.JPG", hoy, hoy, 1500);
        Archivo dsc08909 = new Archivo("DSC08909.JPG", hoy, hoy, 1000);
        Archivo dsc08910 = new Archivo("DSC08910.JPG", hoy, hoy, 2000);
        Archivo dsc08911 = new Archivo("DSC08911.JPG", hoy, hoy, 2500);

        dirViaje.agregarElemento(dsc08904);
        dirViaje.agregarElemento(dsc08909);
        dirViaje.agregarElemento(dsc08910);
        dirViaje.agregarElemento(dsc08911);

        // 2. Directorio: fotos
        Directorio dirFotos = new Directorio("fotos", hoy);
        dirFotos.agregarElemento(new Archivo("CAM00053.jpg", hoy, hoy, 150));
        dirFotos.agregarElemento(new Archivo("CAM00054.jpg", hoy, hoy, 200));
        dirFotos.agregarElemento(new Archivo("CAM00055.jpg", hoy, hoy, 170));
        dirFotos.agregarElemento(new Archivo("CAM00056.jpg", hoy, hoy, 150));
        dirFotos.agregarElemento(new Archivo("CAM00057.jpg", hoy, hoy, 250));
        dirFotos.agregarElemento(dirViaje);

        // 3. Directorio: mis documentos
        Directorio dirMisDocumentos = new Directorio("mis documentos", hoy);
        Archivo cartaDoc = new Archivo("carta.doc", hoy, hoy, 30);
        Archivo curriculumDoc = new Archivo("curriculum.doc", hoy, hoy, 60);
        Archivo recetaDoc = new Archivo("receta de cocina.doc", hoy, hoy, 80);

        dirMisDocumentos.agregarElemento(cartaDoc);
        dirMisDocumentos.agregarElemento(curriculumDoc);
        dirMisDocumentos.agregarElemento(recetaDoc);

        // 4. Subdirectorios de mp3: Queen y The beatles
        Directorio dirQueen = new Directorio("Queen", hoy);
        Archivo bohemian = new Archivo("Bohemian Rhapsody.mp3", hoy, hoy, 5300);
        Archivo madeInHeaven = new Archivo("Made in heaven.mp3", hoy, hoy, 6500);
        Archivo saveMe = new Archivo("Save me.mp3", hoy, hoy, 2500);

        dirQueen.agregarElemento(bohemian);
        dirQueen.agregarElemento(madeInHeaven);
        dirQueen.agregarElemento(saveMe);

        Directorio dirBeatles = new Directorio("The beatles", hoy);
        dirBeatles.agregarElemento(new Archivo("Let it be.mp3", hoy, hoy, 3530));
        dirBeatles.agregarElemento(new Archivo("Yesterday.mp3", hoy, hoy, 3000));

        // 5. Directorio: mp3
        Directorio dirMp3 = new Directorio("mp3", hoy);
        dirMp3.agregarElemento(new Archivo("El choclo.mp3", hoy, hoy, 3500));
        dirMp3.agregarElemento(new Archivo("El dia que me quieras.Mp3", hoy, hoy, 4500));
        dirMp3.agregarElemento(new Archivo("Naranjo en flor.MP3", hoy, hoy, 5000));
        dirMp3.agregarElemento(dirQueen);
        dirMp3.agregarElemento(dirBeatles);

        // 6. Archivos Comprimidos (.zip)
        // Queen.zip ocupa el 80% (tasa 0.80) y contiene los archivos de Queen
        ArchivoComprimido zipQueen = new ArchivoComprimido("Queen.zip", hoy, 0.80);
        zipQueen.agregarElemento(bohemian);
        zipQueen.agregarElemento(madeInHeaven);
        zipQueen.agregarElemento(saveMe);

        // Mis Documentos.zip ocupa el 30% (tasa 0.30) y contiene los archivos de mis documentos
        ArchivoComprimido zipMisDocs = new ArchivoComprimido("Mis Documentos.zip", hoy, 0.30);
        zipMisDocs.agregarElemento(cartaDoc);
        zipMisDocs.agregarElemento(curriculumDoc);
        zipMisDocs.agregarElemento(recetaDoc);

        // 7. Directorio Raíz: C:
        Directorio discoC = new Directorio("C:", hoy);

        // Links de la raíz
        Link linkDsc = new Link("Acceso directo a DSC08910.JPG.lnk", hoy, dsc08910);
        Link linkSaveMe = new Link("Acceso directo a Save me.mp3.lnk", hoy, saveMe);

        // Link dentro de viaje que apunta a la raíz
        Link linkRaiz = new Link("Acceso directo a raiz.lnk", hoy, discoC);
        dirViaje.agregarElemento(linkRaiz);

        // Agregamos todo a la raíz C:
        discoC.agregarElemento(linkDsc);
        discoC.agregarElemento(linkSaveMe);
        discoC.agregarElemento(zipQueen);
        discoC.agregarElemento(zipMisDocs);
        discoC.agregarElemento(new Archivo("Recordatorio.txt", hoy, hoy, 5));
        discoC.agregarElemento(dirFotos);
        discoC.agregarElemento(dirMisDocumentos);
        discoC.agregarElemento(dirMp3);

        // --- VERIFICACIÓN EN CONSOLA ---
        System.out.println("=== LISTADO COMPLETO DEL SISTEMA DE ARCHIVOS ===");
        discoC.listar("");

        System.out.println("\n=== PRUEBAS DE TAMAÑO ===");
        System.out.println("Tamaño de 'Recordatorio.txt': " + discoC.getElementos().get(4).getTamaño() + " kb");
        System.out.println("Tamaño del link '" + linkSaveMe.getNombre() + "': " + linkSaveMe.getTamaño() + " kb");
        System.out.println("Tamaño carpeta 'Queen' sin comprimir: " + dirQueen.getTamaño() + " kb");
        System.out.println("Tamaño 'Queen.zip' (80%): " + zipQueen.getTamaño() + " kb");
        System.out.println("Tamaño carpeta 'mis documentos' sin comprimir: " + dirMisDocumentos.getTamaño() + " kb");
        System.out.println("Tamaño 'Mis Documentos.zip' (30%): " + zipMisDocs.getTamaño() + " kb");
        System.out.println("Tamaño total de la unidad C: " + discoC.getTamaño() + " kb");

        System.out.println("\n=== LISTADO DEL ARCHIVO COMPRIMIDO (Queen.zip) ===");
        zipQueen.listar("   ");
    }
}