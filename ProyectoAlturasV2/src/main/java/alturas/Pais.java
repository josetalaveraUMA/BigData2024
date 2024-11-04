/**
 * Representa un país con su nombre, continente y altura promedio.
 */
package alturas;

/**
 * La clase Pais representa un registro inmutable de un país,
 * incluyendo su nombre, continente y altura promedio.
 *
 * @param nombre     El nombre del país.
 * @param continente El continente al que pertenece el país.
 * @param altura     La altura promedio del país en metros.
 */
public record Pais(String nombre, String continente, double altura) {

    /**
     * Obtiene el nombre del país.
     *
     * @return el nombre del país.
     */
    @Override
    public String nombre() {
        return nombre;
    }

    /**
     * Obtiene el continente al que pertenece el país.
     *
     * @return el continente del país.
     */
    @Override
    public String continente() {
        return continente;
    }

    /**
     * Obtiene la altura promedio del país en metros.
     *
     * @return la altura promedio del país.
     */
    @Override
    public double altura() {
        return altura;
    }
}
