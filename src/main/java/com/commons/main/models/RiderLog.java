package com.commons.main.models;

import org.springframework.data.annotation.Id;

/**
*
* @author Basil
*/
public class RiderLog {
	
	@Id
	public String riderId;	
	public String transactionTime;
	public double slat;
	public double slon;	
	public double dlat;
	public double dlon;	 
	public int inMatching;
	public int inTrip;
	public String transportMode; //1=Boda , 2=Economy, 3=Premium
	public String estimatedDistance;
	public double estimatedPrice;
	private String pickUpLocation;
	private String dropOffLocation;
	
	public String getRiderId() {
		return riderId;
	}

	public void setRiderId(String riderId) {
		this.riderId = riderId;
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

	public int getInMatching() {
		return inMatching;
	}

	public void setInMatching(int inMatching) {
		this.inMatching = inMatching;
	}

	public int getInTrip() {
		return inTrip;
	}

	public void setInTrip(int inTrip) {
		this.inTrip = inTrip;
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
