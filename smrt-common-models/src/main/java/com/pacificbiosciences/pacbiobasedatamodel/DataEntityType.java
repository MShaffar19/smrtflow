//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.12.04 at 02:50:32 PM PST 
//


package com.pacificbiosciences.pacbiobasedatamodel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.pacificbiosciences.pacbiodatamodel.AssayType;


/**
 * Extends BaseEntityType and adds a value element.  The intent is to have only one of the value elements exist at any point in time; however, this is not enforced.
 * 
 * <p>Java class for DataEntityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataEntityType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://pacificbiosciences.com/PacBioBaseDataModel.xsd}BaseEntityType">
 *       &lt;sequence>
 *         &lt;element name="CheckSum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ValueDataType" type="{http://pacificbiosciences.com/PacBioBaseDataModel.xsd}SupportedDataTypes" default="Object" />
 *       &lt;attribute name="SimpleValue" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="MetaType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="TimeStampedName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataEntityType", propOrder = {
    "checkSum"
})
@XmlSeeAlso({
    SequencingChemistryConfig.class,
    RecordedEventType.class,
    SequencingChemistry.class,
    AssayType.class,
    PartNumberType.class
})
public class DataEntityType
    extends BaseEntityType
{

    @XmlElement(name = "CheckSum")
    protected String checkSum;
    @XmlAttribute(name = "ValueDataType")
    protected SupportedDataTypes valueDataType;
    @XmlAttribute(name = "SimpleValue")
    @XmlSchemaType(name = "anySimpleType")
    protected String simpleValue;
    @XmlAttribute(name = "MetaType")
    protected String metaType;
    @XmlAttribute(name = "TimeStampedName")
    protected String timeStampedName;

    /**
     * Gets the value of the checkSum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCheckSum() {
        return checkSum;
    }

    /**
     * Sets the value of the checkSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCheckSum(String value) {
        this.checkSum = value;
    }

    /**
     * Gets the value of the valueDataType property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedDataTypes }
     *     
     */
    public SupportedDataTypes getValueDataType() {
        if (valueDataType == null) {
            return SupportedDataTypes.OBJECT;
        } else {
            return valueDataType;
        }
    }

    /**
     * Sets the value of the valueDataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedDataTypes }
     *     
     */
    public void setValueDataType(SupportedDataTypes value) {
        this.valueDataType = value;
    }

    /**
     * Gets the value of the simpleValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSimpleValue() {
        return simpleValue;
    }

    /**
     * Sets the value of the simpleValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSimpleValue(String value) {
        this.simpleValue = value;
    }

    /**
     * Gets the value of the metaType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMetaType() {
        return metaType;
    }

    /**
     * Sets the value of the metaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMetaType(String value) {
        this.metaType = value;
    }

    /**
     * Gets the value of the timeStampedName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeStampedName() {
        return timeStampedName;
    }

    /**
     * Sets the value of the timeStampedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeStampedName(String value) {
        this.timeStampedName = value;
    }

}
