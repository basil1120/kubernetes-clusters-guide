package com.commons.main.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commons.main.models.LocationRiderBroadcasts;
import com.commons.main.repository.LocationRiderBroadcastsRepository;
import com.commons.main.utils.ResourceNotFoundException;

@Service
@Transactional
public class LocationRiderBroadcastsService{

	@Autowired
	private LocationRiderBroadcastsRepository locationRiderBroadcastsRepository;
	
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	

	public LocationRiderBroadcasts createLocationRiderBroadcasts(LocationRiderBroadcasts locationRiderBroadcasts) {
		locationRiderBroadcasts.setBroadcastTime(simpleDateFormat.format(new Date()));
		return locationRiderBroadcastsRepository.save(locationRiderBroadcasts);
	}


	public List<LocationRiderBroadcasts> getAllLocationRiderBroadcasts() {
		return locationRiderBroadcastsRepository.findAll();
	}


	public LocationRiderBroadcasts getLocationRiderBroadcastsByRiderId(String id) {
        Optional < LocationRiderBroadcasts > locationRiderBroadcastsDb = this.locationRiderBroadcastsRepository.findById(id);

        if (locationRiderBroadcastsDb.isPresent()) {
            return locationRiderBroadcastsDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
	}

}
