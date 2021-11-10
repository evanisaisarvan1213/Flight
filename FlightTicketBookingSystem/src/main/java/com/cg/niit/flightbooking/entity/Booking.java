package com.cg.niit.flightbooking.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="bookingId")
public class Booking 
{
	@Id
	@Column(name="booking_id")
	int bookingId;
	
	@Column(name="booking_date")
	LocalDate bookingDate;
	
	@Column(name="dateoftravel")
	LocalDate dateOfTravel;
		
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="schedule_id")
	FlightSchedule flightschedule;
	
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="user_id")
	UserDetails userdetails;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="booking_id")
	List<PassengerDetails> passengerDetails;
	
	public Booking() {}
	
	public Booking(int bookingId, LocalDate bookingDate, LocalDate dateOfTravel,List<PassengerDetails> passengerDetails,FlightSchedule flightschedule,UserDetails userdetails) {
		
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.dateOfTravel = dateOfTravel;
		this.passengerDetails=passengerDetails;
		this.flightschedule=flightschedule;
		this.userdetails=userdetails;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDate getDateOfTravel() {
		return dateOfTravel;
	}
	public void setDateOfTravel(LocalDate dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}
	public FlightSchedule getFlightschedule() {
		return flightschedule;
	}
	public void setFlightschedule(FlightSchedule flightschedule) {
		this.flightschedule = flightschedule;
	}

	public List<PassengerDetails> getpassenegrDetails() {
		return passengerDetails;
	}

	public void setpassenegrDetails(List<PassengerDetails> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}

	public UserDetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}	
	
	
	
	
}
