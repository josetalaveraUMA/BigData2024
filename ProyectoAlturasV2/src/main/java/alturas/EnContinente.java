package alturas;

/**
 * La clase EnContinente selecciona países basándose en si el nombre del continente
 * contiene un texto dado. Solo aquellos países cuyo nombre de continente contiene
 * el texto especificado serán seleccionados.
 */
public class EnContinente implements Seleccion {

    /** El texto que debe estar presente en el nombre del continente para la selección. */
    private final String texto;

    /**
     * Construye una instancia de EnContinente con el texto especificado.
     *
     * @param texto el texto que debe estar presente en el nombre del continente
     *              para que el país sea seleccionado.
     */
    public EnContinente(String texto) {
        this.texto = texto;
    }

    /**
     * Determina si el nombre del continente de un país contiene el texto especificado.
     *
     * @param pais el objeto Pais a evaluar.
     * @return true si el nombre del continente del país contiene el texto especificado;
     *         false en caso contrario.
     */
    @Override
    public boolean test(Pais pais) {
        return pais.continente().contains(texto);
    }
}
