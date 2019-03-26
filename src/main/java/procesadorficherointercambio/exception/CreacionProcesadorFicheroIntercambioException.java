package procesadorficherointercambio.exception;

public class CreacionProcesadorFicheroIntercambioException extends Exception {

    private static final String message = "Error creando el procesador de ficheros de intercambio.";

    public CreacionProcesadorFicheroIntercambioException(Throwable cause) {
        super(message, cause);
    }
}
