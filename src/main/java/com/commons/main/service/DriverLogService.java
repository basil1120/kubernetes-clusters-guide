package com.commons.main.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commons.main.models.DriverLog;
import com.commons.main.repository.DriverLogRepository;
import com.commons.main.utils.ResourceNotFoundException;

@Service
@Transactional
public class DriverLogService{

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	@Autowired
    private DriverLogRepository driverLogRepository;

    public DriverLog createDriverLog(DriverLog driverLog) {
    	try {
    		driverLogRepository.deleteById(driverLog.getDriverId()); 
    	}catch(Exception ex) {}
    	driverLog.setTransactionTime(simpleDateFormat.format(new Date()));
        return driverLogRepository.save(driverLog);
    }

  
    public DriverLog updateDriverLog(DriverLog driverLog) {
        Optional < DriverLog > driverLogDb = this.driverLogRepository.findById(driverLog.getDriverId());

        if (driverLogDb.isPresent()) {
        	DriverLog driverLogUpdate = driverLogDb.get();
        	driverLogUpdate.setDriverId(driverLog.getDriverId());
        	driverLogUpdate.setSlat(driverLog.getSlat());
        	driverLogUpdate.setSlon(driverLog.getSlon());
        	driverLogUpdate.setDlat(driverLog.getDlat());
        	driverLogUpdate.setDlon(driverLog.getDlon());
        	driverLogUpdate.setNoOfSeats(driverLog.getNoOfSeats());
        	driverLogRepository.save(driverLogUpdate);
            return driverLogUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + driverLog.getDriverId());
        }
    }

 
    public List < DriverLog > getAllDriverLog() {
        return this.driverLogRepository.findAll();
    }


    public DriverLog getDriverById(String driverId) {

        Optional < DriverLog > driverLogDb = this.driverLogRepository.findById(driverId);

        if (driverLogDb.isPresent()) {
            return driverLogDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + driverId);
        }
    }


    public void deleteDriver(String driverId) {
        Optional < DriverLog > driverLogDb = this.driverLogRepository.findById(driverId);

        if (driverLogDb.isPresent()) {
            this.driverLogRepository.delete(driverLogDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + driverId);
        }

    }
	
}
