package com.rosie.ui;
import java.util.LinkedList;
import com.rosie.service.*;
import com.rosie.dto.Item;
import com.rosie.exceptions.InsufficientFundsException;
import com.rosie.exceptions.NoItemInventoryException;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("ui")
public class UserInterfaceImpl implements UserInterface{
	
	
	private LinkedList<Item> itemList;

	private boolean funds = false;
	private Scanner sc = new Scanner(System.in);
	private boolean rangeBool = false;
	private BigDecimal pennies;
	
	// Spring Conversion Code
	
	private InventoryImpl inventory;
	private Change change;
	@Autowired
	public void setInventoryImpl(InventoryImpl inventory, Change change) {
		this.inventory = inventory;
		this.change = change;
		this.itemList = inventory.getAllItems();
	}

	// Spring Conversion End
	
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
			
			/* If the choice is within range: 
			 * * We try checking that the money entered is more than zero when the item price is subtracted, throwing an insufficient funds error if it is not
			 * * We catch this error and offer options (Deposit more money or exit)
			 * * Once money passes the check, we proceed with purchase
			 * *
			 * * Now we check if the item is in stock
			 * * If it is in stock
			 * * * We reduce the inventory number by 1
			 * * * Return the change
			 * * * Save the changes to the inventory
			 * * Else we throw an out of stock error and ask them to pick something different
			 * Else if the choice is zero the program exits
			 * Else they have picked an invalid option and are asked to pick again
			 */
			
			if(choice > 0 && choice <= itemList.size()) { 
				rangeBool = true;
				Item chosenItem = itemList.get(choice-1);
	
				try { // Checking for sufficient funds
					while (!funds) {
						if (money.subtract(chosenItem.getPrice()).compareTo(BigDecimal.ZERO) < 0) {
							throw new InsufficientFundsException("Insufficient funds:");
						} else {
							funds = true;
						}
					}
					// In case of insufficient funds
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
	
				try { // If we have the item
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
					else { // If we don't have the item
	
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

