package com.commons.main.service;

//import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.main.models.MatchLogDriver;
import com.commons.main.models.MatchLogHistory;
import com.commons.main.models.MatchLogRider;
import com.commons.main.repository.MatchLogDriverRepository;
import com.commons.main.repository.MatchLogHistoryRepository;
import com.commons.main.repository.MatchLogRiderRepository;
import com.commons.main.utils.ResourceNotFoundException;

@Service
public class MatchLogDriverService {

	private static final Logger logger = LoggerFactory.getLogger(MatchLogDriverService.class);

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	//private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");
	
	@Autowired
	private MatchLogDriverRepository userRepository;

	@Autowired
	private MatchLogRiderRepository riderRepository;

	@Autowired
	private MatchLogHistoryRepository historyRepository;

	public MatchLogDriver registerUser(MatchLogDriver user) {
		user = userRepository.save(user);
		return user;
	}

	public MatchLogDriver getUser(String userId) {
		Optional<MatchLogDriver> user = userRepository.findById(userId);
		MatchLogDriver matchLogDriver;
		if (user.isPresent()) {
			matchLogDriver = user.get();
			if (matchLogDriver.getInTrip() == 0 && matchLogDriver.getDriveraccepted() == 0 && matchLogDriver.getIsPooled() == 0) {
				matchLogDriver.setIsPooled(1);
				userRepository.save(matchLogDriver);
				return matchLogDriver;
			} else {
				logger.error("ERROR-DRIVER-STATUS ::Info::POLLED [{}]::INTRIP [{}]::ACCEPTED [{}]", matchLogDriver.getIsPooled(),matchLogDriver.getInTrip(),matchLogDriver.getDriveraccepted());
				throw new ResourceNotFoundException("This is an old match : " + userId);
			}
		} else {
			logger.error("===========ERROR========MatchLogDriverServiceImpl : " + "Record not found with id");
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
	}

	public MatchLogDriver acceptRiderRquest(String userId) {
		
		MatchLogDriver matchLogDriver;
		MatchLogRider matchLogRider;
		
		Optional<MatchLogDriver> driver = userRepository.findById(userId);

		if (driver.isPresent()) {
			matchLogDriver = driver.get();
			matchLogDriver.setIsPooled(1);
			matchLogDriver.setInTrip(1);// 1=PREPARING || 2=ON-PICKUP || 3=ON-TRIP || 4=ENDTRIP
			matchLogDriver.setDriveraccepted(1);
			userRepository.save(matchLogDriver);
			logger.info("===========SUCCESS========MatchLogDriverServiceImpl : " + "Driver accepted match request");
			
			Optional<MatchLogRider> rider = riderRepository.findById(matchLogDriver.getRiderId());
			if (rider.isPresent()) {
				matchLogRider = rider.get();
				matchLogRider.setIsPooled(0);
				matchLogRider.setInTrip(0); // 1=PREPARING || 2=ON-PICKUP || 3=ON-TRIP || 4=ENDTRIP
				matchLogRider.setDriveraccepted(1);
				matchLogRider.setRideraccepted(0);
				riderRepository.save(matchLogRider);
			}
			return matchLogDriver;
		} else {
			logger.error("===========ERROR========MatchLogDriverServiceImpl : " + "Accept Record not found with id");
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
	}

	public MatchLogDriver pickingUpCustomer(String userId) {
		Optional<MatchLogDriver> driver = userRepository.findById(userId);
		MatchLogDriver matchLogDriver;
		if (driver.isPresent()) {
			matchLogDriver = driver.get();
			matchLogDriver.setIsPooled(2);
			matchLogDriver.setInTrip(2);// 1=PREPARING || 2=ON-PICKUP || 3=ON-TRIP || 4=ENDTRIP
			matchLogDriver.setDriveraccepted(1);
			userRepository.save(matchLogDriver);
			logger.info("===========SUCCESS========MatchLogDriverServiceImpl : " + "Driver pickingup customer");
			return matchLogDriver;
		} else {
			logger.error("===========ERROR========MatchLogDriverServiceImpl : " + "Pick-Up Record not found with id");
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
	}

	public MatchLogDriver drivingCustomer(String userId) {
		Optional<MatchLogDriver> driver = userRepository.findById(userId);
		MatchLogDriver matchLogDriver;
		if (driver.isPresent()) {
			matchLogDriver = driver.get();
			matchLogDriver.setIsPooled(3);
			matchLogDriver.setInTrip(3);// 1=PREPARING || 2=ON-PICKUP || 3=ON-TRIP || 4=ENDTRIP
			matchLogDriver.setDriveraccepted(1);
			userRepository.save(matchLogDriver);
			logger.info("===========SUCCESS========MatchLogDriverServiceImpl : " + "Driving customer request");
			return matchLogDriver;
		} else {
			logger.error("===========ERROR========MatchLogDriverServiceImpl : " + "Ontrip Record not found with id");
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
	}

	public MatchLogHistory getTripStatusHistory(String conversationId) {
		Optional<MatchLogHistory> history = historyRepository.findById(conversationId);
		if(history.isPresent()) {
			MatchLogHistory hist;
			hist = history.get();
			return hist;
		}else {
			return null;
		}
	}
	
	public MatchLogDriver endTripRquest(String userId) {

		MatchLogDriver matchLogDriver;
		MatchLogRider matchLogRider;

		Optional<MatchLogDriver> driver = userRepository.findById(userId);

		if (driver.isPresent()) {
			matchLogDriver = driver.get();
			matchLogDriver.setIsPooled(4);
			matchLogDriver.setInTrip(4); // 1=PREPARING || 2=ON-PICKUP || 3=ON-TRIP || 4=ENDTRIP
			matchLogDriver.setDriveraccepted(1);
			matchLogDriver.setRideraccepted(1);
			userRepository.save(matchLogDriver);

			Optional<MatchLogRider> rider = riderRepository.findById(matchLogDriver.getRiderId());
			if (rider.isPresent()) {
				matchLogRider = rider.get();
				matchLogRider.setIsPooled(4);
				matchLogRider.setInTrip(4); // 1=PREPARING || 2=ON-PICKUP || 3=ON-TRIP || 4=ENDTRIP
				matchLogRider.setDriveraccepted(1);
				matchLogRider.setRideraccepted(1);
				riderRepository.save(matchLogRider);
			}else {
				return null;
			}
			// NOW PUSH TO HISTORY TABLE
			MatchLogHistory history = new MatchLogHistory();
			
			
			//double timeTaken = calculateTime(matchLogDriver.getMatchTime(), simpleDateFormat.format(new Date()));
			//double distance = calculateDistance(matchLogDriver.getRiderSourceLat(), matchLogDriver.getRiderSourceLon(),matchLogDriver.getRiderDestinationLat(), matchLogDriver.getRiderDestinationLon());
			//decimalFormat.setRoundingMode(RoundingMode.UP);
			//double tripCost = calculatePrice(Double.parseDouble(decimalFormat.format(distance)), timeTaken);
			String transportType; //1=BODA , 2=ECONOMY, 3=PREMIUM
			if(matchLogDriver.getTransportMode().equalsIgnoreCase("1")) {
				transportType = "BODA";
			}else if(matchLogDriver.getTransportMode().equalsIgnoreCase("2")) {
				transportType = "ECONOMY CAR";
			}else if(matchLogDriver.getTransportMode().equalsIgnoreCase("3")) {
				transportType = "PREMIUM CAR";
			}else {
				transportType = "OTHERS";
			}	
			
			history.setTripTimeTaken(matchLogDriver.getEstimatedTime());
			history.setTripAmount(Double.valueOf(matchLogDriver.getEstimatedPrice()));
			history.setDriverId(matchLogDriver.getDriverId());
			history.setDriverName(matchLogDriver.getDriverName());
			history.setRiderName(matchLogDriver.getRiderName());
			history.setRiderId(matchLogDriver.getRiderId());
			history.setConversationId(matchLogDriver.getConversationId());
			history.setCompletedByDriver(1);
			history.setCompletedByRider(0);
			history.setMatchTime(matchLogDriver.getMatchTime());
			history.setPickupTime(matchLogDriver.getMatchTime());
			history.setCompletionTime(simpleDateFormat.format(new Date()));
			history.setStatus("COMPLETED"); //1=COMPLETED : 2=CANCELED : EXPIRED
			history.setsLat(matchLogDriver.getRiderSourceLat());
			history.setsLon(matchLogDriver.getRiderSourceLon());
			history.setdLat(matchLogDriver.getRiderDestinationLat());
			history.setdLon(matchLogDriver.getRiderDestinationLon());
			history.setTransportMode(matchLogDriver.getTransportMode());
			history.setTransportType(transportType);
			history.setVehicleNumberPlate(matchLogDriver.getVehicleNumberPlate());
			history.setPickupDistance(matchLogDriver.getSourceDistance());
			history.setPickUpLocation(matchLogDriver.getPickUpLocation());
			history.setDropOffLocation(matchLogDriver.getDropOffLocation());
			history.setDestinationDistance(Double.parseDouble(matchLogDriver.getEstimatedDistance()));
			historyRepository.save(history);
			return matchLogDriver;
		} else {
			return null;
		}
	}

	public MatchLogDriver rejectRiderRquest(String userId) {

		MatchLogDriver matchLogDriver;
		MatchLogRider  matchLogRider;
		Optional<MatchLogDriver> driver = userRepository.findById(userId);

		if (driver.isPresent()) {
			matchLogDriver = driver.get();
			matchLogDriver.setIsPooled(1);
			matchLogDriver.setInTrip(1);// 1=PREPARING || 2=ON-PICKUP || 3=ON-TRIP || 4=ENDTRIP
			matchLogDriver.setDriveraccepted(2);// 0=pending || 1=accepted 2=rejected
			userRepository.save(matchLogDriver);
			logger.info("===========SUCCESS========MatchLogDriverServiceImpl : " + "Driver REJECTED match request");
			
			Optional<MatchLogRider> rider = riderRepository.findById(matchLogDriver.getRiderId());
			if (rider.isPresent()) {
				matchLogRider = rider.get();
				matchLogRider.setIsPooled(0);
				matchLogRider.setInTrip(0); // 1=PREPARING || 2=ON-PICKUP || 3=ON-TRIP || 4=ENDTRIP
				matchLogRider.setDriveraccepted(2);
				matchLogRider.setRideraccepted(0);
				riderRepository.save(matchLogRider);
			}else {
				return null;
			}
			
			// NOW PUSH TO HISTORY TABLE
			MatchLogHistory history = new MatchLogHistory();
			
			String transportType; //1=BODA , 2=ECONOMY, 3=PREMIUM
			if(matchLogDriver.getTransportMode().equalsIgnoreCase("1")) {
				transportType = "BODA";
			}else if(matchLogDriver.getTransportMode().equalsIgnoreCase("2")) {
				transportType = "ECONOMY CAR";
			}else if(matchLogDriver.getTransportMode().equalsIgnoreCase("3")) {
				transportType = "PREMIUM CAR";
			}else {
				transportType = "OTHERS";
			}	
			
			history.setTripTimeTaken(matchLogDriver.getEstimatedTime());
			history.setTripAmount(Double.valueOf(matchLogDriver.getEstimatedPrice()));
			history.setDriverId(matchLogDriver.getDriverId());
			history.setDriverName(matchLogDriver.getDriverName());
			history.setRiderName(matchLogDriver.getRiderName());
			history.setRiderId(matchLogDriver.getRiderId());
			history.setConversationId(matchLogDriver.getConversationId());
			history.setCompletedByDriver(1);
			history.setCompletedByRider(0);
			history.setMatchTime(matchLogDriver.getMatchTime());
			history.setPickupTime(matchLogDriver.getMatchTime());
			history.setCompletionTime(simpleDateFormat.format(new Date()));
			history.setStatus("CANCELED"); //1=COMPLETED : 2=CANCELED : EXPIRED
			history.setsLat(matchLogDriver.getRiderSourceLat());
			history.setsLon(matchLogDriver.getRiderSourceLon());
			history.setdLat(matchLogDriver.getRiderDestinationLat());
			history.setdLon(matchLogDriver.getRiderDestinationLon());
			history.setTransportMode(matchLogDriver.getTransportMode());
			history.setTransportType(transportType);
			history.setVehicleNumberPlate(matchLogDriver.getVehicleNumberPlate());
			history.setDestinationDistance(Double.parseDouble(matchLogDriver.getEstimatedDistance()));
			history.setPickupDistance(matchLogDriver.getSourceDistance());
			history.setPickUpLocation(matchLogDriver.getPickUpLocation());
			history.setDropOffLocation(matchLogDriver.getDropOffLocation());
			historyRepository.save(history);
			
			return matchLogDriver;
		} else {
			logger.error("===========ERROR========MatchLogDriverServiceImpl : " + "Record not found with id");
			throw new ResourceNotFoundException("Record not found with id : " + userId);
		}
	}

	public MatchLogDriver updateUser(MatchLogDriver user) {
		user = userRepository.save(user);
		return user;
	}

	public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
		String unit = "K";
		if ((lat1 == lat2) && (lon1 == lon2)) {
			return 0;
		} else {
			double theta = lon1 - lon2;
			double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2))
					+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
			dist = Math.acos(dist);
			dist = Math.toDegrees(dist);
			dist = dist * 60 * 1.1515;
			if (unit.equals("K")) {
				dist = dist * 1.609344;
			} else if (unit.equals("N")) {
				dist = dist * 0.8684;
			}
			return (dist);
		}
	}

	public double calculatePrice(double distance, double hours) {
		double amount = 300;
		if (distance <= 3 && distance < 4) {
			amount = 300;
		} else if (distance > 3 && distance < 4) {
			amount = 600;
		} else if (distance > 4 && distance < 10) {
			amount = 900;
		} else if (distance > 10 && distance < 15) {
			amount = 1200;
		} else if (distance > 15 && distance < 20) {
			amount = 1500;
		} else if (distance > 20) {
			amount = 1500;
		}
		return amount;
	}

	public double calculateTime(String start_date, String end_date) {
		try {
			Date d1 = simpleDateFormat.parse(start_date);
			
			Date d2 = simpleDateFormat.parse(end_date);

			long difference_In_Time = d2.getTime() - d1.getTime();

			long difference_In_Seconds = TimeUnit.MILLISECONDS.toSeconds(difference_In_Time) % 60;

			long difference_In_Minutes = TimeUnit.MILLISECONDS.toMinutes(difference_In_Time) % 60;

			long difference_In_Hours = TimeUnit.MILLISECONDS.toHours(difference_In_Time) % 24;

			long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;

			long difference_In_Years = TimeUnit.MILLISECONDS.toDays(difference_In_Time) / 365l;

			System.out.print("Difference" + " between two dates is: ");
			System.out.println(difference_In_Years + " years, " + difference_In_Days + " days, " + difference_In_Hours+ " hours, " + difference_In_Minutes + " minutes, " + difference_In_Seconds + " seconds");
		    
			long finalMinutesTime = difference_In_Minutes + (difference_In_Hours * 60);
			
			//return (double)difference_In_Hours;
			return (double)finalMinutesTime;
			
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
