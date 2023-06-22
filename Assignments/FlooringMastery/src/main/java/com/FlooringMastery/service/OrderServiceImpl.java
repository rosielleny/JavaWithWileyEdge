package com.FlooringMastery.service;

import com.FlooringMastery.dto.Order;
import com.FlooringMastery.dao.OrderDaoImpl;
import com.FlooringMastery.ui.UserIOConsoleImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {
	
	private OrderDaoImpl dao;
	private TaxServiceImpl tax;
	
	// Spring section
	public OrderServiceImpl(OrderDaoImpl dao, TaxServiceImpl tax) {
		this.dao = dao;
		this.tax = tax;
	}
	// End spring section
	
	// Default constructor, useful in unit tests
	public OrderServiceImpl() {};
	
	public LocalDate date; // Used by findOrderNumber
	public LinkedList<Order> oneOrderDay; // Variable in which to store a list of orders from 1 day only
	
	@Override
	public String createOrderSummary() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void createNewOrder(Scanner scanner) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void editOrder(int orderNumber) {
		/*
		 * Create an instance of UserIOConsoleImpl
		 * Need to delete with SpringDependency
		 */
	    UserIOConsoleImpl userIO = new UserIOConsoleImpl();

	    // Get user input for date
	    LocalDate date = userIO.readDate("Enter date (DD-MM-YYYY): ");

	    try {
	        // Retrieve the order based on the provided date and order number
	        LinkedList<Order> orders = dao.getSingleFile(date);
	        Order order = null;

	        for (Order o : orders) {
	            if (o.getOrderNumber() == orderNumber) {
	                order = o;
	                break;
	            }
	        }

	        if (order == null) {
	            userIO.print("Order not found.");
	            return;
	        }

	        // Display the existing order data
	        userIO.print("Existing order data:");
//	        displayOrder(order);
//	        dao.getSingleFile(order);
//	        Maria: not sure which function to use here to display the Order...

	        // Prompt for editing each editable field
	        userIO.print("Enter new data for each field. Press Enter to leave the data unchanged.");

	        // Edit customer name
	        userIO.print("Customer name (" + order.getCustomerName() + "): ");
	        String customerName = userIO.readString("");
	        if (!customerName.isEmpty()) {
	            if (checkName(customerName)) {
	                order.setCustomerName(customerName);
	            } else {
	                userIO.print("Invalid customer name. Changes not saved.");
	                return;
	            }
	        }

	        // Edit state 
	        userIO.print("State (" + order.getState() + "): ");
	        String state = userIO.readString("");
	        if (!state.isEmpty()) {
	            if (tax.checkState(state)) {
	                order.setState(state);
	                order.calculateOrder(); // Recalculate order if state changes  
	            } else {
	                userIO.print("Invalid state. Changes not saved.");
	                return;
	            }
	        }

	        // Edit product type
	        userIO.print("Product type (" + order.getProductType() + "): ");
	        String productType = userIO.readString("");
	        if (!productType.isEmpty()) {
	            if (checkProductType(productType)) {
	                order.setProductType(productType);
	                order.calculateOrder(); // Recalculate order if product type changes
	            } else {
	                userIO.print("Invalid product type. Changes not saved.");
	                return;
	            }
	        }

	        // Edit area
	        userIO.print("Area (" + order.getArea() + "): ");
	        String area = userIO.readString("");
	        if (!area.isEmpty()) {
	            try {
	                BigDecimal areaValue = new BigDecimal(area);
	                if (checkArea(areaValue)) {
	                    order.setArea(areaValue);
	                    order.calculateOrder(); // Recalculate order if area changes
	                } else {
	                    userIO.print("Invalid area. Changes not saved.");
	                    return;
	                }
	            } catch (NumberFormatException e) {
	                userIO.print("Invalid area format. Changes not saved.");
	                return;
	            }
	        }

	        // Display the new order data
	        userIO.print("\nUpdated order data:");
	        displayOrder(order);

	        // Prompt for saving the changes
	        userIO.print("Save changes (yes/no): ");
	        String saveChanges = userIO.readString("");

	        if (saveChanges.equalsIgnoreCase("yes")) {
	            // Save the updated order data
	            dao.saveOrder(order);
	            userIO.print("Changes saved.");
	        } else {
	            userIO.print("Changes not saved.");
	        }
	    } catch (FileNotFoundException e) {
	        userIO.print("Order file not found for the provided date.");
	    } catch (DataValidationException e) {
	        userIO.print(e.getMessage());
	        userIO.print("Changes not saved.");
	    }
	}


	@Override
	public boolean deleteOrder(int orderNumber) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public LinkedList<Order> loadOrdersFromFile() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void exportAllData() throws IOException {
		dao.exportDataToFile();
	}
	
	// Rosie's Section
	
	/* Function to interact with the writeOder function of the DAO layer
	 */
	@Override
	public void writeNewOrder(Order order) {
		date = LocalDate.now();
		String filePath = "Orders/"; 
		try {
			dao.writeOrder(filePath, date, order);
		} catch (Exception e) {
			
			System.out.println("Order could not be saved.");
			return;
		}
	}
	@Override
	/* The following method is used when adding an order to check that the user
	 * has entered a valid Customer Name */
	public boolean checkName(String name) throws DataValidationException{

		// Defining which characters are allowed using regex
		String allowedCharacters = "[^a-zA-Z0-9., ]";

		// The name field is not allowed to be null, so Exception will be thrown if it is
		if(name == null) {
			throw new DataValidationException("Field cannot be empty. Please try again."); 
		}
		// The name field is not allowed any characters that are not a-z, 0-9, or commas and full stops
		// This will throw an error if that is the case
		else if(name.matches(".*" + allowedCharacters + ".*")) {

			throw new DataValidationException("Name must only contain alphabetical characters, numerical characters, full stops, and/or commas. ");
		}
		// If the else block is reached, then the inputed name must contain only allowed characters and not be null
		// Only then will this method return true, signalling to the UI that
		else {
			return true;
		}
	}
	@Override
	/* The following method is used when adding an order to check that the user
	 * has entered a valid delivery date */
	public boolean checkDate(LocalDate date) throws DataValidationException{

		// The date is valid if it is in the future, so first we get the current date

		LocalDate currentDate = LocalDate.now(); 

		// If the user-entered date is after today's date, it is valid and we return true
		if(date.isAfter(currentDate)) {
			return true;
		}
		// Else an Exception is thrown
		else {
			throw new DataValidationException("Date must be in the future.");
		}
	}

	/* The following method is used when adding an order to check that the user
	 * has entered a valid area */
	@Override
	public boolean checkArea(BigDecimal area) throws DataValidationException{

		// There is a minimum area of 100, so if the user's area is >= 100, return true
		if(area.compareTo(new BigDecimal("100")) >= 0) {
			return true;
		}
		// Otherwise, if their entered area is less than 100 but still >= 0, they have not met the minimum area
		else if(area.compareTo(BigDecimal.ZERO) >= 0) {

			throw new DataValidationException("Area must be a minimum of 100sqft.");
		}

		/*If this else clause is being activated, then they have probably entered a negative number
		 * This has a separate error in case the '-' symbol was a mistake and they are under the impression
		 * that their number is greater than 100 */
		else {
			throw new DataValidationException("Area cannot be a negative number.");
		}
	}


	/* The following method is used to assign an order number to a new order
	 * has entered a valid area */
	@Override
    public int findOrderNumber() {
		
        date = LocalDate.now();
        int maxi = 0; // counter to keep track of the maximum order number (which could be different from the length of the list)
        try {
        	oneOrderDay = dao.getSingleFile(date); // Seeing if there is a file with today's date to be found
        	
        	for(Order order: oneOrderDay) {
        		
        		int num = order.getOrderNumber();
        		
        		if(num > maxi) {
        			maxi = num; // Updating maxi with num if num is greater
        		}
        	}
        	
        	return maxi + 1; // The order number for the new order will be the maximum of the already existing numbers, plus 1
        }
        catch(FileNotFoundException e){
        	
        	return 1; // If the file is not found, then this is the first order of the day, so it is order number 1
        	
        }
	}
	// End Rosie's Section
        
   

}
