package indices;
import java.util.*;

public class Indice1aLinea extends Indice {

    // Mapa para almacenar la primera línea donde aparece cada palabra significativa
    private Map<String, Integer> palabras;

    // Constructor: inicializa la lista de texto y el mapa de palabras
    public Indice1aLinea() {
        super();
        this.palabras = new TreeMap<>(); // TreeMap para mantener las palabras ordenadas alfabéticamente
    }

    /**
     * Añade una línea al texto y limpia el índice, ya que cualquier cambio en el texto
     * invalida el índice de palabras.
     *
     * @param linea La línea de texto a agregar
     */
    @Override
    public void agregarLinea(String linea) {
        texto.add(linea); // Añadir la línea al texto
        palabras.clear(); // Limpiar el índice porque ya no es válido
    }

    /**
     * Construye el índice de palabras, asociando a cada palabra significativa la primera línea
     * en la que aparece. Ignora palabras no significativas y no distingue entre mayúsculas y minúsculas.
     *
     * @param delimitadores    Los caracteres de delimitación para separar palabras
     * @param noSignificativas Las palabras a ignorar al construir el índice
     */
    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Set<String> noSignificativasMinusculas = new HashSet<>();
        for (String palabra : noSignificativas) {
            noSignificativasMinusculas.add(palabra.toLowerCase());
        }

        for(int numLinea = 0; numLinea < texto.size(); numLinea++)
        {
            String linea = texto.get(numLinea).toLowerCase();
            try(Scanner scanner = new Scanner(linea)){
                scanner.useDelimiter(delimitadores);

                while(scanner.hasNext()){
                    // Guerra
                    // tenía
                    // una
                    // jarra y Parra tenía una perra, pero la perra de Parra rompió la jarra de Guerra.
                    String palabra = scanner.next().toLowerCase();
                    if(!palabras.containsKey(palabra) && !noSignificativasMinusculas.contains(palabra))
                        palabras.put(palabra,numLinea+1);
                }
            }
        }
    }

    /**
     * Muestra el índice en la consola, presentando cada palabra significativa y el número de
     * la primera línea donde aparece.
     */
    @Override
    public void presentarIndiceConsola() {
        for (Map.Entry<String, Integer> entrada : palabras.entrySet()) {
            System.out.println(entrada.getKey() + ": " + entrada.getValue());
        }
    }
}
