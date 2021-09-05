package com.commons.main.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "api")
public class Properties {

	private String apiSecrete;
	private String apiVersion;
	private String apiDeviceid;
	private String apiUsername;
	private String apiPassword;

	public String getApiSecrete() {
		return apiSecrete;
	}

	public void setApiSecrete(String apiSecrete) {
		this.apiSecrete = apiSecrete;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getApiDeviceid() {
		return apiDeviceid;
	}

	public void setApiDeviceid(String apiDeviceid) {
		this.apiDeviceid = apiDeviceid;
	}

	public String getApiUsername() {
		return apiUsername;
	}

	public void setApiUsername(String apiUsername) {
		this.apiUsername = apiUsername;
	}

	public String getApiPassword() {
		return apiPassword;
	}

	public void setApiPassword(String apiPassword) {
		this.apiPassword = apiPassword;
	}
}
