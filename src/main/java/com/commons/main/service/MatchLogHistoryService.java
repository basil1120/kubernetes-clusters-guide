package com.commons.main.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
}
