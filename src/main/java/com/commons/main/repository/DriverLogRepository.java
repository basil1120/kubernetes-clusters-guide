package com.commons.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commons.main.models.DriverLog;

public interface DriverLogRepository extends MongoRepository<DriverLog, String>{

}
