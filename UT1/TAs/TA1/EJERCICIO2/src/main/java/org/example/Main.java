package org.example;

public class Main {
    public static void main(String[] args) {
        /*1. Analice el siguiente programa para identificar oportunidades de utilizar
        asignaciones compuestas (operadores).
        int result = 1 + 2;
        System.out.println(result);
        result = result - 1;
        System.out.println(result);
        result = result * 2;
        4 System.out.println(result);
        result = result / 2;
        System.out.println(result);
        result = result + 8;
        result = result % 7;
        System.out.println(result); } }*/

        /*ALTERNATIVAS*/
        int result=0;
        result+=3;
        System.out.println(result);
        result-=1;
        System.out.println(result);
        result*=2;
        System.out.println(result);
        result/=2;
        System.out.println(result);
        result+=8;
        System.out.println(result);
        result%=7;
        System.out.println(result);

        /*2. Qué pasa al usar construcciones del tipo
        int a = 5; se asigna 5 en a.
        int i = 3;  se asgina 3 en i
        a+=++i; se le suma a "a" i+1. primero se incrementa la i y luego se suma
         */

        /*Analice el siguiente programa y observe su ejecución.
        int i = 3; se asigna 3 a la variable i
        i++; se incrementa la i, i=4
        System.out.println(i); se imprime un 4.
        ++i; se incrementa la i, i=5
        System.out.println(i); se imprime un 5.
        System.out.println(++i); se incrementa la i, i=6 y luego se imprime 6.
        System.out.println(i++); se imprime un 6 y luego se incrementa la i, i=7
        System.out.println(i); se imprime un 7.
         */
    }
}