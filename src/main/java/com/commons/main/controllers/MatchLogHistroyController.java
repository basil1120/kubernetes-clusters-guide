package com.commons.main.controllers;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.commons.main.models.MatchLogHistory;
import com.commons.main.service.MatchLogHistoryService;
import com.commons.main.utils.Properties;

@CrossOrigin("*")
@RestController
public class MatchLogHistroyController {
	  
	  @Autowired
	  private MatchLogHistoryService historyService;
	  
	  @Autowired
	  private Properties customProperties;
	  
	  private static final Logger logger = LoggerFactory.getLogger(MatchLogHistroyController.class);
	  
	  @GetMapping("/api/v1/match-history")
	  public ResponseEntity<?> getAllTripHistory(@RequestHeader Map<String, String> headers) throws Exception {
		  logger.debug("Header values: {}", headers);
	    	if(headers.get("api_secrete") == null || headers.get("api_version") == null || headers.get("api_deviceid") == null) {
	    		logger.info("-----ValidationError : 412 Precondition failed");
	    		return ResponseEntity.status(412).body(null);
	    	}else if(!headers.get("api_secrete").equals(customProperties.getApiSecrete())) {
	    		logger.info("-----ValidationError : 401 Unauthorised");
	    		return ResponseEntity.status(401).body(null);
	    	}else if(!headers.get("api_version").equals(customProperties.getApiVersion())) {
	    		logger.info("-----ValidationError : 403 Forbidden");
	    		return ResponseEntity.status(403).body(null);
	    	}else {
		      return new ResponseEntity<>(historyService.getMatchLogHistory(), HttpStatus.OK);
	    	}
	  }
	  
	  @GetMapping("/api/v1/match-history/rider/{riderId}")
	  public ResponseEntity<?> getTriHistoryByRiderId(@RequestHeader Map<String, String> headers, @PathVariable(value="riderId") String riderId) throws Exception {
		  logger.debug("Header values: {}", headers);
	    	if(headers.get("api_secrete") == null || headers.get("api_version") == null || headers.get("api_deviceid") == null) {
	    		logger.info("-----ValidationError : 412 Precondition failed");
	    		return ResponseEntity.status(412).body(null);
	    	}else if(!headers.get("api_secrete").equals(customProperties.getApiSecrete())) {
	    		logger.info("-----ValidationError : 401 Unauthorised");
	    		return ResponseEntity.status(401).body(null);
	    	}else if(!headers.get("api_version").equals(customProperties.getApiVersion())) {
	    		logger.info("-----ValidationError : 403 Forbidden");
	    		return ResponseEntity.status(403).body(null);
	    	}else {
			  List<MatchLogHistory> history = historyService.getMatchLogHistoryByRiderId(riderId);
			  if(history != null && history.size() > 0) {
				  return new ResponseEntity<>(history, HttpStatus.OK);
			  }else {
				  return new ResponseEntity<>(history, HttpStatus.NOT_FOUND);
			  } 
	    	}
	  }
	  
	  @GetMapping("/api/v1/match-history/driver/{driverId}")
	  public ResponseEntity<?> getTriHistoryByDriverId(@RequestHeader Map<String, String> headers, @PathVariable(value="driverId") String driverId) throws Exception {
		  logger.debug("Header values: {}", headers);
	    	if(headers.get("api_secrete") == null || headers.get("api_version") == null || headers.get("api_deviceid") == null) {
	    		logger.info("-----ValidationError : 412 Precondition failed");
	    		return ResponseEntity.status(412).body(null);
	    	}else if(!headers.get("api_secrete").equals(customProperties.getApiSecrete())) {
	    		logger.info("-----ValidationError : 401 Unauthorised");
	    		return ResponseEntity.status(401).body(null);
	    	}else if(!headers.get("api_version").equals(customProperties.getApiVersion())) {
	    		logger.info("-----ValidationError : 403 Forbidden");
	    		return ResponseEntity.status(403).body(null);
	    	}else {
			  List<MatchLogHistory> history = historyService.getMatchLogHistoryByDriverId(driverId);
			  if(history != null && history.size() > 0) {
				  return new ResponseEntity<>(history, HttpStatus.OK);
			  }else {
				  return new ResponseEntity<>(history, HttpStatus.NOT_FOUND);
			  } 
	    	}
	  }
	  
	  @GetMapping("/api/v1/match-history/conversation/{correlationId}")
	  public ResponseEntity<?> getTriHistoryById(@RequestHeader Map<String, String> headers, @PathVariable(value="correlationId") String correlationId) throws Exception {
		  logger.debug("Header values: {}", headers);
	    	if(headers.get("api_secrete") == null || headers.get("api_version") == null || headers.get("api_deviceid") == null) {
	    		logger.info("-----ValidationError : 412 Precondition failed");
	    		return ResponseEntity.status(412).body(null);
	    	}else if(!headers.get("api_secrete").equals(customProperties.getApiSecrete())) {
	    		logger.info("-----ValidationError : 401 Unauthorised");
	    		return ResponseEntity.status(401).body(null);
	    	}else if(!headers.get("api_version").equals(customProperties.getApiVersion())) {
	    		logger.info("-----ValidationError : 403 Forbidden");
	    		return ResponseEntity.status(403).body(null);
	    	}else {
			  MatchLogHistory history = historyService.getMatchLogHistoryById(correlationId);
			  if(history != null) {
				  return new ResponseEntity<>(history, HttpStatus.OK);
			  }else {
				  return new ResponseEntity<>(history, HttpStatus.NOT_FOUND);
			  } 
	    	}
	  }
	
}
