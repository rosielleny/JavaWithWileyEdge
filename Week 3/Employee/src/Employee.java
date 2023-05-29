
public class Employee {
	
	String empName;
	int empId;
	int empAge;
	String empDesgn;
	String empLocation;
	int empExpInYrs;
	
	
	// Constructor 1: employee name alone
	
	public Employee(String empName){
        this.empName = empName;
    }
	
	// Constructor 2: employee name and id
	
	public Employee(String empName, int empId) {
		this.empName = empName;
		this.empId = empId;
	}
	
	// Constructor 3: employee name, id and age
	
	public Employee(String empName, int empId, int empAge) {
		this.empName = empName;
		this.empId = empId;
		this.empAge = empAge;
		
	}
	
	// Constructor 4: employee name, id and designation
	
	public Employee(String empName, int empId, String empDesgn) {
		this.empName = empName;
		this.empId = empId;
		this.empDesgn = empDesgn;

	}
	
	// Constructor 5: employee name, id, age, and designation
	
	public Employee(String empName, int empId, int empAge, String empDesgn) {
		this.empName = empName;
		this.empId = empId;
		this.empAge = empAge;
		this.empDesgn = empDesgn;
	}
	
	// Constructor 6: employee name, id, age and location
	
	public Employee(String empName, int empId, String empLocation, int empAge) {
		this.empName = empName;
		this.empId = empId;
		this.empAge = empAge;
		this.empLocation = empLocation;
	}
	
	// Constructor 7: Employee name, id, experience, and age
	
	public Employee(String empName, int empId, int empExpInYrs, int empAge) {
		this.empName = empName;
		this.empId = empId;
		this.empAge = empAge;
		this.empExpInYrs = empExpInYrs;
	}
	
	// Constructor 8: Employee name, id, designation and experience
	
	public Employee(int empExpInYrs, String empName, int empId, String empDesgn) {
		this.empName = empName;
		this.empId = empId;
		this.empDesgn = empDesgn;
		this.empExpInYrs = empExpInYrs;
	}
	
	// Constructor 9: Employee name, id, designation, location and experience
	
		public Employee(int empExpInYrs, String empName, int empId, String empDesgn, String empLocation) {
			this.empName = empName;
			this.empId = empId;
			this.empDesgn = empDesgn;
			this.empExpInYrs = empExpInYrs;
			this.empLocation = empLocation;
		}
		
	// Constructor 10: Employee name, id, age, designation, location and experience
		
		public Employee(int empExpInYrs, String empName, int empId, String empDesgn, String empLocation, int empAge) {
			this.empName = empName;
			this.empId = empId;
			this.empDesgn = empDesgn;
			this.empExpInYrs = empExpInYrs;
			this.empLocation = empLocation;
			this.empAge = empAge;
			}
		
}

