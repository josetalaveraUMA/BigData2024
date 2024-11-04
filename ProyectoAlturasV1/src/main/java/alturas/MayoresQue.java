package alturas;

/**
 * La clase MayoresQue selecciona países basándose en una altura mínima exigida.
 * Solo aquellos países cuya altura promedio es mayor o igual a la altura mínima
 * serán seleccionados.
 */
public class MayoresQue implements Seleccion {

    /** La altura mínima exigida para que un país sea seleccionado. */
    private final double alturaMin;

    /**
     * Construye una instancia de MayoresQue con la altura mínima especificada.
     *
     * @param altura la altura mínima exigida para la selección de países.
     */
    public MayoresQue(double altura) {
        this.alturaMin = altura;
    }

    /**
     * Determina si un país cumple con el criterio de selección,
     * es decir, si su altura promedio es mayor o igual a la altura mínima exigida.
     *
     * @param pais el objeto Pais a evaluar.
     * @return true si la altura promedio del país es mayor que alturaMin;
     *         false en caso contrario.
     */
    @Override
    public boolean test(Pais pais) {
        return pais.altura() > alturaMin;
    }
}
