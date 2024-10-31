package genetico;

import java.util.Random;

/**
 * Clase que implementa un algoritmo genético de un punto de recombinación.
 * Esta clase hereda de AlgoritmoGenetico y redefine el metodo de
 * recombinación para combinar dos cromosomas en un solo individuo
 * tomando los primeros genes de uno de los padres hasta un punto aleatorio.
 */
public class AGUnPunto extends AlgoritmoGenetico {
    private Random rnd = new Random(); // Generador de números aleatorios

    /**
     * Constructor que inicializa el algoritmo genético de un punto con los parámetros dados.
     *
     * @param tamPoblacion Tamaño de la población que se utilizará en el algoritmo.
     * @param ngenes Longitud de los individuos en la población.
     * @param ngeneraciones Número de generaciones que debe ejecutar el algoritmo.
     * @param probMutar Probabilidad de mutación de los genes (debe estar entre 0 y 1).
     * @param p Problema a resolver por el algoritmo genético.
     */
    public AGUnPunto(int tamPoblacion, int ngenes, int ngeneraciones, double probMutar, Problema p) {
        super(tamPoblacion, ngenes, ngeneraciones, probMutar, p); // Llama al constructor de la clase padre
    }

    /**
     * Metodo que recombina dos cromosomas de un punto.
     * Genera un número aleatorio z entre cero y la longitud del cromosoma,
     * tomando los primeros z genes del primer padre y el resto del segundo padre.
     *
     * @param c1 Primer cromosoma padre.
     * @param c2 Segundo cromosoma padre.
     * @return Un nuevo cromosoma resultante de la recombinación de c1 y c2.
     */
    @Override
    protected Cromosoma recombinar(Cromosoma c1, Cromosoma c2) {
        int ngenes = c1.getLongitud(); // Obtiene la longitud del cromosoma
        int alea = rnd.nextInt(ngenes + 1); // Genera un punto de corte aleatorio

        Cromosoma nuevoCromosoma = new Cromosoma(ngenes, false); // Crea un nuevo cromosoma

        // Copia los genes del primer padre hasta el punto de corte
        for(int i = 0; i < alea; i++)
            nuevoCromosoma.setGen(i, c1.getGen(i));

        // Copia el resto de los genes del segundo padre
        for(int i = alea; i < ngenes; i++)
            nuevoCromosoma.setGen(i, c2.getGen(i));

        return nuevoCromosoma; // Devuelve el nuevo cromosoma resultante
    }
}