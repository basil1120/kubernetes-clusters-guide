package com.commons.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commons.main.models.MatchLogDriver;

public interface MatchLogDriverRepository extends MongoRepository<MatchLogDriver, String>{

}
