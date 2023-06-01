package com.rosie.ui;
import java.util.LinkedList;
import com.rosie.service.*;
import com.rosie.dto.Item;
import com.rosie.exceptions.InsufficientFundsException;
import com.rosie.exceptions.NoItemInventoryException;

import java.math.BigDecimal;
import java.util.Scanner;
import java.io.IOException;
public class UserInterfaceImpl implements UserInterface{
	
	private Change change = new Change();
	private LinkedList<Item> itemList;
	private InventoryImpl inventory;
	private boolean funds = false;
	private Scanner sc = new Scanner(System.in);
	private boolean rangeBool = false;
	private BigDecimal pennies;
	
	 public UserInterfaceImpl() {
	        try {
	            inventory = new InventoryImpl();
	            itemList = inventory.getAllItems();
	            
	            if(itemList == null) {
	            	throw new IOException("Couldn't read inventory. File may be missing or moved.");
	            }
	        } catch (IOException e) {
	        	
	        	System.out.println(e.getMessage());
	        	System.exit(0);
	        }
	    }
	
	@Override
	public void showMenu() {
		
		int key = 1;
		for(Item item: itemList) {
			
			if(item.getInventoryCount() < 1) {
				
				key++;
			}
			else{
				System.out.println(key + ". " + item.getName() + " $" + item.getPrice());
			key ++;
			}
		}
		System.out.println("0. Exit");
		

	}

	@Override
	public void performMenu(int choice, BigDecimal money) {
		
		// Performs actions if the choice is within range
		// Requests a different choice if choice not in range
		
		while(!rangeBool) {
			
			if(choice > 0 && choice <= itemList.size()) { 
				rangeBool = true;
				Item chosenItem = itemList.get(choice-1);
	
				try {
					while (!funds) {
						if (money.subtract(chosenItem.getPrice()).compareTo(BigDecimal.ZERO) < 0) {
							throw new InsufficientFundsException("Insufficient funds:");
						} else {
							funds = true;
						}
					}
				} catch (InsufficientFundsException e) {
					System.out.println(e.getMessage());
					System.out.println(money + "$");
					System.out.println("Options: ");
					System.out.println("1. Deposit more money.");
					System.out.println("0. Exit");
					int fundsChoice = sc.nextInt();
	
					switch (fundsChoice) {
					case 1:
						System.out.println("Deposit money $:");
						money = money.add(sc.nextBigDecimal());
						break;
					case 0:
						System.out.println("Goodbye");
						System.exit(0);
					}
				}
	
				try {
					if(inventory.checkInventory(chosenItem)) {
	
						inventory.reduceInventory(chosenItem);
	
						System.out.println("Please take your "+ chosenItem.getName() + " and your change.");
	
	
						pennies = change.calculateChangeInPennies(money, chosenItem);
	
						change.calculateChange(pennies);
	
						System.out.println("Change: "+ change.getQuarters() + " quarter/s, " + change.getDimes() + " dime/s, " + change.getNickles() + " nickle/s and "+ change.getPennies() + " penny/ies.");
						
						try {
							boolean save = inventory.saveRecords(chosenItem, money, pennies);
							if(save == false) {
								throw new IOException("Could not write to file. It may be missing or moved.");
							}
						} catch (IOException e) {
							System.out.println(e.getMessage());
							System.exit(0);
						}
	
					}
					else {
	
						throw new NoItemInventoryException("Out of stock."); 
					}}
				catch(NoItemInventoryException e) {
					System.out.println(e.getMessage());
					System.out.println("Please select a number from those in the menu:");
					
					choice = sc.nextInt();
					rangeBool = false;
	
				}
				
	
			}else if(choice == 0) {
				
				System.out.println("Goodbye");
				System.exit(0);
			}
			else {
	
				System.out.println("Please select a number from those in the menu:");
		
				choice = sc.nextInt();
			}
		}


	}


}

