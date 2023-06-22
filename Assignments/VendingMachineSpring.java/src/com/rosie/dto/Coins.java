package com.rosie.dto;

public enum Coins {
	
	QUARTERS(25), DIMES(10), NICKLES(5), PENNIES(1);
	
	private int value;
	
	private Coins(int value) {
	
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}

