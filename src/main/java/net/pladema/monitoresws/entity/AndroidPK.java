package net.pladema.monitoresws.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.persistence.Column;

public class AndroidPK implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 4610606377309800972L;
	@Column(name = "id_vehicle")
	protected String vehicleId;
	@Column(name = "history_date")
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
	
	public String toString(){
		try {
			String timePlusId = URLEncoder.encode(this.historyDate, "utf-8");
			timePlusId += "_"+this.vehicleId;
			return timePlusId;
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
