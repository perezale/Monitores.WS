package net.pladema.monitoresws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "androids")
public class Android {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	@Column(name = "id_vehicle")
	protected String vehicleId;
	@Column(name = "history_date")
	protected String historyDate;
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
		this.lat = lat;
		this.lon = lon;
		this.speed = speed;
		this.accuracy = accuracy;
		this.bearing = bearing;
		this.vehicleId = vehicleId;
		this.historyDate = historyDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
