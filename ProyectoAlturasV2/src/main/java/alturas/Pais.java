package alturas;

/**
 * La clase Pais representa un registro inmutable de un país,
 * incluyendo su nombre, continente y altura promedio.
 *
 * Implementa la interfaz Comparable para permitir ordenar los objetos de esta clase
 * en función de la altura promedio. En caso de igualdad en la altura, se ordenará
 * alfabéticamente por el nombre del país.
 *
 * @param nombre     El nombre del país.
 * @param continente El continente al que pertenece el país.
 * @param altura     La altura promedio del país en metros.
 */
public record Pais(String nombre, String continente, double altura) implements Comparable<Pais> {

    /**
     * Compara este país con otro país en función de su altura promedio.
     * Si las alturas son iguales, compara los nombres alfabéticamente.
     *
     * @param otro El otro país a comparar.
     * @return un número negativo, cero o positivo si este país es menor,
     * igual o mayor que el país comparado, según su altura y nombre.
     */
    @Override
    public int compareTo(Pais otro) {
        int comparacionAltura = Double.compare(this.altura, otro.altura);
        if (comparacionAltura != 0) {
            return comparacionAltura;
        }
        return this.nombre.compareTo(otro.nombre);
    }

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
