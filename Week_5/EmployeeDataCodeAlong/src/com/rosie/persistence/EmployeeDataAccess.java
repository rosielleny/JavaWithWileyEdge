package com.rosie.persistence;

import java.util.LinkedList;
import java.io.BufferedReader;

import com.rosie.dto.Employee;

public interface EmployeeDataAccess {

	public boolean writeRecords(LinkedList<Employee> employees)throws Exception;
	
}