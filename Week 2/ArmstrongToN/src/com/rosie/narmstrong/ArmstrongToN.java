package com.rosie.narmstrong;

import com.rosie.armstrong.*;;

public class ArmstrongToN {

	public long armstrongs[];
	private long nthNumber;
	private int index = 0;
	
	
	public void setNth(long nthNumber) {
		
		this.nthNumber = nthNumber;
	}
	
	public long[] getArmstrongs() {
		
		calculateArmstrongs();
		
		return armstrongs;
		
		
		
	}
	
	private long[] calculateArmstrongs() {
		
	    
		Armstrong armstr = new Armstrong();

	    for (long i = 1; i <= nthNumber; i++) {
	        armstr.setNumber(i);
	        if (armstr.getResult()) {
	            index++;
	        }
	    }

	    armstrongs = new long[index];
	    index = 0;
	    
	    for (long i = 1; i <= nthNumber; i++) {
	        armstr.setNumber(i);
	        if (armstr.getResult()) {
	            armstrongs[index] = i;
	            index++;
	        }
	    }

	    return armstrongs;
	}

		

	}

