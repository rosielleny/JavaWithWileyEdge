package com.rosie.car;

public class CarVideoGame {
	
    private String make;
    private String model;
    private String color;
    private int topSpeed;
    private int acceleration;
    
    
	public CarVideoGame(String make, String model, String color, int topSpeed, int acceleration) {
		super();
		this.make = make;
		this.model = model;
		this.color = color;
		this.topSpeed = topSpeed;
		this.acceleration = acceleration;
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getTopSpeed() {
		return topSpeed;
	}
	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}
	public int getAcceleration() {
		return acceleration;
	}
	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}
    
    

}
