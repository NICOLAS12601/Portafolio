public class TArbolBB<T> implements IArbolBB<T> {

    private TElementoAB<T> raiz;

    /**
     * Separador utilizado entre elemento y elemento al imprimir la lista
     */
    public static final String SEPARADOR_ELEMENTOS_IMPRESOS = "-";

    public TArbolBB() {
        raiz = null;
    }

    /**
     * Inserta un elemento en el arbol. En caso de ya existir un elemento con la
     * clave indicada en "unElemento", retorna falso.
     *
     * @param unElemento Elemento a insertar
     * @return Exito de la operacián
     */

    @Override
    public InsertResult insertar(TElementoAB<T> unElemento) {
        if (raiz == null) {

            raiz = unElemento;

            return new InsertResult(0, true);
        }

        InsertResult insercion = raiz.insertar(unElemento, 0);

        return insercion;
    }

    /**
     * Busca un elemento dentro del árbol.
     *
     *
     * @param unaEtiqueta Etiqueta identificadora del elemento a buscar.
     *                    .
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    @Override
    public SearchResult buscar(Comparable unaEtiqueta) {
        if (raiz == null) {
            return null;
        }

        return raiz.buscar(unaEtiqueta, 0);
    }

    /**
     * Imprime en PreOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    @Override
    public String preOrden() {
        if (raiz == null) {
            return "";
        }
        return raiz.preOrden();
    }

    /**
     * Imprime en InOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    @Override
    public String inOrden() {
        if (raiz == null) {
            return "";
        }
        return raiz.inOrden();
    }

    /**
     * Imprime en PostOrden los elementos del árbol, separados por guiones.
     *
     * @return String conteniendo el preorden separado por guiones.
     */
    @Override
    public String postOrden() {
        if (raiz == null) {
            return "";
        }

        return raiz.postOrden();
    }

    /**
     * Elimina un elemento dada una etiqueta.
     *
     * @param unaEtiqueta
     */
    @Override
    public void eliminar(Comparable unaEtiqueta) {
        if (raiz != null) {
            raiz = raiz.eliminar(unaEtiqueta);
        }
    }

    /**
     * Devuelve la altura del árbol.
     *
     * @return Altura del árbol.
     */
    @Override
    public int getAltura() {
        if (raiz != null) {
            return raiz.getAltura();
        } else {
            return -1;
        }
    }

    /**
     * Devuelve la cantidad de hojas del árbol.
     *
     * @return Cantidad de hojas del árbol.
     */
    @Override
    public int getCantidadHojas() {
        if (raiz != null) {
            return raiz.getCantidadHojas();
        } else {
            return 0;
        }
    }

    /**
     * Devuelve el tamaño del árbol.
     *
     * @return Tamaño del árbol.
     */
    @Override
    public int getTamanio() {
        if (raiz != null) {
            return raiz.getTamanio();
        } else {
            return 0;
        }
    }

    /**
     * Devuelve el nivel en el que se encuentra un elemento.
     *
     * @param unaEtiqueta Etiqueta del elemento a buscar.
     * @return Nivel del elemento.
     */
    @Override
    public int getNivel(Comparable unaEtiqueta) {
        if (raiz != null) {
            return raiz.getNivel(unaEtiqueta);
        } else {
            return -1;
        }
    }

    /**
     * Devuelve la menor clave del árbol.
     * @return Menor clave del árbol.
     */
    public Comparable obtenerMenorClave() {
        if (raiz == null) return null;
        return raiz.obtenerMenorClave();
    }

    /**
     * Devuelve la mayor clave del árbol.
     * @return Mayor clave del árbol.
     */
    public Comparable obtenerMayorClave() {
        if (raiz == null) return null;
        return raiz.obtenerMayorClave();
    }

    /**
     * Devuelve la clave anterior a la clave indicada.
     * @param clave Clave a buscar.
     * @return Clave anterior a la clave indicada.
     */
    public Comparable obtenerClaveAnterior(Comparable clave) {
        if (raiz == null) return null;

        return raiz.obtenerClaveAnterior(clave);
    }

    /**
     * Devuelve la cantidad de nodos en el nivel indicado.
     * @param nivel Nivel a buscar.
     * @return Cantidad de nodos en el nivel indicado.
     */
    public int cantidadNodosEnNivel(int nivel) {
        if (raiz == null) return 0;
        return raiz.cantidadNodosEnNivel(nivel, 0);
    }

    /**
     * Lista las hojas del árbol con el nivel indicado.
     * @param nivel Nivel a buscar.
     */
    public void listarHojasConNivel() {
        if (raiz != null) raiz.listarHojasConNivel(0);
    }

    /**
     * Devuelve true si el árbol es de búsqueda.
     * @return true si el árbol es de búsqueda, false en caso contrario.
     */
    public boolean esDeBusqueda() {
        if (raiz == null) return true;
        return raiz.esDeBusqueda(null, null);
    }
}
