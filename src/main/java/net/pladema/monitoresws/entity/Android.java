package net.pladema.monitoresws.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "androids")
public class Android {

	@EmbeddedId
	private AndroidPK id;
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
		this.id = new AndroidPK(vehicleId, historyDate);
	}

	public AndroidPK getId() {
		return id;
	}

	public void setId(AndroidPK id) {
		this.id = id;
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
