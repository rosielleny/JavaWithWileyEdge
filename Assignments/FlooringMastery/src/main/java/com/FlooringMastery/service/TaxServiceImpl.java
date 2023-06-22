package com.FlooringMastery.service;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.FlooringMastery.dao.ProductDaoImpl;
import com.FlooringMastery.dao.TaxDaoImpl;
import com.FlooringMastery.dto.Tax;

import jakarta.annotation.PostConstruct;
@Component
public class TaxServiceImpl implements TaxService {
	
	private TaxDaoImpl dao;
	public Map<String, Tax> taxMap;
	
	// Spring section
	public TaxServiceImpl(TaxDaoImpl dao){
		this.dao = dao;
	}
	
	@PostConstruct
    public void init() throws Exception {
        this.taxMap = dao.loadAllTaxRates();
    }
	// End spring section
	
	// Default constructor - useful in unit tests
	public TaxServiceImpl() {}
	
	@Override
	public String getStateAbbrev(String stateAbbrev) {
		// TODO Auto-generated method stub
		return null;
	}

	// Rosie's Section

	/*
	 * Function to check the user's choice of state is valid. Will check both the abbreviation
	 * and the name, so both CA and California should work
	 */
	@Override
	public boolean checkState(String state) throws DataValidationException{

		for (Tax taxObj : taxMap.values()) {
			if (state.equalsIgnoreCase(taxObj.getStateAbbrev()) || state.equalsIgnoreCase(taxObj.getStateName())) {
				return true;
			}
		}

		throw new DataValidationException("State choice not available.");
	}

	@Override
	public BigDecimal findTaxRate(String state) {
		state = assignStateValue(state);
		Tax taxObject = taxMap.get(state);
		return taxObject.getTaxRate();

	}


	/*The State must be stored as an abbreviation, so this function changes user input to the abbreviation
	 * if it wasn't before, but leaves it as is otherwise.
	 */
	public String assignStateValue(String state) {
		
		for (Tax tax : taxMap.values()) {
			if (state.equalsIgnoreCase(tax.getStateName()) || state.equalsIgnoreCase(tax.getStateAbbrev())) {
				return tax.getStateAbbrev();
			}
		}
		return state;

		// End Rosie's Section

	}

}
