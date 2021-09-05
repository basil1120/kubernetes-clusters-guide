package com.commons.main.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.main.models.CancellationLog;
import com.commons.main.models.MatchLogDriver;
import com.commons.main.models.MatchLogHistory;
import com.commons.main.models.MatchLogRider;
import com.commons.main.repository.CancellationLogRepository;
import com.commons.main.repository.MatchLogDriverRepository;
import com.commons.main.repository.MatchLogHistoryRepository;
import com.commons.main.repository.MatchLogRiderRepository;
import com.commons.main.utils.ResourceNotFoundException;


@Service
public class MatchLogRiderService{

	@Autowired
    private MatchLogRiderRepository riderMatchLogRepository;
	
	@Autowired
	private MatchLogDriverRepository driverMatchLogRepository;
	
	@Autowired
	private CancellationLogRepository cancellationLogRepository;
	
	@Autowired
	private MatchLogHistoryRepository historyRepository;

	private static final Logger logger = LoggerFactory.getLogger(MatchLogRiderService.class);
	
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
    public MatchLogRider registerUser(MatchLogRider rider) throws Exception {
        rider = riderMatchLogRepository.save(rider);
        return rider;
    }

    public MatchLogRider getUser(String userId) {
    	
      	MatchLogRider  matchLogRider;
    	MatchLogDriver matchLogDriver;
    	Throwable throwable = null;
    	
    	Optional<MatchLogRider> rider = riderMatchLogRepository.findById(userId);
     	
    	if(rider.isPresent()) {	
    	    matchLogRider = rider.get();	
	    	if(matchLogRider.getIsPooled() == 0 && matchLogRider.getRideraccepted() == 0) {
	    		if(matchLogRider.getDriveraccepted() == 1 || matchLogRider.getDriveraccepted() == 2 || matchLogRider.getDriveraccepted() == 9) {
	        		matchLogRider.setIsPooled(1);
	        		riderMatchLogRepository.save(matchLogRider);
	        		return matchLogRider;
	    		}else {
					logger.error("ERROR-CUSTOMER-STATUS ::Info::userPOLLED [{}]::userINTRIP [{}]::driverACCEPTED [{}]::userUSERID [{}]", matchLogRider.getIsPooled(),matchLogRider.getInTrip(),matchLogRider.getDriveraccepted(), matchLogRider.getId());
	        		logger.error("===========ERROR========MatchLogRiderServiceImpl : "+ "Driver has not accepted the request yet");
					throw new ResourceNotFoundException("Driver has not accepted the request yet {0=NOT YET : 9=REJECTED}: " + userId, throwable);
	    		}
	    	}else {
	    		logger.error("===========ERROR========MatchLogRiderServiceImpl : "+ "Customer already polled with userId[{}]",userId);
	    		throw new ResourceNotFoundException("Customer already polled with userId : " + userId, throwable);
	    	}
    	}else {
    		logger.error("===========ERROR========MatchLogRiderServiceImpl : "+ "Record not found with userId[{}]",userId);
    		throw new ResourceNotFoundException("Record not found with userId : " + userId, throwable);
    	}
    	/*
		Optional<MatchLogDriver> driver = driverMatchLogRepository.findById(matchLogRider.getDriverId());
		if(driver.isPresent()) {
			matchLogDriver = driver.get();
			
			if(matchLogDriver.getDriveraccepted() == 1 && matchLogRider.getIsPooled() == 0) {      //d-ACCEPTED
        		matchLogRider.setIsPooled(1);
        		matchLogRider.setDriveraccepted(matchLogDriver.getDriveraccepted());
        		riderMatchLogRepository.save(matchLogRider);
        		return matchLogRider;
			}else if(matchLogDriver.getDriveraccepted()== 9 && matchLogRider.getIsPooled() == 0) {  //d-REJECTED
        		matchLogRider.setIsPooled(1);
        		matchLogRider.setDriveraccepted(matchLogDriver.getDriveraccepted());
        		riderMatchLogRepository.save(matchLogRider);
        		return matchLogRider;
			}else if(matchLogDriver.getDriveraccepted()== 2 && matchLogRider.getIsPooled() == 0) {  //d-REJECTED
        		matchLogRider.setIsPooled(1);
        		matchLogRider.setDriveraccepted(matchLogDriver.getDriveraccepted());
        		riderMatchLogRepository.save(matchLogRider);
        		return matchLogRider;
			}else {
				logger.error("ERROR-CUSTOMER-STATUS ::Info::userPOLLED1 [{}]::driverPOLLED2 [{}]::INTRIP [{}]::ACCEPTED [{}]",matchLogRider.getIsPooled(), matchLogDriver.getIsPooled(),matchLogDriver.getInTrip(),matchLogDriver.getDriveraccepted());
        		logger.error("===========ERROR========MatchLogRiderServiceImpl : "+ "Driver has not accepted the request yet");
				throw new ResourceNotFoundException("Driver has not accepted the request yet {0=NOT YET : 9=REJECTED}: " + userId, throwable);
			}
		}else {
			logger.error("===========ERROR========MatchLogRiderServiceImpl : "+ "Driver you claimed is not found");
			throw new ResourceNotFoundException("Driver you claimed is not found : " + userId, throwable);
		}
    	}else {
    		logger.error("===========ERROR========MatchLogRiderServiceImpl : "+ "Record not found with userId");
    		throw new ResourceNotFoundException("Record not found with userId : " + userId, throwable);
    	}*/
    }

