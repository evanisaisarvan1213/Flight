package com.cg.niit.flightbooking.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.niit.flightbooking.entity.FlightSchedule;
public interface FlightScheduleRepository extends JpaRepository<FlightSchedule, Integer> 
{
	@Query("select flight from FlightSchedule flight where flight.source=:src and flight.destination=:dest")
	List<FlightSchedule> findBySourceAndDestination(@Param("src")String source,@Param("dest")String destination);
}
