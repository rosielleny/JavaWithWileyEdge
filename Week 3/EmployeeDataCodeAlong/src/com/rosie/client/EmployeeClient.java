package com.rosie.client;

import java.util.Scanner;

import com.rosie.presentation.EmployeeUserInterface;
import com.rosie.presentation.EmployeeUserInterfaceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeClient {

	public static void main(String[] args) {
		//EmployeeUserInterface employeeUserInterface=new EmployeeUserInterfaceImpl();
		ApplicationContext springContainer=new ClassPathXmlApplicationContext("employee.xml");
		EmployeeUserInterface employeeUserInterface=(EmployeeUserInterface)springContainer.getBean("userInterface");
		Scanner scanner=new Scanner(System.in);
		while(true) {
			employeeUserInterface.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			employeeUserInterface.performMenu(choice);
			
		}

	}

}
