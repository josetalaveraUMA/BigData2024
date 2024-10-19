package jarras;

public class Jarra {
    private int contenido; // cantidad de agua actual en la jarra
    private final int capacidad; // capacidad máxima de la jarra

    // Constructor por defecto: inicializa la jarra con capacidad 0
    public Jarra() {
        this(0);  // Llama al otro constructor pasando 0 como capacidad
    }

    /// Constructor con capacidad específica.
    /// Inicializa la jarra con la capacidad indicada y la deja vacía
    /// @param cap Capacidad máxima de la jarra.
    /// @throws IllegalArgumentException Si la capacidad es menor o igual a 0.
    public Jarra(int cap) {
        if (cap <= 0)
            throw new IllegalArgumentException("Capacidad no positiva");

        capacidad = cap;  // Asigna la capacidad de la jarra
        contenido = 0;    // Inicialmente, la jarra está vacía
    }

    /// Vacía completamente la jarra, estableciendo el contenido a 0.
    public void vacia() {
        contenido = 0;  // Vacía completamente la jarra
    }

    /// Devuelve la capacidad máxima de la jarra.
    /// @return Capacidad de la jarra.
    public int capacidad() {
        return capacidad;
    }

    /// Devuelve la cantidad de agua actual en la jarra.
    /// @return Contenido actual de la jarra.
    public int contenido() {
        return contenido;
    }

    /// Llena la jarra actual con agua transferida desde otra jarra.
    /// No puede volcar agua sobre sí misma.
    /// @param j La jarra desde la cual se transferirá el agua.
    /// @throws IllegalArgumentException Si se intenta transferir agua desde la misma jarra.
    public void llenarDesde(Jarra j) {
        if (this == j)
            throw new IllegalArgumentException("No se puede volcar una jarra sobre si misma");

        // Calcula cuánta agua puede recibir la jarra actual
        int litrosDispJarra = capacidad - contenido;

        // Determina la cantidad que se puede transferir
        int cantidadATransferir = Math.min(litrosDispJarra, j.contenido());

        // Aumenta el contenido de la jarra actual con la cantidad transferida
        contenido += cantidadATransferir;

        // Reduce el contenido de la jarra 'j' con la cantidad transferida
        j.contenido -= cantidadATransferir;
    }

    /// Llena completamente la jarra hasta su capacidad máxima.
    public void llena() {
        contenido = capacidad;  // Llenar la jarra al máximo
    }

    /// Sobrescribe el metodo toString() para devolver una representación textual de la jarra.
    /// @return Una cadena de texto con la capacidad y el contenido actual de la jarra.
    @Override
    public String toString() {
        return "capacidad: " + capacidad + "\ncontenido: " + contenido + "\n";  // Devuelve la capacidad y el contenido actual de la jarra
    }
}
