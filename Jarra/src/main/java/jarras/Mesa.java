package jarras;

public class Mesa {
    private Jarra jarraIz;
    private Jarra jarraDr;


    public enum Posicion{
        Izquierda, Derecha;
    }

    // Constructor que crea una mesa con dos jarras de capacidades dadas
    public Mesa(int capacidadIz, int capacidadDr) {
        this.jarraIz = new Jarra(capacidadIz); 
        this.jarraDr = new Jarra(capacidadDr);
    }

    // Constructor que recibe dos jarras directamente como tamaño inicial
    public Mesa(Jarra jarraIz, Jarra jarraDr) {
        this.jarraIz = jarraIz;
        this.jarraDr = jarraDr;
    }

    // Devuelve la capacidad de la jarra especificada como parámetro
    public int capacidad(Posicion posicion) {
        if (posicion == Posicion.Izquierda) {
            return jarraIz.capacidad();
        } else {
            return jarraDr.capacidad();
        }
    }

    // Devuelve el contenido actual de la jarra especificada como parámetro
    public int contenido(Posicion posicion) {
        if (posicion == Posicion.Izquierda) {
            return jarraIz.contenido();
        } else {
            return jarraDr.contenido();
        }
    }

    // Llena el contenido de la jarra especificada
    public void llena(Posicion posicion) {
        if (posicion == Posicion.Izquierda) {
            jarraIz.llena();
        } else {
            jarraDr.llena();
        }
    }

    // Vacía el contenido de la jarra especificada
    public void vacia(Posicion posicion) {
        if (posicion == Posicion.Izquierda) {
            jarraIz.vacia();
        } else {
            jarraDr.vacia();
        }
    }
    // Llena el contenido de la jarra recibida como parámetro desde la otra jarra
    public void llenaDesde(Posicion posicionJarra) {
        if (posicionJarra == Posicion.Izquierda) {
            jarraDr.llenarDesde(jarraIz); // Llena la jarra derecha desde la izquierda
        } else {
            jarraIz.llenarDesde(jarraDr); // Llena la jarra izquierda desde la derecha
        }
    }

    // Redefinición del metodo toString para mostrar la representación textual del objeto Mesa
    @Override
    public String toString() {
        return "M(J(" + jarraIz.capacidad() + "," + jarraIz.contenido() + "),J("
                + jarraDr.capacidad() + "," + jarraDr.contenido() + "))";
    }
}
