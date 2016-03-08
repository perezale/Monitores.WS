package net.pladema.monitoresws.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "androids")
@IdClass(AndroidPK.class)
public class Android {

	@Id	
	@Column(name = "history_date")
	private String historyDate;
	@Id
	@Column(name = "id_vehicle")
	private String vehicleId;
	@Column(name = "latitud")
	private Double lat;
	@Column(name = "longitud")
	private Double lon;
	private Double speed;
	private Double accuracy;
	private Double bearing;

	public Android() {
	}

	/**
	 * @param historyDate
	 * @param vehicleId
	 * @param lat
	 * @param lon
	 * @param speed
	 * @param accuracy
	 * @param bearing
	 */
	public Android(String historyDate, String vehicleId, Double lat, Double lon, Double speed, Double accuracy,
			Double bearing) {
		super();
		this.historyDate = historyDate;
		this.vehicleId = vehicleId;
		this.lat = lat;
		this.lon = lon;
		this.speed = speed;
		this.accuracy = accuracy;
		this.bearing = bearing;
	}

	public String getHistoryDate() {
		return historyDate;
	}

	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
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

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}

	public Double getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Double accuracy) {
		this.accuracy = accuracy;
	}

	public Double getBearing() {
		return bearing;
	}

	public void setBearing(Double bearing) {
		this.bearing = bearing;
	}

}
