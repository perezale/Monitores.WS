package net.pladema.monitoresws.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.monitors.dto.xsd.Device;
import com.monitors.dto.xsd.Frame;
import com.monitors.dto.xsd.SmartphoneDetection;
import com.monitors.ws.GetDevices;
import com.monitors.ws.GetDevicesResponse;
import com.monitors.ws.GetFrames;
import com.monitors.ws.GetFramesResponse;
import com.monitors.ws.GetSmartphoneDetections;
import com.monitors.ws.GetSmartphoneDetectionsResponse;

import net.pladema.monitoresws.service.DeviceService;
import net.pladema.monitoresws.service.FrameService;
import net.pladema.monitoresws.service.SmartphoneDetectionService;


@Endpoint
public class SoapEndpoint {
	
	private static final String NAMESPACE_URI = "http://ws.monitors.com";	
	
	private DeviceService deviceService;
	private FrameService frameService;
	private SmartphoneDetectionService smartphoneDetectionService;
	
	@Autowired
	public SoapEndpoint(DeviceService deviceService, 
			FrameService frameService,
			SmartphoneDetectionService smartphoneDetectionService) {
		this.deviceService = deviceService;
		this.frameService = frameService;
		this.smartphoneDetectionService = smartphoneDetectionService;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetDevices")
	@ResponsePayload
	public GetDevicesResponse getDevices(@RequestPayload GetDevices request) {
		GetDevicesResponse response = new GetDevicesResponse();					
		List<Device> devices = LegacyIntegrator.marshalDeviceList(deviceService.findAll());		
		response.getReturn().addAll(devices);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetFrames")
	@ResponsePayload
	public GetFramesResponse getFrames(@RequestPayload GetFrames request) {
		GetFramesResponse response = new GetFramesResponse();					
		List<Frame> frames = LegacyIntegrator.marshalFrameList(frameService.findAll());		
		response.getReturn().addAll(frames);
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetSmartphoneDetections")
	@ResponsePayload
	public GetSmartphoneDetectionsResponse getFrames(@RequestPayload GetSmartphoneDetections request) {
		GetSmartphoneDetectionsResponse response = new GetSmartphoneDetectionsResponse();					
		List<SmartphoneDetection> smartphoneDetections = LegacyIntegrator.marshalSmartphoneDetectionList(smartphoneDetectionService.findAll());		
		response.getReturn().addAll(smartphoneDetections);
		return response;
	}
	
}