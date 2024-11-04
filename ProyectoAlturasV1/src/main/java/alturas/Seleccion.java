/**
 * La interfaz Seleccion representa un criterio de selección
 * para evaluar si un país cumple con una determinada condición.
 */
package alturas;

/**
 * Define un criterio de selección para objetos de tipo Pais.
 * La interfaz permite aplicar una condición específica a un país dado.
 */
public interface Seleccion {

    /**
     * Evalúa si un país cumple con la condición especificada.
     *
     * @param pais el objeto Pais que será evaluado.
     * @return true si el país cumple con la condición; false en caso contrario.
     */
    boolean test(Pais pais);
}
