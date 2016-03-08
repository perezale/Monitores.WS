package net.pladema.monitoresws.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.pladema.monitoresws.entity.SmartphoneDetection;
import net.pladema.monitoresws.repository.SmartphoneDetectionRepository;

@Service
public class SmartphoneDetectionService {

	@Autowired
	private SmartphoneDetectionRepository smartphoneDetectionRepository;

	public List<SmartphoneDetection> findAll() {
		return smartphoneDetectionRepository.findAll();
	}

	public SmartphoneDetection save(SmartphoneDetection smartphoneDetection) {
		return smartphoneDetectionRepository.save(smartphoneDetection);
	}

	public List<SmartphoneDetection> saveMultiple(
			List<SmartphoneDetection> detections) {		
		return smartphoneDetectionRepository.save(detections);
	}
	
	public void delete(Iterable<SmartphoneDetection> detection){
		smartphoneDetectionRepository.delete(detection);
	}

	public List<String> getSourceMacs() {
		Object[] findDistinctMacs = smartphoneDetectionRepository.findDistinctSourceMacs();
		return Arrays.asList(findDistinctMacs).stream().map(o -> o.toString()).collect(Collectors.toList());		
	}

	public List<String> getDestinationMacs() {
		Object[] findDistinctMacs = smartphoneDetectionRepository.findDistinctDestinationMacs();
		return Arrays.asList(findDistinctMacs).stream().map(o -> o.toString()).collect(Collectors.toList());
	}

	public List<String> getProtocols() {
		Object[] findDistinctProtocols = smartphoneDetectionRepository.findDistinctProtocols();
		return Arrays.asList(findDistinctProtocols).stream().map(o -> o.toString()).collect(Collectors.toList());
	}

}
