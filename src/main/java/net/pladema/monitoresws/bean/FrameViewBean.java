package net.pladema.monitoresws.bean;

import java.util.Arrays;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import net.pladema.monitoresws.entity.Frame;
import net.pladema.monitoresws.service.FrameService;

@ViewScoped
@ManagedBean("frameView")
public class FrameViewBean extends CommonView{

	@Autowired
	private FrameService frameService;
	
	private List<Frame> filteredFrames;
	
	public FrameViewBean(){}

	public List<Frame> getFrames(){
		return frameService.findAll();
	}
	
	public void setFrameService(FrameService frameService) {
		this.frameService = frameService;
	}

	public List<Frame> getFilteredFrames() {
		return filteredFrames;
	}

	public void setFilteredFrames(List<Frame> filteredFrames) {
		this.filteredFrames = filteredFrames;
	}

	public void delete(Frame frame) {
		Frame[] toDelete = new Frame[] { frame };
		frameService.delete(Arrays.asList(toDelete));
		System.out.println("Deleting frame " + frame.getId() + "...");
		return;
	}

	public List<String> getSourceMacs() {
		return frameService.getSourceMacs();
	}

	public List<String> getDestinationMacs() {
		return frameService.getDestinationMacs();
	}

	public List<String> getFrameTypes() {
		return frameService.getFrameTypes();
	}

	public List<String> getProtocols() {
		return Arrays.asList(new String[] { "W", "B" });
	}

}
