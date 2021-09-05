package com.commons.main.models;

import org.springframework.data.annotation.Id;

public class MatchLogHistory {

	@Id
	private String conversationId;
	private String matchTime;
	private String pickupTime;
	private String completionTime;
	private String tripTimeTaken;
	private String driverId;
	private String riderId;
	private String transportMode; // 1=BODA, 2=ECONOMY, 3=EXECUTIVE
	private int status;
	private int completedByRider;
	private int completedByDriver;
	private double pickupDistance;
	private double destinationDistance;
	private double tripAmount;
	private double sLat;
	private double sLon;
	private double dLat;
	private double dLon;
	private String pickUpLocation;
	private String dropOffLocation;

	public MatchLogHistory() {
	}

	public String getConversationId() {
		return conversationId;
	}

	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}

	public String getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(String matchTime) {
		this.matchTime = matchTime;
	}

	public String getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(String pickupTime) {
		this.pickupTime = pickupTime;
	}

	public String getCompletionTime() {
		return completionTime;
	}

	public void setCompletionTime(String completionTime) {
		this.completionTime = completionTime;
	}

	public String getTripTimeTaken() {
		return tripTimeTaken;
	}

	public void setTripTimeTaken(String tripTimeTaken) {
		this.tripTimeTaken = tripTimeTaken;
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

	public String getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getCompletedByRider() {
		return completedByRider;
	}

	public void setCompletedByRider(int completedByRider) {
		this.completedByRider = completedByRider;
	}

	public int getCompletedByDriver() {
		return completedByDriver;
	}

	public void setCompletedByDriver(int completedByDriver) {
		this.completedByDriver = completedByDriver;
	}

	public double getPickupDistance() {
		return pickupDistance;
	}

	public void setPickupDistance(double pickupDistance) {
		this.pickupDistance = pickupDistance;
	}

	public double getDestinationDistance() {
		return destinationDistance;
	}

	public void setDestinationDistance(double destinationDistance) {
		this.destinationDistance = destinationDistance;
	}

	public double getTripAmount() {
		return tripAmount;
	}

	public void setTripAmount(double tripAmount) {
		this.tripAmount = tripAmount;
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

	public double getdLat() {
		return dLat;
	}

	public void setdLat(double dLat) {
		this.dLat = dLat;
	}

	public double getdLon() {
		return dLon;
	}

	public void setdLon(double dLon) {
		this.dLon = dLon;
	}

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public String getDropOffLocation() {
		return dropOffLocation;
	}

	public void setDropOffLocation(String dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}
	
	
}
