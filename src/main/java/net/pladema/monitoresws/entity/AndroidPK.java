package net.pladema.monitoresws.entity;

import java.io.Serializable;

public class AndroidPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1653666867972540813L;
	protected String vehicleId;
	protected String historyDate;

	public AndroidPK() {
	}
	
	public AndroidPK(String vehicleId, String historyDate) {
		super();
		this.vehicleId = vehicleId;
		this.historyDate = historyDate;
	}

	@Override
	public boolean equals(Object o) {
		AndroidPK pk = (AndroidPK) o;
		return pk.historyDate.equals(this.historyDate) && pk.vehicleId.equals(this.vehicleId);
	}

}
