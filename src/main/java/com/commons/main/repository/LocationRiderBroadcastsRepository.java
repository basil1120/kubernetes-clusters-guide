package com.commons.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commons.main.models.LocationRiderBroadcasts;

public interface LocationRiderBroadcastsRepository extends MongoRepository<LocationRiderBroadcasts, String>{

}
