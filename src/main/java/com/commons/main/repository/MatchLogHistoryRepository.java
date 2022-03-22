package com.commons.main.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commons.main.models.MatchLogHistory;

public interface MatchLogHistoryRepository extends MongoRepository<MatchLogHistory, String>{
	
	//BY riderID
	//public List<MatchLogHistory> findByRiderIdByOrderByMatchTimeDesc(String riderId);
	
	//BY driverID
	//public List<MatchLogHistory> findByDriverIdByOrderByMatchTimeDesc(String driverId);
	
	//BY correlationID
	//public MatchLogHistory findByIdByOrderByMatchTimeDesc(String conversationId);
	
	//ALL
	public List<MatchLogHistory> findAllByOrderByMatchTimeDesc();

}
