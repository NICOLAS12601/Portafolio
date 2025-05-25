package org.example;

public class esPalindromo {


    public esPalindromo(){

    }
    /**
     * Verifica si una cadena es palindromo
     * @param texto la cadena a verificar
     * @return true si es palindromo, false en caso contrario
     */
    public static boolean esPalindromo(String texto) {
        // Validar entrada nula
        if (texto == null) {
            return false;
        }

        // Eliminar espacios y convertir a minúsculas para comparación
        String textoLimpio = texto.replaceAll("\\s+", "").toLowerCase();

        // Crear versión invertida usando StringBuilder
        String textoInvertido = new StringBuilder(textoLimpio)
                .reverse()
                .toString();

        // Comparar la cadena original con su versión invertida
        return textoLimpio.equals(textoInvertido);
    }

}
