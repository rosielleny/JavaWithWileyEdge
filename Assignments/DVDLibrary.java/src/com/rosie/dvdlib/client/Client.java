package com.rosie.dvdlib.client;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rosie.dvdlib.ui.*;

public class Client {

	public static void main(String[] args) {
		//UserInterfaceImpl dvdUserInterface=new UserInterfaceImpl();
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("dvd.xml");
		UserInterfaceImpl userInterface = (UserInterfaceImpl)applicationContext.getBean("userInterface");
		Scanner scanner=new Scanner(System.in);
		while(true) {
			userInterface.showMenu();
			System.out.println("Enter Choice: ");
			int choice = scanner.nextInt();
			userInterface.performMenu(choice);
		}
	}
}

