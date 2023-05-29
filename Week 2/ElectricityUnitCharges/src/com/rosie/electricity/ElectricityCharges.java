package com.rosie.electricity;

public class ElectricityCharges {
	
	public double bill = 0.0;
	private int units;
	
	
	
	public void setUnits(int units) {
		
		this.units = units;
	}
	
	public double getBill() {
		
		bill = calculateBill();
		
		return bill;
	}
	
	private double calculateBill() {
		
	    if (units > 250) { // Eg. If the person has used 300 units we start with this statement to calculate the first49
	        for (; units > 250; units--) { // First 50 units costs £75, now units = 250
	            bill += 1.5; 
	        }
	    }
	    if (units > 150) { 
	        for (; units > 150; units--) {
	            bill += 1.2; // Next 100 units cost £120, now units = 150
	        }
	    }
	    if (units > 50) {
	        for (; units > 50; units--) {
	            bill += 0.75; // Next 100 units cost £75, now units = 50
	        }
	    }
	    if (units > 0) {
	        for (; units > 0; units--) {
	            bill += 0.5; // Final 50 units cost £25, now units = 0
	        }	// bill currently = £75 + £120 + £75 + £25 = £295
	    }
	    
	    bill = bill + bill/5; // Adding the 20% surcharge
	    bill = Math.round(bill * 100.0)/100.0;
	    return bill; // Bill now = £295 + £59 = £354
	}
		

	}

