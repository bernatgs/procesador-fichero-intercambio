package procesadorficherointercambio.exception;

import procesadorficherointercambio.enumeration.TipoRegistroEnum;

public abstract class ParseoFicheroIntercambioException extends Exception {

    public ParseoFicheroIntercambioException(final TipoRegistroEnum tipoRegistro, final Integer numeroLinea, final Integer inicioLectura, final Integer finLectura, final String nombreCampo, final String descripcion) {
        super("Error parseando fichero de intercambio en [tipoRegistro " + tipoRegistro + ", numeroLinea " + numeroLinea + ", inicioLectura " + inicioLectura + ", finLectura " + finLectura + ", nombreCampo " + nombreCampo + "]: " + descripcion);
    }
}
