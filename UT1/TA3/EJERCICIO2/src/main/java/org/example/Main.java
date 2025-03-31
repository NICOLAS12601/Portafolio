package org.example;

public class Main {
    public static void main(String[] args) {
        String frase = "HOLA COMO ESTAS";
        System.out.println(ContadorDePalabras.contadorPalabras(frase));
        int[] resultado =new int[2];
        resultado=ContadorDePalabras.contadorDeVocalesYConsonantes(frase);
        System.out.println("La cantidad de consonantes es: "+resultado[0]+" y la cantidad de vocales es: "+resultado[1]);
        System.out.println("La cantidad de palabras con 5 o mas caracteres es: "+ContadorDePalabras.contadorDePalabrasMayores(frase,5));
    }
}