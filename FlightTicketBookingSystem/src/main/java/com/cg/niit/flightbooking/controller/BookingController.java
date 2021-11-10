package com.cg.niit.flightbooking.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.niit.flightbooking.entity.Booking;
import com.cg.niit.flightbooking.service.BookingService;
@RestController
@RequestMapping("/Booking")
public class BookingController 
{
	@Autowired
	BookingService bookingService;
	
	@GetMapping(value="/{bookingId}",produces="application/json")
	public ResponseEntity<Booking> getBookingDetails(@PathVariable int bookingId)
	{
		Booking bookingDetails = bookingService.getBookingDetailsByBookingId(bookingId);
		return new ResponseEntity<Booking>(bookingDetails,HttpStatus.OK);
	}
	
	@PostMapping(consumes="application/json")
	public HttpStatus bookFlightTickets(@RequestBody Booking booking)
	{
		if(bookingService.getBookings(booking))
			return HttpStatus.ACCEPTED;
		return HttpStatus.NOT_ACCEPTABLE;
	}
	
	@ExceptionHandler(RuntimeException.class)
	 public HttpStatus exceptionHandlerMethod()
	 {
		return HttpStatus.NO_CONTENT;
	 }
}
