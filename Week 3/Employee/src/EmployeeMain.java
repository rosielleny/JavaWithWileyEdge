
public class EmployeeMain {

	public static void main(String[] args) {
		
		// Constructor 1: Employee name alone
		
		Employee emp1 = new Employee("John Smith");
		
		// Constructor 2: Employee name and id
		
		Employee emp2 = new Employee("Jane Doe", 1234);
		
		// Constructor 3: Employee name, id and age
		
		Employee emp3 = new Employee("Rosie Young", 2345, 26);
		
		// Constructor 4: Employee name, id and designation
		
		Employee emp4 = new Employee("Emily Williams", 9012, "Manager");
		
		// Constructor 5: Employee name, id, age and designation
		
		Employee emp5 = new Employee("David Brown", 3456, 35, "Supervisor");
		   
		// Constructor 6: Employee name, id, location and age
		
		Employee emp6 = new Employee("Sarah Davis", 7890, "New York", 28);
		
		// Constructor 7: Employee name, id, experience, and age
		
		Employee emp7 = new Employee("Robert Wilson", 2345, 8, 40);
		
		// Constructor 8: Employee experience, name, id, and designation
		
		Employee emp8 = new Employee(5, "Jennifer Lee", 6789, "Engineer");
		
		// Constructor 9: Employee experience, name, id, designation, location 
		
		Employee emp9 = new Employee(3, "Daniel Taylor", 1234, "Analyst", "London");
		
		// Constructor 10: Employee experience, name, id, designation, location and age
		
		Employee emp10 = new Employee(10, "Olivia Johnson", 5678, "Manager", "Paris", 32);
		
        System.out.println("Name: "+ emp1.empName);
        System.out.println("Name: "+ emp2.empName + " - " +" ID: " +emp2.empId);
        System.out.println("Name: "+emp3.empName + " - " + " ID: " +emp3.empId + " - " + "Age: "+emp3.empAge);
        System.out.println("Name: "+emp4.empName + " - " + " ID: " +emp4.empId + " - " + "Designation: "+emp4.empDesgn);
        System.out.println("Name: "+emp5.empName + " - " + " ID: " +emp5.empId + " - " + "Age: "+emp5.empAge + " - " + "Designation: "+emp5.empDesgn);
        System.out.println("Name: "+emp6.empName + " - " + " ID: " +emp6.empId + " - " + "Age: "+emp6.empAge + " - " + "Location: "+emp6.empLocation);
        System.out.println("Name: "+emp7.empName + " - " + " ID: " +emp7.empId + " - " + "Age: "+emp7.empAge + " - " + "Experience: "+ emp7.empExpInYrs);
        System.out.println("Name: "+emp8.empName + " - " + " ID: " +emp8.empId + " - " + "Designation: "+emp8.empDesgn + " - " + "Experience: " +emp8.empExpInYrs);
        System.out.println("Name: "+emp9.empName + " - " + " ID: " +emp9.empId + " - " + "Designation: "+emp9.empDesgn + " - " + "Location: "+emp9.empLocation + " - " + "Experience: "+ emp9.empExpInYrs);
        System.out.println("Name: "+emp10.empName + " - " + " ID: " +emp10.empId + " - " + "Age: "+emp10.empAge + " - " + "Designation: "+emp10.empDesgn + " - " + "Location: "+emp10.empLocation + " - " + "Experience: "+ emp10.empExpInYrs);

	}

}
