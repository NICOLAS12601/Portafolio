public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB hijoIzq;
    private TElementoAB hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     * @return
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    /**
     * Obtiene el valor de la etiqueta del nodo.
     *
     * @return Etiqueta del nodo.
     */

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * Obtiene el hijo izquierdo del nodo.
     *
     * @return Hijo Izquierdo del nodo.
     */

    @Override
    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    /**
     * Obtiene el hijo derecho del nodo.
     *
     * @return Hijo derecho del nodo.
     */

    @Override
    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * Asigna el hijo izquierdo del nodo.
     *
     * @return Elemento a ser asignado como hijo izquierdo.
     */

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        hijoIzq = elemento;
    }

    /**
     * Asigna el hijo derecho del nodo.
     *
     * @return Elemento a ser asignado como hijo derecho.
     */

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        hijoDer = elemento;
    }

    /**
     * Busca un elemento dentro del arbol con la etiqueta indicada.
     *
     * @param unaEtiqueta del nodo a buscar
     * @return Elemento encontrado. En caso de no encontrarlo, retorna nulo.
     */
    @Override
    public SearchResult buscar(Comparable unaEtiqueta, int counter) {
        if (etiqueta.equals(unaEtiqueta)) {
            return new SearchResult(counter, this);
        }

        if (this.hijoIzq != null && etiqueta.compareTo(unaEtiqueta) > 0) {
            counter++;
            return this.hijoIzq.buscar(unaEtiqueta, counter);
        }

        if (this.hijoDer != null) {
            counter++;
            return this.hijoDer.buscar(unaEtiqueta, counter);
        }

        return new SearchResult(0, null);
    }

    /**
     * Inserta un elemento dentro del arbol.
     *
     * @param elemento Elemento a insertar.
     * @return Exito de la operaci�n.
     */
    @Override
    public InsertResult insertar(TElementoAB<T> elemento, int counter) {
        Comparable elemEtiqueta = elemento.getEtiqueta();

        if (etiqueta.equals(elemEtiqueta)) {
            return new InsertResult(0, false);
        }

        counter++;

        if (etiqueta.compareTo(elemEtiqueta) < 0) {
            if (hijoDer != null) {
                return hijoDer.insertar(elemento, counter);
            }

            hijoDer = elemento;
        } else {
            if (hijoIzq != null) {
                return hijoIzq.insertar(elemento, counter);
            }

            hijoIzq = elemento;
        }

        return new InsertResult(counter, true);
    }

    /**
     * Imprime en preorden el arbol separado por comas.
     *
     * @return String conteniendo el PreOrden
     */

    @Override
    public String preOrden() {
        String tempStr = "";
        String separator = ", ";

        tempStr = tempStr + this.getEtiqueta();

        if (hijoIzq != null) {
            tempStr += separator + hijoIzq.preOrden();
        }

        if (hijoDer != null) {
            tempStr += separator + hijoDer.preOrden();
        }

        return tempStr;
    }

    /**
     * Imprime en inorden el arbol separado por comas.
     *
     * @return String conteniendo el InOrden
     */

     @Override
    public String inOrden() {
        String tempStr = "";
        String separator = ", ";

        if (hijoIzq != null) {
            tempStr += hijoIzq.inOrden() + separator;
        }

        tempStr += this.getEtiqueta();

        if (hijoDer != null) {
            tempStr += separator + hijoDer.inOrden();
        }

        return tempStr;
    }

    /**
     * Imprime en postorden el arbol separado por comas.
     *
     * @return String conteniendo el PostOrden
     */

     @Override
    public String postOrden() {
        String tempStr = "";
        String separator = ", ";

        if (hijoIzq != null) {
            tempStr += hijoIzq.postOrden() + separator;
        }

        if (hijoDer != null) {
            tempStr += hijoDer.postOrden() + separator;
        }

        tempStr += this.getEtiqueta();

        return tempStr;
    }

    /**
     * Retorna los datos contenidos en el elemento.
     *
     * @return
     */
    public T getDatos() {
        return this.datos;
    }

    /**
     * Elimina un elemento dada una etiqueta.
     *
     * @param unaEtiqueta
     * @return
     */

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        SearchResult nodoASacar = this.buscar(unaEtiqueta, 0);

        if (nodoASacar != null){
            TElementoAB resultado = quitaNodo(nodoASacar.inserted);
                return resultado;
        }
        return null;
    }

    public TElementoAB quitaNodo(TElementoAB nodoNominado){
        if (hijoIzq == null)
            return hijoDer;
        if (hijoDer == null)
            return hijoIzq;
        //es un nodo completo
        TElementoAB elHijo = hijoIzq;
        TElementoAB elPadre = this;
        while (elHijo.hijoDer != null){
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }
        if (elPadre != this){
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = hijoIzq;
        }
        elHijo.hijoDer = hijoDer;
        return elHijo;
    }

    /**
     * Devuelve la altura del árbol.
     *
     * @return Altura del árbol.
     */

     @Override
    public int getAltura() {
        int alturaIzq = 0;
        int alturaDer = 0;

        if (hijoIzq != null) {
            alturaIzq = hijoIzq.getAltura();
        }

        if (hijoDer != null) {
            alturaDer = hijoDer.getAltura();
        }

        return Math.max(alturaIzq, alturaDer) + 1;
    }

    /**
     * Devuelve la cantidad de hojas del árbol.
     *
     * @return Cantidad de hojas del árbol.
     */

     @Override
    public int getCantidadHojas() {
        if (hijoIzq == null && hijoDer == null) {
            return 1;
        }

        int cantidadHojas = 0;

        if (hijoIzq != null) {
            cantidadHojas += hijoIzq.getCantidadHojas();
        }

        if (hijoDer != null) {
            cantidadHojas += hijoDer.getCantidadHojas();
        }

        return cantidadHojas;
    }

    /**
     * Devuelve el tamaño del árbol.
     *
     * @return Tamaño del árbol.
     */

    @Override
    public int getTamanio() {
        int tamanioIzq = 0;
        int tamanioDer = 0;

        if (hijoIzq != null) {
            tamanioIzq = hijoIzq.getTamanio();
        }

        if (hijoDer != null) {
            tamanioDer = hijoDer.getTamanio();
        }

        return tamanioIzq + tamanioDer + 1;
    }

    /**
     * Devuelve el nivel en el que se encuentra un elemento.
     *
     * @param unaEtiqueta Etiqueta del elemento a buscar.
     * @return Nivel del elemento.
     */

    @Override
    public int getNivel(Comparable unaEtiqueta) {
        if (etiqueta.equals(unaEtiqueta)) {
            return 0;
        }

        if (hijoIzq != null && etiqueta.compareTo(unaEtiqueta) > 0) {
            return hijoIzq.getNivel(unaEtiqueta) + 1;
        }

        if (hijoDer != null) {
            return hijoDer.getNivel(unaEtiqueta) + 1;
        }

        return -1;
    }

    /**
     * Devuelve la menor clave del árbol.
     *
     * @return Menor clave del árbol.
     */
    public Comparable obtenerMenorClave() {
        if (hijoIzq == null)
            return this.getEtiqueta();
        return hijoIzq.obtenerMenorClave();
    }

    /**
     * Devuelve la mayor clave del árbol.
     *
     * @return Mayor clave del árbol.
     */
    public Comparable obtenerMayorClave() {
        if (hijoDer == null)
            return this.getEtiqueta();
        return hijoDer.obtenerMayorClave();
    }

    /**
     * Devuelve la clave anterior a la clave indicada.
     *
     * @param clave Clave a buscar.
     * @return Clave anterior a la clave indicada.
     */
    public Comparable obtenerClaveAnterior(Comparable clave) {
        if (hijoIzq != null && hijoIzq.getEtiqueta().equals(clave)
                || hijoDer != null && hijoDer.getEtiqueta().equals(clave)) {
            return etiqueta;
        }

        if (hijoIzq != null) {
            Comparable anteriorIzq = hijoIzq.obtenerClaveAnterior(clave);

            if (anteriorIzq != null) {
                return anteriorIzq;
            }
        }

        if (hijoDer != null) {
            Comparable anteriorDer = hijoDer.obtenerClaveAnterior(clave);

            if (anteriorDer != null) {
                return anteriorDer;
            }
        }

        return null;
    }

    /**
     * Devuelve la cantidad de nodos en el nivel indicado.
     *
     * @param nivelBuscado Nivel a buscar.
     * @param nivelActual  Nivel actual.
     * @return Cantidad de nodos en el nivel indicado.
     */
    public int cantidadNodosEnNivel(int nivelBuscado, int nivelActual) {
        int cantidad = 0;
        if (nivelActual == nivelBuscado)
            return 1;
        if (hijoIzq != null)
            cantidad += hijoIzq.cantidadNodosEnNivel(nivelBuscado, nivelActual + 1);
        if (hijoDer != null)
            cantidad += hijoDer.cantidadNodosEnNivel(nivelBuscado, nivelActual + 1);
        return cantidad;
    }

    /**
     * Lista las hojas del árbol con el nivel indicado.
     *
     * @param nivel Nivel a buscar. Inicialmente entra a la raiz con nivel = 0, y va sumando uno por cada nivel que recorre.
     * 
     */
    public void listarHojasConNivel(int nivel) {

        if (hijoIzq != null)
            hijoIzq.listarHojasConNivel(nivel + 1);
             
        if (hijoDer != null) 
            hijoDer.listarHojasConNivel(nivel + 1);

        if (hijoIzq == null && hijoDer == null)
                System.out.println("Hoja: " + etiqueta + " Nivel: " + nivel);
    }

    /**
     * Devuelve true si el árbol es de búsqueda.
     *
     * @param min Valor mínimo.
     * @param max Valor máximo.
     * @return true si el árbol es de búsqueda, false en caso contrario.
     */
    public boolean esDeBusqueda(Comparable min, Comparable max) {
        if ((min != null && etiqueta.compareTo(min) <= 0) || (max != null && etiqueta.compareTo(max) >= 0)) {
            return false;
        }
        boolean izqOk = (hijoIzq == null) || hijoIzq.esDeBusqueda(min, etiqueta);
        boolean derOk = (hijoDer == null) || hijoDer.esDeBusqueda(etiqueta, max);
        return izqOk && derOk;
    }
}
