package com.commons.main.models;

import org.springframework.data.annotation.Id;

public class TripStatus {
	
	@Id
	private String conversationId;
	private String driverId;
	private String riderId;
	private String driverStatus;
	private String riderStatus;
	private String tripStatus; //NEW, PICKING, ARRIVED, STARTED, COMPLETED
	
	public String getConversationId() {
		return conversationId;
	}
	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getRiderId() {
		return riderId;
	}
	public void setRiderId(String riderId) {
		this.riderId = riderId;
	}
	public String getDriverStatus() {
		return driverStatus;
	}
	public void setDriverStatus(String driverStatus) {
		this.driverStatus = driverStatus;
	}
	public String getRiderStatus() {
		return riderStatus;
	}
	public void setRiderStatus(String riderStatus) {
		this.riderStatus = riderStatus;
	}
	public String getTripStatus() {
		return tripStatus;
	}
	public void setTripStatus(String tripStatus) {
		this.tripStatus = tripStatus;
	}
}
