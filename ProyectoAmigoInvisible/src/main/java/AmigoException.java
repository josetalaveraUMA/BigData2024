/**
 * Excepción no comprobada para situaciones excepcionales en la gestión del club,
 * como la imposibilidad de asignar amigos invisibles debido a un número insuficiente de personas.
 */
public class AmigoException extends RuntimeException {

    /**
     * Crea una nueva instancia de AmigoException con el mensaje especificado.
     *
     * @param message Mensaje que describe la causa de la excepción.
     */
    public AmigoException(String message) {
        super(message);
    }
}
