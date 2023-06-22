package com.FlooringMastery.dto;

import java.math.BigDecimal;

public class Tax {

    private String stateAbbrev;
    private String stateName;
    private BigDecimal taxRate;

    public Tax(String stateAbbrev, String stateName, BigDecimal taxRate) {
        this.stateAbbrev = stateAbbrev;
        this.stateName = stateName;
        this.taxRate = taxRate;
    }

    public String getStateAbbrev() {
        return stateAbbrev;
    }

    public void setStateAbbrev(String stateAbbrev) {
        this.stateAbbrev = stateAbbrev;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
}
