package uy.edu.ucu.aed.tdas;



import java.io.IOException;

public class main {
  public static void main(String[] args) throws IOException {
   Almacen almacen = new Almacen();
   ProcesarTexto pro = new ProcesarTexto();
   String path="altas.txt";
   String[][] matriz = pro.listarProductos(path);
   int cantidadInvertida=almacen.agregarVariosProductos(matriz);
   System.out.println("Lista de productos agregada con exito, la cantidad invertida fue: "+cantidadInvertida);
   String ventas = "ventas.txt";
   String[][] matriz2 = pro.procesarVentas(ventas);
   almacen.venderVariosProductos(matriz2);
   almacen.listar();

  }
}
