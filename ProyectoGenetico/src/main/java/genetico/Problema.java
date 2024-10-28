package genetico;

public interface Problema{
    /**
     * Evalúa el fitness de un cromosoma dado.
     *
     * @param c El cromosoma a evaluar.
     * @return Un valor numérico que representa el fitness del cromosoma,
     *         donde un valor más alto indica un mejor desempeño en
     *         relación con el problema.
     */
    public double evalua(Cromosoma c);
}
