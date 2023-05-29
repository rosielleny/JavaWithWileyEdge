package com.rosie.peb;

	public class Employee extends Person{
		
		private String empDesig;
		private String empDept;
		private int empSalary;
		
		public Employee(String personName, int personId, String empDesig, String empDept, int empSalary) {
			super(personName, personId);
			this.empDept = empDept;
			this.empDesig = empDesig;
			this.empSalary = empSalary;
		}
		
		public String getEmpDesig() {
			return empDesig;
		}
		public void setEmpDesig(String empDesig) {
			this.empDesig = empDesig;
		}
		public String getEmpDept() {
			return empDept;
		}
		public void setEmpDept(String empDept) {
			this.empDept = empDept;
		}
		public int getEmpSalary() {
			return empSalary;
		}
		public void setEmpSalary(int empSalary) {
			this.empSalary = empSalary;
		}
		
	
		public void inputEmployee(String personName, int personId, String empDesig, String empDept, int empSalary) {
		    setPersonName(personName);
		    setPersonId(personId);
		    this.empDesig = empDesig;
		    this.empDept = empDept;
		    this.empSalary = empSalary;
		}
		
		public void displayEmployee() {
			
			String name = getPersonName();
			int id = getPersonId();
			
			System.out.println("Name: "+name);
			System.out.println("ID: "+ id);
			System.out.println("Designation: " + empDesig);
			System.out.println("Deoartment: "+ empDept);
			System.out.println("Salary: " +empSalary);
		}
		

	}


