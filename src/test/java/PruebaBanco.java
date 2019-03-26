import procesadorficherointercambio.exception.CreacionProcesadorFicheroIntercambioException;
import procesadorficherointercambio.exception.ParseoFicheroIntercambioException;
import procesadorficherointercambio.exception.TipoRegistroNoSoportadoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import procesadorficherointercambio.pojo.FicheroIntercambio;
import procesadorficherointercambio.ProcesadorFicheroIntercambio;

import java.io.FileReader;
import java.io.IOException;

public class PruebaBanco {
    private static final Logger logger = LogManager.getLogger("PruebaBanco");

    public static void main(String[] args) {
        logger.debug("## PruebaBanco - INICIO");

        String rutaFichero = "C:\\workspace\\procesador-fichero-intercambio\\src\\test\\java\\fichero_banco.txt";

        FicheroIntercambio ficheroIntercambio = null;
        try {
            ProcesadorFicheroIntercambio procesadorFicheroIntercambio = new ProcesadorFicheroIntercambio("C:\\workspace\\procesador-fichero-intercambio\\src\\test\\java\\fichero_intercambio_banco.xml");
            ficheroIntercambio = procesadorFicheroIntercambio.procesaFicheroIntercambio(new FileReader(rutaFichero));
        } catch (CreacionProcesadorFicheroIntercambioException | IOException | ParseoFicheroIntercambioException | TipoRegistroNoSoportadoException e) {
            logger.error(e);
        }
//        if (ficheroIntercambio == null)
//            logger.trace("ficheroIntercambio == null");

        logger.debug("## PruebaBanco - FIN");
    }
}
