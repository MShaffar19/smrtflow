//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: XXX
//


package com.pacificbiosciences.pacbiodatasets;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.pacificbiosciences.pacbiobasedatamodel.BaseEntityType;
import com.pacificbiosciences.pacbiobasedatamodel.StrictEntityType;


/**
 * Extend this type to provide DataSetMetadata element in each DataSet.
 * 
 * <p>Java class for DataSetMetadataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DataSetMetadataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TotalLength" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="NumRecords" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Provenance" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CommonServicesInstanceId" type="{http://www.w3.org/2001/XMLSchema}IDREF" minOccurs="0"/>
 *                   &lt;element name="CreatorUserId" type="{http://www.w3.org/2001/XMLSchema}IDREF" minOccurs="0"/>
 *                   &lt;element name="ParentJobId" type="{http://www.w3.org/2001/XMLSchema}IDREF" minOccurs="0"/>
 *                   &lt;element name="ParentTool" type="{http://pacificbiosciences.com/PacBioBaseDataModel.xsd}BaseEntityType" minOccurs="0"/>
 *                   &lt;element name="ParentDataSet" type="{http://pacificbiosciences.com/PacBioBaseDataModel.xsd}StrictEntityType" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="CreatedBy" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="Instrument"/>
 *                       &lt;enumeration value="User"/>
 *                       &lt;enumeration value="AnalysisJob"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DataSetMetadataType", propOrder = {
    "totalLength",
    "numRecords",
    "provenance"
})
@XmlSeeAlso({
    ReadSetMetadataType.class,
    ContigSetMetadataType.class,
    BarcodeSetMetadataType.class,
    AlignmentSetMetadataType.class,
    TranscriptSetMetadataType.class,
    SubreadSetMetadataType.class
})
public class DataSetMetadataType {

    @XmlElement(name = "TotalLength")
    protected long totalLength;
    @XmlElement(name = "NumRecords")
    protected int numRecords;
    @XmlElement(name = "Provenance")
    protected DataSetMetadataType.Provenance provenance;

    /**
     * Gets the value of the totalLength property.
     * 
     */
    public long getTotalLength() {
        return totalLength;
    }

    /**
     * Sets the value of the totalLength property.
     * 
     */
    public void setTotalLength(long value) {
        this.totalLength = value;
    }

    /**
     * Gets the value of the numRecords property.
     * 
     */
    public int getNumRecords() {
        return numRecords;
    }

    /**
     * Sets the value of the numRecords property.
     * 
     */
    public void setNumRecords(int value) {
        this.numRecords = value;
    }

    /**
     * Gets the value of the provenance property.
     * 
     * @return
     *     possible object is
     *     {@link DataSetMetadataType.Provenance }
     *     
     */
    public DataSetMetadataType.Provenance getProvenance() {
        return provenance;
    }

    /**
     * Sets the value of the provenance property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSetMetadataType.Provenance }
     *     
     */
    public void setProvenance(DataSetMetadataType.Provenance value) {
        this.provenance = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="CommonServicesInstanceId" type="{http://www.w3.org/2001/XMLSchema}IDREF" minOccurs="0"/>
     *         &lt;element name="CreatorUserId" type="{http://www.w3.org/2001/XMLSchema}IDREF" minOccurs="0"/>
     *         &lt;element name="ParentJobId" type="{http://www.w3.org/2001/XMLSchema}IDREF" minOccurs="0"/>
     *         &lt;element name="ParentTool" type="{http://pacificbiosciences.com/PacBioBaseDataModel.xsd}BaseEntityType" minOccurs="0"/>
     *         &lt;element name="ParentDataSet" type="{http://pacificbiosciences.com/PacBioBaseDataModel.xsd}StrictEntityType" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="CreatedBy" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="Instrument"/>
     *             &lt;enumeration value="User"/>
     *             &lt;enumeration value="AnalysisJob"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "commonServicesInstanceId",
        "creatorUserId",
        "parentJobId",
        "parentTool",
        "parentDataSet"
    })
    public static class Provenance {

        @XmlElement(name = "CommonServicesInstanceId")
        @XmlIDREF
        @XmlSchemaType(name = "IDREF")
        protected Object commonServicesInstanceId;
        @XmlElement(name = "CreatorUserId")
        @XmlIDREF
        @XmlSchemaType(name = "IDREF")
        protected Object creatorUserId;
        @XmlElement(name = "ParentJobId")
        @XmlIDREF
        @XmlSchemaType(name = "IDREF")
        protected Object parentJobId;
        @XmlElement(name = "ParentTool")
        protected BaseEntityType parentTool;
        @XmlElement(name = "ParentDataSet")
        protected StrictEntityType parentDataSet;
        @XmlAttribute(name = "CreatedBy", required = true)
        protected String createdBy;

        /**
         * Gets the value of the commonServicesInstanceId property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getCommonServicesInstanceId() {
            return commonServicesInstanceId;
        }

        /**
         * Sets the value of the commonServicesInstanceId property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setCommonServicesInstanceId(Object value) {
            this.commonServicesInstanceId = value;
        }

        /**
         * Gets the value of the creatorUserId property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getCreatorUserId() {
            return creatorUserId;
        }

        /**
         * Sets the value of the creatorUserId property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setCreatorUserId(Object value) {
            this.creatorUserId = value;
        }

        /**
         * Gets the value of the parentJobId property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getParentJobId() {
            return parentJobId;
        }

        /**
         * Sets the value of the parentJobId property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setParentJobId(Object value) {
            this.parentJobId = value;
        }

        /**
         * Gets the value of the parentTool property.
         * 
         * @return
         *     possible object is
         *     {@link BaseEntityType }
         *     
         */
        public BaseEntityType getParentTool() {
            return parentTool;
        }

        /**
         * Sets the value of the parentTool property.
         * 
         * @param value
         *     allowed object is
         *     {@link BaseEntityType }
         *     
         */
        public void setParentTool(BaseEntityType value) {
            this.parentTool = value;
        }

        /**
         * Gets the value of the parentDataSet property.
         * 
         * @return
         *     possible object is
         *     {@link StrictEntityType }
         *     
         */
        public StrictEntityType getParentDataSet() {
            return parentDataSet;
        }

        /**
         * Sets the value of the parentDataSet property.
         * 
         * @param value
         *     allowed object is
         *     {@link StrictEntityType }
         *     
         */
        public void setParentDataSet(StrictEntityType value) {
            this.parentDataSet = value;
        }

        /**
         * Gets the value of the createdBy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCreatedBy() {
            return createdBy;
        }

        /**
         * Sets the value of the createdBy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCreatedBy(String value) {
            this.createdBy = value;
        }

    }

}
