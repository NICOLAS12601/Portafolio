package org.example;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;
public class ProductoEscalar {
    public static void main(String[] args) {
        String rutaArchivo = "Vectores";
        String[] cadenas = ManejadorArchivosGenerico.leerArchivo(rutaArchivo);
        String[] salida = new String[cadenas.length];

        for (int i = 0; i < cadenas.length; i++) {
            String[] elementos = cadenas[i].split(",");

            if (elementos.length % 2 != 0) {
                salida[i] = "Línea " + (i + 1) + ": No se puede calcular producto escalar (número impar de componentes).";
                continue;
            }

            int mitad = elementos.length / 2;
            int[] vectorA = new int[mitad];
            int[] vectorB = new int[mitad];

            for (int j = 0; j < mitad; j++) {
                vectorA[j] = Integer.parseInt(elementos[j]);
                vectorB[j] = Integer.parseInt(elementos[j + mitad]);
            }

            int resultado = 0;
            for (int k = 0; k < mitad; k++) {
                resultado += vectorA[k] * vectorB[k];
            }

            salida[i] = "Línea " + (i + 1) + ": Producto escalar = " + resultado;
        }

        ManejadorArchivosGenerico.escribirArchivo("ResultadosProductoEscalar.txt", salida);
    }
}
