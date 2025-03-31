package org.example;

public class ContadorPalabras {

    /*RECORRER LA PALABRA LETRA POR LETRA PARA ESTO LLEVO UN VARIABLE
    AUXILIAR QUE SE VA INCREMENTADO HASTA EL TAMAÑO DEL LARGO DE LA FRASE.
    UNA BANDERA QUE DICE ES PALABRA, LA CUAL PARA QUE SE LEVANTE NECESITA ENCONTRAR
    AL MENOS UNA LETRA O UN NUMERO EN ES MOMENTO SE INCREMENTA EL CONTADOR, SOLO
    CUANDA SE LEVANTA LA BANDERA, UNA VEZ LEVANTADASOLO SE BAJA CUANDO
    ENCUENTRA UN ESPACIO.
     */

    public static int contadorPalabras(String frase) {
        int resultado= 0;
        boolean esPalabra =false;
        int i=0;
        do {
            if(esPalabra==false){
                if (Character.isLetter(frase.charAt(i))||Character.isDigit(frase.charAt(i))) {
                esPalabra = true;
                resultado++;}
            }// queda levantada la bandera}
            if (' ' == frase.charAt(i)) {
                esPalabra = false;
            }
            i++;
        }while(i<frase.length());

        return resultado;}

    public static int[] contadorDeVocalesYConsonantes(String frase) {
        int[] resultado= {0,0};// casilla 0 consonantes, casilla 1 vocales
        int i=0;
        char vocales[] = {'a', 'e', 'i', 'o', 'u'};

        do {
            if (Character.isLetter(frase.charAt(i))) {
                    char letra = Character.toLowerCase(frase.charAt(i));
                    boolean esConsonante = true;
                    for (int j = 0; j < vocales.length; j++) {
                        if (vocales[j] == letra) {
                            resultado[1]++;//vocal
                            esConsonante = false;
                            break;
                        }
                    }
                        if(esConsonante){
                            resultado[0]++;//consonante
                        }
            }
            i++;
        }while(i<frase.length());

    return resultado;}

}



