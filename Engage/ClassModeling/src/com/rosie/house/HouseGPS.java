package com.rosie.house;

public class HouseGPS {
	
	private int number;
	private String street;
	private String town;
	private String postcode;
	
	public HouseGPS(int number, String street, String town, String postcode) {
		this.number = number;
		this.street = street;
		this.town = town;
		this.postcode = postcode;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public void displayHouseGPS() {
		
		System.out.println(number+" " +street+ "\n"+town+"\n"+postcode);
	}
	

}
