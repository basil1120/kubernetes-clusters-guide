package com.commons.main.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.commons.main.models.MatchLogHistory;
import com.commons.main.repository.MatchLogHistoryRepository;

@Service
public class MatchLogHistoryService {
	
	@Autowired
	private MatchLogHistoryRepository matchLogHistoryRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(MatchLogHistoryService.class);
	
	public List<MatchLogHistory> getMatchLogHistory() {
		try {
			List<MatchLogHistory> history = matchLogHistoryRepository.findAllByOrderByMatchTimeDesc();
			return history;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	
	public MatchLogHistory getMatchLogHistoryById(String conversationId) {
		try {
			Optional<MatchLogHistory> history = matchLogHistoryRepository.findById(conversationId);
			if(history.isPresent()) {
				MatchLogHistory hist;
				hist = history.get();
				return hist;
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	
	public List<MatchLogHistory> getMatchLogHistoryByRiderId(String riderId) {
		try{
			
			Query query = new Query();
			query.addCriteria(Criteria.where("age").lt(50).gt(20));
			
			//List<MatchLogHistory> history = matchLogHistoryRepository.findByRiderIdByOrderByMatchTimeDesc(riderId);
			List<MatchLogHistory> history = matchLogHistoryRepository.findAllByOrderByMatchTimeDesc();
			if(history.size()> 0 && history != null) {
				history = history.stream().filter(f -> f.riderId.equals(riderId) ) 
						.collect(Collectors.toList());
				return history;
			}			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	public List<MatchLogHistory> getMatchLogHistoryByDriverId(String driverId) {
		try {
			//List<MatchLogHistory> history = matchLogHistoryRepository.findByDriverIdByOrderByMatchTimeDesc(driverId);
			List<MatchLogHistory> history = matchLogHistoryRepository.findAllByOrderByMatchTimeDesc();
			if(history.size()> 0 && history != null) {
				history = history.stream().filter(f -> f.driverId.equals(driverId) ) 
						.collect(Collectors.toList());
				return history;
			}
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
}
