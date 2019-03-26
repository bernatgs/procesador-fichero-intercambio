package procesadorficherointercambio.exception;

import procesadorficherointercambio.enumeration.TipoRegistroEnum;

public class TipoRegistroSinRellenarException extends ParseoFicheroIntercambioException {

    public TipoRegistroSinRellenarException(final TipoRegistroEnum tipoRegistro, final Integer numeroLinea, final TipoRegistroEnum tipoRegistroRestante) {
        super(tipoRegistro, numeroLinea, null, null, null, "Se ha alcanzado la última línea pero todavía quedan registros por rellenar [" + tipoRegistroRestante + "].");
    }
}
