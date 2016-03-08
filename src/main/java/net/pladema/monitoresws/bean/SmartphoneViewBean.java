package net.pladema.monitoresws.bean;

import java.util.Arrays;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import net.pladema.monitoresws.entity.SmartphoneDetection;
import net.pladema.monitoresws.service.SmartphoneDetectionService;


@ManagedBean("smartphoneView")
@ViewScoped
public class SmartphoneViewBean extends CommonView{

	@Autowired
	private SmartphoneDetectionService smartphoneService;
	private List<SmartphoneDetection> detections;	
	private List<SmartphoneDetection> filteredDetections;
	
	@PostConstruct
	private void updateDetectionList(){
		detections = smartphoneService.findAll();
	}	
	
	public List<SmartphoneDetection> getDetections() {
		return detections;
	}

	public void setFrames(List<SmartphoneDetection> detections) {
		this.detections = detections;
	}

	public List<SmartphoneDetection> getFilteredDetections() {
		return filteredDetections;
	}

	public void setFilteredFrames(List<SmartphoneDetection> filteredDetections) {
		this.filteredDetections = filteredDetections;
	}

	public void delete(SmartphoneDetection detection){
		SmartphoneDetection[] toDelete = new SmartphoneDetection[]{detection};
		smartphoneService.delete(Arrays.asList(toDelete));
		System.out.println("Deleting frame "+ detection.getTimestamp() + "...");
		this.updateDetectionList();
		return;
	}

	public List<String> getSourceMacs() {
		return smartphoneService.getSourceMacs();		
	}
	
	public List<String> getDestinationMacs() {
		return smartphoneService.getDestinationMacs();
	}	

	public List<String> getProtocols() {
		return smartphoneService.getProtocols();
	}

}
