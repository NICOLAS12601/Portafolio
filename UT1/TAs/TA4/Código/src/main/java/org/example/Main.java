package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ContadorDePalabras contador = new ContadorDePalabras();

        String rutaArchivo = "C:\\Algoritmos\\Portafolio\\UT1\\TAs\\TA4\\UT1_TA4_ARCHIVO_EJEMPLO.txt";


        String[] lineas1=contador.obtenerLineas(1,4,rutaArchivo);
        String[] lineas2=contador.obtenerLineas(4,8,rutaArchivo);

        String[] palabras1=contador.separadorEnPalabras(lineas1);
        String[] palabras2=contador.separadorEnPalabras(lineas2);

        String[] resultado=contador.palabrasComunes(palabras1,palabras2);
        if(resultado.length>0) {
            System.out.print("Las coincidencias fueron: ");
            int aux = 0;
            for (; aux < resultado.length - 1; aux++) {
                System.out.print(resultado[aux] + ", ");
            }
            System.out.println(resultado[aux] + ".");
        }

    }
}