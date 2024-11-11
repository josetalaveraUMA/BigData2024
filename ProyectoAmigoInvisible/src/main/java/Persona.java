import java.util.Objects;

/**
 * Representa a una persona que tiene un nombre y un amigo invisible al que se le puede hacer un regalo.
 * La clase implementa la interfaz Comparable para permitir la comparación de personas
 * basándose en su nombre de manera insensible a mayúsculas/minúsculas.
 */
public class Persona implements Comparable<Persona> {
    private String nombre; // Nombre de la persona
    private Persona amigo; // El amigo invisible al que la persona le regala algo

    /**
     * Constructor que crea una nueva persona con el nombre proporcionado.
     *
     * @param nombre El nombre de la persona.
     */
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Asigna un amigo invisible a la persona.
     *
     * @param amigo El amigo invisible al que la persona le regalará algo.
     */
    public void setAmigo(Persona amigo) {
        this.amigo = amigo;
    }

    // Obtiene el amigo invisible de la persona.
    public Persona getAmigo() {
        return amigo;
    }

    // Obtiene el nombre de la persona.
    public String getNombre() {
        return nombre;
    }

    /**
     * Compara esta persona con otra persona para ordenar por nombre de manera insensible a mayúsculas/minúsculas.
     *
     * @param otraPersona La otra persona con la que se va a comparar.
     * @return Un valor negativo, cero o positivo si esta persona es menor, igual o mayor que la otra persona, respectivamente,
     *         según el orden alfabético del nombre.
     */
    @Override
    public int compareTo(Persona otraPersona) {
        return this.nombre.compareToIgnoreCase(otraPersona.nombre);
    }

    /**
     * Compara esta persona con otro objeto para determinar si son iguales. La comparación se realiza basándose en el
     * nombre de la persona, ignorando las mayúsculas y minúsculas.
     *
     * @param o El objeto con el que se va a comparar esta persona.
     * @return true si el objeto es una instancia de Persona y el nombre es el mismo, ignorando el caso;
     *         false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        return (o instanceof Persona p) && (p.nombre.equalsIgnoreCase(nombre));
    }

    /**
     * Devuelve el valor hash de la persona basado en su nombre, sin distinguir entre mayúsculas y minúsculas.
     *
     * @return El valor hash de la persona.
     */
    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase());
    }

    /**
     * Devuelve una representación en forma de cadena de la persona, mostrando el nombre y el nombre de su amigo invisible,
     * si tiene uno asignado. Si no tiene amigo, la cadena indicará que no tiene amigo.
     *
     * @return Una cadena que describe a la persona y su amigo invisible.
     */
    @Override
    public String toString() {
        if (getAmigo() == null) {
            return nombre + " : le regala a: sin amigo";
        } else {
            return nombre + " : le regala a: " + getAmigo().getNombre();
        }
    }
}
