package indices;
import java.util.*;

public class IndiceLineas extends Indice {

    // Mapa que asocia cada palabra significativa con el conjunto de líneas donde aparece
    private Map<String, Set<Integer>> palabras;

    // Constructor: inicializa el mapa de palabras como un TreeMap para mantener orden alfabético
    public IndiceLineas() {
        super();
        this.palabras = new TreeMap<>(); // TreeMap para ordenar automáticamente las palabras
    }

    /**
     * Añade una línea al texto y limpia el índice, ya que cualquier cambio en el texto
     * invalida el índice de palabras.
     *
     * @param linea La línea de texto a agregar
     */
    @Override
    public void agregarLinea(String linea) {
        texto.add(linea); // Agregar la línea al texto
        palabras.clear(); // Limpiar el índice porque ya no es válido
    }

    /**
     * Construye el índice de palabras, asociando a cada palabra significativa todas las líneas
     * en las que aparece. Ignora palabras no significativas y no distingue entre mayúsculas y minúsculas.
     *
     * @param delimitadores    Los caracteres de delimitación para separar palabras
     * @param noSignificativas Las palabras a ignorar al construir el índice
     */
    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        // Crear un conjunto de palabras no significativas en minúsculas
        Set<String> noSignificativasMinusculas = new HashSet<>();
        for (String palabra : noSignificativas) {
            noSignificativasMinusculas.add(palabra.toLowerCase());
        }

        // Recorrer cada línea y procesar las palabras
        for (int numLinea = 0; numLinea < texto.size(); numLinea++) {
            String linea = texto.get(numLinea).toLowerCase(); // Convertir la línea a minúsculas

            try (Scanner scanner = new Scanner(linea)) { // Uso de try-with-resources
                scanner.useDelimiter(delimitadores);

                while (scanner.hasNext()) {
                    String palabra = scanner.next().toLowerCase();

                    // Si la palabra es significativa
                    if (!noSignificativasMinusculas.contains(palabra)) {
                        // Si la palabra no está en el mapa, añadirla con un conjunto vacío
                        palabras.computeIfAbsent(palabra, k -> new HashSet<>());

                        // Añadir el número de línea al conjunto de líneas para esa palabra
                        palabras.get(palabra).add(numLinea + 1); // +1 porque el índice empieza en 0
                    }
                }
            }
        }
    }

    /**
     * Muestra el índice en la consola, presentando cada palabra significativa y
     * el conjunto de líneas donde aparece.
     */
    @Override
    public void presentarIndiceConsola() {
        for (Map.Entry<String, Set<Integer>> entrada : palabras.entrySet()) {
            System.out.print(entrada.getKey() + "\t");
            for (Integer linea : entrada.getValue()) {
                System.out.print(linea + ".");
            }
            System.out.println(); // Nueva línea después de cada palabra
        }
    }
}
