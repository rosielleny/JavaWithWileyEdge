package com.FlooringMastery.service;

import java.math.BigDecimal;
import java.util.LinkedList;

import com.FlooringMastery.dto.Product;

public interface ProductService {
	
	

	BigDecimal getCostPerSqFt(String productType);
	BigDecimal getLaborCostPerSqFt(String productType);
	
	public static LinkedList<Product> createProductMenu() {
		// TODO Auto-generated method stub
		return null;
	}
	LinkedList<Product> createProductChoice() throws Exception;
}