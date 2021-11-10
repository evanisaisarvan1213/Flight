package com.cg.niit.flightbooking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.niit.flightbooking.entity.PassengerDetails;
public interface PassengerDetailsRepository extends JpaRepository<PassengerDetails, Integer> 
{
	@Modifying
	@Query("update PassengerDetails set status=:stat where bookingId=:bookId")
	public int cancelTicketBooked(@Param("stat") String status, @Param("bookId") int bookingId);
	
	@Modifying
	@Query("update PassengerDetails set status=:stat where passengerId=:passId")
	public int cancelTicketByPassengerId(@Param("stat") String status, @Param("passId") int passengerId);
}
