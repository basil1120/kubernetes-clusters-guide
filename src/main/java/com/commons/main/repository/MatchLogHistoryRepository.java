package com.commons.main.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commons.main.models.MatchLogHistory;

public interface MatchLogHistoryRepository extends MongoRepository<MatchLogHistory, String>{
	
	public List<MatchLogHistory> findAllByOrderByMatchTimeDesc();

}
