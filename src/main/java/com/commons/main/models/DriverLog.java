package com.commons.main.models;

import org.springframework.data.annotation.Id;

/**
 *
 * @author Basil
 */
public class DriverLog {

	@Id
	private String driverId;
	private String driverName;
	private String driverPhoneNumber;
	private String transactionTime;
	private String messageId;
	private String noOfSeats;
	private String transportMode; // 1=Boda , 2=Economy, 3=Premium
	private String transportType; // 1=Boda , 2=Economy, 3=Premium
	private String vehicleNumberPlate;
	private String vehicleColor;
	private String vehicleModel;
	private String estimatedTime;
	private String estimatedDistance;
	private String estimatedPrice;
	private String pickUpLocation;
	private String dropOffLocation;
	private double slat;
	private double slon;
	private double dlat;
	private double dlon;
	private int inTrip;
	private int inMatching;
	
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
	public String getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(String noOfSeats) {
		this.noOfSeats = noOfSeats;
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
	public double getSlat() {
		return slat;
	}
	public void setSlat(double slat) {
		this.slat = slat;
	}
	public double getSlon() {
		return slon;
	}
	public void setSlon(double slon) {
		this.slon = slon;
	}
	public double getDlat() {
		return dlat;
	}
	public void setDlat(double dlat) {
		this.dlat = dlat;
	}
	public double getDlon() {
		return dlon;
	}
	public void setDlon(double dlon) {
		this.dlon = dlon;
	}
	public int getInTrip() {
		return inTrip;
	}
	public void setInTrip(int inTrip) {
		this.inTrip = inTrip;
	}
	public int getInMatching() {
		return inMatching;
	}
	public void setInMatching(int inMatching) {
		this.inMatching = inMatching;
	}
}
