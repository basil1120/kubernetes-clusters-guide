package com.commons.main.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.main.models.TripStatus;
import com.commons.main.repository.TripStatusRepository;

@Service
public class TripStatusService {
	
	private static Logger logger = LoggerFactory.getLogger(TripStatusService.class);
	
	@Autowired
	private TripStatusRepository tripStatusRepository;
	
	public TripStatus getTripById(String conversationId) {
		TripStatus response = new TripStatus();
		Optional<TripStatus> tripStatus = Optional.of(new TripStatus());
		try {
			tripStatus = tripStatusRepository.findById(conversationId);
			if(tripStatus.isPresent()) {
				response.setConversationId(conversationId);
				response.setDriverId(tripStatus.get().getDriverId());
				response.setRiderId(tripStatus.get().getRiderId());
				response.setRiderStatus(tripStatus.get().getRiderStatus());
				response.setDriverStatus(tripStatus.get().getDriverStatus());
				response.setTripStatus(tripStatus.get().getTripStatus());
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return response;
	}
	
	public TripStatus updateTripStatus(TripStatus request) {
		TripStatus response = new TripStatus();
		try {
			tripStatusRepository.save(request);
			response = request;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return response;
	}

}
