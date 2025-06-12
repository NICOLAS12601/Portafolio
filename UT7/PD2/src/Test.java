

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for implemented methods.
 */
public class Test
{
    private TGrafoDirigido grafo;


    @BeforeEach
    public void setUp() {
        String vertices = "src/aeropuertos.txt";
        String aristas = "src/conexiones.txt";
        grafo = UtilGrafos.cargarGrafo(vertices, aristas, false, TGrafoDirigido.class);
    }
    /**
     * Sample test in JUnit 5
     */
    @org.junit.jupiter.api.Test
    public void testGrafoNoEsNulo() {
        assertNotNull(grafo, "El grafo debería estar cargado");
    }

    @org.junit.jupiter.api.Test
    public void floyd(){
        Double[][] resultado=grafo.floyd();
        //Asuncion y Mvdeo caso que no se conectaban
        assertEquals(1700.0, resultado[0][3], 0.1);
        //BS.AS y Mvdeo caso que ya estaban conectada y era lo mejor
        assertEquals(200.0,resultado[1][3],0.1);
    }

    @org.junit.jupiter.api.Test
    public void obtenerEcentricidad(){
        Comparable result=grafo.obtenerExcentricidad("Montevideo");
        assertEquals(result,-1,"La excentricidad obtenida no es la correcta");

    }

    @org.junit.jupiter.api.Test
    public void obtenerCentroDelGrafo(){
        Comparable centro=grafo.centroDelGrafo();
        assertEquals(centro,"Durazno");
    }

    @AfterEach
    public void tearDown() {
        grafo = null; // Liberás recursos
    }
}