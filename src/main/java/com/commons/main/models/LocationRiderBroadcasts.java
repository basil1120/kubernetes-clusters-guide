package com.commons.main.models;

import org.springframework.data.annotation.Id;

public class LocationRiderBroadcasts {

	@Id
	private String id;
	private String broadcastTime;
	private int isOnline;
	private double currentSourceLat;
	private double currentSourceLon;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBroadcastTime() {
		return broadcastTime;
	}

	public void setBroadcastTime(String broadcastTime) {
		this.broadcastTime = broadcastTime;
	}

	public int getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(int isOnline) {
		this.isOnline = isOnline;
	}

	public double getCurrentSourceLat() {
		return currentSourceLat;
	}

	public void setCurrentSourceLat(double currentSourceLat) {
		this.currentSourceLat = currentSourceLat;
	}

	public double getCurrentSourceLon() {
		return currentSourceLon;
	}

	public void setCurrentSourceLon(double currentSourceLon) {
		this.currentSourceLon = currentSourceLon;
	}
}
