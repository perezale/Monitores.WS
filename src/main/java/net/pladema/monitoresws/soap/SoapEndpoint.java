package net.pladema.monitoresws.soap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.monitors.dto.xsd.Device;
import com.monitors.dto.xsd.Frame;
import com.monitors.dto.xsd.SmartphoneDetection;
import com.monitors.ws.DeleteDevices;
import com.monitors.ws.DeleteDevicesResponse;
import com.monitors.ws.DeleteFrames;
import com.monitors.ws.DeleteFramesResponse;
import com.monitors.ws.GetDevices;
import com.monitors.ws.GetDevicesResponse;
import com.monitors.ws.GetFrames;
import com.monitors.ws.GetFramesResponse;
import com.monitors.ws.GetSmartphoneDetections;
import com.monitors.ws.GetSmartphoneDetectionsResponse;
import com.monitors.ws.InsertMultipleDeviceDTO;
import com.monitors.ws.InsertMultipleDeviceDTOResponse;
import com.monitors.ws.InsertMultipleDevices;
import com.monitors.ws.InsertMultipleDevicesResponse;
import com.monitors.ws.InsertMultipleFrameDTO;
import com.monitors.ws.InsertMultipleFrameDTOResponse;
import com.monitors.ws.InsertMultipleFrames;
import com.monitors.ws.InsertMultipleFramesResponse;
import com.monitors.ws.InsertMultipleSmartphoneDetection;
import com.monitors.ws.InsertMultipleSmartphoneDetectionDTO;
import com.monitors.ws.InsertMultipleSmartphoneDetectionDTOResponse;
import com.monitors.ws.InsertMultipleSmartphoneDetectionResponse;
import com.monitors.ws.InsertSingleDevice;
import com.monitors.ws.InsertSingleDeviceDTO;
import com.monitors.ws.InsertSingleDeviceDTOResponse;
import com.monitors.ws.InsertSingleDeviceResponse;
import com.monitors.ws.InsertSingleFrame;
import com.monitors.ws.InsertSingleFrameDTO;
import com.monitors.ws.InsertSingleFrameDTOResponse;
import com.monitors.ws.InsertSingleFrameResponse;
import com.monitors.ws.InsertSingleSmartphoneDetection;
import com.monitors.ws.InsertSingleSmartphoneDetectionDTO;
import com.monitors.ws.InsertSingleSmartphoneDetectionDTOResponse;
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
			response.setReturn(
					factory.createInsertSingleDeviceDTOResponseReturn("Insert Device OK: " + device.getId()));
		} catch (Exception e) {
			response.setReturn(factory.createInsertSingleDeviceDTOResponseReturn(
					"Error: La operación no se pudo ejecutar correctamente."));
		}

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertSingleFrameDTO")
	@ResponsePayload
	public InsertSingleFrameDTOResponse insertSingleFrameDTO(@RequestPayload InsertSingleFrameDTO request) {
		InsertSingleFrameDTOResponse response = new InsertSingleFrameDTOResponse();
		try {
			Frame data = request.getFrame().getValue();
			net.pladema.monitoresws.entity.Frame parseFrame = LegacyIntegrator.parseFrame(data);
			net.pladema.monitoresws.entity.Frame frame = frameService.save(parseFrame);
			response.setReturn(factory.createInsertSingleFrameDTOResponseReturn("Insert Frame OK: " + frame.getId()));
		} catch (Exception e) {
			response.setReturn(factory.createInsertSingleFrameDTOResponseReturn(
					"Error: La operación no se pudo ejecutar correctamente."));
		}

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertSingleSmartphoneDetectionDTO")
	@ResponsePayload
	public InsertSingleSmartphoneDetectionDTOResponse insertSingleSmartphoneDetectionDTO(
			@RequestPayload InsertSingleSmartphoneDetectionDTO request) {
		InsertSingleSmartphoneDetectionDTOResponse response = new InsertSingleSmartphoneDetectionDTOResponse();
		try {
			SmartphoneDetection data = request.getDetection().getValue();
			net.pladema.monitoresws.entity.SmartphoneDetection parseSmartphoneDet = LegacyIntegrator
					.parseSmartphoneDetection(data);
			net.pladema.monitoresws.entity.SmartphoneDetection smartphoneDet = smartphoneDetectionService
					.save(parseSmartphoneDet);
			response.setReturn(factory.createInsertSingleSmartphoneDetectionResponseReturn(
					"Insert Frame OK: " + smartphoneDet.getTimestamp() + "," + smartphoneDet.getSource_mac()));
		} catch (Exception e) {
			response.setReturn(factory.createInsertSingleSmartphoneDetectionResponseReturn(
					"Error: La operación no se pudo ejecutar correctamente."));
		}

		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertMultipleDevices")
	@ResponsePayload
	public InsertMultipleDevicesResponse insertMultipleDevices(
			@RequestPayload InsertMultipleDevices request) {
		String msg = "";
		InsertMultipleDevicesResponse response = new InsertMultipleDevicesResponse();
		try {
			String data = request.getData().getValue();
			
			List<net.pladema.monitoresws.entity.Device> devices = new ArrayList<net.pladema.monitoresws.entity.Device>();
			String[] data_lst = data.split(";");
			for(String single : data_lst){
				net.pladema.monitoresws.entity.Device device = ParseUtils.ObtenerDevice(single);
				if(device == null) {
					msg = "Formato de entrada inválido, formato de fecha: "+ParseUtils.sdf.toPattern();
					response.setReturn(factory.createInsertMultipleDevicesResponseReturn(msg));
					return response;
				}
				devices.add(device);			
			}			
			
			List<net.pladema.monitoresws.entity.Device> saveMultiple = deviceService.saveMultiple(devices);
			msg = "Insert OK! "+ saveMultiple.size() + " devices" ;
					
		}catch(Exception ex){
			msg = "Error: La operación no se pudo ejecutar correctamente.";
		}
		
		response.setReturn(factory.createInsertMultipleDevicesResponseReturn(msg));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertMultipleDeviceDTO")
	@ResponsePayload
	public InsertMultipleDeviceDTOResponse insertMultipleDeviceDTO(
			@RequestPayload InsertMultipleDeviceDTO request) {
		String msg = "";
		InsertMultipleDeviceDTOResponse response = new InsertMultipleDeviceDTOResponse();
		try {
			List<Device> data = request.getDevices();
			List<net.pladema.monitoresws.entity.Device> devices = new ArrayList<net.pladema.monitoresws.entity.Device>();
			for(Device d : data){
				devices.add(LegacyIntegrator.parseDevice(d));				
			}			
			List<net.pladema.monitoresws.entity.Device> saveMultiple = deviceService.saveMultiple(devices);
			msg = "Insert OK! "+ saveMultiple.size() + " devices" ;
					
		}catch(Exception ex){
			msg = "Error: La operación no se pudo ejecutar correctamente.";
		}
		
		response.setReturn(factory.createInsertMultipleDeviceDTOResponseReturn(msg));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteDevices")
	@ResponsePayload
	public DeleteDevicesResponse deleteDevices(
			@RequestPayload DeleteDevices request) {
		String msg = "";
		DeleteDevicesResponse response = new DeleteDevicesResponse();
		try {
			List<Device> data = request.getDevices();
			List<net.pladema.monitoresws.entity.Device> devices = new ArrayList<net.pladema.monitoresws.entity.Device>();
			for(Device d : data){
				devices.add(LegacyIntegrator.parseDevice(d));				
			}			
			deviceService.delete(devices);
			msg = "Delete OK! ";
					
		}catch(Exception ex){
			msg = "Error: La operación no se pudo ejecutar correctamente.";
		}
		
		response.setReturn(factory.createDeleteDevicesResponseReturn(msg));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertMultipleFrames")
	@ResponsePayload
	public InsertMultipleFramesResponse insertMultipleFrames(
			@RequestPayload InsertMultipleFrames request) {
		String msg = "";
		InsertMultipleFramesResponse response = new InsertMultipleFramesResponse();
		try {
			String data = request.getData().getValue();
			
			List<net.pladema.monitoresws.entity.Frame> frames = new ArrayList<net.pladema.monitoresws.entity.Frame>();
			String[] data_lst = data.split(";");
			for(String single : data_lst){
				net.pladema.monitoresws.entity.Frame frame = ParseUtils.ObtenerFrame(single);
				if(frame == null) {
					msg = "Formato de entrada inválido, formato de fecha: "+ParseUtils.sdf.toPattern();
					response.setReturn(factory.createInsertMultipleFramesResponseReturn(msg));
					return response;
				}
				frames.add(frame);			
			}			
			
			List<net.pladema.monitoresws.entity.Frame> saveMultiple = frameService.saveMultiple(frames);
			msg = "Insert OK! "+ saveMultiple.size() + " frames" ;
					
		}catch(Exception ex){
			msg = "Error: La operación no se pudo ejecutar correctamente.";
		}
		
		response.setReturn(factory.createInsertMultipleFramesResponseReturn(msg));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertMultipleFrameDTO")
	@ResponsePayload
	public InsertMultipleFrameDTOResponse insertMultipleFrameDTO(
			@RequestPayload InsertMultipleFrameDTO request) {
		String msg = "";
		InsertMultipleFrameDTOResponse response = new InsertMultipleFrameDTOResponse();
		try {
			List<Frame> data = request.getFrames();
			List<net.pladema.monitoresws.entity.Frame> frames = new ArrayList<net.pladema.monitoresws.entity.Frame>();
			for(Frame f : data){
				frames.add(LegacyIntegrator.parseFrame(f));				
			}			
			List<net.pladema.monitoresws.entity.Frame> saveMultiple = frameService.saveMultiple(frames);
			msg = "Insert OK! "+ saveMultiple.size() + " frames" ;
					
		}catch(Exception ex){
			msg = "Error: La operación no se pudo ejecutar correctamente.";
		}
		
		response.setReturn(factory.createInsertMultipleFrameDTOResponseReturn(msg));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "DeleteFrames")
	@ResponsePayload
	public DeleteFramesResponse deleteFrames(
			@RequestPayload DeleteFrames request) {
		String msg = "";
		DeleteFramesResponse response = new DeleteFramesResponse();
		try {
			List<Frame> data = request.getFrames();
			List<net.pladema.monitoresws.entity.Frame> frames = new ArrayList<net.pladema.monitoresws.entity.Frame>();
			for(Frame f : data){
				frames.add(LegacyIntegrator.parseFrame(f));				
			}			
			frameService.delete(frames);
			msg = "Delete OK! ";
					
		}catch(Exception ex){
			msg = "Error: La operación no se pudo ejecutar correctamente.";
		}
		
		response.setReturn(factory.createDeleteFramesResponseReturn(msg));
		return response;
	}


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertMultipleSmartphoneDetection")
	@ResponsePayload
	public InsertMultipleSmartphoneDetectionResponse insertMultipleSmartphoneDetection(
			@RequestPayload InsertMultipleSmartphoneDetection request) {
		String msg = "";
		InsertMultipleSmartphoneDetectionResponse response = new InsertMultipleSmartphoneDetectionResponse();
		try {
			String data = request.getData().getValue();
			
			List<net.pladema.monitoresws.entity.SmartphoneDetection> detections = new ArrayList<net.pladema.monitoresws.entity.SmartphoneDetection>();
			String[] data_lst = data.split(";");
			for(String single : data_lst){
				net.pladema.monitoresws.entity.SmartphoneDetection detection = ParseUtils.ObtenerSmartphoneDetection(single);
				if(detection == null) {
					msg = "Formato de entrada inválido, formato de fecha: "+ParseUtils.sdf.toPattern();
					response.setReturn(factory.createInsertMultipleSmartphoneDetectionResponseReturn(msg));
					return response;
				}
				detections.add(detection);			
			}			
			
			List<net.pladema.monitoresws.entity.SmartphoneDetection> saveMultiple = smartphoneDetectionService.saveMultiple(detections);
			msg = "Insert OK! "+ saveMultiple.size() + " smartphone detection(s)" ;
					
		}catch(Exception ex){
			msg = "Error: La operación no se pudo ejecutar correctamente.";
		}
		
		response.setReturn(factory.createInsertMultipleSmartphoneDetectionResponseReturn(msg));
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "InsertMultipleSmartphoneDetectionDTO")
	@ResponsePayload
	public InsertMultipleSmartphoneDetectionDTOResponse insertMultipleSmartphoneDetectionDTO(
			@RequestPayload InsertMultipleSmartphoneDetectionDTO request) {
		String msg = "";
		InsertMultipleSmartphoneDetectionDTOResponse response = new InsertMultipleSmartphoneDetectionDTOResponse();
		try {
			List<SmartphoneDetection> data = request.getDetections();
			List<net.pladema.monitoresws.entity.SmartphoneDetection> detections = new ArrayList<net.pladema.monitoresws.entity.SmartphoneDetection>();
			for(SmartphoneDetection det : data){
				detections.add(LegacyIntegrator.parseSmartphoneDetection(det));				
			}			
			List<net.pladema.monitoresws.entity.SmartphoneDetection> saveMultiple = smartphoneDetectionService.saveMultiple(detections);
			msg = "Insert OK! "+ saveMultiple.size() + " detections" ;
					
		}catch(Exception ex){
			msg = "Error: La operación no se pudo ejecutar correctamente.";
		}
		
		response.setReturn(factory.createInsertMultipleSmartphoneDetectionDTOResponseReturn(msg));
		return response;
	}
}