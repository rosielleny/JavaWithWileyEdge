package com.rosie.dvdlib.client;

import java.util.Scanner;

import com.rosie.dvdlib.ui.*;

public class Client {

	public static void main(String[] args) {
		UserInterfaceImpl dvdUserInterface=new UserInterfaceImpl();
		Scanner scanner=new Scanner(System.in);
		while(true) {
			dvdUserInterface.showMenu();
			System.out.println("Enter Choice: ");
			int choice = scanner.nextInt();
			dvdUserInterface.performMenu(choice);
		}
	}
}

