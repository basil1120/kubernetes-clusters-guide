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

import com.commons.main.models.MatchLogRider;
import com.commons.main.service.MatchLogRiderService;
import com.commons.main.utils.Properties;

@RestController
public class MatchLogRiderController {
	  
	  @Autowired
	  private MatchLogRiderService matchLogRiderImpl;
	  
	  @Autowired
	  private Properties customProperties;
		
	  private static final Logger log = LoggerFactory.getLogger(MatchLogRiderController.class);
	  
	  @GetMapping("api/v2/rider/match/{id}")
	  public ResponseEntity<MatchLogRider> getUser(@RequestHeader Map<String, String> headers, @PathVariable(value="id") String id) throws Exception {
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
			    MatchLogRider user = matchLogRiderImpl.getUser(id);
		        return new ResponseEntity<>(user, HttpStatus.OK);
	    	}
	  }
	  
	  @GetMapping("api/v2/rider/match/accept/{id}")
	  public ResponseEntity<MatchLogRider> acceptDriver(@RequestHeader Map<String, String> headers, @PathVariable(value="id") String id) throws Exception {
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
			  MatchLogRider user = matchLogRiderImpl.acceptDriverRquest(id);
		      return new ResponseEntity<>(user, HttpStatus.OK);
	    	}
	  }
	  
	  @GetMapping("api/v2/rider/match/reject/{id}")
	  public ResponseEntity<MatchLogRider> rejectDriver(@RequestHeader Map<String, String> headers, @PathVariable(value="id") String id) throws Exception {
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
			  MatchLogRider user = matchLogRiderImpl.rejectDriverRquest(id);
		      return new ResponseEntity<>(user, HttpStatus.OK);
	    	}
	  }
	  
}
