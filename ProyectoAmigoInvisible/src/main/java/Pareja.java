
import java.util.Objects;

/// Clase que representa una pareja de amigos, asegurando que los dos amigos son diferentes personas
public record Pareja(Persona uno, Persona otro) {

    /**
     * Constructor de la clase Pareja que verifica que las dos personas no sean la misma.
     *
     * @throws AmigoException si las dos personas son iguales.
     */
    public Pareja {
        if (uno.equals(otro)) {
            throw new AmigoException("Una persona no puede ser su propia pareja.");
        }
    }

    /**
     * Metodo para verificar si dos objetos Pareja son iguales.
     *
     * @param o Objeto a comparar con la pareja actual.
     * @return true si ambos objetos Pareja contienen las mismas personas, sin importar el orden; false en caso contrario.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pareja pareja = (Pareja) o;
        // Compara sin importar el orden
        return (Objects.equals(uno, pareja.uno) && Objects.equals(otro, pareja.otro)) ||
                (Objects.equals(uno, pareja.otro) && Objects.equals(otro, pareja.uno));
    }

    /**
     * Metodo para obtener el código hash de la pareja.
     *
     * @return Código hash basado en las dos personas de la pareja, en cualquier orden.
     */
    @Override
    public int hashCode() {
        // Usamos los hash de las personas en cualquier orden
        return Objects.hash(uno, otro) + Objects.hash(otro, uno);
    }

    /**
     * Metodo para obtener la primera persona de la pareja.
     *
     * @return La persona "uno" de la pareja.
     */
    public Persona uno() {
        return uno;
    }

    /**
     * Metodo para obtener la segunda persona de la pareja.
     *
     * @return La persona "otro" de la pareja.
     */
    public Persona otro() {
        return otro;
    }
}
