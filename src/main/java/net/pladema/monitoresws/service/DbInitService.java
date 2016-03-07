package net.pladema.monitoresws.service;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import net.pladema.monitoresws.app.Application;
import net.pladema.monitoresws.entity.BluetoothDetection;
import net.pladema.monitoresws.entity.Detector;
import net.pladema.monitoresws.entity.Device;
import net.pladema.monitoresws.entity.Frame;
import net.pladema.monitoresws.repository.BluetoothDetectionRepository;
import net.pladema.monitoresws.repository.DetectorRepository;
import net.pladema.monitoresws.repository.DeviceRepository;
import net.pladema.monitoresws.repository.FrameRepository;

@Service
@Profile("dev")
public class DbInitService {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
    @Autowired
    private DetectorRepository detectorRepository;
    
    @Autowired
    private BluetoothDetectionRepository bluetoothRepository;
    
    @Autowired
    private DeviceRepository deviceRepository;
    
    @Autowired
    private FrameRepository frameRepository;

    @PostConstruct
    public void init() {
    	detectorRepository.save(new Detector(-37.320750f, -59.081938f));
		detectorRepository.save(new Detector(-37.321531f, -59.083338f));
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());				
		deviceRepository.save(new Device(0,calendar,"386077DB1E86",5,"android","W"));
		deviceRepository.save(new Device(0,calendar,"54E6FCFDBC56",5,"blackberry","W"));
		
		frameRepository.save(new Frame(0,calendar,"386077DB1E86","54E6FCFDBC56",5,"probe_req","android","W","club union"));

		// fetch all detectors
		log.info("Detectors found with findAll():");
		log.info("-------------------------------");
		for (Detector detector : detectorRepository.findAll()) {
			log.info(detector.toString());
		}
		log.info("");

		// fetch an individual detectors by ID
		Detector detector = detectorRepository.findOne(1L);
		log.info("Detector found with findOne(1L):");
		log.info("--------------------------------");
		log.info(detector.toString());
		log.info("");

		// save a couple of Bluetooth Detections
		bluetoothRepository.save(new BluetoothDetection(detector, new Date(), "349e4a", -50));
		bluetoothRepository.save(new BluetoothDetection(detector, new Date(), "349e4a", -55));
		bluetoothRepository.save(new BluetoothDetection(detector, new Date(), "349e4a", -60));

		// fetch all detections
		log.info("Bluetooth detections found with findAll():");
		log.info("-------------------------------");
		for (BluetoothDetection detection : bluetoothRepository.findAll()) {
			log.info(detection.toString());
		}
		log.info("");

		// fetch an individual detectors by ID
		BluetoothDetection bdetection = bluetoothRepository.findOne(1L);
		log.info("Bluetooth detection found with findOne(1L):");
		log.info("--------------------------------");
		log.info(bdetection.toString());
		log.info("");
    }
}