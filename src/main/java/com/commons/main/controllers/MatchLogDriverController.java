package com.commons.main.controllers;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.commons.main.models.MatchLogDriver;
import com.commons.main.service.MatchLogDriverService;
import com.commons.main.utils.Properties;


@RestController
public class MatchLogDriverController {

	  @Autowired
	  private MatchLogDriverService driverImpl;
	  
	  @Autowired
	  private Properties customProperties;
	  
	  private static final Logger log = LoggerFactory.getLogger(MatchLogDriverController.class);
	  
	  @GetMapping("api/v2/driver/match/{id}")
	  public ResponseEntity<MatchLogDriver> getUser(@RequestHeader Map<String, String> headers, @PathVariable(value="id") String id) throws Exception {
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
			  MatchLogDriver user = driverImpl.getUser(id);
			  if(user == null) {
				  return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
			  }else {
				  return new ResponseEntity<>(user, HttpStatus.OK);
			  }
	    	}
	  }
	  
	  @GetMapping("api/v2/driver/match/accept/{id}")
	  public ResponseEntity<MatchLogDriver> acceptRider(@RequestHeader Map<String, String> headers, @PathVariable(value="id") String id) throws Exception {
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
			  MatchLogDriver user = driverImpl.acceptRiderRquest(id);
			  if(user == null) {
				  return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
			  }else {
				  return new ResponseEntity<>(user, HttpStatus.OK);
			  }
	    	}
	  }
	  
	  @GetMapping("api/v2/driver/match/reject/{id}")
	  public ResponseEntity<MatchLogDriver> rejectRider(@RequestHeader Map<String, String> headers, @PathVariable(value="id") String id) throws Exception {
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
			  MatchLogDriver user = driverImpl.rejectRiderRquest(id);
			  if(user == null) {
				  return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
			  }else {
				  return new ResponseEntity<>(user, HttpStatus.OK);
			  }
	    	}
	  }
	  
	  @GetMapping("api/v2/driver/match/pickup/{id}")
	  public ResponseEntity<MatchLogDriver> inPickupRider(@RequestHeader Map<String, String> headers, @PathVariable(value="id") String id) throws Exception {
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
			  MatchLogDriver user = driverImpl.pickingUpCustomer(id);
			  if(user == null) {
				  return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
			  }else {
				  return new ResponseEntity<>(user, HttpStatus.OK);
			  }
	    	}
	  }
	  
	  @GetMapping("api/v2/driver/match/intrip/{id}")
	  public ResponseEntity<MatchLogDriver> inTripRider(@RequestHeader Map<String, String> headers, @PathVariable(value="id") String id) throws Exception {
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
			  MatchLogDriver user = driverImpl.drivingCustomer(id);
			  if(user == null) {
				  return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
			  }else {
				  return new ResponseEntity<>(user, HttpStatus.OK);
			  }
	    	}
	  }
	  
	  @GetMapping("api/v2/driver/match/endtrip/{id}")
	  public ResponseEntity<MatchLogDriver> endTrip(@RequestHeader Map<String, String> headers, @PathVariable(value="id") String id) throws Exception {
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
			  MatchLogDriver user = driverImpl.endTripRquest(id);
			  if(user == null) {
				  return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
			  }else {
				  return new ResponseEntity<>(user, HttpStatus.OK);
			  }
	    	}
	  }
	  
}
