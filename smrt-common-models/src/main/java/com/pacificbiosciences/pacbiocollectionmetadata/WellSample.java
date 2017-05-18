//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.05.17 at 02:46:42 PM PDT 
//


package com.pacificbiosciences.pacbiocollectionmetadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.pacificbiosciences.pacbiobasedatamodel.BaseEntityType;
import com.pacificbiosciences.pacbiobasedatamodel.DataEntityType;
import com.pacificbiosciences.pacbiosampleinfo.BioSamplePointers;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://pacificbiosciences.com/PacBioBaseDataModel.xsd}BaseEntityType">
 *       &lt;sequence>
 *         &lt;element name="WellName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Concentration" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="InsertSize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SampleReuseEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="StageHotstartEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SizeSelectionEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="UseCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="DNAControlComplex" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SampleBarcodeInfo" type="{http://pacificbiosciences.com/PacBioBaseDataModel.xsd}DataEntityType" minOccurs="0"/>
 *         &lt;element ref="{http://pacificbiosciences.com/PacBioSampleInfo.xsd}BioSamplePointers" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "wellName",
    "concentration",
    "insertSize",
    "sampleReuseEnabled",
    "stageHotstartEnabled",
    "sizeSelectionEnabled",
    "useCount",
    "dnaControlComplex",
    "sampleBarcodeInfo",
    "bioSamplePointers"
})
@XmlRootElement(name = "WellSample")
public class WellSample
    extends BaseEntityType
{

    @XmlElement(name = "WellName", required = true)
    protected String wellName;
    @XmlElement(name = "Concentration")
    protected double concentration;
    @XmlElement(name = "InsertSize")
    protected int insertSize;
    @XmlElement(name = "SampleReuseEnabled")
    protected boolean sampleReuseEnabled;
    @XmlElement(name = "StageHotstartEnabled")
    protected boolean stageHotstartEnabled;
    @XmlElement(name = "SizeSelectionEnabled")
    protected boolean sizeSelectionEnabled;
    @XmlElement(name = "UseCount")
    protected int useCount;
    @XmlElement(name = "DNAControlComplex")
    protected String dnaControlComplex;
    @XmlElement(name = "SampleBarcodeInfo")
    protected DataEntityType sampleBarcodeInfo;
    @XmlElement(name = "BioSamplePointers", namespace = "http://pacificbiosciences.com/PacBioSampleInfo.xsd")
    protected BioSamplePointers bioSamplePointers;

    /**
     * Gets the value of the wellName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWellName() {
        return wellName;
    }

    /**
     * Sets the value of the wellName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWellName(String value) {
        this.wellName = value;
    }

    /**
     * Gets the value of the concentration property.
     * 
     */
    public double getConcentration() {
        return concentration;
    }

    /**
     * Sets the value of the concentration property.
     * 
     */
    public void setConcentration(double value) {
        this.concentration = value;
    }

    /**
     * Gets the value of the insertSize property.
     * 
     */
    public int getInsertSize() {
        return insertSize;
    }

    /**
     * Sets the value of the insertSize property.
     * 
     */
    public void setInsertSize(int value) {
        this.insertSize = value;
    }

    /**
     * Gets the value of the sampleReuseEnabled property.
     * 
     */
    public boolean isSampleReuseEnabled() {
        return sampleReuseEnabled;
    }

    /**
     * Sets the value of the sampleReuseEnabled property.
     * 
     */
    public void setSampleReuseEnabled(boolean value) {
        this.sampleReuseEnabled = value;
    }

    /**
     * Gets the value of the stageHotstartEnabled property.
     * 
     */
    public boolean isStageHotstartEnabled() {
        return stageHotstartEnabled;
    }

    /**
     * Sets the value of the stageHotstartEnabled property.
     * 
     */
    public void setStageHotstartEnabled(boolean value) {
        this.stageHotstartEnabled = value;
    }

    /**
     * Gets the value of the sizeSelectionEnabled property.
     * 
     */
    public boolean isSizeSelectionEnabled() {
        return sizeSelectionEnabled;
    }

    /**
     * Sets the value of the sizeSelectionEnabled property.
     * 
     */
    public void setSizeSelectionEnabled(boolean value) {
        this.sizeSelectionEnabled = value;
    }

    /**
     * Gets the value of the useCount property.
     * 
     */
    public int getUseCount() {
        return useCount;
    }

    /**
     * Sets the value of the useCount property.
     * 
     */
    public void setUseCount(int value) {
        this.useCount = value;
    }

    /**
     * Gets the value of the dnaControlComplex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDNAControlComplex() {
        return dnaControlComplex;
    }

    /**
     * Sets the value of the dnaControlComplex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDNAControlComplex(String value) {
        this.dnaControlComplex = value;
    }

    /**
     * Gets the value of the sampleBarcodeInfo property.
     * 
     * @return
     *     possible object is
     *     {@link DataEntityType }
     *     
     */
    public DataEntityType getSampleBarcodeInfo() {
        return sampleBarcodeInfo;
    }

    /**
     * Sets the value of the sampleBarcodeInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataEntityType }
     *     
     */
    public void setSampleBarcodeInfo(DataEntityType value) {
        this.sampleBarcodeInfo = value;
    }

    /**
     * Back references to other sample object UniqueIds
     *  
     * This is optional since we will likely not have a link back to samples created in the calculator.
     * 
     * @return
     *     possible object is
     *     {@link BioSamplePointers }
     *     
     */
    public BioSamplePointers getBioSamplePointers() {
        return bioSamplePointers;
    }

    /**
     * Sets the value of the bioSamplePointers property.
     * 
     * @param value
     *     allowed object is
     *     {@link BioSamplePointers }
     *     
     */
    public void setBioSamplePointers(BioSamplePointers value) {
        this.bioSamplePointers = value;
    }

}
