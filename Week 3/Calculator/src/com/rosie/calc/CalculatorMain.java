package com.rosie.calc;

public class CalculatorMain {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();

        // Using int parameters
		
		 System.out.println("");
        calculator.add(5, 3);
        calculator.diff(10, 4);
        calculator.mul(7, 2);
        calculator.div(15, 5);
        
        // Using double parameters
        
        System.out.println("");
        calculator.add(2.5, 1.3);
        calculator.diff(7.8, 3.2);
        calculator.mul(3.5, 2.2);
        calculator.div(10.0, 2.5);
        
        // Using mixed int and double parameters
        
        System.out.println("");
        calculator.add(4, 2.7);
        calculator.diff(9.6, 5);
        calculator.mul(6, 3.2);
        calculator.div(12.5, 2);

	}

}
