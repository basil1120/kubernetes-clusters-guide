package com.commons.main.models;

import org.springframework.data.annotation.Id;

public class MatchLogDriver {

	
	@Id
	private String driverId;
	private String driverName;
	private String driverPhoneNumber;
	private String riderId;
	private String riderName;
	private String riderPhoneNumber;
	private String messageId;
	private String conversationId;
	private String matchTime;
	private String transportMode; // 1=BODA, 2=ECONOMY, 3=EXECUTIVE
	private String transportType; // 1=BODA, 2=ECONOMY, 3=EXECUTIVE
	private String paymentMode;
	private String vehicleNumberPlate;
	private String estimatedTime;
	private String estimatedDistance;
	private String estimatedPrice;
	private String vehicleColor;
	private String vehicleModel;
	private String pickUpLocation;
	private String dropOffLocation;
	private double sourceDistance;
	private double riderSourceLat;
	private double riderSourceLon;
	private double riderDestinationLat;
	private double riderDestinationLon;
	private int rideraccepted;
	private int driveraccepted;
	private int inTrip;
	private int isPooled;
	
	
	public String getDriverId() {
		return driverId;
	}
	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getDriverPhoneNumber() {
		return driverPhoneNumber;
	}
	public void setDriverPhoneNumber(String driverPhoneNumber) {
		this.driverPhoneNumber = driverPhoneNumber;
	}
	public String getRiderId() {
		return riderId;
	}
	public void setRiderId(String riderId) {
		this.riderId = riderId;
	}
	public String getRiderName() {
		return riderName;
	}
	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}
	public String getRiderPhoneNumber() {
		return riderPhoneNumber;
	}
	public void setRiderPhoneNumber(String riderPhoneNumber) {
		this.riderPhoneNumber = riderPhoneNumber;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
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
	public String getTransportType() {
		return transportType;
	}
	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}
	public String getVehicleNumberPlate() {
		return vehicleNumberPlate;
	}
	public void setVehicleNumberPlate(String vehicleNumberPlate) {
		this.vehicleNumberPlate = vehicleNumberPlate;
	}
	public String getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	public String getEstimatedDistance() {
		return estimatedDistance;
	}
	public void setEstimatedDistance(String estimatedDistance) {
		this.estimatedDistance = estimatedDistance;
	}
	public String getEstimatedPrice() {
		return estimatedPrice;
	}
	public void setEstimatedPrice(String estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}
	public String getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
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
	public double getSourceDistance() {
		return sourceDistance;
	}
	public void setSourceDistance(double sourceDistance) {
		this.sourceDistance = sourceDistance;
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
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
}
