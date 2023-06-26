package com.rosie.dvdlib.client;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.rosie.dvdlib.ui.UserInterfaceImpl;

@SpringBootApplication
@ComponentScan(basePackages = "com.rosie.dvdlib.*")
public class DvdClient {

	public static void main(String[] args) {
		
		ApplicationContext springContainer = SpringApplication.run(DvdClient.class, args);
		UserInterfaceImpl dvdUI =(UserInterfaceImpl)springContainer.getBean("dvdUI");
		Scanner  scanner=new Scanner(System.in);
		while(true) {
			dvdUI.showMenu();
			System.out.println("Enter Choice: ");
			int choice = scanner.nextInt();
			dvdUI.performMenu(choice);
		}

	}

}
