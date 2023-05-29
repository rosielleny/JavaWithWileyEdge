package com.rosie.numlength;

public class LengthFinder {
	
	private long number;
	public int counter = 0;
	
	
	public void setNumber(long number) {
		
		this.number = number;
	}
	
	public int getLength() {
		
		counter = calculateLength();
		
		return counter;
	}
	
	private int calculateLength() {
		
		for(long i = number; i != 0; i/=10) {
			
			counter += 1;
		}
		
		return counter;
	}

}
