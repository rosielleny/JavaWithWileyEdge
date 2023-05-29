package com.rosie.armstrong;

import com.rosie.numlength.*;

public class Armstrong {
	
	public boolean result;
	private int length;
	private long number;
	
	public void setNumber(long number) {
		
		this.number = number;
	}
	
	public boolean getResult() {
		
		result = checkArmstrong(number);
		return result;
	}
	
	private boolean checkArmstrong(long number) {
		
		LengthFinder lengthFinder = new LengthFinder();
		
		lengthFinder.setNumber(number);
		length = lengthFinder.getLength();
		
		long temp = number;
		long sum = 0;
		
		while (temp > 0) {
			int digit = (int) (temp % 10);
			sum += Math.pow(digit, length);
			temp /= 10;
		}
		
		return number == sum;
	}

}
