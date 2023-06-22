package com.FlooringMastery.service;

import java.math.BigDecimal;

public interface TaxService {


	public boolean checkState(String state) throws DataValidationException, Exception;
	public BigDecimal findTaxRate(String state);
	public String assignStateValue(String state) throws Exception;
	public String getStateAbbrev(String stateAbbrev);
	

}