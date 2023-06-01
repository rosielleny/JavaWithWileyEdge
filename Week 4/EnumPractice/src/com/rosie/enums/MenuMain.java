package com.rosie.enums;

public class MenuMain {

	public static void main(String[] args) {
		
		Menu menu;
		
		menu = Menu.PASTA;
		
		System.out.println("Customer ordered "+menu+ ". Vegeterian: "+ menu.getVeggie()+ ". Calories: " +menu.getKcals()+ ". Price: "+ menu.getPrice());

	}

}
