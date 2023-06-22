package com.FlooringMastery.service;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import com.FlooringMastery.App;
import com.FlooringMastery.dao.OrderDaoImpl;
import com.FlooringMastery.dao.ProductDaoImpl;
import com.FlooringMastery.dto.*;

import jakarta.annotation.PostConstruct;
@Component
public class ProductServiceImpl implements ProductService {

	private ProductDaoImpl dao;
	
	public Map<String, Product> products;

	// Spring section
	public ProductServiceImpl(ProductDaoImpl dao){
		this.dao = dao;
	
	}
	
	@PostConstruct
    public void init() throws Exception {
        this.products = dao.loadAllProducts();
    }
	// End Spring section
	
	// Default constructor – useful in unit tests
	public ProductServiceImpl() {}
	

	@Override
	public BigDecimal getCostPerSqFt(String productType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getLaborCostPerSqFt(String productType) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<Product> createProductMenu() {

		// TODO Auto-generated method stub
		return null;
	}


	//Rosie
	/* Function will print a product menu and return a list
	 * whose indices will match the menu numbers -1. 
	 * This can then be used for the user to make their selection.
	 * Their choice is productChoiceList[input-1]
	 */
	@Override
	public LinkedList<Product> createProductChoice() throws Exception {

		StringBuilder buildMenu = new StringBuilder();
		LinkedList<Product> productChoiceList = new LinkedList();
		int num = 1;


		for (Map.Entry<String, Product> entry : products.entrySet()) { 
			String productType = entry.getKey();
			Product product = entry.getValue();
			buildMenu.append(num).append(". ").append(productType).append(" | $").append(product.getCostPerSqFt()).append(" p/sqft |").append(product.getLaborCostPerSqFt()).append(" in Labour Cost p/sqft\n"); 
			num++;
			productChoiceList.add(product);
		}

		// Concatenates everything into a String
		String menu = buildMenu.toString(); 
		System.out.println(menu);
		return productChoiceList;
	}

}
