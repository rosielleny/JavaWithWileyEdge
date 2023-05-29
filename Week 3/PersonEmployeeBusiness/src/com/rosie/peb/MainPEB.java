package com.rosie.peb;

public class MainPEB {

	public static void main(String[] args) {
		
		
		// Employee
		
		System.out.println("\nEmployee\n");
		
		Employee employee = new Employee("Jane Smith", 1234, "HR", "Manager", 60000);
	
		employee.displayEmployee();
		
		
		// Businessman 
		
		System.out.println("\nBusinessman\n");
		
		Business business = new Business("John Smith", 4321, "Tech", 20);
	
		business.displayBusiness();
	}

}
