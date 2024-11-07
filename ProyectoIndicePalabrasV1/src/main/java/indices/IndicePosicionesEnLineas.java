package indices;

import java.util.*;

public class IndicePosicionesEnLineas extends Indice {

    // Mapa que asocia cada palabra significativa con el conjunto de líneas donde aparece
    private Map<String, Map<Integer, Set<Integer>>> palabras;

    // Constructor: inicializa el mapa de palabras como un TreeMap para mantener orden alfabético
    public IndicePosicionesEnLineas() {
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

        // Recorrer cada línea y procesar las palabras con sus posiciones
        for (int numLinea = 0; numLinea < texto.size(); numLinea++) {
            String linea = texto.get(numLinea).toLowerCase();
            try (Scanner scanner = new Scanner(linea)) {
                scanner.useDelimiter(delimitadores);
                int posicion = 0; // Posición de la palabra en la línea

                while (scanner.hasNext()) {
                    String palabra = scanner.next().toLowerCase();

                    // Si la palabra es significativa
                    if (!noSignificativasMinusculas.contains(palabra)) {
                        // Obtener el mapa de líneas para la palabra, o crear uno nuevo si no existe
                        Map<Integer, Set<Integer>> lineas = palabras.computeIfAbsent(palabra, k -> new TreeMap<>());

                        // Obtener el conjunto de posiciones para la línea actual, o crear uno nuevo si no existe
                        Set<Integer> posiciones = lineas.computeIfAbsent(numLinea + 1, k -> new TreeSet<>());

                        // Añadir la posición de la palabra en la línea actual
                        posiciones.add(posicion);
                    }
                    posicion++; // Incrementa la posición para la siguiente palabra
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
        for (Map.Entry<String, Map<Integer, Set<Integer>>> palabraEntry : palabras.entrySet()) {
            System.out.println(palabraEntry.getKey() + ":");
            for (Map.Entry<Integer, Set<Integer>> lineaEntry : palabraEntry.getValue().entrySet()) {
                System.out.println("  Línea " + lineaEntry.getKey() + ": " + lineaEntry.getValue());
            }
        }
    }
}
