package com.commons.main.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.commons.main.models.LocationDriverBroadcasts;
import com.commons.main.service.LocationDriverBroadcastsService;
import com.commons.main.utils.Properties;

@RestController
public class LocationDriverBroadcastsController {
	
	private static final Logger log = LoggerFactory.getLogger(LocationDriverBroadcastsController.class);
	
	@Autowired
	private LocationDriverBroadcastsService locationDriverBroadcastsService;
	
	@Autowired
	private Properties properties;
	
    @PostMapping("api/v2/drivers/current/locations")
    public ResponseEntity < LocationDriverBroadcasts > createLocationDriverBroadcasts(@RequestHeader Map<String, String> headers, @RequestBody LocationDriverBroadcasts locationDriverBroadcasts) {
	   	log.debug("Header values: {}", headers);
	   	if(headers.get("api_secrete") == null || headers.get("api_version") == null || headers.get("api_deviceid") == null) {
	   		log.info("-----ValidationError : 412 Precondition failed");
	   		return ResponseEntity.status(412).body(null);
	   	}else if(!headers.get("api_secrete").equals(properties.getApiSecrete())) {
	   		log.info("-----ValidationError : 401 Unauthorised");
	   		return ResponseEntity.status(401).body(null);
	   	}else if(!headers.get("api_version").equals(properties.getApiVersion())) {
	   		log.info("-----ValidationError : 403 Forbidden");
	   		return ResponseEntity.status(403).body(null);
	   	}else {
	   		return ResponseEntity.ok().body(this.locationDriverBroadcastsService.createLocationDriverBroadcasts(locationDriverBroadcasts));
	   	}
    }
    
    @GetMapping("api/v2/drivers/current/locations")
    public ResponseEntity < List < LocationDriverBroadcasts >> getAllLocationDriverBroadcasts(@RequestHeader Map<String, String> headers) {
	   	log.debug("Header values: {}", headers);
	   	if(headers.get("api_secrete") == null || headers.get("api_version") == null || headers.get("api_deviceid") == null) {
	   		log.info("-----ValidationError : 412 Precondition failed");
	   		return ResponseEntity.status(412).body(null);
	   	}else if(!headers.get("api_secrete").equals(properties.getApiSecrete())) {
	   		log.info("-----ValidationError : 401 Unauthorised");
	   		return ResponseEntity.status(401).body(null);
	   	}else if(!headers.get("api_version").equals(properties.getApiVersion())) {
	   		log.info("-----ValidationError : 403 Forbidden");
	   		return ResponseEntity.status(403).body(null);
	   	}else {
	   		return ResponseEntity.ok().body(locationDriverBroadcastsService.getAllLocationDriverBroadcasts());
	   	}
    }

    @GetMapping("api/v2/drivers/current/locations/{id}")
    public ResponseEntity < LocationDriverBroadcasts > getLocationDriverBroadcastsByDriverId(@RequestHeader Map<String, String> headers, @PathVariable String id) throws Exception {
	   	log.debug("Header values: {}", headers);
	   	if(headers.get("api_secrete") == null || headers.get("api_version") == null || headers.get("api_deviceid") == null) {
	   		log.info("-----ValidationError : 412 Precondition failed");
	   		return ResponseEntity.status(412).body(null);
	   	}else if(!headers.get("api_secrete").equals(properties.getApiSecrete())) {
	   		log.info("-----ValidationError : 401 Unauthorised");
	   		return ResponseEntity.status(401).body(null);
	   	}else if(!headers.get("api_version").equals(properties.getApiVersion())) {
	   		log.info("-----ValidationError : 403 Forbidden");
	   		return ResponseEntity.status(403).body(null);
	   	}else {
	   		return ResponseEntity.ok().body(locationDriverBroadcastsService.getLocationDriverBroadcastsByDriverId(id));
	   	}
    }
	
}
