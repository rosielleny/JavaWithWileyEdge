package com.rosie.tests;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.rosie.dataaccess.ItemDAOImpl;
import com.rosie.dto.Item;
import com.rosie.service.InventoryImpl;

import java.math.BigDecimal;
import java.util.LinkedList;

public class InventoryImplTest {

    private InventoryImpl inventory;
    private LinkedList<Item> items;
    private ItemDAOImpl dao;
    
    
    @Before
    public void setUp() throws Exception {
        inventory = new InventoryImpl();
        items = new LinkedList<>();
		items.add(new Item("Item 1", new BigDecimal("1.99"), 5));
		items.add(new Item("Item 2", new BigDecimal("1.25"), 10));
        
    }

    @Test
    public void testCheckInventory_WithAvailableItem_ShouldReturnTrue() throws Exception {
        Item availableItem = new Item("Item1", new BigDecimal(1.22), 10);
        assertTrue(inventory.checkInventory(availableItem));
    }

    @Test
    public void testCheckInventory_WithUnavailableItem_ShouldReturnFalse() throws Exception {
        Item unavailableItem = new Item("Item2", new BigDecimal(2.43), 0);
        assertFalse(inventory.checkInventory(unavailableItem));
    }

    @Test
    public void testReduceInventory_ShouldReduceItemCountByOne() throws Exception {
        Item item = new Item("Item3", new BigDecimal(1.10), 5);
        int initialItemCount = item.getInventoryCount();
        inventory.reduceInventory(item);
        assertEquals(initialItemCount - 1, item.getInventoryCount());
    }

    @Test
    public void testGetAllItems_ShouldReturnNonNullItemList() throws Exception {
        assertNotNull(items);
    }

}

