package genetico;

/**
 * La clase Individuo representa un individuo en un algoritmo genético,
 * que contiene un cromosoma y un valor de fitness asociado.
 */
public class Individuo {
    private double fitness; // Valor de fitness del individuo
    private Cromosoma cromosoma; // Cromosoma asociado al individuo

    /**
     * Constructor que inicializa un individuo con un cromosoma de longitud
     * dada y evalúa su fitness basado en el problema proporcionado.
     *
     * @param longitud La longitud del cromosoma.
     * @param p El problema a resolver que evaluará el fitness del individuo.
     * @throws IllegalArgumentException Si la longitud del cromosoma es menor que 1.
     */
    public Individuo(int longitud, Problema p) {
        if (longitud < 1)
            throw new IllegalArgumentException("La longitud del cromosoma no puede ser ni 0 ni negativo");

        // Crea un cromosoma de forma aleatoria
        cromosoma = new Cromosoma(longitud, true);
        fitness = p.evalua(cromosoma); // Evalúa el fitness del cromosoma
    }

    /**
     * Constructor que asocia un cromosoma existente al individuo
     * y evalúa su fitness basado en el problema proporcionado.
     *
     * @param c El cromosoma que se asociará al individuo.
     * @param p El problema a resolver que evaluará el fitness del individuo.
     * @throws IllegalArgumentException Si el cromosoma es null.
     */
    public Individuo(Cromosoma c, Problema p) {
        if (c == null)
            throw new IllegalArgumentException("El cromosoma no puede ser null");

        // Genera una copia del cromosoma que recibe como parámetro
        cromosoma = new Cromosoma(c); // Crea una copia del cromosoma
        fitness = p.evalua(cromosoma); // Evalúa el fitness del cromosoma asociado al individuo
    }

    /**
     * Obtiene una copia del cromosoma asociado al individuo.
     *
     * @return Una copia del cromosoma.
     */
    public Cromosoma getCromosoma() {
        return new Cromosoma(cromosoma); // Devuelve una copia del cromosoma
    }

    /**
     * Obtiene el valor de fitness del individuo.
     *
     * @return El fitness del individuo.
     */
    public double getFitness() {
        return fitness; // Devuelve el fitness del individuo
    }

    /**
     * Devuelve una representación en cadena del individuo,
     * incluyendo su cromosoma y su valor de fitness.
     *
     * @return Una cadena que representa al individuo.
     */
    @Override
    public String toString() {
        return "Individuo: [" + cromosoma.toString() + ", Fitness: " + fitness + "]";
    }
}
