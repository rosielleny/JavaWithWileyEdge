package com.rosie.dto;

import java.math.BigDecimal;

public class Item{
	
	private String name;
	private BigDecimal price;
	private int inventoryCount;
	
	
	public Item(String name, BigDecimal price, int inventoryCount) {
		this.name = name;
		this.price = price;
		this.inventoryCount = inventoryCount;
	
	}
	
	public Item() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getInventoryCount() {
		return inventoryCount;
	}
	public void setInventoryCount(int inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

	

}
