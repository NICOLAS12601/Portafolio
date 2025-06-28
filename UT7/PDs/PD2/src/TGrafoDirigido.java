
import javax.naming.spi.ObjectFactoryBuilder;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-
    private int[][] predecesores;
    private Double[][] matrizFloyd;

    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
        predecesores = null;
        matrizFloyd = null;
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }


    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     * <p>
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     * <p>
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     * <p>
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        Object[]aeropuertos=getEtiquetasOrdenado();
        int tamañio=aeropuertos.length;
        double menorExcentricidad = Double.MAX_VALUE;
        Comparable resultado=null;

        //Calcula la excentricidad para cada vertice y me quedo con la menor
        for(int i=0;i<tamañio;i++){
            Comparable etiqueta = (Comparable) aeropuertos[i];
            double excentricidad = obtenerExcentricidad(etiqueta);
            if(excentricidad!=-1.d && menorExcentricidad>excentricidad){
                menorExcentricidad=excentricidad;
                resultado=etiqueta;
            }
        }
        return resultado;


    }


    @Override
    public Double[][] floyd() {
        //obtengo la listas de aeropuertos ordenada
        Object[] aeropuertos = getEtiquetasOrdenado();
        int cant = aeropuertos.length;
        //inicializo la matriz de floyd con la matriz de costos
        this.matrizFloyd = UtilGrafos.obtenerMatrizCostos(vertices);

        this.predecesores = new int[cant][cant];


        //INICIALIZACION DE MATRIZ DE PREDECESORES
        for (int i = 0; i < cant; i++) {
            for (int j = 0; j < cant; j++) {
                if (i != j && matrizFloyd[i][j] < Double.MAX_VALUE) {
                    predecesores[i][j] = i;
                } else {
                    predecesores[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < cant; k++) {
            for (int i = 0; i < cant; i++) {
                for (int j = 0; j < cant; j++) {
                    if (matrizFloyd[i][k] < Double.MAX_VALUE && matrizFloyd[k][j] < Double.MAX_VALUE) {
                        if (matrizFloyd[i][j] > matrizFloyd[i][k] + matrizFloyd[k][j]) {
                            matrizFloyd[i][j] = matrizFloyd[i][k] + matrizFloyd[k][j];
                            predecesores[i][j] = predecesores[k][j];
                        }
                    }
                }
            }
        }
        return matrizFloyd;
    }

    @Override
    public Double obtenerExcentricidad(Comparable etiquetaVertice) {
        if (matrizFloyd == null) {
            matrizFloyd = floyd();
        }

        int indice = obtenerIndice(etiquetaVertice);
        if (indice != -1) {// Encontro el vértice en la lista de aeropuertos
            Object[] aeropuertos = getEtiquetasOrdenado();
            int tamaño = aeropuertos.length;
            double excentricidad = Double.NEGATIVE_INFINITY;

            for (int i = 0; i < tamaño; i++) {
                if(indice!=i){
                    if(matrizFloyd[i][indice] < Double.MAX_VALUE) {
                        if (matrizFloyd[i][indice] > excentricidad) {
                            excentricidad = matrizFloyd[i][indice];
                        }
                    }else{
                       return -1.0;

                    }
                }
            }

            return excentricidad; // Valor de la excentricidad hacia el vértice dado
        }

        return -1.0; // Si el vértice no existe
    }



    public int obtenerIndice(Comparable etiquetaVertice) {
        int result = -1;
        Object[] aeropuertos = getEtiquetasOrdenado();
        for (int i = 0; i < aeropuertos.length; i++) {
            if (aeropuertos[i].toString().equals(etiquetaVertice)) {
                return i;
            }
        }
        return result;
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
