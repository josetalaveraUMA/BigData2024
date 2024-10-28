package genetico;

/**
 * La clase Poblacion representa un grupo de individuos en un algoritmo genético.
 * Está constituida por un número fijo de individuos, almacenados en un array.
 */
public class Poblacion {
    private Individuo[] individuos; // Array que contiene los individuos de la población

    /**
     * Constructor que inicializa la población con un tamaño específico,
     * y llena la población con individuos generados aleatoriamente.
     *
     * @param tamPoblacion El número de individuos en la población.
     * @param ngenes La longitud del cromosoma para cada individuo.
     * @param p El problema que se resolverá con los individuos.
     * @throws IllegalArgumentException Si el tamaño de la población es negativo.
     */
    public Poblacion(int tamPoblacion, int ngenes, Problema p) {
        if (tamPoblacion < 0)
            throw new IllegalArgumentException("El tamaño de la población no puede ser negativa.");

        individuos = new Individuo[tamPoblacion]; // Inicializa el array de individuos

        // Crea individuos aleatorios y los almacena en el array
        for (int i = 0; i < tamPoblacion; i++)
            individuos[i] = new Individuo(ngenes, p);
    }

    /**
     * Devuelve el i-ésimo individuo de la población.
     *
     * @param i El índice del individuo a devolver.
     * @return El i-ésimo individuo de la población.
     * @throws ArrayIndexOutOfBoundsException Si el índice está fuera de los límites del array.
     */
    public Individuo getIndividuo(int i) {
        return individuos[i]; // Devuelve el i-ésimo individuo
    }

    /**
     * Devuelve el número total de individuos en la población.
     *
     * @return El número de individuos en la población.
     */
    public int getNumIndividuo() {
        return individuos.length; // Devuelve la longitud del array de individuos
    }

    /**
     * Devuelve el individuo con el mayor valor de fitness de la población.
     *
     * @return El mejor individuo de la población.
     * @throws IllegalStateException Si la población está vacía.
     */
    public Individuo mejorIndividuo() {
        if (individuos.length == 0) {
            throw new IllegalStateException("La población está vacía."); // Lanza excepción si la población está vacía
        }

        Individuo mejorIndividuo = individuos[0]; // Asume que el primer individuo es el mejor

        // Recorre la población para encontrar el individuo con mayor fitness
        for (int i = 1; i < individuos.length; i++)
            if (individuos[i].getFitness() > mejorIndividuo.getFitness())
                mejorIndividuo = individuos[i]; // Actualiza el mejor individuo si se encuentra uno con mayor fitness

        return mejorIndividuo; // Devuelve el mejor individuo encontrado
    }

    /**
     * Sustituye el peor individuo de la población por el individuo dado,
     * solo si el nuevo individuo tiene un fitness mayor que el peor.
     *
     * @param individuo El individuo que se va a usar para reemplazar al peor.
     * @throws IllegalStateException Si la población está vacía.
     */
    public void reemplaza(Individuo individuo) {
        if (individuos.length == 0) {
            throw new IllegalStateException("La población está vacía."); // Lanza excepción si la población está vacía
        }

        int peorIndividuo = 0; // Asume que el índice del primer individuo es el peor

        // Recorre la población para encontrar el individuo con menor fitness
        for (int i = 1; i < individuos.length; i++)
            if (individuos[i].getFitness() < individuos[peorIndividuo].getFitness())
                peorIndividuo = i; // Actualiza el peor individuo si se encuentra uno con menor fitness

        // Si el nuevo individuo tiene mayor fitness, reemplaza al peor
        if (individuo.getFitness() > individuos[peorIndividuo].getFitness())
            individuos[peorIndividuo] = individuo; // Reemplaza al peor individuo
    }
}
