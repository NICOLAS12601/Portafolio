package uy.edu.ucu.aed.tdas;
import java.text.Normalizer;

public class Lista<T> implements ILista<T> {

    private class Nodo<T> {

        private final Comparable etiqueta;
        private T dato;
        private Nodo<T> siguiente = null;


        public Nodo(Comparable etiqueta, T dato) {
            this.etiqueta = etiqueta;
            this.dato = dato;
        }
    }

    private Nodo<T> primero;
    private Nodo<T> actual= null;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        if (primero == null) {
            this.primero = new Nodo(clave, dato);
            actual = this.primero;



            return;
        }

        Nodo actual = primero;

        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }



        actual.siguiente = new Nodo(clave, dato);


    }

    @Override
    public T buscar(Comparable clave) {
        if (primero == null) {
            return null;
        }
        else {
            Nodo actual = primero;
            while (!actual.etiqueta.equals(clave) && actual.siguiente != null) {
                actual = actual.siguiente;
            }
            if (actual.etiqueta.equals(clave)){
                return (T) actual.dato;
            }else {
                return null;
            }
        }

    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }
        else {
            Nodo actual = primero;
            Nodo anterior = null;
            while (!actual.etiqueta.equals(clave) && actual.siguiente != null) {
                anterior = actual;
                actual = actual.siguiente;
            }
            if (actual.etiqueta.equals(clave)) {
                if (anterior == null) {
                    primero = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String imprimir() {
        String resultado = "";
       if(primero==null){
           resultado = "La lista esta vacia";
       return resultado;}
       else {
           Nodo actual = primero;
           while (actual != null) {
               resultado += actual.dato + " ";
               actual = actual.siguiente;
           }
       return resultado;}
    }

    @Override
    public String imprimir(String separador) {
        String resultado = "";
        if(primero==null){
            resultado = "La lista esta vacia";
            return resultado;}
        else {
            Nodo actual = primero;
            while (actual != null) {
                resultado += actual.dato + separador;
                actual = actual.siguiente;
            }
            return resultado;}

    }

    @Override
    public int cantElementos() {
        if(primero == null){
            return 0;
        }
        else {
            Nodo actual = primero;
            int cantElementos = 0;
            while (actual != null) {
                cantElementos++;
                actual = actual.siguiente;
            }
            return cantElementos;

        }


    }

    @Override
    public boolean esVacia() {
        if(primero == null){
            return true;
        }
        else {return false;}

    }

    public boolean recorrido(){
        if(actual==null){
            return true;
        }else return false;
    }

    public T obtenerDato() {
        return actual.dato;
    }
    public T obtenerElPrimero() {
        return primero.dato;
    }

    public void insertarOrdenado(T dato, Comparable etiquetaNueva,Comparable etiquetaAnterior ) {

        Nodo nuevoNodo= new Nodo(etiquetaNueva, dato);

        Nodo actual = primero;
        if(actual==null){// la lista esta vacia
            primero = nuevoNodo;
            return;
        }
        if(actual.etiqueta==etiquetaAnterior){// Se inserta al inicio
            actual.siguiente = nuevoNodo;
            primero = nuevoNodo;
        }else {
            while(actual.siguiente!=null & actual.siguiente.etiqueta!=etiquetaAnterior){
                actual = actual.siguiente;
            }
            if(actual.siguiente==null){// va al final
                actual.siguiente=nuevoNodo;
            }else{// encontro la posicion
                nuevoNodo.siguiente = actual.siguiente;
                actual.siguiente = nuevoNodo;
            }
        }


   }

   public void  avanzar() {
        actual=actual.siguiente;
   }
   public void resetActual(){
        actual=primero;
   }
}


class StringUtils {

    public static String limpiarNombre(String input) {
        // Pasa a minúsculas
        String limpio = input.toLowerCase();

        // Elimina acentos y normaliza
        limpio = Normalizer.normalize(limpio, Normalizer.Form.NFD);
        limpio = limpio.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        // Elimina caracteres no alfabéticos (puedes ajustar si querés mantener espacios, por ejemplo)
        limpio = limpio.replaceAll("[^a-z]", "");

        return limpio;
    }
}
