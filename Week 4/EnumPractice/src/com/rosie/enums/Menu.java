package com.rosie.enums;

public enum Menu {

		PASTA(true, 700, 10.79), TOFU(true, 600, 9.65), CHICKEN(false, 800, 11.99), BEEF(false, 800, 12.00), PIE(true, 700, 10.78), ASPARAGUS(true, 500, 8.49);
	
	private boolean veggie;
	private int kcals;
	private double price;
	
	private Menu(boolean veggie, int kcals, double price) {
		
		this.veggie = veggie;
		this.kcals = kcals;
		this.price = price;
	}
	
	public boolean getVeggie() {
		
		return veggie;
	}

	public int getKcals() {
		return kcals;
	}

	public double getPrice() {
		return price;
	}
	
	
}
