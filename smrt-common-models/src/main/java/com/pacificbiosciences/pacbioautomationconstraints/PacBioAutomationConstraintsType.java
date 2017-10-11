//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.09.18 at 03:16:30 PM PDT 
//


package com.pacificbiosciences.pacbioautomationconstraints;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.pacificbiosciences.pacbiopartnumbers.PacBioPartNumbersType;


/**
 * <p>Java class for PacBioAutomationConstraintsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PacBioAutomationConstraintsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AutomationConstraints" type="{http://pacificbiosciences.com/PacBioAutomationConstraints.xsd}AutomationConstraints"/>
 *         &lt;element ref="{http://pacificbiosciences.com/PacBioPartNumbers.xsd}PacBioPartNumbers" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PacBioAutomationConstraintsType", propOrder = {
    "automationConstraints",
    "pacBioPartNumbers"
})
@XmlSeeAlso({
    PacBioAutomationConstraints.class
})
public class PacBioAutomationConstraintsType {

    @XmlElement(name = "AutomationConstraints", required = true)
    protected AutomationConstraints automationConstraints;
    @XmlElement(name = "PacBioPartNumbers", namespace = "http://pacificbiosciences.com/PacBioPartNumbers.xsd")
    protected PacBioPartNumbersType pacBioPartNumbers;
    @XmlAttribute(name = "Version")
    protected String version;
    @XmlAttribute(name = "Description")
    protected String description;

    /**
     * Gets the value of the automationConstraints property.
     * 
     * @return
     *     possible object is
     *     {@link AutomationConstraints }
     *     
     */
    public AutomationConstraints getAutomationConstraints() {
        return automationConstraints;
    }

    /**
     * Sets the value of the automationConstraints property.
     * 
     * @param value
     *     allowed object is
     *     {@link AutomationConstraints }
     *     
     */
    public void setAutomationConstraints(AutomationConstraints value) {
        this.automationConstraints = value;
    }

    /**
     * Gets the value of the pacBioPartNumbers property.
     * 
     * @return
     *     possible object is
     *     {@link PacBioPartNumbersType }
     *     
     */
    public PacBioPartNumbersType getPacBioPartNumbers() {
        return pacBioPartNumbers;
    }

    /**
     * Sets the value of the pacBioPartNumbers property.
     * 
     * @param value
     *     allowed object is
     *     {@link PacBioPartNumbersType }
     *     
     */
    public void setPacBioPartNumbers(PacBioPartNumbersType value) {
        this.pacBioPartNumbers = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

}
