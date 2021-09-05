package com.commons.main.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.commons.main.models.DriverLog;
import com.commons.main.service.DriverLogService;
import com.commons.main.utils.Properties;

@RestController
public class DriverLogController {

	@Autowired
    private DriverLogService driverLogService;
	
	@Autowired
	private Properties customProperties;
	
	private static final Logger log = LoggerFactory.getLogger(DriverLogController.class);

    @GetMapping("api/v2/drivers")
    public ResponseEntity < List < DriverLog >> getAllDriverLog(@RequestHeader Map<String, String> headers) {
	   	log.debug("Header values: {}", headers);
	   	if(headers.get("api_secrete") == null || headers.get("api_version") == null || headers.get("api_deviceid") == null) {
	   		log.info("-----ValidationError : 412 Precondition failed");
	   		return ResponseEntity.status(412).body(null);
	   	}else if(!headers.get("api_secrete").equals(customProperties.getApiSecrete())) {
	   		log.info("-----ValidationError : 401 Unauthorised");
	   		return ResponseEntity.status(401).body(null);
	   	}else if(!headers.get("api_version").equals(customProperties.getApiVersion())) {
	   		log.info("-----ValidationError : 403 Forbidden");
	   		return ResponseEntity.status(403).body(null);
	   	}else {
	   		return ResponseEntity.ok().body(driverLogService.getAllDriverLog());
	   	}
    }

    @GetMapping("api/v2/drivers/{id}")
    public ResponseEntity < DriverLog > getDriverById(@RequestHeader Map<String, String> headers, @PathVariable String id) {
	   	log.debug("Header values: {}", headers);
	   	if(headers.get("api_secrete") == null || headers.get("api_version") == null || headers.get("api_deviceid") == null) {
	   		log.info("-----ValidationError : 412 Precondition failed");
	   		return ResponseEntity.status(412).body(null);
	   	}else if(!headers.get("api_secrete").equals(customProperties.getApiSecrete())) {
	   		log.info("-----ValidationError : 401 Unauthorised");
	   		return ResponseEntity.status(401).body(null);
	   	}else if(!headers.get("api_version").equals(customProperties.getApiVersion())) {
	   		log.info("-----ValidationError : 403 Forbidden");
	   		return ResponseEntity.status(403).body(null);
	   	}else {
	   		return ResponseEntity.ok().body(driverLogService.getDriverById(id));
	   	}
    }

    @PostMapping("api/v2/drivers")
    public ResponseEntity < DriverLog > createDriverLog(@RequestHeader Map<String, String> headers, @RequestBody DriverLog driverLog) {
	   	log.debug("Header values: {}", headers);
	   	if(headers.get("api_secrete") == null || headers.get("api_version") == null || headers.get("api_deviceid") == null) {
	   		log.info("-----ValidationError : 412 Precondition failed");
	   		return ResponseEntity.status(412).body(null);
	   	}else if(!headers.get("api_secrete").equals(customProperties.getApiSecrete())) {
	   		log.info("-----ValidationError : 401 Unauthorised");
	   		return ResponseEntity.status(401).body(null);
	   	}else if(!headers.get("api_version").equals(customProperties.getApiVersion())) {
	   		log.info("-----ValidationError : 403 Forbidden");
	   		return ResponseEntity.status(403).body(null);
	   	}else {
	   		return ResponseEntity.ok().body(this.driverLogService.createDriverLog(driverLog));
	   	}
    }

    @PutMapping("api/v2/drivers/{id}")
    public ResponseEntity < DriverLog > updateDriverLog(@RequestHeader Map<String, String> headers, @PathVariable String id, @RequestBody DriverLog driverLog) {
	   	log.debug("Header values: {}", headers);
	   	if(headers.get("api_secrete") == null || headers.get("api_version") == null || headers.get("api_deviceid") == null) {
	   		log.info("-----ValidationError : 412 Precondition failed");
	   		return ResponseEntity.status(412).body(null);
	   	}else if(!headers.get("api_secrete").equals(customProperties.getApiSecrete())) {
	   		log.info("-----ValidationError : 401 Unauthorised");
	   		return ResponseEntity.status(401).body(null);
	   	}else if(!headers.get("api_version").equals(customProperties.getApiVersion())) {
	   		log.info("-----ValidationError : 403 Forbidden");
	   		return ResponseEntity.status(403).body(null);
	   	}else {
	   		driverLog.setDriverId(id);
	   		return ResponseEntity.ok().body(this.driverLogService.updateDriverLog(driverLog));
	   	}
    }

    @DeleteMapping("api/v2/drivers/delete/{id}")
    public ResponseEntity<?> deleteDriver(@RequestHeader Map<String, String> headers, @PathVariable String id) {
	   	log.debug("Header values: {}", headers);
	   	if(headers.get("api_secrete") == null || headers.get("api_version") == null || headers.get("api_deviceid") == null) {
	   		log.info("-----ValidationError : 412 Precondition failed");
	   		return ResponseEntity.status(412).body(null);
	   	}else if(!headers.get("api_secrete").equals(customProperties.getApiSecrete())) {
	   		log.info("-----ValidationError : 401 Unauthorised");
	   		return ResponseEntity.status(401).body(null);
	   	}else if(!headers.get("api_version").equals(customProperties.getApiVersion())) {
	   		log.info("-----ValidationError : 403 Forbidden");
	   		return ResponseEntity.status(403).body(null);
	   	}else {
	        this.driverLogService.deleteDriver(id);
	        return ResponseEntity.status(200).body(null);
	   	}
    }
	
}
