package paquete;

public class Ordenadora {

    public static void ordenar(Comparable[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        // Algoritmo de ordenamiento por burbujeo
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                // Si el elemento actual es mayor que el siguiente, se intercambian
                if (array[j].compareTo(array[j + 1]) > 0) {
                    Comparable aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }
}