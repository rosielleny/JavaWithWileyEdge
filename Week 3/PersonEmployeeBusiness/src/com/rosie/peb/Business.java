package com.rosie.peb;

public class Business extends Person {
	
	private String businessNature;
	private int annualTurnover;
	
	public Business(String personName, int personId, String businessNature, int annualTurnover) {
		
		super(personName, personId);
		this.businessNature = businessNature;
		this.annualTurnover = annualTurnover;
	}
	
	public String getBusinessNature() {
		return businessNature;
	}
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}
	public int getAnualTurnover() {
		return annualTurnover;
	}
	public void setAnnualTurnover(int annualTurnover) {
		this.annualTurnover = annualTurnover;
	} 
	
	public void inputBusiness(String personName, int personId, String businessNature, int annualTurnover) {
	    setPersonName(personName);
	    setPersonId(personId);
	    setBusinessNature(businessNature);
	    setAnnualTurnover(annualTurnover);
	}
	public void displayBusiness() {
		
		String name = getPersonName();
		int id = getPersonId();
		
		System.out.println("Name: "+name);
		System.out.println("ID: "+ id);
		System.out.println("Nature of Business: " + businessNature);
		System.out.println("Annual Turnover: "+ annualTurnover + "%");
	}

}
