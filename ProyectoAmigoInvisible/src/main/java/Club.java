import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

/**
 * La clase Club representa un grupo de personas que participan en un amigo invisible.
 * Permite leer socios desde un archivo, asignar amigos invisibles aleatoriamente y
 * mostrar el resultado en consola o en un archivo.
 */
public class Club {

    /** Conjunto de socios del club, almacenado en un LinkedHashSet para mantener el orden de inserción */
    protected Set<Persona> socios;

    /**
     * Constructor que inicializa el conjunto de socios como un LinkedHashSet vacío.
     */
    public Club() {
        socios = new LinkedHashSet<>();
    }

    /**
     * Lee los nombres de los socios desde un archivo y los añade al conjunto de socios.
     *
     * @param fEntrada Nombre del archivo de entrada que contiene los nombres de los socios.
     * @param delim Delimitador para separar nombres en el archivo.
     * @throws IOException Si ocurre un error de lectura del archivo.
     */
    public void lee(String fEntrada, String delim) throws IOException {
        try (Scanner sc = new Scanner(Path.of(fEntrada))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                leeSocios(linea, delim);
            }
        }
    }

    /**
     * Procesa una línea del archivo y agrega los socios a la lista.
     *
     * @param linea Línea que contiene el nombre de un socio.
     * @param delim Delimitador para separar nombres.
     */
    private void leeSocios(String linea, String delim) {
        try (Scanner scLinea = new Scanner(linea)) {
            scLinea.useDelimiter(delim);
            String nombre = scLinea.next();
            creaSocioDesdeString(nombre);
        }
    }

    /**
     * Crea un nuevo socio con el nombre especificado y lo añade al conjunto de socios.
     *
     * @param nombre Nombre del socio a crear.
     */
    protected void creaSocioDesdeString(String nombre) {
        socios.add(new Persona(nombre));
    }

    /**
     * Asigna de forma aleatoria un amigo invisible a cada socio, garantizando que ningún
     * socio sea su propio amigo.
     */
    protected void hacerAmigos() {
        List<Integer> posAmigos = new ArrayList<>();
        List<Persona> listaSocios = new ArrayList<>(socios);

        // Paso 1: Crear una lista de posiciones de 0 a n-1
        for (int i = 0; i < socios.size(); i++) {
            posAmigos.add(i);
        }

        // Paso 2: Barajar hasta que no haya coincidencias
        do {
            Collections.shuffle(posAmigos);
        } while (hayCoincidencias(posAmigos));

        // Paso 3: Asignar amigos invisibles
        for (int i = 0; i < socios.size(); i++) {
            Persona socioActual = listaSocios.get(i);
            int amigoIndice = posAmigos.get(i);
            Persona amigoInvisible = listaSocios.get(amigoIndice);
            socioActual.setAmigo(amigoInvisible);
        }
    }

    /**
     * Comprueba si hay coincidencias en una lista de enteros, es decir, si alguna posición
     * tiene el mismo índice que su valor.
     *
     * @param lista Lista de enteros a comprobar.
     * @return true si hay coincidencias; false si no las hay.
     */
    private static boolean hayCoincidencias(List<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Presenta el amigo invisible de cada socio en el flujo de salida especificado.
     *
     * @param pw PrintWriter para escribir la salida.
     */
    public void presentaAmigos(PrintWriter pw) {
        for (Persona socio : socios) {
            pw.println(socio);
        }
    }

    /**
     * Presenta el amigo invisible de cada socio en un archivo de salida.
     *
     * @param fSalida Nombre del archivo de salida.
     * @throws FileNotFoundException Si el archivo de salida no se puede crear o abrir.
     */
    public void presentaAmigos(String fSalida) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(fSalida);
        presentaAmigos(pw);
        pw.close();
    }
}
