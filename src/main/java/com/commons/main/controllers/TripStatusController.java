package com.commons.main.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.commons.main.models.TripStatus;
import com.commons.main.utils.Properties;

@RestController
public class TripStatusController {
	
	private static Logger log = LoggerFactory.getLogger(TripStatusController.class);
	
	@Autowired
	private Properties customProperties;
	
    @PostMapping("api/v2/trip-status")
    public ResponseEntity < TripStatus > updateTripStatus(@RequestHeader Map<String, String> headers, @RequestBody TripStatus tripStatus) {
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
    		//return ResponseEntity.ok().body(this.riderLogService.createRiderLog(riderLog));
    		return ResponseEntity.ok().body(null);
    	}
    }

}
