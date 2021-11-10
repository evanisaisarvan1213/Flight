package com.cg.niit.flightbooking.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.niit.flightbooking.entity.FlightSchedule;
import com.cg.niit.flightbooking.service.FlightScheduleService;

@RestController
@RequestMapping("/FlightSchedule")
public class FlightScheduleController 
{
	@Autowired
	FlightScheduleService flightScheduleService;
	
	@GetMapping(value="/{source}/{destination}",produces="application/json")
	public ResponseEntity<List<FlightSchedule>> getFlightsScheduleBySourceAndDestination(@PathVariable String source, @PathVariable String destination)
	{
		return new ResponseEntity<List<FlightSchedule>>(flightScheduleService.getFlightsSchedulesBySourceAndDestination(source, destination),HttpStatus.OK);
	}
	
	@GetMapping(value="/{scheduleId}",produces="application/json")
	public ResponseEntity<FlightSchedule> getFlightScheduleByScheduleId(int scheduleId)
	{
		return new ResponseEntity<FlightSchedule>(flightScheduleService.getFlightSchedulesByScheduleId(scheduleId),HttpStatus.OK);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}
}
