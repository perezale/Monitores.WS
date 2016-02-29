package net.pladema.monitoresws.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Frame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int id_scanner;
	private Calendar timestamp;
	private String source_mac;
	private String destination_mac;
	private int signal;
	private String frame_type;
	private String source_device_type;
	private String protocol;
	private String ssid;

	public Frame() {
	}

	public Frame(int id_scanner, Calendar ts, String src_mac, String dest_mac, int si, String f_type,
			String src_device_type, String prot, String ss) {
		this.id_scanner = id_scanner;
		this.timestamp = ts;
		this.source_mac = src_mac;
		this.destination_mac = dest_mac;
		this.signal = si;
		this.frame_type = f_type;
		this.source_device_type = src_device_type;
		this.protocol = prot;
		this.ssid = ss;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getId_scanner() {
		return id_scanner;
	}

	public void setId_scanner(int id_scanner) {
		this.id_scanner = id_scanner;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
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

	public String getFrame_type() {
		return frame_type;
	}

	public void setFrame_type(String frame_type) {
		this.frame_type = frame_type;
	}

	public String getSource_device_type() {
		return source_device_type;
	}

	public void setSource_device_type(String source_device_type) {
		this.source_device_type = source_device_type;
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

}
