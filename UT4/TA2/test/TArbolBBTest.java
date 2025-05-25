import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TArbolBBTest {

    @Test
    public void testGetAltura() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        assertEquals(-1, arbol.getAltura()); //Si vacío

        arbol.insertar(new TElementoAB<>(10, 10));
        assertEquals(1, arbol.getAltura()); //solo raíz

        arbol.insertar(new TElementoAB<>(5, 5));
        arbol.insertar(new TElementoAB<>(15, 15));
        assertEquals(2, arbol.getAltura()); // 2 levels

        arbol.insertar(new TElementoAB<>(3, 3));
        assertEquals(3, arbol.getAltura()); // 3 levels
    }

    @Test
    public void testGetTamanio() {
        TArbolBB<Integer> arbol = new TArbolBB<>();
        assertEquals(0, arbol.getTamanio()); //Si vacío

        arbol.insertar(new TElementoAB<>(10, 10));
        assertEquals(1, arbol.getTamanio()); // Solo raíz

        arbol.insertar(new TElementoAB<>(5, 5));
        arbol.insertar(new TElementoAB<>(15, 15));
        assertEquals(3, arbol.getTamanio()); // 3 nodos

        arbol.insertar(new TElementoAB<>(3, 3));
        assertEquals(4, arbol.getTamanio()); // 4 nodos
    }
    @Test
    public void testCantidadDeHojas(){
        TArbolBB<Integer> arbol = new TArbolBB<>();
        assertEquals(0, arbol.getCantidadHojas());

        arbol.insertar(new TElementoAB<>(10, 10));
        assertEquals(1, arbol.getCantidadHojas()); // Solo raíz

        arbol.insertar(new TElementoAB<>(5, 5));
        arbol.insertar(new TElementoAB<>(15, 15));
        assertEquals(2, arbol.getCantidadHojas());


    }
    @Test
    public void TestBusqueda(){

            TArbolBB<String> arbol = new TArbolBB<>();

            arbol.insertar(new TElementoAB<>("M", "Manzana"));
            arbol.insertar(new TElementoAB<>("F", "Frutilla"));
            arbol.insertar(new TElementoAB<>("T", "Tomate"));

            SearchResult<String> res = arbol.buscar("T");
            // COMPARA EL VALOR OBTENIDO, SI ES DISTINTO DE NULL DA COMO CORRECTO EL TEST,
           // DE LO CONTRARIO LANZA UN EXCEPTION CON EL MENSAJE EL NODO DEBE ENCONTRARSE EL TEST FALLA.
           // ANALOGO PARA LOS DEMAS
            assert res.inserted != null : "El nodo debe encontrarse.";
            assert res.inserted.getEtiqueta().equals("T") : "Etiqueta incorrecta.";
            assert res.counter == 1 : "Niveles incorrectos.";
    }

    @Test
    public void TestPreOrden() {
        TArbolBB<String> arbol = new TArbolBB<>();

        arbol.insertar(new TElementoAB<>("M", "Manzana"));
        arbol.insertar(new TElementoAB<>("F", "Frutilla"));
        arbol.insertar(new TElementoAB<>("T", "Tomate"));

        String resultado = arbol.preOrden();

        assertEquals("M, F, T", resultado, "Mensaje erroneo");
    }
    @Test
    public void TestInOrden() {
        TArbolBB<String> arbol = new TArbolBB<>();

        arbol.insertar(new TElementoAB<>("M", "Manzana"));
        arbol.insertar(new TElementoAB<>("F", "Frutilla"));
        arbol.insertar(new TElementoAB<>("T", "Tomate"));

        String resultado = arbol.inOrden();

        assertEquals("F, M, T", resultado, "Mensaje erroneo");
    }
    @Test
    public void TestPostOrden() {
        TArbolBB<String> arbol = new TArbolBB<>();

        arbol.insertar(new TElementoAB<>("M", "Manzana"));
        arbol.insertar(new TElementoAB<>("F", "Frutilla"));
        arbol.insertar(new TElementoAB<>("T", "Tomate"));

        String resultado = arbol.postOrden();

        assertEquals("F, T, M", resultado, "Mensaje erroneo");
    }
    @Test
    public void TestEliminarEInsertar(){
        TArbolBB<String> arbol = new TArbolBB<>();

        arbol.insertar(new TElementoAB<>("M", "Manzana"));
        arbol.eliminar("M");

        SearchResult<String> res = arbol.buscar("M");

        assert res == null : "El nodo, no fue eliminado.";

        arbol.insertar(new TElementoAB<>("M", "Manzana"));
        arbol.insertar(new TElementoAB<>("F", "Frutilla"));
        arbol.insertar(new TElementoAB<>("T", "Tomate"));

        arbol.eliminar("M");

        res= arbol.buscar("F");
        assertEquals(0, res.counter, "No quedo ordenado el árbol");




    }


}

