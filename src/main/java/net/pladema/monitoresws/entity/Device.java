package net.pladema.monitoresws.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Device {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int id_scanner;
	private Calendar timestamp;
	private String mac;
	private int signal;
	private String source_device_type;
	private String protocol;

	public Device() {
	}

	public Device(int id_scanner, Calendar timestamp, String mac, int signal, String src_device_type, String protocol) {

		this.id_scanner = id_scanner;
		this.timestamp = timestamp;
		this.mac = mac;
		this.signal = signal;
		this.source_device_type = src_device_type;
		this.protocol = protocol;
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

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public int getSignal() {
		return signal;
	}

	public void setSignal(int signal) {
		this.signal = signal;
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

}