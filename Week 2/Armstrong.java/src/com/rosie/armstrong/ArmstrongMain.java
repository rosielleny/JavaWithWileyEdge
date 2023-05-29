package com.rosie.armstrong;

import java.util.Scanner;

import com.rosie.numlength.LengthFinder;

public class ArmstrongMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Armstrong armstr = new Armstrong();
		
		System.out.println("Enter a number to find out if it is an armstrong number: ");
		
		long num = sc.nextLong();
		
		armstr.setNumber(num);
		
		boolean isArm = armstr.getResult();
		
		if(isArm) {
			
			System.out.println(num+" is an armstrong number.");
		}
		else {
			
			System.out.println(num+ " is not an armstrong number.");
		}

	}

}
