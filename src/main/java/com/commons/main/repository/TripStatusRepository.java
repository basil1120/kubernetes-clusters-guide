package com.commons.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commons.main.models.TripStatus;

public interface TripStatusRepository extends MongoRepository<TripStatus, String>{

}
