package com.FlooringMastery.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.FlooringMastery.App;
import com.FlooringMastery.dto.Order;
import com.FlooringMastery.dto.Product;
import com.FlooringMastery.service.*;
import com.FlooringMastery.ui.UserIO;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

@Component
public class FlooringMasteryUserInterfaceImpl implements FlooringMasteryUserInterface
{

	private boolean valid, exitToMainMenu;
	private BigDecimal taxRate, costPerSqFt, labourCostPerSqFt;

	// Spring dependency injections
	private UserIOConsoleImpl io;
	private OrderServiceImpl orderService;
	private ProductServiceImpl productService;
	private TaxServiceImpl taxService;

	public FlooringMasteryUserInterfaceImpl(UserIOConsoleImpl io, OrderServiceImpl orderService, ProductServiceImpl productService, TaxServiceImpl taxService) {
		this.io = io;
		this.orderService = orderService;
		this.productService = productService;
		this.taxService = taxService;
	}


	public boolean searchOrderNumber(int searchOrderNumberPrompt, List<Order> orders)
	{
		Scanner scanner = new Scanner(System.in);
		boolean validInput = false;

		while (!validInput)
		{
			System.out.print("Enter the Order Number (MMDDYYYY): ");
			String orderNumberString = scanner.nextLine();

			if (orderNumberString.matches("\\d{8}")) {
				int orderNumber = Integer.parseInt(orderNumberString);
				return checkDate(orderNumber, orders);
			} else {
				displayErrorMessage("Invalid input. Order Number must be in MMDDYYYY format.");
			}
		}
		return false;
	}

	public boolean checkDate(int inputtedDate, List<Order> orders)
	{
		boolean found = false;

		for (Order order : orders)
		{
			if (order.getOrderNumber() == inputtedDate) {
				found = true;
				viewOrders(orders);
				break;
			}
		}

		if (!found) {
			System.out.println("No Orders Found.");
			displayExitMessage(" ");
		}

		return found;
	}

	public boolean viewOrders(List<Order> orders)
	{
		if (!orders.isEmpty()) {
			for (Order order : orders) {
				System.out.println("Order Number: " + order.getOrderNumber());
				System.out.println("Customer Name: " + order.getCustomerName());
				System.out.println("State: " + order.getState());
				System.out.println("Tax Rate: " + order.getTaxRate());
				System.out.println("Product Type: " + order.getProductType());
				System.out.println("Area: " + order.getArea());
				System.out.println("Cost Per Square Foot: " + order.getCostPerSqFt());
				System.out.println("Labor Cost Per Square Foot: " + order.getLaborCostPerSqFt());
				System.out.println("Material Cost: " + order.getMaterialCost());
				System.out.println("Labor Cost: " + order.getLaborCost());
				System.out.println("Tax: " + order.getTax());
				System.out.println("Total: " + order.getTotal());
				System.out.println();
			}

			return searchAgain(null, 0, orders);
		}

		return false;
	}


	public boolean searchAgain(String searchAgainPrompt, int searchOrderNumberPrompt, List<Order> orders)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Would You Like to Search Again? (Y/N)");
		String userInput = scanner.nextLine();

