package uy.edu.ucu.aed.tdas;

public interface IAlmacen {
    boolean agregarProducto(Producto prod);
    boolean agregarStock(String codProd, int cant);
    float venta(String codProd, int cant);
    Producto eliminarProd(String codProd);
    boolean existen(String codProd);
    void listar();
}
