package genetico;

/**
 * La clase OneMax implementa la interfaz Problema y evalúa el fitness de un cromosoma
 * basado en el número de genes que contienen el valor 1.
 */
public class OneMax implements Problema {

    /**
     * Evalúa el fitness de un cromosoma contando el número de genes que son igual a 1.
     *
     * @param c El cromosoma a evaluar.
     * @return El fitness del cromosoma, que es el número total de genes con valor 1.
     */
    @Override
    public double evalua(Cromosoma c) {
        double fitness = 0; // Inicializa el fitness a 0
        for (int i = 0; i < c.getLongitud(); i++) // Recorre cada gen del cromosoma
            if (c.getGen(i) == 1) // Si el gen es 1
                fitness++; // Incrementa el fitness
        return fitness; // Devuelve el fitness total
    }
}
