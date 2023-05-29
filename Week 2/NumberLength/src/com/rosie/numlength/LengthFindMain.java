package com.rosie.numlength;

import java.util.Scanner;

public class LengthFindMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		LengthFinder lengthFinder = new LengthFinder();
		
		System.out.println("Enter a number to count its digits: ");
		
		long num = sc.nextLong();
		
		lengthFinder.setNumber(num);
		
		int length = lengthFinder.getLength();
		
		System.out.println("You number is "+length+" digits long.");
		
		

	}

}
