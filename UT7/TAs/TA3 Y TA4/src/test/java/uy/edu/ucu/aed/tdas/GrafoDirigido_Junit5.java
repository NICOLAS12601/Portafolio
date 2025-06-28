package uy.edu.ucu.aed.tdas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;



import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for implemented methods.
 */
public class GrafoDirigido_Junit5
{
    private TGrafoDirigido grafo;


    @BeforeEach
    public void setUp() {
        String vertices = "aeropuertos.txt";
        String aristas = "conexiones.txt";
        grafo = UtilGrafos.cargarGrafo(vertices, aristas, false, TGrafoDirigido.class);
    }
    /**
     * Sample test in JUnit 5
     */
    @Test
    public void testGrafoNoEsNulo() {
     assertNotNull(grafo, "El grafo debería estar cargado");
     }
    @Test
    public void testBPFDevuelveTodosLosAeropuertos() {
        LinkedList<IVertice> resultado = (LinkedList<IVertice>) grafo.bpf();

        Set<Comparable> obtenidos = resultado.stream()
                .map(IVertice::getEtiqueta)
                .collect(Collectors.toSet());

        Set<String> esperados = Set.of(
                "Asuncion", "Buenos_Aires", "Curitiba", "Montevideo",
                "Porto_Alegre", "Rio_de_Janeiro", "San_Pablo", "Santos"
        );

        assertEquals(esperados, obtenidos, "La BPF no recorrió todos los aeropuertos.");
    }
    @Test
    public void testBPFDesdeUnVertice(){
        LinkedList<IVertice> resultado = (LinkedList<IVertice>) grafo.bpf("Santos");

        Set<Comparable> obtenidos=resultado.stream().map(IVertice::getEtiqueta).collect(Collectors.toSet());

        Set<String> esperados=Set.of("Asuncion", "Buenos_Aires", "Curitiba", "Montevideo",
                "Porto_Alegre", "Rio_de_Janeiro", "San_Pablo", "Santos");

        assertEquals(esperados,obtenidos,"La BPF desde Santos no recorrio correctamente");
    }
    @Test
    public void floyd(){
        Double[][] resultado=grafo.floyd();
        //Asuncion y Mvdeo caso que no se conectaban
        assertEquals(1700.0, resultado[0][3], 0.1);
        //BS.AS y Mvdeo caso que ya estaban conectada y era lo mejor
        assertEquals(200.0,resultado[1][3],0.1);
    }

    @Test
    public void distenciaMinima(){
        double result=grafo.distanciaMinima("Montevideo","Buenos_Aires");
        assertEquals(200.0,result,"El resultado no es el esperado");
    }
    @Test
    public void itinerario(){
        String result=grafo.itinerario("Asuncion","Montevideo");
        String esperado="Asuncion -> Porto_Alegre -> Montevideo";
        assertEquals(result,esperado,"El itinerario no es el esperado");
    }

    @Test
    public void warshall(){
        boolean [][] warshall=grafo.warshall();
        boolean b = warshall[0][3];
        assertEquals(true,b,"No se conectaron correctamente los aereopuertos");

    }
    @Test
    public void obtenerEcentricidad(){
        Comparable result=grafo.obtenerExcentricidad("Montevideo");
        assertEquals(result,5280.0,"La excentricidad obtenida no es la correcta");

    }

    @Test
    public void obtenerCentroDelGrafo(){
        Comparable centro=grafo.centroDelGrafo();
        assertEquals(centro,"Curitiba");
    }
    @Test
    public void testGrafoVacio() {
        TGrafoDirigido grafoVacio = new TGrafoDirigido(null,null);
        LinkedList<IVertice> resultado = (LinkedList<IVertice>) grafoVacio.bpf();
        assertTrue(resultado.isEmpty(), "El recorrido BPF en un grafo vacío debe ser vacío.");
    }

    @AfterEach
    public void tearDown() {
        grafo = null; // Liberás recursos
    }
}