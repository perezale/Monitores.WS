package net.pladema.monitoresws.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.pladema.monitoresws.entity.Device;
import net.pladema.monitoresws.repository.DeviceRepository;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;
	
	
	public List<Device> findAll(){
		return deviceRepository.findAll();
	}
	
	public List<String> getMacs(){
		Object[] findDistinctMacs = deviceRepository.findDistinctMacs();
		return Arrays.asList(findDistinctMacs).stream().map(o -> o.toString()).collect(Collectors.toList());
	}
}
