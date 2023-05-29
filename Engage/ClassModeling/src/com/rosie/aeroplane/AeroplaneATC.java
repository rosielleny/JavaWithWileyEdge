package com.rosie.aeroplane;

public class AeroplaneATC {
	
	private String flightNumber;
    private String currentLocation;
    private String destination;
    private int altitude;
    private int speed;
    private int heading;
    private int fuelLevel;
    private String status;
    private int passengerCount;
    private int crewCount;
    
  
	public AeroplaneATC(String flightNumber, String currentLocation, String destination, int altitude, int speed,
			int heading, int fuelLevel, String status, int passengerCount, int crewCount) {
		super();
		this.flightNumber = flightNumber;
		this.currentLocation = currentLocation;
		this.destination = destination;
		this.altitude = altitude;
		this.speed = speed;
		this.heading = heading;
		this.fuelLevel = fuelLevel;
		this.status = status;
		this.passengerCount = passengerCount;
		this.crewCount = crewCount;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getAltitude() {
		return altitude;
	}
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getHeading() {
		return heading;
	}
	public void setHeading(int heading) {
		this.heading = heading;
	}
	public int getFuelLevel() {
		return fuelLevel;
	}
	public void setFuelLevel(int fuelLevel) {
		this.fuelLevel = fuelLevel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPassengerCount() {
		return passengerCount;
	}
	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}
	public int getCrewCount() {
		return crewCount;
	}
	public void setCrewCount(int crewCount) {
		this.crewCount = crewCount;
	}
    

}
