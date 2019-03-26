//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.03.22 a las 02:21:58 PM CET 
//


package procesadorficherointercambio.pojo.xsd;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the dtd.fichero_intercambio package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dtd.fichero_intercambio
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Fichero }
     */
    public Fichero createFichero() {
        return new Fichero();
    }

    /**
     * Create an instance of {@link Cabecera }
     */
    public Cabecera createCabecera() {
        return new Cabecera();
    }

    /**
     * Create an instance of {@link Campo }
     */
    public Campo createCampo() {
        return new Campo();
    }

    /**
     * Create an instance of {@link Operacion }
     */
    public Operacion createOperacion() {
        return new Operacion();
    }

    /**
     * Create an instance of {@link Totales }
     */
    public Totales createTotales() {
        return new Totales();
    }

}
