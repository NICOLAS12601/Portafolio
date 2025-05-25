package org.example;
public class Main {
    public static void main(String[] args) {
        // Simulamos argumentos como si vinieran por consola
        args = new String[2];
        args[0] = "13.4";
        args[1] = "66.1";

        if (args.length == 2) {
            // Convertimos los strings a float
            float a = Float.valueOf(args[0]);
            float b = Float.valueOf(args[1]);

            // Hacemos las operaciones
            System.out.println("a + b = " + (a + b));
            System.out.println("a - b = " + (a - b));
            System.out.println("a * b = " + (a * b));
            System.out.println("a / b = " + (a / b));
            System.out.println("a % b = " + (a % b));
        } else {
            System.out.println("Este programa requiere exactamente 2 argumentos.");
        }
    }
}

