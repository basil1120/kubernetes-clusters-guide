package com.commons.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commons.main.models.LocationDriverBroadcasts;

public interface LocationDriverBroadcastsRepository extends MongoRepository<LocationDriverBroadcasts, String>{

}
