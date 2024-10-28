package genetico;

/**
 * La clase CeroMax implementa la interfaz Problema y evalúa el fitness de un cromosoma
 * basado en el número de genes que contienen el valor 0.
 */
public class CeroMax implements Problema {

    /**
     * Evalúa el fitness de un cromosoma contando el número de genes que son igual a 0.
     *
     * @param c El cromosoma a evaluar.
     * @return El fitness del cromosoma, que es el número total de genes con valor 0.
     */
    @Override
    public double evalua(Cromosoma c) {
        double fitness = 0; // Inicializa el fitness a 0
        for (int i = 0; i < c.getLongitud(); i++) // Recorre cada gen del cromosoma
            if (c.getGen(i) == 0) // Si el gen es 0
                fitness++; // Incrementa el fitness
        return fitness; // Devuelve el fitness total
    }
}
