package org.example;
import uy.edu.ucu.aed.utils.ManejadorArchivosGenerico;

import java.util.Locale;

import static com.sun.tools.javac.util.StringUtils.toUpperCase;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //imprimirTablero(7, 7);

        //String nombreArchivo = "archivoPrueba.txt";
       // leerEntradaArchivo(nombreArchivo);

        //leerEntradaStdin();

        String ruta="LetrasANumeros";
        transformarTextoT9(ruta);


    }

    //EJERCICIO 1
    public static void imprimirTablero(int largo, int ancho) {
        int i = largo;
        do {
            for (int j = ancho; j >= 0; j--) {
                System.out.print("#");
            }
            if (i > 1)
                System.out.println();
            i--;
        } while (i > 0);

    }

    /*EJERCICIO 2 PARTE A*/
    public static void leerEntradaArchivo(String rutaArchivo) {


        String[] cadenas = ManejadorArchivosGenerico.leerArchivo(rutaArchivo);

        for (int i = 0; i < cadenas.length; i++) {
            String[] partes = cadenas[i].split(",");
            int parteEntera = Integer.parseInt(partes[0]);
            float parteFloat = Float.parseFloat(partes[1]);
            float suma = parteFloat + parteEntera;
            float resto = parteFloat % parteEntera;
            int cociente = (int) (parteFloat / parteEntera);
            System.out.println("El entero leído es:" + partes[0] + "\n" +
                    "El número de punto flotante es:" + partes[1] + "\n" +
                    "La cadena leída es " + partes[2] + "\n" +
                    "¡Hola " + partes[2] + "! La suma de " + partes[0] + " y " + partes[1] + " es:" + suma + "\n" +
                    "La división entera de " + partes[1] + " y " + partes[0] + " es " + cociente + " y su resto es " + resto + "\n");
        }
    }
    /*EJERCICIO 2 PARTE B*/
    public static void leerEntradaStdin(){
        String nombreArchivo="Stdin";
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(nombreArchivo);
        for(int i=0;i< lineas.length;i++){
            int radio=Integer.parseInt(lineas[i]);
            float perimetro= (float) (radio*(3.14)*2);
            float area=(float) (radio*radio*(3.14));
            System.out.println("El perimetro de la cfa" + i+ " es:"+perimetro+"\n"+
                                "El área es:"+area);


           }

    }
    public static void transformarTextoT9(String rutaArchivo) {
        String[] cadenas = ManejadorArchivosGenerico.leerArchivo(rutaArchivo);
        String[] cadenasAescribir= new String[cadenas.length];


        for (int j = 0; j < cadenas.length; j++) {
            StringBuilder lineas=new StringBuilder();
            cadenas[j] = cadenas[j].toUpperCase();


            for (int i = 0; i < cadenas[j].length(); i++) {
                char c = cadenas[j].charAt(i);

                switch (c) {
                    case 'A': lineas.append("2 "); break;
                    case 'B': lineas.append("2 "); break;
                    case 'C': lineas.append("222 "); break;
                    case 'D': lineas.append("3 "); break;
                    case 'E': lineas.append("33 "); break;
                    case 'F': lineas.append("333 "); break;
                    case 'G': lineas.append("4 "); break;
                    case 'H': lineas.append("44 "); break;
                    case 'I': lineas.append("444 "); break;
                    case 'J': lineas.append("5 "); break;
                    case 'K': lineas.append("55 "); break;
                    case 'L': lineas.append("555 "); break;
                    case 'M': lineas.append("6 "); break;
                    case 'N': lineas.append("66 "); break;
                    case 'O': lineas.append("666 "); break;
                    case 'P': lineas.append("7 "); break;
                    case 'Q': lineas.append("77 "); break;
                    case 'R': lineas.append("777 "); break;
                    case 'S': lineas.append("7777 "); break;
                    case 'T': lineas.append("8 "); break;
                    case 'U': lineas.append("88 "); break;
                    case 'V': lineas.append("888 "); break;
                    case 'W': lineas.append("9 "); break;
                    case 'X': lineas.append("99 "); break;
                    case 'Y': lineas.append("999 "); break;
                    case 'Z': lineas.append("9999 "); break;
                    case ' ': lineas.append("0 "); break;
                    case '.': lineas.append("1 "); break;

                }

            }
            cadenasAescribir[j]=lineas.toString();


        }
         ManejadorArchivosGenerico.escribirArchivo("salidaT9.txt", cadenasAescribir);
    }




}
