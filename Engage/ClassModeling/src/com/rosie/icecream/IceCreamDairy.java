package com.rosie.icecream;

public class IceCreamDairy {
	
	 	private String flavour;
	    private String brand;
	    private int batchNumber;
	    private String ingredients;
	    private double price;
	    private String productionDate;
	    private String expirationDate;
	    private boolean isVegetarian;
	    private boolean isGlutenFree;
	    private String storageTemperature;
	    
	   
		public IceCreamDairy(String flavour, String brand, int batchNumber, String ingredients, double price,
				String productionDate, String expirationDate, boolean isVegetarian, boolean isGlutenFree,
				String storageTemperature) {
			super();
			this.flavour = flavour;
			this.brand = brand;
			this.batchNumber = batchNumber;
			this.ingredients = ingredients;
			this.price = price;
			this.productionDate = productionDate;
			this.expirationDate = expirationDate;
			this.isVegetarian = isVegetarian;
			this.isGlutenFree = isGlutenFree;
			this.storageTemperature = storageTemperature;
		}
		
		public String getFlavour() {
			return flavour;
		}
		public void setFlavor(String flavour) {
			this.flavour = flavour;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public int getBatchNumber() {
			return batchNumber;
		}
		public void setBatchNumber(int batchNumber) {
			this.batchNumber = batchNumber;
		}
		public String getIngredients() {
			return ingredients;
		}
		public void setIngredients(String ingredients) {
			this.ingredients = ingredients;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getProductionDate() {
			return productionDate;
		}
		public void setProductionDate(String productionDate) {
			this.productionDate = productionDate;
		}
		public String getExpirationDate() {
			return expirationDate;
		}
		public void setExpirationDate(String expirationDate) {
			this.expirationDate = expirationDate;
		}
		public boolean isVegetarian() {
			return isVegetarian;
		}
		public void setVegetarian(boolean isVegetarian) {
			this.isVegetarian = isVegetarian;
		}
		public boolean isGlutenFree() {
			return isGlutenFree;
		}
		public void setGlutenFree(boolean isGlutenFree) {
			this.isGlutenFree = isGlutenFree;
		}
		public String getStorageTemperature() {
			return storageTemperature;
		}
		public void setStorageTemperature(String storageTemperature) {
			this.storageTemperature = storageTemperature;
		}
	    
	    

}
