package procesadorficherointercambio.exception;

import procesadorficherointercambio.enumeration.TipoRegistroEnum;

public class UbicacionRellenoNoSoportadaException extends ParseoFicheroIntercambioException {

    public UbicacionRellenoNoSoportadaException(final TipoRegistroEnum tipoRegistro, final Integer numeroLinea, final Integer inicioLectura, final Integer finLectura, final String nombreCampo, final String ubicacionRelleno) {
        super(tipoRegistro, numeroLinea, inicioLectura, finLectura, nombreCampo, "Ubicación de relleno no soportada, se ha leído [" + ubicacionRelleno + "].");
    }
}
