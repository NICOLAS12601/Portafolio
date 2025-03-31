package org.example;

public static class UtilMath {

    /*Metodo que calcula el factorial de un
    número que le es pasado por parametro*/
    public static int factorial(int n) {
        int resultado = 1;
        for (int i = n; i > 1; i--) {
            resultado *= i;
        }
        return resultado;
    }

    /*Metodo que chequea si un número es primo o no.
    Si lo es calcula la suma de los números pares desde cero hasta el dado.
    Y en caso contrario calcula la suma de los números impares desde cero
    hasta el número dado.
     */
    public static boolean isPrime(long n) {
        boolean prime = true;
        int i = 3;
        double tope=Math.sqrt(n);
        while ( i <= tope){
            if (n % i == 0) {
                prime = false;
                break;
            }
            i += 2;}//esquiva los multiplos de 2

            //verifica si es primo, si prime es verdadero o si es dos
            if ((n % 2 != 0 && prime && n > 2) || n == 2) {//aca chequea si es dos
                    int aux=0;
                    int resultado=0;
                    do{
                        resultado+=aux;
                        aux+=2;
                    }while (aux<=n);

                    return true;}
            else { // si es primo
                   int aux=1;
                   int resultado=0;
                   do{
                       resultado+=aux;
                       aux+=2;
                   }while (aux<=n);
                return false; }

    }
}

