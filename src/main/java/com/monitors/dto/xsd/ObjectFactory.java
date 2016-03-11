//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.07 at 03:19:14 PM ART 
//


package com.monitors.dto.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.monitors.dto.xsd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FrameDestinationMac_QNAME = new QName("http://dto.monitors.com/xsd", "destination_mac");
    private final static QName _FrameFrameType_QNAME = new QName("http://dto.monitors.com/xsd", "frame_type");
    private final static QName _FrameSsid_QNAME = new QName("http://dto.monitors.com/xsd", "ssid");
    private final static QName _FrameSourceMac_QNAME = new QName("http://dto.monitors.com/xsd", "source_mac");
    private final static QName _FrameTimestamp_QNAME = new QName("http://dto.monitors.com/xsd", "timestamp");
    private final static QName _FrameProtocol_QNAME = new QName("http://dto.monitors.com/xsd", "protocol");
    private final static QName _FrameSourceDeviceType_QNAME = new QName("http://dto.monitors.com/xsd", "source_device_type");
    private final static QName _SmartphoneDetectionLon_QNAME = new QName("http://dto.monitors.com/xsd", "lon");
    private final static QName _SmartphoneDetectionLat_QNAME = new QName("http://dto.monitors.com/xsd", "lat");
    private final static QName _DeviceMac_QNAME = new QName("http://dto.monitors.com/xsd", "mac");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.monitors.dto.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Frame }
     * 
     */
    public Frame createFrame() {
        return new Frame();
    }

    /**
     * Create an instance of {@link Device }
     * 
     */
    public Device createDevice() {
        return new Device();
    }

    /**
     * Create an instance of {@link SmartphoneDetection }
     * 
     */
    public SmartphoneDetection createSmartphoneDetection() {
        return new SmartphoneDetection();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "destination_mac", scope = Frame.class)
    public JAXBElement<String> createFrameDestinationMac(String value) {
        return new JAXBElement<String>(_FrameDestinationMac_QNAME, String.class, Frame.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "frame_type", scope = Frame.class)
    public JAXBElement<String> createFrameFrameType(String value) {
        return new JAXBElement<String>(_FrameFrameType_QNAME, String.class, Frame.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "ssid", scope = Frame.class)
    public JAXBElement<String> createFrameSsid(String value) {
        return new JAXBElement<String>(_FrameSsid_QNAME, String.class, Frame.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "source_mac", scope = Frame.class)
    public JAXBElement<String> createFrameSourceMac(String value) {
        return new JAXBElement<String>(_FrameSourceMac_QNAME, String.class, Frame.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "timestamp", scope = Frame.class)
    public JAXBElement<XMLGregorianCalendar> createFrameTimestamp(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_FrameTimestamp_QNAME, XMLGregorianCalendar.class, Frame.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "protocol", scope = Frame.class)
    public JAXBElement<String> createFrameProtocol(String value) {
        return new JAXBElement<String>(_FrameProtocol_QNAME, String.class, Frame.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "source_device_type", scope = Frame.class)
    public JAXBElement<String> createFrameSourceDeviceType(String value) {
        return new JAXBElement<String>(_FrameSourceDeviceType_QNAME, String.class, Frame.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "destination_mac", scope = SmartphoneDetection.class)
    public JAXBElement<String> createSmartphoneDetectionDestinationMac(String value) {
        return new JAXBElement<String>(_FrameDestinationMac_QNAME, String.class, SmartphoneDetection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "lon", scope = SmartphoneDetection.class)
    public JAXBElement<Double> createSmartphoneDetectionLon(Double value) {
        return new JAXBElement<Double>(_SmartphoneDetectionLon_QNAME, Double.class, SmartphoneDetection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "ssid", scope = SmartphoneDetection.class)
    public JAXBElement<String> createSmartphoneDetectionSsid(String value) {
        return new JAXBElement<String>(_FrameSsid_QNAME, String.class, SmartphoneDetection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "lat", scope = SmartphoneDetection.class)
    public JAXBElement<Double> createSmartphoneDetectionLat(Double value) {
        return new JAXBElement<Double>(_SmartphoneDetectionLat_QNAME, Double.class, SmartphoneDetection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "source_mac", scope = SmartphoneDetection.class)
    public JAXBElement<String> createSmartphoneDetectionSourceMac(String value) {
        return new JAXBElement<String>(_FrameSourceMac_QNAME, String.class, SmartphoneDetection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "timestamp", scope = SmartphoneDetection.class)
    public JAXBElement<XMLGregorianCalendar> createSmartphoneDetectionTimestamp(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_FrameTimestamp_QNAME, XMLGregorianCalendar.class, SmartphoneDetection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "protocol", scope = SmartphoneDetection.class)
    public JAXBElement<String> createSmartphoneDetectionProtocol(String value) {
        return new JAXBElement<String>(_FrameProtocol_QNAME, String.class, SmartphoneDetection.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "mac", scope = Device.class)
    public JAXBElement<String> createDeviceMac(String value) {
        return new JAXBElement<String>(_DeviceMac_QNAME, String.class, Device.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "timestamp", scope = Device.class)
    public JAXBElement<XMLGregorianCalendar> createDeviceTimestamp(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_FrameTimestamp_QNAME, XMLGregorianCalendar.class, Device.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "protocol", scope = Device.class)
    public JAXBElement<String> createDeviceProtocol(String value) {
        return new JAXBElement<String>(_FrameProtocol_QNAME, String.class, Device.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dto.monitors.com/xsd", name = "source_device_type", scope = Device.class)
    public JAXBElement<String> createDeviceSourceDeviceType(String value) {
        return new JAXBElement<String>(_FrameSourceDeviceType_QNAME, String.class, Device.class, value);
    }

}
