package com.rosie.tests;
import com.rosie.dataaccess.*;
import static org.junit.jupiter.api.Assertions.*;
import com.rosie.dto.Item;
import java.math.BigDecimal;
import java.util.LinkedList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestItemDAO {
	
	private ItemDAO itemDAO;
	private LinkedList<Item> items;

	@BeforeEach
	void setUp() throws Exception {
		// Initialising the ItemDAOImpl and creating a mock list for testing
		itemDAO = new ItemDAOImpl(); 
		items = new LinkedList<>();
		items.add(new Item("Item 1", new BigDecimal("1.99"), 5));
		items.add(new Item("Item 2", new BigDecimal("1.25"), 10));
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testWriteRecords() throws Exception {
		
		boolean result = itemDAO.writeRecords(items);
		
		assertTrue(result);
	}
	
	@Test
	void testReadRecords() throws Exception {
		
		itemDAO.writeRecords(items);
		LinkedList<Item> readItems = itemDAO.readRecords();
		assertNotNull(readItems);
	}

}
