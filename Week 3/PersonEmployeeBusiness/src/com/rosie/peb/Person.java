package com.rosie.peb;

public class Person {
	
	private int personId;
	private String personName;
	
	public Person(String personName, int personId) {
		this.personName = personName;
	    this.personId = personId;
	}
	
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public void displayPerson() {
		
		System.out.println("ID: "+ personId);
		System.out.println("Name: "+personName);
	}
	

}
