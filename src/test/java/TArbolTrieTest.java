import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

public class TArbolTrieTest {

  @Test
  public void testBuscar() {
    TArbolTrie arbol = new TArbolTrie();

    arbol.insertar("hola");

    assertEquals(4, arbol.buscar("hola"));
  }

  @Test
  public void testPredecir() {
    TArbolTrie arbol = new TArbolTrie();

    arbol.insertar("hola");
    arbol.insertar("horda");

    LinkedList<String> palabras = arbol.predecir("ho");

    assertEquals(2, palabras.size());
    assertTrue(palabras.contains("hola"));
    assertTrue(palabras.contains("horda"));
  }
}
