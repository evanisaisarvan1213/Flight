package com.cg.niit.flightbooking.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.niit.flightbooking.entity.PassengerDetails;
import com.cg.niit.flightbooking.repository.PassengerDetailsRepository;

@Service
public class PassengerDetailsService 
{
	@Autowired
	PassengerDetailsRepository passengerRepository;
	
	@Transactional
	public boolean getCancelTicketsById(String status,int bookingId)
	{
		int count=passengerRepository.cancelTicketBooked(status,bookingId);
		return count!=0;
	}
	
	@Transactional 
	public boolean getCancelTicketsIndividual(String status,int passengerId)
	{
		int count=passengerRepository.cancelTicketByPassengerId(status, passengerId);
		return count==1;
	}
	
	@Transactional
	public boolean addUserDetails(PassengerDetails passengerDetails)
	{
		PassengerDetails passenger_details = passengerRepository.save(passengerDetails);
		return passenger_details!=null;
	}
	
}
