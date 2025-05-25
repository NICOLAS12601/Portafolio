package com.example;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        SucursalesManager manager = new SucursalesManager();

        // Test 1: Cargar suc1.txt
        System.out.println("=== Test 1: Cargando suc1.txt ===");
        manager.cargarSucursalesDesdeArchivo("sucursales.txt");
        //Son 107 ciudades

        // // Test 2: Eliminar Chicago y buscar siguiente de Hong Kong
        System.out.println("\n=== Test 2: Eliminando Chicago y buscando siguiente de Hong Kong ===");
        manager.quitarSucursal("Chicago");
        try {
            String siguienteCiudad = manager.obtenerSiguienteCiudad("Hong Kong");
            System.out.println("Ciudad siguiente a Hong Kong: " + siguienteCiudad);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // La ciudad siguiente a Hong Kong es Shenzhen


        // Test 3: Cargar suc2.txt y eliminar ciudades
        System.out.println("\n=== Test 3: Cargando suc2.txt y eliminando ciudades ===");
        manager.cargarSucursalesDesdeArchivo("suc2.txt");
        manager.listarSucursales();
        manager.quitarSucursal("Tokio");
        manager.quitarSucursal("Shenzhen");
        manager.listarSucursales();
        // Seria la c) Queda vacía y da error de ejecución pero en nuestro caso no retorna una excepción ya que devuelve null en caso de que no exista la ciudad


        // // Test 4: Cargar suc3.txt e imprimir con separador
        System.out.println("\n=== Test 4: Cargando suc3.txt e imprimiendo con separador ===");
        manager.cargarSucursalesDesdeArchivo("suc3.txt");
        manager.Imprimir(";_");
        //Imprime: Montreal;_Caracas;_Tulsa;_Mobile;_Vancouver;_
    }
}
