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

import com.commons.main.models.LocationRiderBroadcasts;
import com.commons.main.service.LocationRiderBroadcastsService;
import com.commons.main.utils.Properties;

@RestController
public class LocationRiderBroadcastsController {

	@Autowired
    private LocationRiderBroadcastsService locationRiderBroadcastsService;
	
	@Autowired
	private Properties customProperties;
	
	private static final Logger log = LoggerFactory.getLogger(LocationRiderBroadcastsController.class);
	
   @PostMapping("api/v2/riders/current/locations")
    public ResponseEntity < LocationRiderBroadcasts > createLocationRiderBroadcasts(@RequestHeader Map<String, String> headers, @RequestBody LocationRiderBroadcasts locationRiderBroadcasts) {
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
	       return ResponseEntity.ok().body(this.locationRiderBroadcastsService.createLocationRiderBroadcasts(locationRiderBroadcasts));
	   	}
    }
	
   @GetMapping("api/v2/riders/current/locations")
   public ResponseEntity < List < LocationRiderBroadcasts >> getAllLocationDriverBroadcasts(@RequestHeader Map<String, String> headers) {
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
	   		return ResponseEntity.ok().body(locationRiderBroadcastsService.getAllLocationRiderBroadcasts());
	   	}
   }

   @GetMapping("api/v2/riders/current/locations/{id}")
   public ResponseEntity < LocationRiderBroadcasts > getLocationDriverBroadcastsByDriverId(@RequestHeader Map<String, String> headers, @PathVariable String id) {
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
	   		return ResponseEntity.ok().body(locationRiderBroadcastsService.getLocationRiderBroadcastsByRiderId(id));
	   	}
   }
   
}
