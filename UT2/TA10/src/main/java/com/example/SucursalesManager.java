package com.example;

import java.io.*;
import java.util.LinkedList;

public class SucursalesManager {
    private LinkedList<String> sucursales;

    public SucursalesManager() {
        sucursales = new LinkedList<>();
    }

    public void cargarSucursalesDesdeArchivo(String nombreArchivo) {
        sucursales.clear();

        try {
            File archivo = new File(nombreArchivo);

            if (archivo.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(archivo));
                String linea;

                do {
                    linea = reader.readLine();

                    if (linea != null) {
                        linea = linea.trim();

                        if (!linea.isEmpty()) {
                            sucursales.add(linea);
                        }
                    }
                } while (linea != null);

                reader.close();

                System.out.println("Sucursales cargadas exitosamente desde " + nombreArchivo);
                System.out.println("Total de sucursales: " + cantidadSucursales());
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    } // O(n)

    public void agregarSucursal(String ciudad) {
        if (!sucursales.contains(ciudad)) {
            sucursales.add(ciudad);
            System.out.println("Sucursal agregada exitosamente en " + ciudad);
        } else {
            System.out.println("Ya existe una sucursal en " + ciudad);
        }
    } // O(n)

    public String buscarSucursal(String ciudad) {
        int index = sucursales.indexOf(ciudad);

        if (index == -1) return null;

        return sucursales.get(index);
    } // O(n)

    public String obtenerSiguienteCiudad(String ciudad) {
        int index = sucursales.indexOf(ciudad);

        if (index != -1 && index < sucursales.size() - 1) {
            return sucursales.get(index + 1);
        }

        return null;
    } // O(n)

    public boolean quitarSucursal(String ciudad) {
        String ciudadEncontrada = null;
        for (String c : sucursales) {
            String parsed = c.replaceAll("^[^\\p{ASCII}]+", "").trim(); // Eliminamos caracteres no ASCII

            if (parsed.equals(ciudad)) {
                ciudadEncontrada = c;
                break;
            }
        }

        if (ciudadEncontrada != null) {
            sucursales.remove(ciudadEncontrada);
            System.out.println("Ciudad " + ciudad + " eliminada exitosamente");
            return true;
        } else {
            System.out.println("No se encontró la ciudad " + ciudad);
            return false;
        }
    } // O(n)

    public void listarSucursales() {
        if (sucursales.isEmpty()) {
            System.out.println("No hay sucursales registradas");
        } else {
            System.out.println("\nLista de Sucursales:");

            for (String ciudad : sucursales) {
                System.out.println("- " + ciudad);
            }
        }
    } // O(n)

    public void Imprimir(String separador) {
        int cantidad = cantidadSucursales();

        if (cantidad > 0) {
            for (int i = 0; i < cantidad; i++) {
                System.out.print(sucursales.get(i) + separador);
            }
        }
    } // O(n)

    public int cantidadSucursales() {
        return sucursales.size();
    } // O(1)

    public boolean estaVacio() {
        return sucursales.isEmpty();
    } // O(1)
}
