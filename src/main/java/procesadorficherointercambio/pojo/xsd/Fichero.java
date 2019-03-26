//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.03.22 a las 02:21:58 PM CET 
//


package procesadorficherointercambio.pojo.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 *
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{fichero_intercambio.dtd}cabecera" minOccurs="0"/>
 *         &lt;element ref="{fichero_intercambio.dtd}operacion"/>
 *         &lt;element ref="{fichero_intercambio.dtd}totales" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "cabecera",
        "operacion",
        "totales"
})
@XmlRootElement(name = "fichero")
public class Fichero {

    protected Cabecera cabecera;
    protected Operacion operacion;
    protected Totales totales;

    /**
     * Obtiene el valor de la propiedad cabecera.
     *
     * @return possible object is
     * {@link Cabecera }
     */
    public Cabecera getCabecera() {
        return cabecera;
    }

    /**
     * Define el valor de la propiedad cabecera.
     *
     * @param value allowed object is
     *              {@link Cabecera }
     */
    public void setCabecera(Cabecera value) {
        this.cabecera = value;
    }

    /**
     * Obtiene el valor de la propiedad operacion.
     *
     * @return possible object is
     * {@link Operacion }
     */
    public Operacion getOperacion() {
        return operacion;
    }

    /**
     * Define el valor de la propiedad operacion.
     *
     * @param value allowed object is
     *              {@link Operacion }
     */
    public void setOperacion(Operacion value) {
        this.operacion = value;
    }

    /**
     * Obtiene el valor de la propiedad totales.
     *
     * @return possible object is
     * {@link Totales }
     */
    public Totales getTotales() {
        return totales;
    }

    /**
     * Define el valor de la propiedad totales.
     *
     * @param value allowed object is
     *              {@link Totales }
     */
    public void setTotales(Totales value) {
        this.totales = value;
    }

}
