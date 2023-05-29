package com.rosie.service;

import java.util.LinkedList;

import com.rosie.dto.Employee;
import com.rosie.exception.EmployeeNotFound;

public interface EmployeeBussinessLogic {

	LinkedList<Employee> getAllEmployees();
	boolean addEmployee(Employee employee);
	boolean deleteEmployee(int id);
	public void saveAllEmployees();
	public Employee searchEmployee(int id) throws EmployeeNotFound;
}