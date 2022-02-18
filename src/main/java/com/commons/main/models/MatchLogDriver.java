package com.commons.main.models;

import org.springframework.data.annotation.Id;

public class MatchLogDriver {

	@Id
	private String id;
	private String riderId;
	private String messageId;
	private String conversationId;
	private String matchTime;
	private String transportMode; // 1=BODA, 2=ECONOMY, 3=EXECUTIVE
	private int rideraccepted;
	private int driveraccepted;
	private int inTrip;
	private int isPooled;
	private double sourceDistance;
	private double destinationDistance;
	private double riderSourceLat;
	private double riderSourceLon;
	private double riderDestinationLat;
	private double riderDestinationLon;
	private String pickUpLocation;
	private String dropOffLocation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRiderId() {
		return riderId;
	}

	public void setRiderId(String riderId) {
		this.riderId = riderId;
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

	public String getTransportMode() {
		return transportMode;
	}

	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}

	public int getRideraccepted() {
		return rideraccepted;
	}

	public void setRideraccepted(int rideraccepted) {
		this.rideraccepted = rideraccepted;
	}

	public int getDriveraccepted() {
		return driveraccepted;
	}

	public void setDriveraccepted(int driveraccepted) {
		this.driveraccepted = driveraccepted;
	}

	public int getInTrip() {
		return inTrip;
	}

	public void setInTrip(int inTrip) {
		this.inTrip = inTrip;
	}

	public int getIsPooled() {
		return isPooled;
	}

	public void setIsPooled(int isPooled) {
		this.isPooled = isPooled;
	}

	public double getSourceDistance() {
		return sourceDistance;
	}

	public void setSourceDistance(double sourceDistance) {
		this.sourceDistance = sourceDistance;
	}

	public double getDestinationDistance() {
		return destinationDistance;
	}

	public void setDestinationDistance(double destinationDistance) {
		this.destinationDistance = destinationDistance;
	}

	public double getRiderSourceLat() {
		return riderSourceLat;
	}

	public void setRiderSourceLat(double riderSourceLat) {
		this.riderSourceLat = riderSourceLat;
	}

	public double getRiderSourceLon() {
		return riderSourceLon;
	}

	public void setRiderSourceLon(double riderSourceLon) {
		this.riderSourceLon = riderSourceLon;
	}

	public double getRiderDestinationLat() {
		return riderDestinationLat;
	}

	public void setRiderDestinationLat(double riderDestinationLat) {
		this.riderDestinationLat = riderDestinationLat;
	}

	public double getRiderDestinationLon() {
		return riderDestinationLon;
	}

	public void setRiderDestinationLon(double riderDestinationLon) {
		this.riderDestinationLon = riderDestinationLon;
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

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	
	
}
