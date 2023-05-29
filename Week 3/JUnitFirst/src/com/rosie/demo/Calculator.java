package com.rosie.demo;

public class Calculator {

	/*
	 * Requirement (R001)
	 * divide will divide two positive integers
	 * if number1 is negative : NegativeNumberException
	 * if number2 is negative : NegativeNumberException
	 * 
	 */
	public int divide(int number1,int number2)throws NegativeNumberException, AnArithmeticException {
		
	    if (number1 >= 0 && number2 >= 0) {
	        if (number2 != 0) {
	            return number1 / number2;
	        } else {
	            throw new AnArithmeticException("Division by zero is not allowed");
	        }
	    } else {
	        throw new NegativeNumberException("Number cannot be Negative");
	    }
	}
}

