package com.cg.niit.flightbooking.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.niit.flightbooking.entity.Booking;
import com.cg.niit.flightbooking.repository.BookingRepository;
@Service
public class BookingService 
{
	@Autowired
	BookingRepository bookingRepository;
	
	@Transactional(readOnly=true)
	public Booking getBookingDetailsByBookingId(int bookingId)
	{
		Optional<Booking> optionalBooking = bookingRepository.findById(bookingId);
		if(optionalBooking!=null)
			return optionalBooking.get();
		throw new RuntimeException("No Tickets Found");
	}
	
	@Transactional
	public boolean getBookings(Booking booking)
	{
		Booking bookingTicket = bookingRepository.save(booking);
		return bookingTicket!=null;
	}
	
	

}
