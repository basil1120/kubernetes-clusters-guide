package com.commons.main.models;



public class CancellationLog {
	
	private String conversationId;
	private String cancellationTime;
	private String cancelledByUser;
	private String cancelledByDriver;
	private String cancellationCode;
	private String cancellationCodeDescription;
	
	public CancellationLog() {}

	public String getConversationId() {
		return conversationId;
	}

	public void setConversationId(String conversationId) {
		this.conversationId = conversationId;
	}

	public String getCancellationTime() {
		return cancellationTime;
	}

	public void setCancellationTime(String cancellationTime) {
		this.cancellationTime = cancellationTime;
	}

	public String getCancelledByUser() {
		return cancelledByUser;
	}

	public void setCancelledByUser(String cancelledByUser) {
		this.cancelledByUser = cancelledByUser;
	}

	public String getCancelledByDriver() {
		return cancelledByDriver;
	}

	public void setCancelledByDriver(String cancelledByDriver) {
		this.cancelledByDriver = cancelledByDriver;
	}

	public String getCancellationCode() {
		return cancellationCode;
	}

	public void setCancellationCode(String cancellationCode) {
		this.cancellationCode = cancellationCode;
	}

	public String getCancellationCodeDescription() {
		return cancellationCodeDescription;
	}

	public void setCancellationCodeDescription(String cancellationCodeDescription) {
		this.cancellationCodeDescription = cancellationCodeDescription;
	}
}
