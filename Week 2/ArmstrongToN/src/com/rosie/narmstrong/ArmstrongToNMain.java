package com.rosie.narmstrong;

import java.util.Scanner;

import java.util.Scanner;

public class ArmstrongToNMain {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		ArmstrongToN armstr = new ArmstrongToN();
		
		System.out.println("Enter a number to find all armstrong numbers between it and 1: ");
		
		long num = sc.nextLong();
		
		armstr.setNth(num);
		
		 long arms[] = armstr.getArmstrongs();
		
		
		 System.out.println("The armstrong numbers between 0 and "+num+" are: ");
		 
		 for (long armstrong : arms) {
	            System.out.println(armstrong);
		}


	}
}


