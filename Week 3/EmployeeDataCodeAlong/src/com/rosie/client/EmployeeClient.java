package com.rosie.client;

import java.util.Scanner;

import com.rosie.presentation.EmployeeUserInterface;
import com.rosie.presentation.EmployeeUserInterfaceImpl;

public class EmployeeClient {

	public static void main(String[] args) {
		EmployeeUserInterface employeeUserInterface=new EmployeeUserInterfaceImpl();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			employeeUserInterface.showMenu();
			System.out.println("Enter Choice : ");
			int choice=scanner.nextInt();
			employeeUserInterface.performMenu(choice);
			
		}

	}

}
