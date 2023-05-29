package com.rosie.test;

import static org.junit.jupiter.api.Assertions.*;

import com.rosie.demo.AnArithmeticException;
import com.rosie.demo.Calculator;

import org.junit.jupiter.api.Test;
import com.rosie.demo.NegativeNumberException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class CalculatorTest {

	//refrence variable : null
	private Calculator calculator;
	
	@BeforeEach
	void setUp() throws Exception {
		//we created the object and now my reference variable is referring/pointing to that object on heap
		calculator=new Calculator();
	}

	@AfterEach
	void tearDown() throws Exception {
		//reference variable :null
		calculator=null;
	}

	@Test
	void r001T001() throws NegativeNumberException, AnArithmeticException {
		//assertEquals(expected,function call)
		assertEquals(6, calculator.divide(12, 2));
		
	}
	
	@Test
	void r001T002()throws NegativeNumberException{
		assertThrows(NegativeNumberException.class, ()->calculator.divide(-12, 2));
	}
	
	@Test
	void r001T003()throws NegativeNumberException{
		assertThrows(NegativeNumberException.class, ()->calculator.divide(12, -2));
	}

	@Test
	void r001T004()throws NegativeNumberException{
		assertThrows(NegativeNumberException.class, ()->calculator.divide(-12, -2));
	}
	@Test
	void r001T005() throws NegativeNumberException, AnArithmeticException {
		assertEquals(0, calculator.divide(0, 5));
	}
	

	@Test
	void r001T006()throws NegativeNumberException, AnArithmeticException{
		assertThrows(AnArithmeticException.class, ()->calculator.divide(5, 0));
	}
}