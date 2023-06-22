package com.FlooringMastery.service.test;
import com.FlooringMastery.service.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;


public class AddOrderServiceTests {

	OrderServiceImpl order;
	TaxServiceImpl tax;

	@BeforeEach
	void setUp() {

		order = new OrderServiceImpl();
		tax = new TaxServiceImpl();
	}


	@Test
	public void testCheckName_ValidName() {
		String name = "Acme Inc.";
		boolean isValid = false;
		try {
			isValid = order.checkName(name);
		} catch (DataValidationException e) {
			isValid = false;
		}
		assertTrue(isValid);
	}

	@Test
	public void testCheckName_NullName() {
		String name = null;
		boolean isValid;
		try {
			isValid = order.checkName(name);
		} catch (DataValidationException e) {
			isValid = false;
		}
		assertFalse(isValid);
	}

	@Test
	public void testCheckName_InvalidCharacters() {
		String name = "Acme£$@";
		boolean isValid;
		try {
			isValid = order.checkName(name);
		} catch (DataValidationException e) {
			isValid = false;
		}
		assertFalse(isValid);
	}

	@Test
	public void testCheckDate_ValidDate() {
		String dateString = "01/09/2025";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate date = LocalDate.parse(dateString, formatter);
		boolean isValid;
		try {
			isValid = order.checkDate(date);
		} catch (DataValidationException e) {
			isValid = false;
		}
		assertTrue(isValid);
	}

	@Test
	public void testCheckDate_PastDate() {
		String dateString = "01/09/2022";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate date = LocalDate.parse(dateString, formatter);
		boolean isValid;
		try {
			isValid = order.checkDate(date);
		} catch (DataValidationException e) {
			isValid = false;
		}
		assertFalse(isValid);
	}


// Further tests require use of Mockito or Spring boot
	

}
