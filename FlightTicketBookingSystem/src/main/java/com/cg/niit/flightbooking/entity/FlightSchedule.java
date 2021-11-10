package com.cg.niit.flightbooking.entity;
import java.time.LocalTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.JoinColumn;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="scheduleId")
public class FlightSchedule 
{
	@Id
	@Column(name="schedule_id")
	int scheduleId;
	
	@Column(name="source")
	String source;
	
	@Column(name="destination")
	String destination;
	
	@Column(name="arrival_time")
	LocalTime arrivalTime;
	
	@Column(name="departure_time")
	LocalTime departureTime;
	
	@Column(name="fare")
	Double fare;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="flight_number")
	FlightDetails flightdetails;
	
	
	public FlightSchedule() {}
	public FlightSchedule(int scheduleId,String source, String destination, LocalTime arrivalTime, LocalTime departureTime, Double fare,FlightDetails flightdetails) {
		this.scheduleId=scheduleId;
		this.source = source;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.fare = fare;
		this.flightdetails=flightdetails;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public Double getFare() {
		return fare;
	}
	public void setFare(Double fare) {
		this.fare = fare;
	}
	public FlightDetails getFlightdetails() {
		return flightdetails;
	}
	public void setFlightdetails(FlightDetails flightdetails) {
		this.flightdetails = flightdetails;
	}
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	
}
