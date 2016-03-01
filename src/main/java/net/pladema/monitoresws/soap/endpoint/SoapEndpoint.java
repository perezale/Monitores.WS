package net.pladema.monitoresws.soap.endpoint;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import net.pladema.monitoresws.soap.xsd.Device;
import net.pladema.monitoresws.soap.xsd.GetDevicesResponse;


@Endpoint
public class SoapEndpoint {
	private static final String NAMESPACE_URI = "http://ws.monitors.com";

	@Autowired
	public SoapEndpoint() {

	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDevicesRequest")
	@ResponsePayload
	public GetDevicesResponse getCountry() {
		GetDevicesResponse response = new GetDevicesResponse();
		Device d = new Device();
		
		response.getReturn().addAll(Arrays.asList(new Device[]{d}));

		return response;
	}
	
}