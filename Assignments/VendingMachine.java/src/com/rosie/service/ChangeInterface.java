package com.rosie.service;

import java.math.BigDecimal;

import com.rosie.dto.*;

public interface ChangeInterface {
	
	public void calculateChange(BigDecimal changeInPennies);
    public BigDecimal calculateChangeInPennies(BigDecimal money, Item chosenItem);
    public int getQuarters();
    public int getDimes();
    public int getNickles();
    public int getPennies();
    
}
