
import static java.lang.System.in;
import java.util.Collection;

public class main {

    public static void main(String[] args) {
        TGrafoDirigido gd = (TGrafoDirigido) UtilGrafos.cargarGrafo("TA5/src/aeropuertos_2.txt", "TA5/src/conexiones_2.txt",
                false, TGrafoDirigido.class);

        TCaminos caminos = gd.todosLosCaminos("Santos", "Curitiba");

        caminos.imprimirCaminosConsola();

        gd.tieneCiclo();

    }
}
