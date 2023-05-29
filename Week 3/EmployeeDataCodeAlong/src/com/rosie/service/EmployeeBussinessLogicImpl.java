package com.rosie.service;

import java.util.LinkedList;

import com.rosie.exception.EmployeeNotFound;

import com.rosie.dto.Employee;
import com.rosie.persistence.EmployeeDataAccess;
import com.rosie.persistence.EmployeeDataAccessImpl;

public class EmployeeBussinessLogicImpl implements EmployeeBussinessLogic {

	
	private EmployeeDataAccess dataAccess=new EmployeeDataAccessImpl();
	
	private LinkedList<Employee> employeeList;
	
	public EmployeeBussinessLogicImpl() {
		try {
			employeeList=dataAccess.readRecords();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public LinkedList<Employee> getAllEmployees() {
		
		return employeeList;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		
		return employeeList.add(employee);
	}

	@Override
	public boolean deleteEmployee(int id) {
		for(Employee employee:employeeList) {
			if(id==employee.getEmpId())
				return employeeList.remove(employee);
		}
		return false;
	}
	
	public Employee searchEmployee(int id) throws EmployeeNotFound {
	    for (Employee employee : employeeList) {
	        if (id == employee.getEmpId())
	            return employee;
	    }
	    throw new EmployeeNotFound("Employee with ID " + id + " not found");
	}
	
	public void saveAllEmployees() {
		try {
			dataAccess.writeRecords(employeeList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}