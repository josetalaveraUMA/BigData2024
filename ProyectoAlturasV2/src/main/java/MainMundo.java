import alturas.*;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * La clase MainMundo contiene el metodo principal para ejecutar una aplicación que manipula
 * una lista de países de diferentes maneras, utilizando criterios de selección y ordenación.
 * La aplicación realiza selecciones de países según criterios de altura y continente,
 * y luego organiza los países en conjuntos con varios órdenes.
 */
public class MainMundo {

    /**
     * Metodo principal que ejecuta la aplicación.
     *
     * @param args Los argumentos de línea de comando.
     * @throws IOException si ocurre un error de E/S al leer el archivo de países.
     */
    public static void main(String[] args) throws IOException {
        try {
            // Crea un objeto Mundo y lee los países desde el archivo alturas.txt
            Mundo mundo = new Mundo();
            mundo.leePaises("alturas.txt");

            // Selecciona los países con altura mayor o igual a 1.77 y los imprime
            List<Pais> mayoresQue = mundo.selecciona(new MayoresQue(1.77));
            System.out.println("Países con altura mayor o igual a 1.77:");
            for (Pais pais : mayoresQue) {
                System.out.println(pais);
            }

            // Selecciona los países con altura menor que 1.77 y los imprime
            List<Pais> menoresQue = mundo.selecciona(new MenoresQue(1.77));
            System.out.println("\nPaíses con altura menor que 1.77:");
            for (Pais pais : menoresQue) {
                System.out.println(pais);
            }

            // Selecciona los países del continente "Europe" y los imprime
            List<Pais> enEuropa = mundo.selecciona(new EnContinente("Europe"));
            System.out.println("\nPaíses en Europa:");
            for (Pais pais : enEuropa) {
                System.out.println(pais);
            }

            // Crea un conjunto de países ordenados por altura de menor a mayor y lo imprime
            Set<Pais> conjuntoPorAltura = new TreeSet<>(Comparator.comparingDouble(Pais::altura));
            conjuntoPorAltura.addAll(mundo.getPaises());
            System.out.println("\nPaíses ordenados por altura:");
            for (Pais pais : conjuntoPorAltura) {
                System.out.println(pais);
            }

            // Crea un conjunto de países ordenados alfabéticamente por nombre y lo imprime
            Set<Pais> conjuntoAlfabetico = new TreeSet<>(Comparator.comparing(Pais::nombre));
            conjuntoAlfabetico.addAll(mundo.getPaises());
            System.out.println("\nPaíses ordenados alfabéticamente:");
            for (Pais pais : conjuntoAlfabetico) {
                System.out.println(pais);
            }

            // Crea un conjunto de países ordenados por continente y alfabéticamente por nombre y lo imprime
            Set<Pais> conjuntoPorContinenteYNombre = new TreeSet<>(Comparator.comparing(Pais::continente)
                    .thenComparing(Pais::nombre));
            conjuntoPorContinenteYNombre.addAll(mundo.getPaises());
            System.out.println("\nPaíses ordenados por continente y nombre alfabéticamente:");
            for (Pais pais : conjuntoPorContinenteYNombre) {
                System.out.println(pais);
            }

            // Crea un conjunto de países ordenados por continente y nombre en orden inverso y lo imprime
            Set<Pais> conjuntoPorContinenteYNombreInverso = new TreeSet<>(Comparator.comparing(Pais::continente)
                    .thenComparing(Comparator.reverseOrder()));
            conjuntoPorContinenteYNombreInverso.addAll(mundo.getPaises());
            System.out.println("\nPaíses ordenados por continente y nombre en orden inverso:");
            for (Pais pais : conjuntoPorContinenteYNombreInverso) {
                System.out.println(pais);
            }

            // Crea un conjunto de países ordenados por el orden natural (altura y nombre en caso de igualdad) y lo imprime
            Set<Pais> conjuntoPorOrdenNatural = new TreeSet<>(mundo.getPaises());
            System.out.println("\nPaíses ordenados por el orden natural (altura y nombre):");
            for (Pais pais : conjuntoPorOrdenNatural) {
                System.out.println(pais);
            }

            // Crea un conjunto de países ordenados por continente y luego por el orden natural y lo imprime
            Set<Pais> conjuntoPorContinenteYOrdenNatural = new TreeSet<>(Comparator.comparing(Pais::continente)
                    .thenComparing(Pais::compareTo));
            conjuntoPorContinenteYOrdenNatural.addAll(mundo.getPaises());
            System.out.println("\nPaíses ordenados por continente y luego por orden natural:");
            for (Pais pais : conjuntoPorContinenteYOrdenNatural) {
                System.out.println(pais);
            }

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
