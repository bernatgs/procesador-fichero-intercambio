package procesadorficherointercambio;

import com.sun.istack.internal.NotNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import procesadorficherointercambio.enumeration.TipoDatoEnum;
import procesadorficherointercambio.enumeration.TipoRegistroEnum;
import procesadorficherointercambio.enumeration.UbicacionRellenoEnum;
import procesadorficherointercambio.exception.*;
import procesadorficherointercambio.pojo.FicheroIntercambio;
import procesadorficherointercambio.pojo.xsd.Campo;
import procesadorficherointercambio.pojo.xsd.Fichero;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class ProcesadorFicheroIntercambio {
    private final Logger logger = LogManager.getLogger("ProcesadorFicheroIntercambio");

    private static final URL urlXsd = ProcesadorFicheroIntercambio.class.getClassLoader().getResource("fichero_intercambio.xsd");

    private final Fichero fichero;

    //region Constructores

    /**
     * Crea una instancia con una ruta a un fichero XML como parámetro.
     *
     * @param rutaLocalXml Ruta a un fichero XML.
     */
    public ProcesadorFicheroIntercambio(@NotNull final String rutaLocalXml) throws CreacionProcesadorFicheroIntercambioException, MalformedURLException {
//        this(ProcesadorFicheroIntercambio.class.getClassLoader().getResource(rutaLocalXml));
        this(Paths.get((rutaLocalXml)).toUri().toURL());
    }

    /**
     * Crea una instancia con una URL a un fichero XSD como parámetro.
     *
     * @param urlXml URL a un fichero XSD.
     */
    public ProcesadorFicheroIntercambio(@NotNull final URL urlXml) throws CreacionProcesadorFicheroIntercambioException {
        logger.debug("## ProcesadorFicheroIntercambio - INICIO");

        Fichero ficheroTemporal = null;
        try {
            // carga del XSD
            Schema schema = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(this.urlXsd);

            // validación del XML
            Source source = new StreamSource(urlXml.getFile());
            Validator validator = schema.newValidator();
            validator.validate(source);

            // descodificación del XML
            JAXBContext jc = JAXBContext.newInstance(Fichero.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setSchema(schema);
            JAXBElement<Fichero> element = unmarshaller.unmarshal(source, Fichero.class);
            ficheroTemporal = element.getValue();
        } catch (IOException | JAXBException | SAXException e) {
            throw new CreacionProcesadorFicheroIntercambioException(e);
        } finally {
            this.fichero = ficheroTemporal;
        }

        logger.debug("## ProcesadorFicheroIntercambio - FIN");
    }

    //endregion

    //region Métodos públicos

    public FicheroIntercambio procesaFicheroIntercambio(final Reader reader) throws IOException, ParseoFicheroIntercambioException, TipoRegistroNoSoportadoException {
        logger.debug("## procesaFicheroIntercambio - INICIO");

        FicheroIntercambio ficheroIntercambio = new FicheroIntercambio();
        int numeroLinea = 0;

        TipoRegistroEnum ultimoTipoRegistroParaseado = null;
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            // procesamos líneas y registros
            String linea = bufferedReader.readLine();
            TipoRegistroEnum tipoRegistroActual = TipoRegistroEnum.CABECERA;

            while (linea != null && tipoRegistroActual != null) {
                // comprobamos para cada tipo de registro que haya información asociada en el fichero
                if (this.isTipoRegistroFicheroNull(tipoRegistroActual)) {
                    tipoRegistroActual = tipoRegistroActual.getSiguiente();
                    continue;
                }

                // si el tipo de registro actual tiene información parseable en el fichero, intentamos parsear
                try {
                    HashMap<String, String> listaCampos = this.parseaRegistro(tipoRegistroActual, linea, numeroLinea);

                    // guarda los registros leídos
                    switch (tipoRegistroActual) {
                        case CABECERA:
                            ficheroIntercambio.getListaCabecera().add(listaCampos);
                            logger.trace("#### {}: añadido registro tipo {}", numeroLinea, tipoRegistroActual);
                            break;
                        case OPERACION:
                            ficheroIntercambio.getListaOperacion().add(listaCampos);
                            logger.trace("#### {}: añadido registro tipo {}", numeroLinea, tipoRegistroActual);
                            break;
                        case TOTALES:
                            ficheroIntercambio.getListaTotales().add(listaCampos);
                            logger.trace("#### {}: añadido registro tipo {}", numeroLinea, tipoRegistroActual);
                            break;
                        default:
                            throw new TipoRegistroNoSoportadoException(tipoRegistroActual);
                    }

                    // actualiza el último tipo de registro paraseado correctamente
                    ultimoTipoRegistroParaseado = tipoRegistroActual;

                    // si el tipo de registro que acabamos de leer no es repetible, actualizamos el siguiente tipo a leer
                    if (this.isTipoRegistroFicheroNoRepetible(tipoRegistroActual)) {
                        tipoRegistroActual = tipoRegistroActual.getSiguiente();
                    }

                    // leemos los datos de la siguiente línea a procesar
                    linea = bufferedReader.readLine();
                    numeroLinea++;
                } catch (LongitudLineaIncorrectaException | TipoDatoIncorrectoException e) {
                    // fallo al parasear la línea conforme al tipo de registro, si el campo es opcional o ya lo hemos leído, pasamos al siguiente tipo de registro
                    if (tipoRegistroActual.equals(ultimoTipoRegistroParaseado) // ya hemos leído un registro de este tipo
                            || this.isTipoRegistroFicheroOpcional(tipoRegistroActual)) { // o estamos leyendo un tipo de registro opcional
                        tipoRegistroActual = tipoRegistroActual.getSiguiente();
                    } else {
                        // en caso contrario habrá un error paraseando
                        throw e;
                    }
                } catch (TipoDatoNoSoportadoException | TipoRegistroNoSoportadoException | UbicacionRellenoNoSoportadaException e) {
                    // error procesando la línea
                    throw e;
                }
            }

            // comprobamos si nos hemos dejado líneas por parsear
            if (linea != null) {
                throw new LineasSinParsearException(tipoRegistroActual, numeroLinea);
            }

            // comprobamos si nos hemos dejado tipos de registro por parsear
            if (tipoRegistroActual != null) {
                for (TipoRegistroEnum tipoRegistroRestante = tipoRegistroActual.equals(ultimoTipoRegistroParaseado) ? tipoRegistroActual.getSiguiente() : tipoRegistroActual; tipoRegistroRestante != null; tipoRegistroRestante = tipoRegistroRestante.getSiguiente()) {
                    if (!this.isTipoRegistroFicheroOpcional(tipoRegistroRestante)) {
                        throw new TipoRegistroSinRellenarException(tipoRegistroActual, numeroLinea, tipoRegistroRestante);
                    }
                }
            }
        }

        logger.trace("#### numeroLinea == {}", numeroLinea);

        logger.debug("## procesaFicheroIntercambio - FIN");
        return ficheroIntercambio;
    }

    //endregion

    //region Métodos privados

    private boolean isTipoRegistroFicheroNull(final TipoRegistroEnum tipoRegistro) {
        return TipoRegistroEnum.CABECERA.equals(tipoRegistro) && this.fichero.getCabecera() == null
                || TipoRegistroEnum.OPERACION.equals(tipoRegistro) && this.fichero.getOperacion() == null
                || TipoRegistroEnum.TOTALES.equals(tipoRegistro) && this.fichero.getTotales() == null;
    }

    private boolean isTipoRegistroFicheroNoRepetible(final TipoRegistroEnum tipoRegistro) {
        return TipoRegistroEnum.CABECERA.equals(tipoRegistro) && !this.fichero.getCabecera().isRepetible()
                || TipoRegistroEnum.OPERACION.equals(tipoRegistro) && !this.fichero.getOperacion().isRepetible()
                || TipoRegistroEnum.TOTALES.equals(tipoRegistro) && !this.fichero.getTotales().isRepetible();
    }

    private boolean isTipoRegistroFicheroOpcional(final TipoRegistroEnum tipoRegistro) {
        return TipoRegistroEnum.CABECERA.equals(tipoRegistro) && this.fichero.getCabecera().isOpcional()
                || TipoRegistroEnum.OPERACION.equals(tipoRegistro) && this.fichero.getOperacion().isOpcional()
                || TipoRegistroEnum.TOTALES.equals(tipoRegistro) && this.fichero.getTotales().isOpcional();
    }

    private HashMap<String, String> parseaRegistro(@NotNull final TipoRegistroEnum tipoRegistro, @NotNull final String linea) throws UbicacionRellenoNoSoportadaException, TipoDatoNoSoportadoException, LongitudLineaIncorrectaException, TipoDatoIncorrectoException, TipoRegistroNoSoportadoException {
        return this.parseaRegistro(tipoRegistro, linea, null);
    }

    private HashMap<String, String> parseaRegistro(@NotNull final TipoRegistroEnum tipoRegistro, @NotNull final String linea, final Integer numeroLinea) throws UbicacionRellenoNoSoportadaException, TipoDatoNoSoportadoException, LongitudLineaIncorrectaException, TipoDatoIncorrectoException, TipoRegistroNoSoportadoException {
        logger.debug("## parseaRegistro - INICIO");

        HashMap<String, String> registro = new HashMap<>();
        List<Campo> listaCampos;
        switch (tipoRegistro) {
            case CABECERA:
                listaCampos = this.fichero.getCabecera().getCampo();
                break;
            case OPERACION:
                listaCampos = this.fichero.getOperacion().getCampo();
                break;
            case TOTALES:
                listaCampos = this.fichero.getTotales().getCampo();
                break;
            default:
                throw new TipoRegistroNoSoportadoException(tipoRegistro);
        }

        // inicializa variables iteración/depuración
        int inicioLectura = 0;
        int finalLectura = 0;
        String nombreUltimoCampoLeido = "";

        for (Campo campo : listaCampos) {
            nombreUltimoCampoLeido = campo.getNombre();

            // recupera el siguiente campo
            finalLectura = inicioLectura + Integer.valueOf(campo.getLongitud());
            if (finalLectura > linea.length())
                throw new LongitudLineaIncorrectaException(tipoRegistro, numeroLinea, inicioLectura, finalLectura, nombreUltimoCampoLeido, linea.length());
            String valorCampo = linea.substring(inicioLectura, finalLectura);

            // quita carácter de relleno
            UbicacionRellenoEnum ubicacionRelleno = UbicacionRellenoEnum.valueOfValor(campo.getUbicacionRelleno());
            if (ubicacionRelleno != null) {
                switch (ubicacionRelleno) {
                    case DERECHA:
                        valorCampo = valorCampo.replaceFirst("" + campo.getCaracterRelleno() + "++$", "");
                        break;
                    case IZQUIERDA:
                        valorCampo = valorCampo.replaceFirst("^" + campo.getCaracterRelleno() + "++", "");
                        break;
                    default:
                        throw new UbicacionRellenoNoSoportadaException(tipoRegistro, numeroLinea, inicioLectura, finalLectura, nombreUltimoCampoLeido, ubicacionRelleno.getValor());
                }
            }

            // comprueba tipo/regexp
            TipoDatoEnum tipoDato = TipoDatoEnum.valueOfValor(campo.getTipoDato());
            if (tipoDato != null) {
                boolean esTipoDatoCorrecto;
                switch (tipoDato) {
                    case ALFANUMERICO:
                        esTipoDatoCorrecto = valorCampo.matches("[a-zA-Z0-9]*");
                        break;
                    case NUMERICO:
                        esTipoDatoCorrecto = valorCampo.matches("[0-9]*");
                        break;
                    case REGEXP:
                        esTipoDatoCorrecto = valorCampo.matches(campo.getRegexpFormato());
                        break;
                    case TEXTO:
                        esTipoDatoCorrecto = true;
                        break;
                    case DECIMAL:
                        esTipoDatoCorrecto = valorCampo.matches("[+\\-]?[0-9]*[,.]?[0-9]*");
                        break;
                    default:
                        throw new TipoDatoNoSoportadoException(tipoRegistro, numeroLinea, inicioLectura, finalLectura, nombreUltimoCampoLeido, tipoDato.getValor());
                }

                // comprueba si el valor es del tipo esperado
                if (!esTipoDatoCorrecto)
                    throw new TipoDatoIncorrectoException(tipoRegistro, numeroLinea, inicioLectura, finalLectura, nombreUltimoCampoLeido, valorCampo, tipoDato.getValor());
            }

            // si todo ha ido bien, guardamos el valor leído
            registro.put(campo.getNombre(), valorCampo);

            // prepara siguiente iteración
            inicioLectura = finalLectura;
        }

        // si al finalizar la lectura de la línea nos han faltado/sobrado campos por completar,
        if (finalLectura != linea.length())
            throw new LongitudLineaIncorrectaException(tipoRegistro, numeroLinea, inicioLectura, finalLectura, nombreUltimoCampoLeido, linea.length());

        logger.debug("## parseaRegistro - FIN");
        return registro;
    }

    //endregion

}
