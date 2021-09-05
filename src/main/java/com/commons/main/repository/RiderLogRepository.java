package com.commons.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commons.main.models.RiderLog;

public interface RiderLogRepository extends MongoRepository<RiderLog, String>{

}
