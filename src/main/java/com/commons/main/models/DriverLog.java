package com.commons.main.models;

import org.springframework.data.annotation.Id;

/**
*
* @author Basil
*/
public class DriverLog {
	
	@Id
	public String driverId;
	public String transactionTime;
	public double slat;
	public double slon;	
	public double dlat;
	public double dlon;	
	public int inTrip; 
	public int inMatching;
	public String noOfSeats;
	public String transportMode; //1=Boda , 2=Economy, 3=Premium
	public String estimatedDistance;
	public double estimatedPrice;
	private String pickUpLocation;
	private String dropOffLocation;
	
	public DriverLog(){}

	/*
	public DriverLog(String driverId,String transactionTime, double slat, double slon, double dlat, double dlon ,int inMatching, int inTrip, String noOfSeats,String transportMode, String estimatedDistance, double estimatedPrice) {
		super();
		this.driverId = driverId;
		this.transactionTime = transactionTime;
		this.slat = slat;
		this.slon = slon;
		this.dlat = dlat;
		this.dlon = dlon;
		this.inMatching = inMatching;
		this.inTrip = inTrip;
		this.noOfSeats = noOfSeats;
		this.transportMode = transportMode;
		this.estimatedDistance = estimatedDistance;
		this.estimatedPrice = estimatedPrice;
		
	}*/

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
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

	public String getEstimatedDistance() {
		return estimatedDistance;
	}

	public void setEstimatedDistance(String estimatedDistance) {
		this.estimatedDistance = estimatedDistance;
	}

	public double getEstimatedPrice() {
		return estimatedPrice;
	}

	public void setEstimatedPrice(double estimatedPrice) {
		this.estimatedPrice = estimatedPrice;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
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
