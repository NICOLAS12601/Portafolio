import org.example.ContadorDePalabras;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestPalabrasComunes {


    @Test
    public void testPalabrasComunes() {
        ContadorDePalabras contador = new ContadorDePalabras();

        String rutaArchivo = "C:\\Algoritmos\\Portafolio\\UT1\\TAs\\TA4\\UT1_TA4_ARCHIVO_EJEMPLO.txt";


        String[] lineas1 = contador.obtenerLineas(4, 4, rutaArchivo);
        String[] lineas2 = contador.obtenerLineas(4, 8, rutaArchivo);

        String[] palabras1 = contador.separadorEnPalabras(lineas1);
        String[] palabras2 = contador.separadorEnPalabras(lineas2);

        String[] resultado = contador.palabrasComunes(palabras1, palabras2);

        // Resultado esperado
        String[] esperado = {
                "Ooh", "ooh", "y", "ella", "compra", "una", "escalera", "al", "cielo."
        };
        // Ordenar para que el orden no afecte el resultado
        Arrays.sort(resultado);
        Arrays.sort(esperado);

        assertArrayEquals(esperado, resultado);
    }
}

