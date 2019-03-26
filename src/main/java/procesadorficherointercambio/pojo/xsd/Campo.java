//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.03.22 a las 02:21:58 PM CET 
//


package procesadorficherointercambio.pojo.xsd;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="nombre" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="longitud" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="caracterRelleno" type="{http://www.w3.org/2001/XMLSchema}string" default=" " />
 *       &lt;attribute name="ubicacionRelleno" default="derecha">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;procesadorficherointercambio.enumeration value="derecha"/>
 *             &lt;procesadorficherointercambio.enumeration value="izquierda"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="tipoDato" default="alfanum�rico">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;procesadorficherointercambio.enumeration value="alfanum�rico"/>
 *             &lt;procesadorficherointercambio.enumeration value="num�rico"/>
 *             &lt;procesadorficherointercambio.enumeration value="regexp"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="regexpFormato" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "campo")
public class Campo {

    @XmlAttribute(name = "nombre", required = true)
    protected String nombre;
    @XmlAttribute(name = "longitud", required = true)
    protected String longitud;
    @XmlAttribute(name = "caracterRelleno")
    protected String caracterRelleno;
    @XmlAttribute(name = "ubicacionRelleno")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ubicacionRelleno;
    @XmlAttribute(name = "tipoDato")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tipoDato;
    @XmlAttribute(name = "regexpFormato")
    protected String regexpFormato;

    /**
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad longitud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLongitud() {
        return longitud;
    }

    /**
     * Define el valor de la propiedad longitud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLongitud(String value) {
        this.longitud = value;
    }

    /**
     * Obtiene el valor de la propiedad caracterRelleno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaracterRelleno() {
        if (caracterRelleno == null) {
            return " ";
        } else {
            return caracterRelleno;
        }
    }

    /**
     * Define el valor de la propiedad caracterRelleno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaracterRelleno(String value) {
        this.caracterRelleno = value;
    }

    /**
     * Obtiene el valor de la propiedad ubicacionRelleno.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicacionRelleno() {
        if (ubicacionRelleno == null) {
            return "derecha";
        } else {
            return ubicacionRelleno;
        }
    }

    /**
     * Define el valor de la propiedad ubicacionRelleno.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicacionRelleno(String value) {
        this.ubicacionRelleno = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDato() {
        if (tipoDato == null) {
            return "alfanum\u00e9rico";
        } else {
            return tipoDato;
        }
    }

    /**
     * Define el valor de la propiedad tipoDato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDato(String value) {
        this.tipoDato = value;
    }

    /**
     * Obtiene el valor de la propiedad regexpFormato.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegexpFormato() {
        return regexpFormato;
    }

    /**
     * Define el valor de la propiedad regexpFormato.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegexpFormato(String value) {
        this.regexpFormato = value;
    }

}
