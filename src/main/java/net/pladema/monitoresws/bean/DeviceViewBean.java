package net.pladema.monitoresws.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import net.pladema.monitoresws.entity.Device;
import net.pladema.monitoresws.service.DeviceService;

@ViewScoped
@ManagedBean("deviceView")
public class DeviceViewBean extends CommonView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4630506639933453408L;

	@Autowired
	private DeviceService deviceService;

	private List<Device> filteredDevices;

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	public List<Device> getDevices() {
		return deviceService.findAll();
	}

	public List<Device> getFilteredDevices() {
		return filteredDevices;
	}

	public void setFilteredDevices(List<Device> filteredDevices) {
		this.filteredDevices = filteredDevices;
	}

	/*
	 * public void delete(Device device){ Device[] toDelete = new
	 * Device[]{device}; new WebService().DeleteDevices(toDelete);
	 * System.out.println("Deleting device "+ device.getId() + "...");
	 * this.updateDeviceList(); return; }
	 */
	public List<String> getMacs() {
		return deviceService.getMacs();		
	}

	public List<String> getProtocols() {
		return Arrays.asList(new String[] { "W", "B" });
	}
	
	public String getTime(){
		return new Date().toString();
	}

}
