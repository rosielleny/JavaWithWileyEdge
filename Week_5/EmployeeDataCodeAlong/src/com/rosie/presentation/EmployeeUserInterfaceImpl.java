package com.rosie.presentation;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.LinkedList;
import com.rosie.exception.*;
import java.util.Scanner;

import com.rosie.dto.Employee;
import com.rosie.service.EmployeeBussinessLogic;
import com.rosie.service.EmployeeBussinessLogicImpl;

@Component("ui")
public class EmployeeUserInterfaceImpl implements EmployeeUserInterface {

	 private EmployeeBussinessLogic bussinessLogic;
	 	@Autowired 
	    public void setBussinessLogic(EmployeeBussinessLogic bussinessLogic) {
	        this.bussinessLogic = bussinessLogic;
	    }
	
	@Override
	public void showMenu() {
		System.out.println("1. List All Employees");
		System.out.println("2. Add New Employee");
		System.out.println("3. Delete Existing Employee");
		System.out.println("4. Search Employee");
		System.out.println("5. Exit");

	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner=new Scanner(System.in);
		switch (choice) {
		case 1: 
			LinkedList<Employee> employees;
			try {
				employees = bussinessLogic.getAllEmployees();
				for(Employee employee:employees) {
					System.out.println(employee);}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			break;
		case 2:
			Employee employee=new Employee();
			System.out.println("Enter Employee ID : ");
			employee.setEmpId(scanner.nextInt());
			scanner.nextLine();
			System.out.println("Enter Employee Name : ");
			employee.setEmpName(scanner.nextLine());
			System.out.println("Enter Employee Designation : ");
			employee.setEmpDesignation(scanner.nextLine());
			System.out.println("Enter Employee Department : ");
			employee.setEmpDepartment(scanner.nextLine());
			System.out.println("Enter Employee Salary : ");
			employee.setEmpSalary(scanner.nextDouble());
			
			boolean status=bussinessLogic.addEmployee(employee);
			
			if(status)
				System.out.println("Employee Added!");
			else
				System.out.println("Employee Not Added!");
			break;
		case 3:
			System.out.println("Enter Employee ID whoes record you want to delete : ");
			int id=scanner.nextInt();
			if(bussinessLogic.deleteEmployee(id))
				System.out.println("Record Deleted");
			else
				System.out.println("Employee with id "+id+" does not exist");
			break;
			
		case 4:
		    System.out.println("Enter Employee ID whose record you want to find: ");
		    int id1 = scanner.nextInt();
		    try {
		    	Employee foundEmployee = bussinessLogic.searchEmployee(id1);
		        System.out.println("Employee found:");
		        System.out.println(foundEmployee);
		    }
		    catch(EmployeeNotFound e) {
		        System.out.println(e.getMessage());
		    }
		    
		    break;
			
		case 5:
			bussinessLogic.saveAllEmployees();
			System.out.println("Thanks for Using Employee Management System");
			System.exit(0);
			
		default:
			System.out.println("Invalid Choice");
		}

	}

}