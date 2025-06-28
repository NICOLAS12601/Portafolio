package uy.edu.ucu.aed.tas;

import uy.edu.ucu.aed.tdas.IVertice;
import uy.edu.ucu.aed.tdas.TGrafoDirigido;
import uy.edu.ucu.aed.tdas.UtilGrafos;

import java.util.LinkedList;

public class Main
{    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String aristas="conexiones.txt";
        String vertices="aeropuertos.txt";
        TGrafoDirigido vueleSeguro=UtilGrafos.cargarGrafo(vertices,aristas,false,TGrafoDirigido.class);
        UtilGrafos.imprimirMatrizMejorado(UtilGrafos.obtenerMatrizCostos(vueleSeguro.getVertices()),vueleSeguro.getVertices(),"Matriz de adyacencias");

        UtilGrafos.imprimirMatrizMejorado(vueleSeguro.floyd(),vueleSeguro.getVertices(),"Matriz de floyd");

        System.out.println("Distancia mínima entre MVD y BUE: " +
                vueleSeguro.distanciaMinima("Montevideo", "Buenos_Aires"));

        System.out.println("El itinerario de menor costo entre MVD y ASUN es:" +
                vueleSeguro.itinerario("Montevideo","Asuncion"));

        System.out.println("Si la aerolínea decide instalar un nuevo centro de mantenimiento y logística para sus aviones, " +
                "el aeropuerto más indicado al cual todos los demás destinos pueden acceder en menor tiempo es: " + vueleSeguro.centroDelGrafo());

        //APARTIR DE ESTE PUNTO ES EL TA4
        //BUSQUEDA EN PROFUNDIDAD DESDE TODOS LOS VERTICES
        LinkedList<IVertice> lista= (LinkedList<IVertice>) vueleSeguro.bpf();
        for(IVertice ver:lista){
            System.out.println(ver.getEtiqueta());
        }
        //BUSQUEDA EN PROFUNDIDAD DESDE UN VERTICE SOLO
        lista=(LinkedList<IVertice>) vueleSeguro.bpf("Santos");
        for(IVertice ver:lista) {
            System.out.println(ver.getEtiqueta());
        }

    }
}
