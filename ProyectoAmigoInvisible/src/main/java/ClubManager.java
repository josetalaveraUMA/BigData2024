import java.io.IOException;
import java.io.PrintWriter;

/**
 * La clase ClubManager gestiona la creación de un club de amigos invisibles,
 * permitiendo configurar el archivo de entrada, delimitadores, archivo de salida y
 * la opción de mostrar los resultados en consola.
 */
public class ClubManager {

    private String fEntrada;
    private String delimitadores;
    private String fSalida;
    private boolean consola;
    private Club club;

    /**
     * Constructor que inicializa el ClubManager con el club especificado.
     *
     * @param club El club que va a manejar.
     */
    public ClubManager(Club club) {
        this.club = club;
    }

    /**
     * Configura el archivo de entrada de datos y el delimitador de nombres.
     *
     * @param fEntrada Nombre del fichero de entrada de datos.
     * @param delim Delimitador para separar nombres en el archivo.
     * @return El mismo objeto ClubManager (para encadenar métodos).
     */
    public ClubManager setEntrada(String fEntrada, String delim) {
        this.fEntrada = fEntrada;
        this.delimitadores = delim;
        return this;
    }

    /**
     * Configura el archivo de salida de datos.
     *
     * @param salida Nombre del fichero de salida.
     * @return El mismo objeto ClubManager (para encadenar métodos).
     */
    public ClubManager setSalida(String salida) {
        this.fSalida = salida;
        return this;
    }

    /**
     * Establece si se deben mostrar los resultados en consola.
     *
     * @param consola true si se deben mostrar en consola; false en caso contrario.
     * @return El mismo objeto ClubManager (para encadenar métodos).
     */
    public ClubManager setConsola(boolean consola) {
        this.consola = consola;
        return this;
    }

    /**
     * Verifica que los datos de configuración sean correctos:
     * - Debe haber un fichero de entrada de datos.
     * - Debe haber una salida, ya sea a fichero o a consola.
     *
     * @throws AmigoException Si no se cumple alguna de las condiciones anteriores.
     */
    private void verify() throws AmigoException {
        if (fEntrada == null) {
            throw new AmigoException("El archivo de entrada de datos es obligatorio.");
        }
        if (fSalida == null && !consola) {
            throw new AmigoException("Debe haber una salida: fichero de salida o consola.");
        }
    }

    /**
     * Ejecuta el proceso de creación del club:
     * - Verifica la configuración.
     * - Lee los datos del archivo de entrada.
     * - Asigna amigos invisibles.
     * - Muestra los resultados en consola y/o en el archivo de salida.
     * Si ocurre un error, lo informa sin lanzar excepciones.
     */
    public void build() {
        try {
            // Verificar que la configuración es correcta
            verify();

            // Leer los datos del archivo de entrada usando el delimitador
            club.lee(fEntrada, delimitadores);

            // Asignar amigos invisibles
            club.hacerAmigos();

            // Presentar los resultados en consola y/o archivo
            if (consola) {
                club.presentaAmigos(new PrintWriter(System.out, true));
            }
            if (fSalida != null) {
                club.presentaAmigos(fSalida);
            }

        }catch (IOException e) {
            System.err.println("Error al leer o escribir archivos: " + e.getMessage());
        } catch (AmigoException e) {
            System.err.println("Error en la configuración del ClubManager: " + e.getMessage());
        }
    }

}
