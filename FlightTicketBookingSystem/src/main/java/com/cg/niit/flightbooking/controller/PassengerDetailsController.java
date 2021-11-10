package com.cg.niit.flightbooking.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.niit.flightbooking.entity.PassengerDetails;
import com.cg.niit.flightbooking.service.PassengerDetailsService;
@RestController
@RequestMapping("/Passenger")
public class PassengerDetailsController 
{
	@Autowired
	PassengerDetailsService passengerService;
	
	@PutMapping(value="/{status}/{bookingId}")
	public HttpStatus getTicketsCanceledByBookingId(@PathVariable String status,@PathVariable int bookingId)
	{
		if(passengerService.getCancelTicketsById(status, bookingId))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
			
	}
	
	@PutMapping(value="/cancelTickets/{status}/{passengerId}")
	public HttpStatus getTicketsCanceledByPassengerId(@PathVariable String status,@PathVariable int passengerId)
	{
		if(passengerService.getCancelTicketsIndividual(status, passengerId))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
			
	}
	
	@PostMapping(consumes="application/json")
	public HttpStatus addUserDetails(@RequestBody PassengerDetails passengerDetails)
	 {
		 if(passengerService.addUserDetails(passengerDetails))
			 return HttpStatus.CREATED;
		 return HttpStatus.NOT_ACCEPTABLE;			 
	 }
	
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}
}
