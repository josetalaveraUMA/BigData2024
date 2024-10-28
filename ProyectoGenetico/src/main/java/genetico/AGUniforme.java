package genetico;

import java.util.Random;

/**
 * Clase que implementa un algoritmo genético de recombinación uniforme.
 * Esta clase hereda de AlgoritmoGenetico y redefine el metodo de
 * recombinación para combinar dos cromosomas de manera que cada gen del
 * nuevo cromosoma se elige aleatoriamente de uno de los padres.
 */
public class AGUniforme extends AlgoritmoGenetico {
    private Random rnd = new Random(); // Generador de números aleatorios

    /**
     * Constructor que inicializa el algoritmo genético uniforme con los parámetros dados.
     *
     * @param tamPoblacion Tamaño de la población que se utilizará en el algoritmo.
     * @param ngenes Longitud de los individuos en la población.
     * @param ngeneraciones Número de generaciones que debe ejecutar el algoritmo.
     * @param probMutar Probabilidad de mutación de los genes (debe estar entre 0 y 1).
     * @param p Problema a resolver por el algoritmo genético.
     */
    public AGUniforme(int tamPoblacion, int ngenes, int ngeneraciones, double probMutar, Problema p) {
        super(tamPoblacion, ngenes, ngeneraciones, probMutar, p); // Llama al constructor de la clase padre
    }

    /**
     * Metodo que recombina dos cromosomas de forma uniforme.
     * Para cada gen del nuevo cromosoma, se elige aleatoriamente un gen de
     * uno de los padres, c1 o c2.
     *
     * @param c1 Primer cromosoma padre.
     * @param c2 Segundo cromosoma padre.
     * @return Un nuevo cromosoma resultante de la recombinación uniforme de c1 y c2.
     */
    @Override
    protected Cromosoma recombinar(Cromosoma c1, Cromosoma c2) {
        int ngenes = c1.getLongitud(); // Obtiene la longitud del cromosoma
        Cromosoma nuevoCromosoma = new Cromosoma(ngenes, false); // Crea un nuevo cromosoma

        // Recorre cada gen y elige aleatoriamente de qué padre tomar el gen
        for(int i = 0; i < ngenes; i++) {
            int alea = rnd.nextInt(2); // Genera un número aleatorio (0 o 1)
            if(alea == 0)
                nuevoCromosoma.setGen(i, c1.getGen(i)); // Toma el gen del primer padre
            else
                nuevoCromosoma.setGen(i, c2.getGen(i)); // Toma el gen del segundo padre
        }

        return nuevoCromosoma; // Devuelve el nuevo cromosoma resultante
    }
}
