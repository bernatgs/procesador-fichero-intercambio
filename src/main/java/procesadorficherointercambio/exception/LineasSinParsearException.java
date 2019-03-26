package procesadorficherointercambio.exception;

import procesadorficherointercambio.enumeration.TipoRegistroEnum;

public class LineasSinParsearException extends ParseoFicheroIntercambioException {

    public LineasSinParsearException(final TipoRegistroEnum tipoRegistro, final Integer numeroLinea) {
        super(tipoRegistro, numeroLinea, null, null, null, "Se ha alcanzado el último tipo de registro pero todavía quedan líneas por parsear.");
    }
}
