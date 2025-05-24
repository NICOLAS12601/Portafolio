package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Math.min;

public class ContadorDePalabras {

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

    /*Este metodo recorre el string letra caracter por caracter, si es una letra la compara
    esta letra contra las letras almacenadas en array de char que tiene todas las vocales.
    Si coincide con alguna aumenta la cantidad de vocales si no coincide aumenta las consonantes.
     */

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

    public static int contadorDePalabrasMayores(String frase, int tamaño) {
        int resultado= 0;
        int aux=0;
        int i=0;
        do {
            if (Character.isLetter(frase.charAt(i))||Character.isDigit(frase.charAt(i))) {
                    aux++;
                    if(aux>=tamaño)
                        resultado++;}
            if (' ' == frase.charAt(i)) {
                aux=0;// empieza de nuevo, una nueva palabra
            }
            i++;
        }while(i<frase.length());



    return resultado;}

    public String[] obtenerLineas(String archivo) {
        try {
            // Primera lectura se cuentan las lineas
            File nuevoArchivo = new File(archivo);
            FileReader fr = new FileReader(nuevoArchivo);
            BufferedReader br = new BufferedReader(fr);
            int numLineas = 0;
            while (br.readLine() != null) {
                numLineas++;
            }
            br.close();

            // Se crea el array con el tamaño de la cantidad de numLineas
            String[] lineas = new String[numLineas];

            // Segunda lectura se vuelve a recorrer el archivo
            // pero esta ves almacenando linea por linea.
            nuevoArchivo = new File(archivo);
            fr = new FileReader(nuevoArchivo);
            br = new BufferedReader(fr);

            String linea;
            int i = 0;
            while ((linea = br.readLine()) != null) {
                lineas[i++] = linea;
            }
            br.close();

            return lineas;
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage(), e);
        }
    }
    public String[] obtenerLineas(int ini, int fin ,String archivo) {
        try {
            // Primera lectura se cuentan las lineas
            File nuevoArchivo = new File(archivo);
            FileReader fr = new FileReader(nuevoArchivo);
            BufferedReader br = new BufferedReader(fr);
            int numLineas = 0;
            while (br.readLine() != null) {
                numLineas++;
            }
            br.close();
            int tamaño = Math.min(numLineas, fin - ini+1);
            String[] lineas = new String[tamaño];

            // Segunda lectura se vuelve a recorrer el archivo
            // pero esta ves almacenando linea por linea.
            nuevoArchivo = new File(archivo);
            fr = new FileReader(nuevoArchivo);
            br = new BufferedReader(fr);

            String linea;
            int i = 0;
            int j=0;
            while ((linea = br.readLine()) != null) {
                if(j>=ini && j<=fin){
                    lineas[i] = linea;
                    i++;
                }
                j++;
            }
            br.close();

            return lineas;
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage(), e);
        }
    }
    public String[] separadorEnPalabras(String[] lineas) {
        ArrayList<String> resultado = new ArrayList<>();

        for (String linea : lineas) {
            // Separar la línea en palabras por espacios
            String[] palabras = linea.split("[ ,]+");

            // Agregar cada palabra al ArrayList
            for (String palabra : palabras) {
                if (!palabra.isEmpty()) { // evitar strings vacíos
                    resultado.add(palabra);
                }
            }
        }

        // Convertir ArrayList a arreglo y retornar
        return resultado.toArray(new String[0]);
    }



    public int cantPalabras(String[] lineasArchivo) {
        int resultado= 0;
        for(int i=0;i<lineasArchivo.length;i++){
            resultado+=contadorPalabras(lineasArchivo[i]);
        }
        return resultado;
    }

    public static String[] palabrasComunes(String[] palabras1, String[] palabras2) {
        ArrayList<String> resultado = new ArrayList<>();

        for (String palabra : palabras1) {
            boolean coincidencia = false;
            int aux = 0;
            while (aux < palabras2.length && !coincidencia) {
                coincidencia = palabra.equals(palabras2[aux]);
                if (coincidencia) {
                    resultado.add(palabra); // o palabras2[aux], es lo mismo acá
                    break;
                }
                aux++;
            }
        }

        if (resultado.isEmpty()) {
            System.out.println("No hubo coincidencias");
            return new String[0]; // arreglo vacío
        } else {
            return resultado.toArray(new String[0]); // convertir ArrayList a array
        }
    }


}









