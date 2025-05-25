package uy.edu.ucu.aed.tdas;

public class Producto implements IProducto {

        String nombreProducto;
        String codProd;
        float precioUnitario;
        int cantidad;

        public Producto(String nombreProducto, String codProd, float precioUnitario, int cantidad) {
            this.nombreProducto = nombreProducto;
            this.codProd = codProd;
            this.precioUnitario = precioUnitario;
            this.cantidad = cantidad;
        }

        public String getNombreProducto() {
            return nombreProducto;
        }

    }
