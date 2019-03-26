//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.03.22 a las 02:21:58 PM CET 
//


package procesadorficherointercambio.pojo.xsd;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element ref="{fichero_intercambio.dtd}campo" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="repetible" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "campo"
})
@XmlRootElement(name = "cabecera")
public class Cabecera implements Registro {

    @XmlElement(required = true)
    protected List<Campo> campo;
    @XmlAttribute(name = "opcional")
    protected Boolean opcional;
    @XmlAttribute(name = "repetible")
    protected Boolean repetible;

    /**
     * Gets the value of the campo property.
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the campo property.
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCampo().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Campo }
     */
    public List<Campo> getCampo() {
        if (campo == null) {
            campo = new ArrayList<Campo>();
        }
        return this.campo;
    }

    /**
     * Obtiene el valor de la propiedad repetible.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isRepetible() {
        if (repetible == null) {
            return false;
        } else {
            return repetible;
        }
    }

    /**
     * Define el valor de la propiedad repetible.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setRepetible(Boolean value) {
        this.repetible = value;
    }

    /**
     * Obtiene el valor de la propiedad opcional.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public boolean isOpcional() {
        if (opcional == null) {
            return true;
        } else {
            return opcional;
        }
    }

    /**
     * Define el valor de la propiedad opcional.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setOpcional(Boolean value) {
        this.opcional = value;
    }

}
