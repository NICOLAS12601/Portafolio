package org.example;

public class Main {
    public static void main(String[] args) {
        String frase = "HOLA COMO ESTAS";
        System.out.println(ContadorPalabras.contadorPalabras(frase));
        int[] resultado =new int[2];
        resultado=ContadorPalabras.contadorDeVocalesYConsonantes(frase);
        System.out.println("La cantidad de consonantes es: "+resultado[0]+" y la cantidad de vocales es: "+resultado[1]);
    }
}