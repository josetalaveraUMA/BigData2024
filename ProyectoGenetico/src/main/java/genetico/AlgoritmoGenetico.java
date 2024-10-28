package genetico;

import java.util.Random;

/**
 * Clase abstracta que representa un algoritmo genético.
 * Esta clase almacena información necesaria sobre un problema,
 * una población de soluciones tentativas, la probabilidad de mutación
 * de los genes de los individuos y el número de pasos que debe realizar.
 */
public abstract class AlgoritmoGenetico {
    private Poblacion poblacion; // Población de individuos que se utilizará en el algoritmo
    private Problema problema; // Problema a resolver mediante el algoritmo genético
    private double probMutacion; // Probabilidad de mutación de los genes
    private int pasos; // Número de generaciones o pasos del algoritmo
    private Random rnd = new Random(); // Generador de números aleatorios

    /**
     * Constructor que inicializa un algoritmo genético con los parámetros dados.
     *
     * @param tamPoblacion Tamaño de la población que se utilizará en el algoritmo.
     * @param ngenes Longitud de los individuos en la población.
     * @param ngeneraciones Número de generaciones que debe ejecutar el algoritmo.
     * @param probMutar Probabilidad de mutación de los genes (debe estar entre 0 y 1).
     * @param p Problema a resolver por el algoritmo genético.
     * @throws IllegalArgumentException Si el número de generaciones es menor que 1
     *                                   o si la probabilidad de mutación no está en el rango válido.
     */
    public AlgoritmoGenetico(int tamPoblacion, int ngenes, int ngeneraciones, double probMutar, Problema p){
        if (ngeneraciones < 1)
            throw new IllegalArgumentException("El número de generaciones debe ser mayor que 0.");
        if (probMutar < 0 || probMutar > 1)
            throw new IllegalArgumentException("La probabilidad de mutación debe estar entre 0 y 1.");

        problema = p; // Asigna el problema
        probMutacion = probMutar; // Asigna la probabilidad de mutación
        pasos = ngeneraciones; // Asigna el número de generaciones
        poblacion = new Poblacion(tamPoblacion, ngenes, p); // Crea la población inicial
    }

    /**
     * Ejecuta el algoritmo genético durante el número de pasos especificado.
     * En cada paso, selecciona dos individuos aleatoriamente, recombina sus cromosomas,
     * muta el resultado, y reemplaza al peor individuo de la población con el nuevo individuo
     * si es mejor.
     *
     * @return El mejor individuo de la población después de completar el número de pasos.
     */
    public Individuo ejecuta(){
        for (int i = 0; i < pasos; i++) {
            // Seleccionar dos individuos de la población aleatoriamente
            int indv1, indv2;

            indv1 = rnd.nextInt(poblacion.getNumIndividuo()); // Selecciona un índice aleatorio
            // Generar el segundo número aleatorio diferente del primero
            do {
                indv2 = rnd.nextInt(poblacion.getNumIndividuo()); // Selecciona otro índice aleatorio
            } while (indv2 == indv1); // Repite hasta que indv2 sea diferente de indv1

            // Tomar sus cromosomas y recombinarlos usando el metodo abstracto recombinar(Cromosoma, Cromosoma)
            Cromosoma cromosoma = recombinar(poblacion.getIndividuo(indv1).getCromosoma(), poblacion.getIndividuo(indv2).getCromosoma());

            // Mutar el resultado con la probabilidad indicada
            cromosoma.mutar(probMutacion);

            // Crear un nuevo individuo con el cromosoma resultante
            Individuo nuevoIndividuo = new Individuo(cromosoma, problema);
            // Reemplazar al peor individuo en la población con el nuevo individuo
            poblacion.reemplaza(nuevoIndividuo);
        }

        // Devolver el mejor individuo de la población después de la terminación del bucle
        return poblacion.mejorIndividuo();
    }

    /**
     * Metodo abstracto que debe ser implementado por las subclases para definir
     * la lógica de recombinación de dos cromosomas.
     *
     * @param c1 Primer cromosoma padre.
     * @param c2 Segundo cromosoma padre.
     * @return Un nuevo cromosoma resultante de la recombinación de c1 y c2.
     */
    protected abstract Cromosoma recombinar(Cromosoma c1, Cromosoma c2);
}
