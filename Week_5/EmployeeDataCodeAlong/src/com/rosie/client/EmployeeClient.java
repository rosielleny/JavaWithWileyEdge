package com.rosie.client;

import java.util.Scanner;

import com.rosie.presentation.EmployeeUserInterface;
import com.rosie.presentation.EmployeeUserInterfaceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class EmployeeClient {

	public static void main(String[] args) {
		//EmployeeUserInterface employeeUserInterface=new EmployeeUserInterfaceImpl();
		//ApplicationContext springContainer=new ClassPathXmlApplicationContext("employee.xml");
		//EmployeeUserInterface employeeUserInterface=(EmployeeUserInterface)springContainer.getBean("userInterface");
		
		AnnotationConfigApplicationContext springContainer=new AnnotationConfigApplicationContext();
		springContainer.scan("com.rosie");
		springContainer.refresh();
		
		Scanner scanner=new Scanner(System.in);
		EmployeeUserInterface employeeUserInterface =(EmployeeUserInterface)springContainer.getBean("ui");
		while(true) {
			
			employeeUserInterface.showMenu();
			
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			
			employeeUserInterface.performMenu(choice);
			
		}

	}

}
