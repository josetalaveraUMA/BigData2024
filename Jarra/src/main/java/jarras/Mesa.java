package jarras;

public class Mesa {
    private Jarra jarraIz;  // Jarra situada a la izquierda
    private Jarra jarraDr;  // Jarra situada a la derecha

    // Enumeración que define las posiciones de las jarras: izquierda o derecha
    public enum Posicion { Izquierda, Derecha }

    // Constructor por defecto que crea una mesa con dos jarras vacías y con capacidades de 0
    public Mesa() {
        this.jarraIz = new Jarra();
        this.jarraDr = new Jarra();
    }

    /// Constructor que crea una mesa con dos jarras de capacidades específicas.
    /// @param capacidadIz Capacidad de la jarra izquierda.
    /// @param capacidadDr Capacidad de la jarra derecha.
    public Mesa(int capacidadIz, int capacidadDr) {
        this.jarraIz = new Jarra(capacidadIz);
        this.jarraDr = new Jarra(capacidadDr);
    }

    /// Constructor que crea una mesa utilizando jarras ya existentes.
    /// @param jarraIz Jarra que se colocará en la posición izquierda.
    /// @param jarraDr Jarra que se colocará en la posición derecha.
    public Mesa(Jarra jarraIz, Jarra jarraDr) {
        this.jarraIz = jarraIz;
        this.jarraDr = jarraDr;
    }

    /// Devuelve la capacidad de la jarra indicada por la posición.
    /// @param posicion Posición de la jarra (Izquierda o Derecha).
    /// @return La capacidad de la jarra seleccionada.
    public int capacidad(Posicion posicion) {
        if (posicion == Posicion.Izquierda) {
            return jarraIz.capacidad();
        } else {
            return jarraDr.capacidad();
        }
    }

    /// Devuelve el contenido actual de la jarra indicada por la posición.
    /// @param posicion Posición de la jarra (Izquierda o Derecha).
    /// @return El contenido actual de la jarra seleccionada.
    public int contenido(Posicion posicion) {
        if (posicion == Posicion.Izquierda) {
            return jarraIz.contenido();
        } else {
            return jarraDr.contenido();
        }
    }

    /// Llena completamente la jarra indicada por la posición.
    /// @param posicion Posición de la jarra (Izquierda o Derecha) a llenar.
    public void llena(Posicion posicion) {
        if (posicion == Posicion.Izquierda) {
            jarraIz.llena();
        } else {
            jarraDr.llena();
        }
    }

    /// Vacía completamente la jarra indicada por la posición.
    /// @param posicion Posición de la jarra (Izquierda o Derecha) a vaciar.
    public void vacia(Posicion posicion) {
        if (posicion == Posicion.Izquierda) {
            jarraIz.vacia();
        } else {
            jarraDr.vacia();
        }
    }

    /// Llena una jarra desde la otra, según la posición de la jarra receptora.
    /// @param posicionJarra Posición de la jarra que recibirá el agua (Izquierda o Derecha).
    public void llenaDesde(Posicion posicionJarra) {
        if (posicionJarra == Posicion.Izquierda) {
            jarraDr.llenarDesde(jarraIz);  // Llena la jarra derecha desde la izquierda
        } else {
            jarraIz.llenarDesde(jarraDr);  // Llena la jarra izquierda desde la derecha
        }
    }

    /// Redefine el metodo toString para devolver una representación textual del estado de la mesa.
    /// @return Una cadena de texto que representa la capacidad y contenido de ambas jarras.
    @Override
    public String toString() {
        return "M(J(" + jarraIz.capacidad() + "," + jarraIz.contenido() + "),J("
                + jarraDr.capacidad() + "," + jarraDr.contenido() + "))";
    }
}
