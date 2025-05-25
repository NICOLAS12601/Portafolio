
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }

            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    private TNodoTrie buscarPrefijo(String s) {
        String[] caracteres = s.split("");

        TNodoTrie nodoActual = this;

        for (String car : caracteres) {
            TNodoTrie nodoEncontrado = nodoActual.buscarNodoTrie(car);

            if (nodoEncontrado == null)
                return null;

            nodoActual = nodoEncontrado;
        }

        return nodoActual;
    }


    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie hijo = this.hijos[s.charAt(0) - 'a'];

        return hijo;
    }

    private void buscarTodasLasPalabras(String s, TNodoTrie nodo, LinkedList<String> palabras) {
        if (nodo.esPalabra) {
            palabras.add(s);
        }

        for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
            if (nodo.hijos[c] != null) {
                buscarTodasLasPalabras(s + (char) (c + 'a'), nodo.hijos[c], palabras);
            }
        }
    }

    @Override
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodoPrefijo = this.buscarPrefijo(prefijo);

        if (nodoPrefijo == null) {
            return;
        }

        this.buscarTodasLasPalabras(prefijo, nodoPrefijo, palabras);
    }

    @Override
    public int buscar(String s) {
        String[] caracteres = s.split("");

        TNodoTrie nodoActual = this;

        int contador = 0;

        for (String car : caracteres) {
            contador += 1;
            TNodoTrie nodoEncontrado = nodoActual.buscarNodoTrie(car);

            if (nodoEncontrado == null)
                return 0;

            nodoActual = nodoEncontrado;
        }

        if (nodoActual.esPalabra) {
            return contador;
        }

        return 0;
    }
}
