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

    }



