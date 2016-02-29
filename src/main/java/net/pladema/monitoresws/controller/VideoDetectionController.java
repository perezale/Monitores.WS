package net.pladema.monitoresws.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.pladema.monitoresws.entity.Detector;
import net.pladema.monitoresws.entity.VideoDetection;
import net.pladema.monitoresws.entity.VideoDetectionCollection;
import net.pladema.monitoresws.repository.DetectorRepository;
import net.pladema.monitoresws.repository.VideoDetectionRepository;

@RestController
@RequestMapping("/api/videoDetections")
public class VideoDetectionController {
    
	@Autowired
	private VideoDetectionRepository videoDetectionRepository;
	
	@Autowired
	private DetectorRepository detectorRepository;

	@RequestMapping(path = "/collection", method = RequestMethod.POST)
	ResponseEntity<?> addCollection(@RequestBody VideoDetectionCollection input) {
		long detectorId = input.getDetectorId();
		Detector detector = detectorRepository.findOne(detectorId);
		if(detector == null){
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("X-Status-Reason", String.format("Detector with id=%s not found",detectorId));
			return new ResponseEntity<>(null, httpHeaders, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		List<VideoDetection> detections = input.getDetections();
		List<Long> results = new ArrayList<Long>();
		for (VideoDetection detection : detections) {			
			VideoDetection result = videoDetectionRepository
					.save(new VideoDetection(detector, detection.getTime(), detection.getCount()));
			results.add(result.getId());
		}
		return new ResponseEntity<>(Arrays.toString(results.toArray()), null, HttpStatus.CREATED);

	}
   
}
