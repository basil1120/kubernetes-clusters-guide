package com.commons.main.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commons.main.models.LocationDriverBroadcasts;
import com.commons.main.repository.LocationDriverBroadcastsRepository;


@Service
@Transactional
public class LocationDriverBroadcastsService{
	
	@Autowired
	private LocationDriverBroadcastsRepository locationDriverBroadcastsRepository;
	

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	
	public LocationDriverBroadcasts createLocationDriverBroadcasts(LocationDriverBroadcasts locationDriverBroadcasts) {
		locationDriverBroadcasts.setBroadcastTime(simpleDateFormat.format(new Date()));
		return locationDriverBroadcastsRepository.save(locationDriverBroadcasts);
	}

	
	public List<LocationDriverBroadcasts> getAllLocationDriverBroadcasts() {
		return this.locationDriverBroadcastsRepository.findAll();
	}

	
	public LocationDriverBroadcasts getLocationDriverBroadcastsByDriverId(String id) throws Exception {
        Optional < LocationDriverBroadcasts > locationDriverBroadcastsDb = this.locationDriverBroadcastsRepository.findById(id);

        if (locationDriverBroadcastsDb.isPresent()) {
            return locationDriverBroadcastsDb.get();
        } else {
            throw new Exception("Record not found with id : " + id);
        }
	}

}
