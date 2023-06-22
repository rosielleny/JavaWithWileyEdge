package com.rosie.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;

import com.rosie.dataaccess.*;
import com.rosie.dto.Item;

public class InventoryImpl implements InventoryInterface {
	// Spring conversion
	LinkedList itemList;
	ItemDAOImpl dao; //= new ItemDAOImpl();
	AuditDAOImpl audit; //= new AuditDAOImpl();
	
	@Autowired
	public InventoryImpl(ItemDAOImpl dao, AuditDAOImpl audit) throws IOException {
		super();
		this.dao = dao;
		this.audit = audit;
		this.itemList = ItemDAOImpl.readRecords();
		
	}	
	// End Spring
	
	// Returns true or false based on if the item is in stock or not
	@Override
	public boolean checkInventory(Item item){
		
		if(item.getInventoryCount() > 0) {
			
			return true;
		}
		else {
		return false;
		}
	}

	// Removes 1 from the amount of items in Inventory
	@Override
	public void reduceInventory(Item item){
		
		item.setInventoryCount(item.getInventoryCount() - 1);

	}
	 
	
	@Override
	public LinkedList<Item> getAllItems(){
		
		return itemList;
		
	}
	
	// Passes the variables into the audit DAO to write the audit
	// Writes the Vending Machine Inventory records using itemList
	// Returns true if this is accomplished
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
