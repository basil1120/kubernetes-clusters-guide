package com.commons.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commons.main.models.CancellationLog;

public interface CancellationLogRepository extends MongoRepository<CancellationLog, String>{

}
