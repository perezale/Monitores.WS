package net.pladema.monitoresws.service;

import java.util.List;

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
}
