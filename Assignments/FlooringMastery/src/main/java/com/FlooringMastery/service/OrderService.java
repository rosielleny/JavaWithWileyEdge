package com.FlooringMastery.service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.FlooringMastery.dto.Order;

public interface OrderService {

    public boolean checkName(String name) throws DataValidationException;
	public boolean checkDate(LocalDate date)throws DataValidationException;
	public boolean checkArea(BigDecimal area)throws DataValidationException;
	
	public int findOrderNumber();
	

	void createNewOrder(Scanner scanner); //Maria: Not sure if void is correct
	void editOrder(int orderNumber);
	boolean deleteOrder(int orderNumber);
	LinkedList<Order> loadOrdersFromFile();
	void exportAllData() throws IOException; 
	void writeNewOrder(Order order);
	String createOrderSummary();

}