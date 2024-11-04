package alturas;

/**
 * La clase MenoresQue selecciona países basándose en una altura máxima especificada.
 * Solo aquellos países cuya altura promedio es menor que la altura máxima serán seleccionados.
 */
public class MenoresQue implements Seleccion {

    /** La altura máxima permitida para que un país sea seleccionado. */
    private final double alturaMax;

    /**
     * Construye una instancia de MenoresQue con la altura máxima especificada.
     *
     * @param altura la altura máxima permitida para la selección de países.
     */
    public MenoresQue(double altura) {
        this.alturaMax = altura;
    }

    /**
     * Determina si un país cumple con el criterio de selección,
     * es decir, si su altura promedio es menor que la altura máxima especificada.
     *
     * @param pais el objeto Pais a evaluar.
     * @return true si la altura promedio del país es menor que alturaMax;
     *         false en caso contrario.
     */
    @Override
    public boolean test(Pais pais) {
        return pais.altura() < alturaMax;
    }
}
