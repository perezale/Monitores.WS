//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.07 at 03:19:14 PM ART 
//


package com.monitors.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.monitors.dto.xsd.Device;


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
 *         &lt;element name="device" type="{http://dto.monitors.com/xsd}Device" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "device"
})
@XmlRootElement(name = "InsertSingleDeviceDTO")
public class InsertSingleDeviceDTO {

    @XmlElementRef(name = "device", namespace = "http://ws.monitors.com", type = JAXBElement.class, required = false)
    protected JAXBElement<Device> device;

    /**
     * Gets the value of the device property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Device }{@code >}
     *     
     */
    public JAXBElement<Device> getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Device }{@code >}
     *     
     */
    public void setDevice(JAXBElement<Device> value) {
        this.device = value;
    }

}