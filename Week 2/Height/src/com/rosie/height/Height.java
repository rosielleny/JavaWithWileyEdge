package com.rosie.height;

public class Height {

	
	private int feet, inches;

	public int getFeet() {
		
		correct();
		return feet;
	}

	public void setFeet(int feet) {
		this.feet = feet;
	}

	public int getInches() {
		
		correct();
		return inches;
	}

	public void setInches(int inches) {
		this.inches = inches;
	}
	
	public String getHeight() {
		
		return getFeet() + "\'"+getInches()+"\"";
	}
	
	
	private void correct() {
		
		feet = feet + inches/12;
		inches = inches%12;
		
		}
	}



