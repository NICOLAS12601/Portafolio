package org.example;

public class PruebaAtributos {

  /*
    PARTE 1, SE PUDO OBSERVAR QUE EL COMPILADOR NO AVANZA,
    ES DECIR SE PARA EN EL PRIMER ERROR Y NO SIGUE COMPILANDO.

    int num=0,3;
    string palabra=67;
    char letra= "hola";
    int[] arreglo=new char[10];

    PruebaAtributos() {
        for(int i=0;i<10;i++){
            arreglo[i]=letra;
        }

  */

  /*
    PARTE 2 LO MISMO QUE LA 3 NO ME DEJA COMPILAR PORQUE NO HAY INFO EN EL ARRAY,
    DICE QUE ES NULO

    int num=3;
    String palabra="HOLA";
    char letra= 'H';
    public int[] arreglo;
    PruebaAtributos() {

        }

  */

  /*
    PARTE 3, EN ESTE CASO ESTAMOS INTENTANDO IMPRIMIR EL ARREGLO CUANDO AUN
    NO FUE INICIALIZADO DESDE LA PROPIA CLASE, EL ERROR EN CONSOLA ES UNA EXCEPTION NullPointerException,
    dice que no pudo cargar info del array porque es nulo, no tiene info guardada.

    int num=3;
    String palabra="HOLA";
    char letra= 'H';
    int[] arreglo;
    PruebaAtributos() {
        for(int i=0;i<10;i++){
            System.out.println(arreglo[i]);
        }
    }
  */
}