		if (userInput.equalsIgnoreCase("Y")) {
			return searchOrderNumber(searchOrderNumberPrompt, orders);
		} else if (userInput.equalsIgnoreCase("N")) {
			displayExitMessage(" ");
			return false;
		} else {
			displayErrorMessage(" ");
			return searchAgain(searchAgainPrompt, searchOrderNumberPrompt, orders);
		}
	}

	public void displayExitMessage(String exitMessagePrompt)
	{
		System.out.println("Returning to the Main Menu...");
		System.out.println(" ");
		App.performMainMenu();
	}

	public void displayErrorMessage(String errorMessagePrompt)
	{
		System.out.println(" ");
		System.out.println("Invalid Input. Please Enter Again.");
		System.out.println(" ");

	}

	/* Function for building an Order object.
	 * Calls all the functions beneath it (All Get and Validate functions, and performProductMenu).
	 * Displays an order summary using toString.
	 * Asks the user if they want to place the order, feeds the Order to a write function if yes
	 */
	@Override
	public void addOrder() {

		// Assembling the order object

		LocalDate deliveryDate = getDateAndValidate(); // Assigns deliveryDate based on user input
		String name = getNameAndValidate(); // Assigns customer name based on user input
		String state = getStateAndValidate(); // Assigns state based on user input, and taxRate based on state

		if(exitToMainMenu) { // In the getStateAndValidate function it is possible for the user to choose return to the main menu
			return;
		}

		String productType = performProductMenu(); // Assigns productType based on user choice, and costPerSqFt and labourCostPerSqFt based on productType
		BigDecimal area = getAreaAndValidate();

		if(exitToMainMenu) { // In the getAreaAndValidate function it is possible for the user to choose return to the main menu
			return; 
		}

		int orderNum = orderService.findOrderNumber();

		Order newOrder = new Order(orderNum, deliveryDate, name, state, productType, taxRate, costPerSqFt, labourCostPerSqFt, area);

		// Confirming placement of order
		valid = false;
		System.out.println(newOrder.toString());
		while(!valid) {
			String place = io.readString("Would you like to place the order? y/n)");

			if(place.equalsIgnoreCase("y") || place.equalsIgnoreCase("yes")){

				orderService.writeNewOrder(newOrder);  // Writing order to today's file
				valid = true;

			}
			else if(place.equalsIgnoreCase("n") || place.equalsIgnoreCase("no")){
				valid = true;
				return;
			}
			else {
				System.out.println("Input not recognised, please try again.");
			}

		}

	}

	/* Function to take the date input from the user, call the checkDate function from service
	 * to ensure it fulfils the requirements, and finally return the value for deliverDate
	 */

	private LocalDate getDateAndValidate() {

		LocalDate deliveryDate = null;
		valid = false; // Boolean to handle the validity of the entered date (must be in the future)
		boolean dateValid = false; // Boolean to handle the validity of the date format
		
		while(!valid) { // Loop will exit when the input has passed the checks

			while(!dateValid) { // Will loop until format is correct
				try {
					String dateString = io.readString("Enter the day the work will take place MM/dd/yyyy:");
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
					deliveryDate = LocalDate.parse(dateString, formatter); 
					dateValid = true; // If we are able to parse the date, the date format is valid

				}catch(DateTimeParseException e){

					System.out.println("Entered date must match the MM/dd/yyyy format.");

				}
			}
			// Try/catch for input validation, checkDate() will throw errors if the input is invalid
			try {

				valid = orderService.checkDate(deliveryDate);

			}catch(DataValidationException e){
				dateValid = false;
				System.out.println(e.getMessage());
			}
		}

		return deliveryDate; // Returning a validated date
	}

	/* Function to take customer name input from the user and check it meets requirements
	 * using the checkName() function from the service layer
	 */
	private String getNameAndValidate() {

		String name = null;
		valid = false;

		while(!valid) { // Loop will exit when the input has passed the checks

			name = io.readString("Enter customer name: ");

			// Try/catch for input validation, checkName() will throw errors if the input is invalid
			try { 

				valid = orderService.checkName(name);

			}catch(DataValidationException e){

				System.out.println(e.getMessage());
			}
		}

		return name;
	}
	
	/* Function to take state input from the user and check it meets requirements
	 * using the checkState() function from the service layer
	 * If the state is valid, findTaxRate() is called from the service layer to
	 * use the state to set taxRate
	 * Before returning, assignStateValue() is used to ensure the state is in a suitable
	 * format for writing to the file: eg. California, ca, cA, CaLifornia will all be changed to CA
	 */
	private String getStateAndValidate() {

		String state = null;
		valid = false;

		while(!valid) {


			state = io.readString("Enter US State: ");

			// Try/Catch for input validation, checkState() will throw an error if the State is not valid
			try {
				valid = taxService.checkState(state);

			}catch(DataValidationException e){

				System.out.println(e.getMessage());
			}

			if(valid) { // If the check passed and validState is true
				taxRate = taxService.findTaxRate(state); // Use it to assign taxRate
			}else {

				handleInvalidState();
			}
		}

		return taxService.assignStateValue(state);
	}

	/* Called by the getStateAndValidate function to handle the menu and choices
	 * for the case in which the user has input an invalid State
	 */
	private void handleInvalidState() {

		int invalidStateChoice = io.readInt("1. Enter a different State \n0. Exit to main menu");
		switch(invalidStateChoice) {
		case 1:
			break;
		case 0:
			/* An option to exit is given as if the user has entered a real state but 
			 * we cannot work there (not in tax file), they may want to cancel the order entry
			 */
			exitToMainMenu = true; // Once we return to the addOrder function, this will be checked for
			valid = true; // Allows immediate exit of the getStateAndValidate function
			break;
		default: 
			System.out.println("Please choose an option from the menu.");
		}

	}


	/* Function to take the area input from the user and ensure it passes validation
	 * checks carried out in checkArea(): not negative, greater than or equal to 100
	 */
	private BigDecimal getAreaAndValidate() {

		BigDecimal area = null;
		valid = false;
		
		/* While loop will continue until a valid area has been entered unless the 
		 * user chooses to quit in the handleInvalidArea() function
		 */
		while(!valid) { 


			area = io.readBigDecimal("Enter the area to be covered in square feet:"); 

			try {

				valid = orderService.checkArea(area); 

			}catch(DataValidationException e){

				System.out.println(e.getMessage());

			}

			if(!valid) {
				handleInvalidArea();
			}
		}

		return area;
	}

	/* Called by the getAreaAndValidate function to handle the menu and choices
	 * for the case in which the user has input an invalid area
	 */
	private void handleInvalidArea() {

		int invalidAreaChoice = io.readInt("1. Enter a different area \n0. Exit to main menu");
		switch(invalidAreaChoice) {

		case 1:
			break;
		case 0:
			/* An option to exit is given as if the user has entered the intended area but 
			 * we cannot make the order because it is under 100. In this case they may want to 
			 * cancel the order entry.
			 */
			exitToMainMenu = true; // Will be checked for upon return to addOrder()
			valid = true; // Exits the while loop in getAreaAndValidate()
			break;
		default: 
			System.out.println("Please choose an option from the menu.");
		}

	}

	/* Shows the product menu and  takes a choice of product from the user.
	 * Uses the product choice to assign variables to productType, costPerSqFt
	 * and labourCostPerSqFt
	 */
	private String performProductMenu() {
		valid = false;
		String productType = "";
		Scanner scanner = new Scanner(System.in);
		LinkedList<Product> productChoiceList = null;
		Product chosenProduct = null;

		while(!valid) {

			try {
				productChoiceList = productService.createProductChoice(); 

			} catch (Exception e) {

				System.out.println(e.getMessage());

			}
			int choice = io.readInt("Enter your choice:");


			try { // Assigning productType
				chosenProduct = productChoiceList.get(choice -1); 
				productType = chosenProduct.getProductType();
				valid = true;

			}catch(IndexOutOfBoundsException e) {

				System.out.println("Please choose an option from the menu.");
			}

			if(valid) { // If we have productType, we can assign costPerSqFt and labourCostPerSqFt
				
				costPerSqFt = chosenProduct.getCostPerSqFt();
				labourCostPerSqFt = chosenProduct.getLaborCostPerSqFt();
			}
		}

		return productType;
	}
}

