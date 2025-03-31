package org.example;

public class Marcapasos {

    short presionSanguinea; // 2 bytes
    short frecuenciaCardiaca;// 2 bytes
    short azucarEnSangre; // 2 bytes
    long maximaFuerza; // 8 bytes
    float minimoTiempoEntreLatidos; // 4 bytes
    double bateriaRestante; // 8 bytes
    char[] codigoFabricante=new char[8]; // 2bytes*8=16bytes

    // la suma de toda la memoria utilizada en las variables es de 42 bytes

    public Marcapasos(short presionSanguinea, short frecuenciaCardiaca, short azucarEnSangre,
                      long maximaFuerza, float minimoTiempoEntreLatidos, double bateriaRestante, char[] codigoFabricante) {
        this.presionSanguinea=presionSanguinea;
        this.frecuenciaCardiaca=frecuenciaCardiaca;
        this.azucarEnSangre=azucarEnSangre;
        this.maximaFuerza=maximaFuerza;
        this.minimoTiempoEntreLatidos=minimoTiempoEntreLatidos;
        this.bateriaRestante=bateriaRestante;
        this.codigoFabricante=codigoFabricante;
    }

}
