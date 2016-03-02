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
import com.monitors.ws.InsertSingleDevice;
import com.monitors.ws.InsertSingleDeviceDTO;
import com.monitors.ws.InsertSingleDeviceDTOResponse;
import com.monitors.ws.InsertSingleDeviceResponse;
import com.monitors.ws.InsertSingleFrame;
import com.monitors.ws.InsertSingleFrameResponse;
import com.monitors.ws.InsertSingleSmartphoneDetection;
import com.monitors.ws.InsertSingleSmartphoneDetectionResponse;
import com.monitors.ws.ObjectFactory;

import net.pladema.monitoresws.service.DeviceService;
import net.pladema.monitoresws.service.FrameService;
import net.pladema.monitoresws.service.SmartphoneDetectionService;
import net.pladema.monitoresws.util.ParseUtils;

@Endpoint
public class SoapEndpoint {

	private static final String NAMESPACE_URI = "http://ws.monitors.com";
	private static final ObjectFactory factory = new com.monitors.ws.ObjectFactory();

	private DeviceService deviceService;
	private FrameService frameService;
	private SmartphoneDetectionService smartphoneDetectionService;

	@Autowired
	public SoapEndpoint(DeviceService deviceService, FrameService frameService,
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
		List<SmartphoneDetection> smartphoneDetections = LegacyIntegrator
				.marshalSmartphoneDetectionList(smartphoneDetectionService.findAll());
		response.getReturn().addAll(smartphoneDetections);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertSingleDevice")
	@ResponsePayload
	public InsertSingleDeviceResponse insertSingleDevice(@RequestPayload InsertSingleDevice request) {
		InsertSingleDeviceResponse response = new InsertSingleDeviceResponse();
		try {
			String data = request.getData().getValue();
			net.pladema.monitoresws.entity.Device device = deviceService.save(ParseUtils.ObtenerDevice(data));
			response.setReturn(factory.createInsertSingleDeviceData("Insert Device OK: " + device.getId()));
		} catch (Exception e) {
			response.setReturn(
					factory.createInsertSingleDeviceData("Error: La operación no se pudo ejecutar correctamente."));
		}

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertSingleFrame")
	@ResponsePayload
	public InsertSingleFrameResponse insertSingleFrame(@RequestPayload InsertSingleFrame request) {
		InsertSingleFrameResponse response = new InsertSingleFrameResponse();
		try {
			String data = request.getData().getValue();
			net.pladema.monitoresws.entity.Frame frame = frameService.save(ParseUtils.ObtenerFrame(data));
			response.setReturn(factory.createInsertSingleFrameData("Insert Frame OK: " + frame.getId()));
		} catch (Exception e) {
			response.setReturn(
					factory.createInsertSingleFrameData("Error: La operación no se pudo ejecutar correctamente."));
		}

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertSingleSmartphoneDetection")
	@ResponsePayload
	public InsertSingleSmartphoneDetectionResponse insertSingleSmartphoneDetection(
			@RequestPayload InsertSingleSmartphoneDetection request) {
		InsertSingleSmartphoneDetectionResponse response = new InsertSingleSmartphoneDetectionResponse();
		try {
			String data = request.getData().getValue();
			net.pladema.monitoresws.entity.SmartphoneDetection smartphoneDetection = smartphoneDetectionService
					.save(ParseUtils.ObtenerSmartphoneDetection(data));
			response.setReturn(factory.createInsertSingleSmartphoneDetectionData("Insert SmartphoneDetection OK: "
					+ smartphoneDetection.getTimestamp() + "," + smartphoneDetection.getSource_mac()));
		} catch (Exception e) {
			response.setReturn(factory.createInsertSingleSmartphoneDetectionData(
					"Error: La operación no se pudo ejecutar correctamente."));
		}

		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertSingleDeviceDTO")
	@ResponsePayload
	public InsertSingleDeviceDTOResponse insertSingleDeviceDTO(@RequestPayload InsertSingleDeviceDTO request) {
		InsertSingleDeviceDTOResponse response = new InsertSingleDeviceDTOResponse();
		try {
			Device data = request.getDevice().getValue();
			net.pladema.monitoresws.entity.Device parseDevice = LegacyIntegrator.parseDevice(data);
			net.pladema.monitoresws.entity.Device device = deviceService.save(parseDevice);
			response.setReturn(factory.createInsertSingleDeviceDTOResponseReturn("Insert Device OK: " + device.getId()));
		} catch (Exception e) {
			response.setReturn(
					factory.createInsertSingleDeviceDTOResponseReturn("Error: La operación no se pudo ejecutar correctamente."));
		}

		return response;
	}
}