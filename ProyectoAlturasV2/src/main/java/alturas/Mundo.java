
package alturas;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

/**
 * La clase Mundo representa una colección de países y proporciona métodos para seleccionar países
 * según un criterio específico y para leer datos de países desde un archivo.
 */
public class Mundo {

    /** Lista de países en el mundo. */
    private final List<Pais> paises;

    /**
     * Crea una instancia de Mundo con una lista vacía de países.
     */
    public Mundo() {
        paises = new ArrayList<>();
    }

    /**
     * Selecciona los países que cumplen con el criterio especificado en el objeto Seleccion.
     *
     * @param sel el criterio de selección implementado en un objeto Seleccion.
     * @return una lista de países que cumplen con el criterio especificado.
     */
    public List<Pais> selecciona(Seleccion sel) {
        List<Pais> seleccionados = new ArrayList<>();
        for (Pais pais : paises) {
            if (sel.test(pais)) {
                seleccionados.add(pais);
            }
        }
        return seleccionados;
    }

    /**
     * Devuelve la lista completa de países.
     *
     * @return la lista de países.
     */
    public List<Pais> getPaises() {
        return paises;
    }

    /**
     * Lee datos de países desde un archivo y los añade a la lista de países.
     * El archivo debe tener líneas con el formato: nombre, continente, altura,
     * donde el nombre es un texto, el continente es un texto y la altura es un número decimal.
     *
     * @param fichero la ruta del archivo que contiene los datos de los países.
     * @throws IOException si ocurre un error de E/S al leer el archivo.
     * @throws InputMismatchException si los datos no tienen el tipo esperado.
     * @throws NoSuchElementException si faltan datos en una línea del archivo.
     */
    public void leePaises(String fichero) throws IOException {
        try (Scanner sc = new Scanner(Path.of(fichero))) {
            while (sc.hasNextLine())
            {
                String linea = sc.nextLine(); // Lee la línea completa
                try (Scanner scLinea = new Scanner(linea).useLocale(Locale.US)) // Asegurar de que use el punto como separador decimal) {
                {
                    scLinea.useDelimiter(","); // Establece la coma como delimitador

                    // Aquí se obtienen los datos usando scLinea, no sc
                    String nombre = scLinea.next().trim();
                    String continente = scLinea.next().trim();
                    double altura = scLinea.nextDouble();

                    // Añade el nuevo objeto Pais a la lista de países
                    paises.add(new Pais(nombre, continente, altura));

                } catch (InputMismatchException e) {
                    throw new InputMismatchException("Error de fichero. El tipo de dato no es correcto.");
                } catch (NoSuchElementException e) {
                    throw new NoSuchElementException("Error de fichero. Faltan datos.");
                }
            }
        }
    }


    public void ordenaPorAltura() {
        List<Pais> ordenadosPorAltura = new ArrayList<>(paises);
        ordenadosPorAltura.sort(Comparator.comparingDouble(Pais::altura)); // Ordenar por altura
        System.out.println("\nPaíses ordenados por altura (menor a mayor):");
        for (Pais pais : ordenadosPorAltura) {
            System.out.println(pais);
        }
    }
    public void ordenaAlfabeticamente() {
        List<Pais> ordenadosAlfabeticamente = new ArrayList<>(paises);
        ordenadosAlfabeticamente.sort(Comparator.comparing(Pais::nombre)); // Ordenar alfabéticamente
        System.out.println("\nPaíses ordenados alfabéticamente:");
        for (Pais pais : ordenadosAlfabeticamente) {
            System.out.println(pais);
        }
    }
    public void ordenaPorContinenteYNombre() {
        List<Pais> ordenadosPorContinente = new ArrayList<>(paises);
        ordenadosPorContinente.sort(Comparator.comparing(Pais::continente).thenComparing(Pais::nombre)); // Ordenar por continente y nombre
        System.out.println("\nPaíses ordenados por continente y, en igualdad, alfabéticamente:");
        for (Pais pais : ordenadosPorContinente) {
            System.out.println(pais);
        }
    }






}
