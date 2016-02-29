package net.pladema.monitoresws.entity;

import java.io.Serializable;
import java.util.Calendar;

public class SmartphoneDetectionPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1602602991966201206L;
	protected Calendar timestamp;
	protected String source_mac;

	public SmartphoneDetectionPK() {
	}

	public SmartphoneDetectionPK(Calendar timestamp, String source_mac) {
		this.timestamp = timestamp;
		this.source_mac = source_mac;
	}

	@Override
	public boolean equals(Object o) {
		SmartphoneDetectionPK pk = (SmartphoneDetectionPK) o;
		return pk.timestamp.equals(this.timestamp) && pk.source_mac.equals(this.source_mac);
	}

}
