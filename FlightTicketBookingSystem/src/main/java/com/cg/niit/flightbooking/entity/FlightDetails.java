package com.cg.niit.flightbooking.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="flightNumber")
public class FlightDetails
{
	@Id
	@Column(name="flight_number")
	int flightNumber;
	
	@Column(name="flight_company_name")
	String flightCompanyName;
	
	@Column(name="rows")
	int noOfRows;
	
	@Column(name="columns")
	int noOfColumns;
	
	@OneToOne(cascade=CascadeType.REMOVE,mappedBy="flightdetails")
	FlightSchedule flightschedule;
	
	public FlightDetails() {}
	
	public FlightDetails(int flightNumber, String flightCompanyName, int noOfRows, int noOfColumns)
	{
		this.flightNumber = flightNumber;
		this.flightCompanyName = flightCompanyName;
		this.noOfRows = noOfRows;
		this.noOfColumns = noOfColumns;
	}
	
	public int getFlightNumber() {
		return flightNumber;
	}
	
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public String getFlightCompanyName() {
		return flightCompanyName;
	}
	
	public void setFlightCompanyName(String flightCompanyName) {
		this.flightCompanyName = flightCompanyName;
	}
	
	public int getNoOfRows() {
		return noOfRows;
	}
	
	public void setNoOfRows(int noOfRows) {
		this.noOfRows = noOfRows;
	}
	
	public int getNoOfColumns() {
		return noOfColumns;
	}
	
	public void setNoOfColumns(int noOfColumns) {
		this.noOfColumns = noOfColumns;
	}

	public FlightSchedule getFlightschedule() {
		return flightschedule;
	}

	public void setFlightschedule(FlightSchedule flightschedule) {
		this.flightschedule = flightschedule;
	}
	
	
}
