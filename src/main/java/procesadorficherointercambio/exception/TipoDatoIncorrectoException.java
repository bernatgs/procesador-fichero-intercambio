package procesadorficherointercambio.exception;

import procesadorficherointercambio.enumeration.TipoRegistroEnum;

public class TipoDatoIncorrectoException extends ParseoFicheroIntercambioException {

    public TipoDatoIncorrectoException(final TipoRegistroEnum tipoRegistro, final Integer numeroLinea, final Integer inicioLectura, final Integer finLectura, final String nombreCampo, final String valorLeido, final String tipoDatoEsperado) {
        super(tipoRegistro, numeroLinea, inicioLectura, finLectura, nombreCampo, "Formato del valor incorrecto, se ha leído [" + valorLeido + "] y se esperaba el tipo [" + tipoDatoEsperado + "].");
    }
}
