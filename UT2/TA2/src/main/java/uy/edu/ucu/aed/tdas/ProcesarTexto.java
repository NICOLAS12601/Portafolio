package uy.edu.ucu.aed.tdas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProcesarTexto {

    public String[][] listarProductos(String archivo) throws IOException {

        String[][] productos=null;

        File nuevoArchivo = new File(archivo);
        FileReader fr = new FileReader(nuevoArchivo);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> lineas = new ArrayList<>();
        String linea;
        int i=0;

        while ((linea = br.readLine())!= null){
            lineas.add(linea);
            i++;

        }
        productos = new String[i][4];

        for (int j =0;j<lineas.size();j++){
            String[] partes = lineas.get(j).split(",");
            productos[j][0] = partes[0];
            productos[j][1] = partes[1];
            productos[j][2] = partes[2];
            productos[j][3] = partes[3];

        }
        return productos;
    }

    public String[][] procesarVentas(String archivo) throws IOException {
        String[][] productos=null;

        File nuevoArchivo = new File(archivo);
        FileReader fr = new FileReader(nuevoArchivo);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> lineas = new ArrayList<>();
        String linea;
        int i=0;

        while ((linea = br.readLine())!= null){
            lineas.add(linea);
            i++;

        }
        productos = new String[i][2];

        for (int j =0;j<lineas.size();j++){
            String[] partes = lineas.get(j).split(",");
            productos[j][0] = partes[0];
            productos[j][1] = partes[1];


        }
        return productos;

    }
}
