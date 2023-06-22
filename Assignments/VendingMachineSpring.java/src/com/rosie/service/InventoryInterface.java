package com.rosie.service;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import com.rosie.dataaccess.*;
import com.rosie.dto.Item;
import java.util.LinkedList;
import com.rosie.dto.Item; 
public interface InventoryInterface {
	
	public boolean checkInventory(Item item)throws Exception;
	public void reduceInventory(Item item)throws Exception;
	public LinkedList<Item> getAllItems() throws Exception;
	public boolean saveRecords(Item chosenItem, BigDecimal money, BigDecimal pennies) throws Exception;
	

}
