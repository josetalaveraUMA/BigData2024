package urna;
import java.util.NoSuchElementException;
import java.util.Random;


public class Urna {
    // Atributos que almacenan el número de bolas blancas y negras en la urna
    private int blancas, negras;

    // Enumerado que define los posibles colores de las bolas
    public static enum ColorBola { Blanca, Negra };

    /// Constructor que inicializa la urna con el número especificado de bolas blancas y negras.
    /// @param nblancas Número inicial de bolas blancas.
    /// @param nnegras Número inicial de bolas negras.
    /// @throws IllegalArgumentException Si alguno de los números de bolas es negativo.
    public Urna(int nblancas, int nnegras) {

        // Verifica que no se pase un número negativo de bolas, de lo contrario lanza una excepción
        if (nblancas < 0 || nnegras < 0) {
            throw new IllegalArgumentException("No se pueden crear urnas con un número negativo de bolas");
        }

        // Inicializa los atributos con el número de bolas proporcionado
        blancas = nblancas;
        negras = nnegras;
    }

    /// Devuelve el número total de bolas en la urna (blancas + negras).
    /// @return Número total de bolas en la urna.
    public int totalBolas() {
        return blancas + negras;
    }

    /// Incrementa el número de bolas blancas en la urna.
    public void ponerBlanca() {
        blancas++;
    }

    /// Incrementa el número de bolas negras en la urna.
    public void ponerNegra() {
        negras++;
    }

    /// Extrae una bola de manera aleatoria de la urna.
    /// @return El color de la bola extraída (Blanca o Negra) de tipo ColorBola.
    /// @throws NoSuchElementException Si no quedan bolas en la urna.
    public ColorBola extraerBola() {
        Random rnd = new Random(); // Generador de números aleatorios
        int totalBolas = blancas + negras; // Calcula el número total de bolas

        // Si no hay bolas disponibles, lanza una excepción
        if (totalBolas == 0) {
            throw new NoSuchElementException("No hay bolas en la urna");
        }

        // Genera un número aleatorio entre 1 y el número total de bolas (inclusive)
        int res = rnd.nextInt(totalBolas) + 1; // Cambié el rango para que sea entre 1 y totalBolas

        // Si se genera un número menor o igual al número de bolas blancas, se extrae una bola blanca
        if (res <= blancas) {
            if (blancas == 0) {
                throw new NoSuchElementException("No hay bolas blancas en la urna");
            }
            blancas--;
            return ColorBola.Blanca;
        } else {
            // Si no hay bolas blancas, se verifica si hay bolas negras
            if (negras == 0) {
                throw new NoSuchElementException("No hay bolas negras en la urna");
            }
            negras--;
            return ColorBola.Negra;
        }
    }

    /// Sobrescribe el metodo `toString()` para proporcionar una representación en forma de cadena de la urna.
    /// @return Una cadena que describe el estado actual de la urna (número de bolas blancas y negras).
    @Override
    public String toString() {
        return "Bolas blancas: " + blancas + "; Bolas negras: " + negras;
    }
}

