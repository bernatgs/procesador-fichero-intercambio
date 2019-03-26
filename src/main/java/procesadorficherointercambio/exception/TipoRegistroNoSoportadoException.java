package procesadorficherointercambio.exception;

import procesadorficherointercambio.enumeration.TipoRegistroEnum;

public class TipoRegistroNoSoportadoException extends Exception {

    public TipoRegistroNoSoportadoException(final TipoRegistroEnum tipoRegistro) {
        super("Tipo de registro no soportado [" + tipoRegistro + "]");
    }
}
