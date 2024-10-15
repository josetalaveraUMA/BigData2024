package jarras;

public class Jarra {
    private int contenido; // Atributos: 'contenido' es la cantidad de agua actual en la jarra, 'capacidad' es la capacidad máxima de la jarra
    private final int capacidad;


    // Constructor por defecto: inicializa la jarra con capacidad 0
    public Jarra() {
        this(0);  // Llama al otro constructor pasando 0 como capacidad
    }

    // Constructor con capacidad específica: inicializa la jarra con la capacidad indicada y la deja vacía
    public Jarra(int cap) {
        // todo esto ha sido añadido
        if(cap <= 0)
            throw new IllegalArgumentException("Capacidad no positiva");

        capacidad = cap;  // Asigna la capacidad de la jarra
        contenido = 0;    // Inicialmente, la jarra está vacía
    }

    // Metodo para vaciar la jarra
    public void vacia() {
        contenido = 0;  // Vacía completamente la jarra
    }

    // Metodo que devuelve la capacidad de la jarra
    public int capacidad() {
        return capacidad;
    }

    // Metodo que devuelve el contenido actual de la jarra
    public int contenido() {
        return contenido;
    }

    // Metodo para transferir agua desde otra jarra a la jarra actual
    public void llenarDesde(Jarra j) {
        //todo añadido
        if(this == j)
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

    // Metodo para llenar completamente la jarra
    public void llena() {
        contenido = capacidad;  // Llenar la jarra al máximo
    }

    // Sobrescribe el metodo toString para devolver una representación textual de la jarra
    @Override
    public String toString() {
        return "capacidad: " + capacidad + "\ncontenido: " + contenido + "\n";  // Devuelve la capacidad y el contenido actual de la jarra
    }

}
