package net.pladema.monitoresws.bean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import net.pladema.monitoresws.entity.Device;
import net.pladema.monitoresws.service.DeviceService;

@ManagedBean(name = "dtFilterView")
@ViewScoped
public class FilterViewBean extends CommonView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4630506639933453408L;

	@ManagedProperty("#{deviceService}")
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
		List<Object> findDistinctMacs = Arrays.asList(deviceService.getMacs());
		return findDistinctMacs.stream().map(o -> o.toString()).collect(Collectors.toList());
	}

	public List<String> getProtocols() {
		return Arrays.asList(new String[] { "W", "B" });
	}

}
