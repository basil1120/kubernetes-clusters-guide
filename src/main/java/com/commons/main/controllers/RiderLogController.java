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

import com.commons.main.models.RiderLog;
import com.commons.main.service.RiderLogService;
import com.commons.main.utils.Properties;

@RestController
public class RiderLogController {
	
	@Autowired
    private RiderLogService riderLogService;
	
	@Autowired
	private Properties customProperties;
	
	private static final Logger log = LoggerFactory.getLogger(RiderLogController.class);

    @GetMapping("api/v2/riders")
    public ResponseEntity < List < RiderLog >> getAllRiderLog(@RequestHeader Map<String, String> headers) {
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
	        return ResponseEntity.ok().body(riderLogService.getAllRiderLog());
    	}
    }

    @GetMapping("api/v2/riders/{id}")
    public ResponseEntity < RiderLog > getRiderById(@RequestHeader Map<String, String> headers, @PathVariable String id) {
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
	        return ResponseEntity.ok().body(riderLogService.getRiderById(id));
    	}
    }

    @PostMapping("api/v2/riders")
    public ResponseEntity < RiderLog > createRiderLog(@RequestHeader Map<String, String> headers, @RequestBody RiderLog riderLog) {
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
    		return ResponseEntity.ok().body(this.riderLogService.createRiderLog(riderLog));
    	}
    }
    
    @PutMapping("api/v2/riders/{id}")
    public ResponseEntity < RiderLog > updateRiderLog(@RequestHeader Map<String, String> headers, @PathVariable String id, @RequestBody RiderLog riderLog) {
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
	    	riderLog.setRiderId(id);
	        return ResponseEntity.ok().body(this.riderLogService.updateRiderLog(riderLog));
    	}
    }

    @DeleteMapping("api/v2/riders/delete/{id}")
    public ResponseEntity<?> deleteRider(@RequestHeader Map<String, String> headers, @PathVariable String id) {
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
	        this.riderLogService.deleteRider(id);
	        return ResponseEntity.status(200).body(null);
    	}
    }

}
