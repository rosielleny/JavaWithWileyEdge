package com.FlooringMastery.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.FlooringMastery.dto.Order;

public interface FlooringMasteryUserInterface
{
	public static boolean searchOrderNumber (int searchOrderNumberPrompt)
	{
		return false;
	}
	public boolean checkDate (int inputtedDate, List <Order> orders);
	public boolean viewOrders (List <Order> orders);
	public boolean searchAgain (String searchAgainPrompt, int searchOrderNumberPrompt, List<Order> orders);
	public void displayExitMessage (String exitMessagePrompt);
	public void displayErrorMessage (String errorMessagePrompt);
	void addOrder();
	

}