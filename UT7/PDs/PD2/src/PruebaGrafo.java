public class PruebaGrafo {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("./src/aeropuertos.txt","./src/conexiones.txt",
                false, TGrafoDirigido.class);

        Object[] aeropuertos = gd.getEtiquetasOrdenado();

        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(gd.getVertices());
        UtilGrafos.imprimirMatrizMejorado(matriz, gd.getVertices(), "Matriz");

        Double[][] mfloyd = gd.floyd();

        UtilGrafos.imprimirMatrizMejorado(mfloyd, gd.getVertices(), "Matriz luego de FLOYD");


        for (int i = 0; i < aeropuertos.length; i++) {
            System.out.println("excentricidad de " + aeropuertos[i] + " : " + gd.obtenerExcentricidad((Comparable) aeropuertos[i]));
        }
        System.out.println();
        System.out.println("Centro del grafo: " + gd.centroDelGrafo());



    }
}
