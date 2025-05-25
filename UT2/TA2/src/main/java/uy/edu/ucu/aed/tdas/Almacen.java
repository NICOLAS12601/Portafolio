package uy.edu.ucu.aed.tdas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Almacen implements IAlmacen {

    ILista<Producto> lista = new Lista<>();

    public boolean agregarProducto(Producto prod){
        if (existen(prod.codProd)){
            agregarStock(prod.codProd, prod.cantidad);
        }else {
            this.lista.insertar(prod,prod.codProd);

        }
        return true; // siempre devuelve true, si no existe lo agerga y si existe aumenta cantidad
    }

    public boolean agregarStock(String codProd, int cant){
        Producto prod =lista.buscar(codProd);
        if (prod != null){
            prod.cantidad += cant;

            return true;
        }else{
            return false;
        }
    }
    public boolean venderVariosProductos(String[][] matriz){
        int totalVendidos = 0;
        for (int j = 0; j < matriz.length; j++) {
            int cantidad = Integer.parseInt(matriz[j][1]);
            totalVendidos+=venta(matriz[j][0], cantidad);
        }
        System.out.println("El total vendido fue: "+ totalVendidos);
        return true;
    }


    public float venta(String codProd, int cant){
        Producto prod =lista.buscar(codProd);
        if (prod != null){
            if(prod.cantidad >= cant){
                prod.cantidad -= cant;
                return cant*prod.precioUnitario;
            }
           else{
               prod.cantidad =0;
               return prod.cantidad*prod.precioUnitario;
            }
        }else{
            return 0;
        }
    }

    public Producto eliminarProd(String codProd){return null;}

    public boolean existen(String codProd){
        Producto prod= lista.buscar(codProd);
        if (prod != null){
            return true;
        }else {
            return false;
        }
    }
    public void listar(){

        if (!lista.esVacia()) {
            ILista<Producto> listaOrdenada = new Lista<>();;
            ILista<Producto> actual = lista;
            // Se arma una nueva lista ordenada,
            //nodo por nodo se va insertando pero de manera ordenada
            while(!actual.recorrido()) {
                Producto prod = actual.obtenerDato();
                String nuevoNombre=StringUtils.limpiarNombre(prod.nombreProducto);
                ILista<Producto> actualListaOrdena = listaOrdenada;
                if(!actualListaOrdena.esVacia()){
                    String nombreActual=StringUtils.limpiarNombre(actualListaOrdena.obtenerDato().nombreProducto);
                    while(!actualListaOrdena.recorrido() & nombreActual.compareTo(nuevoNombre)<=0 ) {
                        actualListaOrdena.avanzar();
                        if(!actualListaOrdena.recorrido()){
                            nombreActual=StringUtils.limpiarNombre(actualListaOrdena.obtenerDato().nombreProducto);
                        }

                       }

                    if(actualListaOrdena.recorrido()){// va al final
                    listaOrdenada.insertar(prod,prod.codProd);}
                    else{
                        listaOrdenada.insertarOrdenado(prod, prod.codProd, actualListaOrdena.obtenerDato().codProd);

                    }
                    actualListaOrdena.resetActual();
                    actual.avanzar();
                }else{
                listaOrdenada.insertar(prod,prod.codProd);
                actual.avanzar();}
                }
                actual.resetActual();

                while(!listaOrdenada.recorrido()){
                    String nombre=listaOrdenada.obtenerDato().nombreProducto;
                    int cantidad =listaOrdenada.obtenerDato().cantidad;
                    System.out.println("El nombre del producto es: "+nombre + " cantidad: "+cantidad);
                    listaOrdenada.avanzar();
                }

                 listaOrdenada = null;
                 actual = null;


        }
        else {
            System.out.println("La lista esta vacia");
        }
    }

    /* Recibe una matriz donde cada columna contiene
    toda la info necesario para construir un producto.
    Construye el producto y lo agrega a la lista del almacen.
    En cada iteracion va alamacenando en una variable aux
    el resultado de la inversion de cada producto. Al final
    devuelve el valor de la inversion total */
    public int agregarVariosProductos(String productos[][]){

        int inversion = 0;
        for (int j =0;j<productos.length;j++){
            String nombre = productos[j][1];
            String codProd = productos[j][0];
            float precio = Float.parseFloat(productos[j][2].replace("\"", "").trim());
            int cantidad = Integer.parseInt(productos[j][3]);
            Producto p = new Producto(nombre,codProd,precio,cantidad);
            agregarProducto(p);
            inversion+=(precio*cantidad);
        }
        return inversion;
    }


}