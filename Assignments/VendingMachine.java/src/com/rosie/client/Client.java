package com.rosie.client;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.BigDecimal;
import com.rosie.ui.*;
public class Client {


	public static void main(String[] args) {
		UserInterfaceImpl userInterface=new UserInterfaceImpl();
		Scanner sc = new Scanner(System.in);
		boolean numBool = false;
		boolean numBool2 = false;
		int choice = 0;
		BigDecimal money = new BigDecimal(0);

			userInterface.showMenu();
			while(!numBool) {
				System.out.println("Insert money in $: ");
				System.out.print("$");
				try {
					money = new BigDecimal(sc.next());
					numBool = true;
					
				}catch(NumberFormatException e) {
					
					System.out.println("Please enter numbers only.");
					
				}
			
			while(!numBool2) {
	
				System.out.println("Enter Choice: ");
				try {
					choice = sc.nextInt();
					numBool2 = true;
				}catch(InputMismatchException e) {
					
					System.out.println("Please enter numbers only.");
					sc.nextLine();
				}
			}
			userInterface.performMenu(choice, money);
		
	
}
}
}