package uy.edu.ucu.aed.tdas;

import javax.print.DocFlavor;
import java.util.*;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, IVertice> vertices; // vertices del grafo.-
    private Double[][] matrizFloyd = null;
    private boolean floydCalculado = false;
    private String[][] matrizPredeceroes=null;

    public TGrafoDirigido(Collection<IVertice> vertices, Collection<IArista> aristas) {
        this.vertices = new HashMap<>();
        for (IVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (IArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            IVertice vertOrigen = buscarVertice(nomVerticeOrigen);
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
        IVertice vertOrigen = buscarVertice(etiquetaOrigen);
        IVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
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
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private IVertice buscarVertice(Comparable unaEtiqueta) {
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
    public boolean insertarArista(IArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            IVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            IVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            IVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override
    public boolean insertarVertice(IVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, IVertice> mapOrdenado = new TreeMap<>(this.getVertices());

        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, IVertice> getVertices() {
        return vertices;
    }

    public Comparable centroDelGrafo() {
        int cant = vertices.size();
        if (cant == 0) return null;

        Double[] excentricidades = new Double[cant];
        Object[] aeropuertos = getEtiquetasOrdenado();
        int indice = 0;

        //Obtengo la excentricidad de cada aeropuerto
        for (Object obj : aeropuertos) {
            Comparable etiqueta = (Comparable) obj;
            Double ex = (Double) obtenerExcentricidad(etiqueta);
            if (ex == null) ex = Double.POSITIVE_INFINITY; // Para evitar NullPointerEx
            excentricidades[indice] = ex;
            indice++;
        }
        // fijo un resultado, el primero
        double min = excentricidades[0];
        Comparable aeropuertoCentro = (Comparable) aeropuertos[0];
        // luego comparo para sacar el min
        for (int j = 1; j < cant; j++) {
            if (excentricidades[j] < min) {
                min = excentricidades[j];
                aeropuertoCentro = (Comparable) aeropuertos[j];
            }
        }

        return aeropuertoCentro;
    }




    public Double[][] floyd() {

        if (floydCalculado && matrizFloyd != null) {
            return matrizFloyd;
        }


        int cant=vertices.size();
        Double[][] resultado= new Double[cant][cant];
        //me devuelve los aeropuertos ordenados alfabeticamente
        Object[] aeropuertos=getEtiquetasOrdenado();

        //INICIALIZO LA MATRIZ RESULTADO
        for(int i=0;i<cant;i++){
            for (int j=0;j<cant;j++){
                if(i==j){
                    resultado[i][j]=0d;
                }else{
                    resultado[i][j]=Double.POSITIVE_INFINITY;
                }
            }
        }

        String[][] predecesores=new String[cant][cant];
        for(int i=0;i<cant;i++){
            for (int j=0;j<cant;j++){
                predecesores[i][j]=null;
            }
        }
        //Cargo la matriz con los costos de vertices adyacentes
        for(int i=0;i<cant;i++){
            Comparable etiqueta = (Comparable) aeropuertos[i];
            IVertice ciudad = vertices.get(etiqueta);
            for(IAdyacencia ady: ciudad.getAdyacentes()){
                int j=posicionEtiqueta(ady.getDestino().getEtiqueta(),aeropuertos);
                resultado[i][j]=ady.getCosto();
                //me guardo la ciudad anterior a llegar al destino j, que en este caso es la ciudad origen i
                predecesores[i][j]=aeropuertos[i].toString();// significa que puede viajar directo
            }
        }
        //Recien ahora algoritmo de Floyd
        for (int k=0;k<cant;k++)
         for(int i=0;i<cant;i++)
          for (int j=0;j<cant;j++){
           if(resultado[i][k]+resultado[k][j]<resultado[i][j]){
            resultado[i][j]=resultado[i][k]+resultado[k][j];
            //actualizo la ciudad anterior a llegar al destino j desde i, que pasa a ser k
            predecesores[i][j]=predecesores[k][j];
            }
          }
        // Guardar el resultado
        this.matrizPredeceroes=predecesores;
        this.matrizFloyd = resultado;
        this.floydCalculado = true;

        return resultado;
    }

    // Método auxiliar para encontrar la posición de una etiqueta en el array
    private int posicionEtiqueta(Comparable etiqueta, Object[] etiquetas) {
        for (int i = 0; i < etiquetas.length; i++) {
            if (etiquetas[i].equals(etiqueta)) {
                return i;
            }
        }
        return -1;
    }
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        Object[] aeropuertos = getEtiquetasOrdenado();
        int i = posicionEtiqueta(etiquetaVertice, aeropuertos);
        Double[][]matriz;

        if(!floydCalculado){
            matriz=floyd();}

        matriz=matrizFloyd;

        Double resultado = -1d;
        int cant = vertices.size();

        // Recorremos la columna i: de todos los vértices j hacia el vértice i
        for (int j = 0; j < cant; j++) {
            if (matriz[j][i] != Double.POSITIVE_INFINITY && matriz[j][i] > resultado) {
                resultado = matriz[j][i];
            }
        }


        return resultado;
    }


    public boolean[][] warshall() {
        int cant=vertices.size();
        //Inicializo los valores con falso
        boolean[][] resultado= new boolean[cant][cant];
        for(int i=0;i<cant;i++){
            for(int j=0;j<cant;j++){
               resultado[i][j]=false;}
        }

        Double[][]matriz;

        if(!floydCalculado){
        matriz=floyd();}

        matriz=matrizFloyd;

        for(int i=0;i<cant;i++){
            for(int j=0;j<cant;j++){
                if(matriz[i][j]!= Double.POSITIVE_INFINITY){
                    resultado[i][j]=true;
                }
            }
        }
    return resultado;}

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void desvisitarVertices() {
        // TODO Auto-generated method stub
        
    }
    public Double distanciaMinima(Comparable origen, Comparable destino){
        Double[][]matriz;

        if(!floydCalculado){
            matriz=floyd();}

        matriz=matrizFloyd;

        Object[]aeropuertos=getEtiquetasOrdenado();
        int i=posicionEtiqueta(origen,aeropuertos);
        int j=posicionEtiqueta(destino,aeropuertos);

        if (i == -1 || j == -1) {
            // Origen o destino no existen
            return null;
        }
        Double distancia = matriz[i][j];
        if (distancia == Double.POSITIVE_INFINITY) {
            // No hay camino entre origen y destino
            return null;
        }

        return distancia;
    }
    public String itinerario(Comparable origen, Comparable destino) {
        if (!floydCalculado) {
            floyd();
        }

        Object[] etiquetas = getEtiquetasOrdenado();
        int ori = posicionEtiqueta(origen, etiquetas);
        int dest = posicionEtiqueta(destino, etiquetas);

        ArrayList<String> itinerario = new ArrayList<>();
        while (matrizPredeceroes[ori][dest] != null &&
                !matrizPredeceroes[ori][dest].equals(etiquetas[ori].toString())) {
            String ciudadIntermedia = matrizPredeceroes[ori][dest];
            itinerario.add(ciudadIntermedia);
            ori = posicionEtiqueta(ciudadIntermedia, etiquetas);
        }

        StringBuilder textoProcesado = new StringBuilder();
        textoProcesado.append(origen.toString());

        for (String intermedia : itinerario) {
            textoProcesado.append(" -> ").append(intermedia);
        }

        textoProcesado.append(" -> ").append(destino.toString());

        return textoProcesado.toString();
    }
    public Collection bpf(){

        LinkedList<IVertice> verticesVisitado=new LinkedList<IVertice>();

        for(IVertice vertice : vertices.values()){
            if(!vertice.getVisitado()){
                LinkedList<IVertice> nuevaLista=vertice.bpf();
                for(IVertice ver: nuevaLista){
                    verticesVisitado.add(ver);
                }
            }

        }
        return verticesVisitado;

    }
    public Collection bpf(Comparable etiquetaOrigen){

        IVertice origen=vertices.get(etiquetaOrigen);

        return origen.bpf();
    }



}

