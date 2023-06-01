package com.rosie.demo;

import java.util.Arrays;
import java.util.List;

public class EmployeeStreamsMain {

	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(new Employee(101, "AAAA", "Sales", "Executive", 78000),
				new Employee(102, "BBBB", "IT", "Associate", 67000), new Employee(103, "CCCC", "Sales", "Associate", 0),
				new Employee(104, "DDDD", "IT", "Manager", 0), new Employee(105, "EEEE", "HR", "Executive", 0),
				new Employee(104, "FFFF", "Sales", "Manager", 0), new Employee(105, "GGGG", "HR", "Executive", 0),
				new Employee(104, "BHHH", "Sales", "Manager", 0), new Employee(105, "IIII", "Sales", "Executive", 0));

		System.out.println("Total No of Employees working in sales department : "
				+ empList.stream().filter(employee -> employee.getDepartment().equals("Sales")).count());

		empList.stream().filter(employee -> employee.getDesignation().equals("Executive"))
				.forEach(employee -> System.out.println(employee.getEmpName()));
		System.out.println("============");

		empList.stream().filter(employee -> employee.getDesignation().equals("Executive"))
				.map(employee -> employee.getEmpName()).forEach(name -> System.out.println(name));
		System.out.println("=====================");
		empList.stream()
		.map(employee -> employee.getDepartment())
		.distinct()
		.forEach(deptt -> System.out.println(deptt));
		
		System.out.println("=====================");
		
		long managerCount = empList.stream()
		.filter(employee -> employee.getDepartment().equals("Sales") && employee.getDesignation().equals("Manager"))
		.count();
		
		System.out.println("Total number of managers working in the sales department: " + managerCount);
		
		System.out.println("=====================");
		
		empList.stream()
		.filter(employee -> employee.getEmpName().startsWith("B"))
		.forEach(empB -> System.out.println(empB));
	}

}