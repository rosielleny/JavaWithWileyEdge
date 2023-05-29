package com.rosie.car;

public class CarAtDealer {
	
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;
    private String vin;
    private int mileage;
    private String status;
    
	public CarAtDealer(String make, String model, int year, String color, double price, String vin, int mileage,
			String status) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.price = price;
		this.vin = vin;
		this.mileage = mileage;
		this.status = status;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
    

}
