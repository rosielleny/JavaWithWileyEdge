package com.rosie.tests;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import com.rosie.service.*;
import com.rosie.dto.Item;
import com.rosie.dto.*;

public class ChangeTest {
	
	private Change change;

	@Before
	public void setup() {
		change = new Change();
	}

	@Test
	public void testCalculateChangeInPennies() {
		BigDecimal pennies = BigDecimal.valueOf(2.50); // Creating test money
		Item chosenItem = new Item("Item A", BigDecimal.valueOf(1.99), 1); // Creating test item
		
		BigDecimal expectedChange = BigDecimal.valueOf(51); // Should give 51 pennies change
		BigDecimal actualChange = change.calculateChangeInPennies(pennies, chosenItem);
		
		assertEquals(expectedChange, actualChange);
	}
	
	@Test
	public void testCalculateChange() {
		BigDecimal changeInPennies = BigDecimal.valueOf(51);
		
		change.calculateChange(changeInPennies);
		
		int expectedQuarters = 2; // 51 pennies change shoult be 2*25
		int expectedDimes = 0;
		int expectedNickels = 0;
		int expectedPennies = 1; // and 1*1
		
		assertEquals(expectedQuarters, change.getQuarters());
		assertEquals(expectedDimes, change.getDimes());
		assertEquals(expectedNickels, change.getNickles());
		assertEquals(expectedPennies, change.getPennies());
	}
}
