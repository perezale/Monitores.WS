package net.pladema.monitoresws.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONString;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tweet implements JSONString {

	@JsonIgnore
	@Id
	private String id;
	@JsonIgnore
	private String user_id;
	private Double lat;
	private Double lon;
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar timestamp;

	@JsonIgnore
	private Integer comuna;

	public Tweet() {
	}

	public Tweet(String id, String user_id, Double lat, Double lon) {
		this.id = id;
		this.user_id = user_id;
		this.lat = lat;
		this.lon = lon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getComuna() {
		return comuna;
	}

	public void setComuna(Integer comuna) {
		this.comuna = comuna;
	}

	@Override
	public String toJSONString() {
		JSONArray arr = new JSONArray();
		arr.put(lon);
		arr.put(lat);
		return arr.toString();
	}

}
