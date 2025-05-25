
import java.util.LinkedList;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }

        trie.imprimir();

        System.out.println(trie.buscar("sofa"));

        LinkedList<String> palabras = trie.predecir("s");

        for (String p : palabras) {
            System.out.println(p);
        }
    }
}
