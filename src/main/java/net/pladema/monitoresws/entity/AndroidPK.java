package net.pladema.monitoresws.entity;

import java.io.Serializable;

public class AndroidPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1653666867972540813L;
	//@Column(name = "id_vehicle")
	protected String vehicleId;
	//@Column(name = "history_date")
	protected String historyDate;

	public AndroidPK() {
	}
	
	public AndroidPK(String vehicleId, String historyDate) {
		super();
		this.vehicleId = vehicleId;
		this.historyDate = historyDate;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getHistoryDate() {
		return historyDate;
	}

	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}

	@Override
	public boolean equals(Object o) {
		AndroidPK pk = (AndroidPK) o;
		return pk.historyDate.equals(this.historyDate) && pk.vehicleId.equals(this.vehicleId);
	}	
}
