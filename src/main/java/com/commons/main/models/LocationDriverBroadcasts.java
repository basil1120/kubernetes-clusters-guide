package com.commons.main.models;

import org.springframework.data.annotation.Id;

public class LocationDriverBroadcasts {

	@Id
	private String id;
	private String status;
	private String transportType;
	private String broadcastTime;
	private double sLat;
	private double sLon;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public String getBroadcastTime() {
		return broadcastTime;
	}

	public void setBroadcastTime(String broadcastTime) {
		this.broadcastTime = broadcastTime;
	}

	public double getsLat() {
		return sLat;
	}

	public void setsLat(double sLat) {
		this.sLat = sLat;
	}

	public double getsLon() {
		return sLon;
	}

	public void setsLon(double sLon) {
		this.sLon = sLon;
	}
}
