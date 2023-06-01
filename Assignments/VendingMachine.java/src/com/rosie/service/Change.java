package com.rosie.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.rosie.dto.*;

public class Change implements ChangeInterface{
	
	private int quarters;
    private int dimes;
    private int nickles;
    private int pennies;
    private int changeCoins;
	
    
    @Override
    
    public BigDecimal calculateChangeInPennies(BigDecimal pennies, Item chosenItem) {
    	
    	pennies = pennies.multiply(BigDecimal.valueOf(100));
    	
    	BigDecimal cost = chosenItem.getPrice().multiply(BigDecimal.valueOf(100));
    	
    	pennies = pennies.subtract(cost);
    	pennies = pennies.setScale(0, RoundingMode.DOWN);
    	
    	return pennies;
    }
    
    @Override
    public void calculateChange(BigDecimal changeInPennies) {
    	
        BigDecimal remainingChange = changeInPennies;

        BigDecimal quartersValue = new BigDecimal(Coins.QUARTERS.getValue());
        quarters = remainingChange.divideToIntegralValue(quartersValue).intValue();
        remainingChange = remainingChange.remainder(quartersValue);

        BigDecimal dimesValue = new BigDecimal(Coins.DIMES.getValue());
        dimes = remainingChange.divideToIntegralValue(dimesValue).intValue();
        remainingChange = remainingChange.remainder(dimesValue);

        BigDecimal nickelsValue = new BigDecimal(Coins.NICKLES.getValue());
        nickles = remainingChange.divideToIntegralValue(nickelsValue).intValue();
        remainingChange = remainingChange.remainder(nickelsValue);

        pennies = remainingChange.intValue();
    }
    
    @Override
    public int getQuarters() {
        return quarters;
    }

    @Override
    public int getDimes() {
        return dimes;
    }
    
    @Override
    public int getNickles() {
        return nickles;
    }
    
    @Override
    public int getPennies() {
        return pennies;
    }
}
