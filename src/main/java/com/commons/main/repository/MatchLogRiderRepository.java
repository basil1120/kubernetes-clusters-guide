package com.commons.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commons.main.models.MatchLogRider;

public interface MatchLogRiderRepository extends MongoRepository<MatchLogRider, String> {
	
}
