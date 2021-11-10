package com.cg.niit.flightbooking.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.niit.flightbooking.entity.FlightSchedule;
import com.cg.niit.flightbooking.repository.FlightScheduleRepository;
@Service
public class FlightScheduleService 
{
	@Autowired
	FlightScheduleRepository flightScheduleRepository;
	
	@Transactional(readOnly=true)
	public List<FlightSchedule> getFlightsSchedulesBySourceAndDestination(String source, String destination)
	{
		return flightScheduleRepository.findBySourceAndDestination(source,destination);
	}
	
	@Transactional(readOnly=true)
	public FlightSchedule getFlightSchedulesByScheduleId(int scheduleId)
	{
		Optional<FlightSchedule> flightSchedule = flightScheduleRepository.findById(scheduleId);
		if(flightSchedule!=null)
			return flightSchedule.get();
		throw new RuntimeException("Flights Not Found");
	}
	
}
