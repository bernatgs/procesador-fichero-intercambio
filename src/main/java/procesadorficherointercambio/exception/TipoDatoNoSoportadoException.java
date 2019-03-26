package procesadorficherointercambio.exception;

import procesadorficherointercambio.enumeration.TipoRegistroEnum;

public class TipoDatoNoSoportadoException extends ParseoFicheroIntercambioException {

    public TipoDatoNoSoportadoException(final TipoRegistroEnum tipoRegistro, final Integer numeroLinea, final Integer inicioLectura, final Integer finLectura, final String nombreCampo, final String tipoDato) {
        super(tipoRegistro, numeroLinea, inicioLectura, finLectura, nombreCampo, "Tipo dato no soportado, se ha leído [" + tipoDato + "].");
    }
}
