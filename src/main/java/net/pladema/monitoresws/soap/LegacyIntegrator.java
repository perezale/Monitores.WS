package net.pladema.monitoresws.soap;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import com.monitors.dto.xsd.ObjectFactory;

import net.pladema.monitoresws.entity.Device; 
import net.pladema.monitoresws.entity.Frame;
import net.pladema.monitoresws.entity.SmartphoneDetection;;

public class LegacyIntegrator {
	
	public static ObjectFactory factory = new ObjectFactory();

	
	private static XMLGregorianCalendar createXmlGregorianCalendar(Calendar calendar){
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(calendar.getTime());
		XMLGregorianCalendar date2 = null;		
		try {
			date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		return date2;
	}
	public static Device parseDevice(com.monitors.dto.xsd.Device input){
		Device output = new Device();
		output.setId(input.getId());
		output.setId_scanner(input.getIdScanner());
		output.setMac(input.getMac().getValue());
		output.setProtocol(input.getProtocol().getValue());
		output.setSignal(input.getSignal());
		output.setSource_device_type(input.getSourceDeviceType().getValue());
		output.setTimestamp(input.getTimestamp().getValue().toGregorianCalendar());		
		return output;
	}
	
	public static Frame parseFrame(com.monitors.dto.xsd.Frame input){
		Frame output = new Frame();
		output.setId(input.getId());
		output.setId_scanner(input.getIdScanner());
		output.setSource_mac(input.getSourceMac().getValue());
		output.setDestination_mac(input.getDestinationMac().getValue());
		output.setFrame_type(input.getFrameType().getValue());
		output.setProtocol(input.getProtocol().getValue());
		output.setSignal(input.getSignal());
		output.setSsid(input.getSsid().getValue());
		output.setSource_device_type(input.getSourceDeviceType().getValue());
		output.setTimestamp(input.getTimestamp().getValue().toGregorianCalendar());		
		return output;
	}
	
	public static SmartphoneDetection parseSmartphoneDetection(com.monitors.dto.xsd.SmartphoneDetection input){
		SmartphoneDetection output = new SmartphoneDetection();
		output.setTimestamp(input.getTimestamp().getValue().toGregorianCalendar());
		output.setLat(input.getLat().getValue());
		output.setLon(input.getLon().getValue());
		output.setProtocol(input.getProtocol().getValue());
		output.setSignal(input.getSignal());
		output.setSsid(input.getSsid().getValue());
		output.setDestination_mac(input.getDestinationMac().getValue());
		output.setSource_mac(input.getSourceMac().getValue());		
		return output;
	}
	
	public static com.monitors.dto.xsd.Device marshalDevice(Device input){
		com.monitors.dto.xsd.Device output = new com.monitors.dto.xsd.Device();
		output.setId(input.getId());
		output.setIdScanner(input.getId_scanner());
		output.setMac(factory.createDeviceMac(input.getMac()));
		output.setProtocol(factory.createDeviceProtocol(input.getProtocol()));		
		output.setSignal(input.getSignal());
		output.setSourceDeviceType(factory.createDeviceSourceDeviceType(input.getSource_device_type()));		
		output.setTimestamp(factory.createDeviceTimestamp(createXmlGregorianCalendar(input.getTimestamp())));			
		return output;
	}
	
	public static com.monitors.dto.xsd.Frame marshalFrame(Frame input){
		com.monitors.dto.xsd.Frame output = new com.monitors.dto.xsd.Frame();
		output.setDestinationMac(factory.createFrameDestinationMac(input.getDestination_mac()));
		output.setFrameType(factory.createFrameFrameType(input.getFrame_type()));		
		output.setId(input.getId());
		output.setIdScanner(input.getId_scanner());				
		output.setProtocol(factory.createFrameProtocol(input.getProtocol()));		
		output.setSignal(input.getSignal());
		output.setSourceDeviceType(factory.createFrameSourceDeviceType(input.getSource_device_type()));
		output.setSourceMac(factory.createFrameSourceMac(input.getSource_mac()));
		output.setSsid(factory.createFrameSsid(input.getSsid()));
		output.setTimestamp(factory.createFrameTimestamp(createXmlGregorianCalendar(input.getTimestamp())));
		
		return output;
	}
	
	public static com.monitors.dto.xsd.SmartphoneDetection marshalSmarthponeDetection(SmartphoneDetection input){
		com.monitors.dto.xsd.SmartphoneDetection output = new com.monitors.dto.xsd.SmartphoneDetection();		
		output.setDestinationMac(factory.createSmartphoneDetectionDestinationMac(input.getDestination_mac()));
		output.setLat(factory.createSmartphoneDetectionLat(input.getLat()));
		output.setLon(factory.createSmartphoneDetectionLon(input.getLon()));
		output.setProtocol(factory.createSmartphoneDetectionProtocol(input.getProtocol()));
		output.setSignal(input.getSignal());
		output.setSourceMac(factory.createFrameSourceMac(input.getSource_mac()));
		output.setSsid(factory.createSmartphoneDetectionSsid(input.getSsid()));
		output.setTimestamp(factory.createFrameTimestamp(createXmlGregorianCalendar(input.getTimestamp())));		
		return output;
	}
	
	public static List<com.monitors.dto.xsd.Device> marshalDeviceList(
			List<Device> list) {
		List<com.monitors.dto.xsd.Device> output = new ArrayList<com.monitors.dto.xsd.Device>();
		for(net.pladema.monitoresws.entity.Device device : list){
			output.add(LegacyIntegrator.marshalDevice(device));
		}
		return output;
	}
	
	public static List<com.monitors.dto.xsd.Frame> marshalFrameList(
			List<Frame> list) {
		List<com.monitors.dto.xsd.Frame> output = new ArrayList<com.monitors.dto.xsd.Frame>();
		for(net.pladema.monitoresws.entity.Frame frame : list){
			output.add(LegacyIntegrator.marshalFrame(frame));
		}
		return output;
	}
	
	public static List<com.monitors.dto.xsd.SmartphoneDetection> marshalSmartphoneDetectionList(
			List<SmartphoneDetection> list) {
		List<com.monitors.dto.xsd.SmartphoneDetection> output = new ArrayList<com.monitors.dto.xsd.SmartphoneDetection>();
		for(net.pladema.monitoresws.entity.SmartphoneDetection smartphone : list){
			output.add(LegacyIntegrator.marshalSmarthponeDetection(smartphone));
		}
		return output;
	}
}
