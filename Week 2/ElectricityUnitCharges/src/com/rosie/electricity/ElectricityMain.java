package com.rosie.electricity;

import java.util.Scanner;
public class ElectricityMain {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		ElectricityCharges lecky = new ElectricityCharges();
		
		System.out.println("Enter units of electricity used:");
		
		int units = sc.nextInt();
		
		lecky.setUnits(units);
		
		double bill = lecky.getBill();
		
		System.out.println("Bill: £"+bill);

	}

}
