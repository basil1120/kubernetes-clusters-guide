package com.commons.main.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commons.main.models.RiderLog;
import com.commons.main.repository.MatchLogRiderRepository;
import com.commons.main.repository.RiderLogRepository;
import com.commons.main.utils.ResourceNotFoundException;

@Service
@Transactional
public class RiderLogService{
	
	@Autowired
    private RiderLogRepository riderLogRepository;
	
	@Autowired
    private MatchLogRiderRepository riderMatchLogRepository;

	private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	private final Logger logger = LoggerFactory.getLogger(RiderLogService.class);

 
    public RiderLog createRiderLog(RiderLog riderLog) {
    	try {
        	riderLog.setTransactionTime(simpleDateFormat.format(new Date()));
        	try {
        		riderMatchLogRepository.deleteById(riderLog.getRiderId()); 
        	}catch(Exception ex) {}
            return riderLogRepository.save(riderLog);
    	}catch(Exception e) {
    		logger.error(e.getMessage());
    		return null;
    	}
    }

  
    public RiderLog updateRiderLog(RiderLog riderLog) {
        Optional < RiderLog > riderLogDb = this.riderLogRepository.findById(riderLog.getRiderId());
        if (riderLogDb.isPresent()) {
        	RiderLog riderLogUpdate = riderLogDb.get();
        	riderLogUpdate.setRiderId(riderLog.getRiderId());
        	riderLogUpdate.setSlat(riderLog.getSlat());
        	riderLogUpdate.setSlon(riderLog.getSlon());
        	riderLogUpdate.setDlat(riderLog.getDlat());
        	riderLogUpdate.setDlon(riderLog.getDlon());
            riderLogRepository.save(riderLogUpdate);
            return riderLogUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + riderLog.getRiderId());
        }
    }


    public List < RiderLog > getAllRiderLog() {
        return this.riderLogRepository.findAll();
    }

 
    public RiderLog getRiderById(String riderId) {
        Optional < RiderLog > riderLogDb = this.riderLogRepository.findById(riderId);
        if (riderLogDb.isPresent()) {
            return riderLogDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + riderId);
        }
    }

    public void deleteRider(String riderId) {
        Optional < RiderLog > riderLogDb = this.riderLogRepository.findById(riderId);
        if (riderLogDb.isPresent()) {
            this.riderLogRepository.deleteById(riderLogDb.get().getRiderId());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + riderId);
        }

    }

}
