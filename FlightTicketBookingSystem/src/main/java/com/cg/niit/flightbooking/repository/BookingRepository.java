package com.cg.niit.flightbooking.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.niit.flightbooking.entity.Booking;
public interface BookingRepository extends JpaRepository<Booking, Integer> 
{
	
}
