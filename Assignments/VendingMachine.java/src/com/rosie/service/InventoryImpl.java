package com.rosie.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import com.rosie.dataaccess.*;
import com.rosie.dto.Item;

public class InventoryImpl implements InventoryInterface {
	
	LinkedList itemList;
	ItemDAOImpl dao = new ItemDAOImpl();
	AuditDAOImpl audit = new AuditDAOImpl();
	
	public InventoryImpl() throws IOException{ // Initialises the itemList by reading records from the data access layer
			
		itemList = dao.readRecords();
		
	}

	@Override
	public boolean checkInventory(Item item){
		
		if(item.getInventoryCount() > 0) {
			
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public void reduceInventory(Item item){
		
		item.setInventoryCount(item.getInventoryCount() - 1);

	}
	 
	@Override
	public LinkedList<Item> getAllItems(){
		
		return itemList;
		
	}
	
	
	@Override
	public boolean saveRecords(Item chosenItem, BigDecimal money, BigDecimal pennies) throws IOException{
		 
		if(audit.writeRecords(chosenItem, money, pennies) && dao.writeRecords(itemList)) {
			return true;
		}
		else {
			return false;
		}
	}

}
