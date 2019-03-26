package procesadorficherointercambio.exception;

import procesadorficherointercambio.enumeration.TipoRegistroEnum;

public class LongitudLineaIncorrectaException extends ParseoFicheroIntercambioException {

    public LongitudLineaIncorrectaException(final TipoRegistroEnum tipoRegistro, final Integer numeroLinea, final Integer inicioLectura, final Integer finLectura, final String nombreCampo, final Integer longitudLinea) {
        super(tipoRegistro, numeroLinea, inicioLectura, finLectura, nombreCampo, "Longitud de la linea incorrecta por exceso o por defecto [" + longitudLinea + "].");
    }
}