    public MatchLogRider acceptDriverRquest(String userId) {
    	
    	MatchLogRider  matchLogRider;
    	MatchLogDriver matchLogDriver;
    	
    	Optional<MatchLogRider> rider = riderMatchLogRepository.findById(userId);
    	if(rider.isPresent()) {
    		matchLogRider = rider.get();
    		Optional<MatchLogDriver> driver = driverMatchLogRepository.findById(matchLogRider.getDriverId());
    		if(driver.isPresent()) {
				matchLogDriver = driver.get();
	    		matchLogRider.setIsPooled(1);
	    		matchLogRider.setRideraccepted(matchLogDriver.getDriveraccepted());
	    		riderMatchLogRepository.save(matchLogRider);
	    		logger.info("===========SUCCESS========MatchLogRiderServiceImpl : "+ "Rider accepted match request as per the driver");
	        	return matchLogRider;
    		}else {
				logger.error("===========ERROR========MatchLogRiderServiceImpl : "+ "Driver you claimed is not found");
				throw new ResourceNotFoundException("Driver you claimed is not found : " + userId);
    		}
    	}else {
    		logger.error("===========ERROR========MatchLogRiderServiceImpl : "+ "Record not found with id");
    		throw new ResourceNotFoundException("Record not found with id : " + userId);
    	}
    }
    
    public MatchLogRider rejectDriverRquest(String userId) {
   
    	MatchLogRider matchLogRider;
    	Optional<MatchLogRider> rider = riderMatchLogRepository.findById(userId);
    
    	if(rider.isPresent()) {
    		matchLogRider = rider.get();
    		matchLogRider.setRideraccepted(9);//Rejected
    		riderMatchLogRepository.save(matchLogRider);
    		//REMEMBER TO PUSH THIS TO REJECTED QUEUE
    		//hence bring in TRIPID or MATCHEIDS
    		CancellationLog cancel = new CancellationLog();
    		cancel.setConversationId(matchLogRider.getConversationId());
    		cancel.setCancelledByUser("1");
    		cancel.setCancelledByDriver("0");
    		cancel.setCancellationCode("000");
    		cancel.setCancellationCodeDescription("Driver Took too long");
    		cancel.setCancellationTime(simpleDateFormat.format(new Date()));
    		cancellationLogRepository.save(cancel);
    		
			// NOW PUSH TO HISTORY TABLE
			MatchLogHistory history = new MatchLogHistory();
			history.setConversationId(matchLogRider.getConversationId());
			history.setCompletedByDriver(0);
			history.setCompletedByRider(1);
			history.setMatchTime(matchLogRider.getMatchTime());
			history.setPickupTime(matchLogRider.getMatchTime());
			history.setCompletionTime(simpleDateFormat.format(new Date()));
			history.setStatus(0);
			history.setsLat(matchLogRider.getRiderSourceLat());
			history.setsLon(matchLogRider.getRiderSourceLon());
			history.setdLat(matchLogRider.getRiderDestinationLat());
			history.setdLon(matchLogRider.getRiderDestinationLon());
			history.setDriverId(matchLogRider.getDriverId());
			history.setRiderId(matchLogRider.getId());
			history.setDestinationDistance(0);
			history.setPickupDistance(0);
			history.setTripAmount(0);
			history.setTripTimeTaken("0");
			historyRepository.save(history);
    		logger.info("===========SUCCESS========MatchLogRiderServiceImpl : "+ "Rider REJECTED match request");
        	return matchLogRider;
    	}else {
    		logger.error("===========ERROR========MatchLogRiderServiceImpl : "+ "Record not found with id");
    		throw new ResourceNotFoundException("Record not found with id : " + userId);
    	}
    }
      
    public List<MatchLogRider> getAllUser() throws Exception {
        List<MatchLogRider> users = riderMatchLogRepository.findAll();
        return users;
    }

    public MatchLogRider updateUser(MatchLogRider user) throws Exception {
        user = riderMatchLogRepository.save(user);
        return user;
    }
}
