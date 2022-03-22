package com.commons.main.models;

import org.springframework.data.annotation.Id;

/**
*
* @author Basil
*/
public class RiderLog {
	
	@Id
	private String riderId;
	private String riderName;
	private String riderPhoneNumber;
	private String transactionTime;
	private String messageId;
	private String transportMode; //1=Boda , 2=Economy, 3=Premium
	private String transportType; //1=Boda , 2=Economy, 3=Premium
	private String paymentMode;
	private String estimatedTime;
	private String estimatedDistance;
	private String estimatedPrice;
	private String pickUpLocation;
	private String dropOffLocation;
	private double slat;
	private double slon;	
	private double dlat;
	private double dlon;
	private int inMatching;
	private int inTrip;
	
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
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
}
