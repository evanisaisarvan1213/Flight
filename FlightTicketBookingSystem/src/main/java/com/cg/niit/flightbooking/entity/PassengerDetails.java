package com.cg.niit.flightbooking.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="passengerId")
public class PassengerDetails
{
	@Id
	@Column(name="passenger_id")
	int passengerId;
	
	@Column(name="passenger_name")
	String passengerName;
	
	@Column(name="passenger_phone")
	long passengerPhone;
	
	@Column(name="passenger_age")
	int passengerAge;
	
	@Column(name="passenger_ssn")
	long passengerSsn;
	
	@Column(name="booking_id")
	int bookingId;
	
	@Column(name="seat_row")
	int seat_row;
	
	@Column(name="seat_column")
	int seat_column;
	
	@Column(name="status")
	String status;
	
	
	
	public PassengerDetails() {}
	
	public PassengerDetails(int passengerId, String passengerName, long passengerPhone, int passengerAge,long passengerSsn,int bookingId, int seat_row,int seat_column,String status) 
	{
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerPhone = passengerPhone;
		this.passengerAge = passengerAge;
		this.passengerSsn = passengerSsn;
		this.bookingId=bookingId;
		this.seat_row=seat_row;
		this.seat_column=seat_column;
		this.status=status;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public long getPassengerPhone() {
		return passengerPhone;
	}
	public void setPassengerPhone(long passengerPhone) {
		this.passengerPhone = passengerPhone;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public long getPassengerSsn() {
		return passengerSsn;
	}
	public void setPassengerSsn(long passengerSsn) {
		this.passengerSsn = passengerSsn;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getSeat_row() {
		return seat_row;
	}

	public void setSeat_row(int seat_row) {
		this.seat_row = seat_row;
	}

	public int getSeat_column() {
		return seat_column;
	}

	public void setSeat_column(int seat_column) {
		this.seat_column = seat_column;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
