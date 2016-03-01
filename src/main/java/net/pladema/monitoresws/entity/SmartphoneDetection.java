package net.pladema.monitoresws.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONString;

@Entity
@Table(name="smartphonedetection")
@IdClass(SmartphoneDetectionPK.class)
public class SmartphoneDetection implements JSONString {

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar timestamp;

	@Id
	private String source_mac;
	private String destination_mac;
	private int signal;
	private String protocol;
	private String ssid;
	private Double lat;
	private Double lon;

	public SmartphoneDetection() {
	}

	public SmartphoneDetection(Calendar ts, String src_mac, String dest_mac, int si, String prot, String ss, double lat,
			double lon) {
		this.timestamp = ts;
		this.source_mac = src_mac;
		this.destination_mac = dest_mac;
		this.signal = si;
		this.protocol = prot;
		this.ssid = ss;
		this.lat = lat;
		this.lon = lon;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public String getSource_mac() {
		return source_mac;
	}

	public void setSource_mac(String source_mac) {
		this.source_mac = source_mac;
	}

	public String getDestination_mac() {
		return destination_mac;
	}

	public void setDestination_mac(String destination_mac) {
		this.destination_mac = destination_mac;
	}

	public int getSignal() {
		return signal;
	}

	public void setSignal(int signal) {
		this.signal = signal;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	@Override
	public String toJSONString() {
		JSONArray arr = new JSONArray();
		arr.put(lon);
		arr.put(lat);
		return arr.toString();
	}

}
