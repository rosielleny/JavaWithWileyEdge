package com.rosie.height;

import java.util.Scanner;

public class HeightMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Height height = new Height();
		
		System.out.println("Enter feet: ");
		
		int feet = sc.nextInt();
		
		height.setFeet(feet);
		
		System.out.println("Enter inches: ");
		
		int inches = sc.nextInt();
		
		height.setInches(inches);
		
		String theHeight = height.getHeight();
		
		System.out.println("Height is: "+theHeight);

	}

}
