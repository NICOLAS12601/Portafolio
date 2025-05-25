package org.example;

public class toString {

    public static void main(String[] args) {
        double d = 888.51;
        String s = Double.toString(d);
        int dot = s.indexOf('.'); // cuenta cuantos caracteres antes del punto
        System.out.println(dot + " digits " +
                "before decimal point.");
        // calcula cuantos caracteres despues del punto
        System.out.println( (s.length() - dot - 1) +
                " digits after decimal point.");
        System.out.println(s);
    }

}
