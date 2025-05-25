public interface IElementoAB<T> {

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */
    public Comparable getEtiqueta();

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */
    public TElementoAB<T> getHijoIzq();

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */
    public TElementoAB<T> getHijoDer();

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @return Elemento a ser asignado como hijo izquierdo.
     */
    public void setHijoIzq(TElementoAB<T> elemento);

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @return Elemento a ser asignado como hijo derecho.
     */
    public void setHijoDer(TElementoAB<T> elemento);

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @param counter contador de operaciones
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    public SearchResult buscar(Comparable unaEtiqueta, int counter);


    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    public InsertResult insertar(TElementoAB<T> elemento, int counter);

    /**
     * Imprime en preorden el arbol separado por guiones.
     *
     * @return String conteniendo el PreOrden
     */
    public String preOrden();

    /**
     * Imprime en inorden el arbol separado por guiones.
     *
     * @return String conteniendo el InOrden
     */
    public String inOrden();

    /**
     * Imprime en postorden el arbol separado por guiones.
     *
     * @return String conteniendo el PostOrden
     */
    public String postOrden();

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
    public T getDatos();

	 /**
     * Elimina un elemento dada una etiqueta.
     * @param unaEtiqueta
     * @return
     */
    public TElementoAB eliminar(Comparable unaEtiqueta);

    /**
     * Devuelve la altura del árbol.
     * @return Altura del árbol.
     */
    public int getAltura();

    /**
     * Devuelve la cantidad de hojas del árbol.
     * @return Cantidad de hojas del árbol.
     */
    public int getCantidadHojas();

    /**
     * Devuelve el tamaño del árbol.
     * @return Tamaño del árbol.
     */
    public int getTamanio();

    /**
     * Devuelve el nivel en el que se encuentra un elemento.
     * @param unaEtiqueta Etiqueta del elemento a buscar.
     * @return Nivel del elemento.
     */
    public int getNivel(Comparable unaEtiqueta);
}
