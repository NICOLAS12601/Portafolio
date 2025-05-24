package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        ContadorDePalabras contador = new ContadorDePalabras();

        String rutaArchivo = "UT1/TA3/EJERCICIO3/UT1_TA3_ARCHIVO_EJEMPLO.txt";

        String[] linesaArchivo=contador.obtenerLineas(rutaArchivo);
        int result=contador.cantPalabras(linesaArchivo);

        System.out.println("La cantidad de palabras del texto es : "+result);


    }
}