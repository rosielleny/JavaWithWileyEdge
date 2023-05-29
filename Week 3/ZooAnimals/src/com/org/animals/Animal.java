package com.org.animals;

abstract public class Animal {
	
	String colour;
	double weight;
	int age;
	boolean climb;
	boolean vegetarian;
	
	public Animal(String colour, double weight, int age, boolean climb, boolean vegetarian) {
	    this.colour = colour;
	    this.weight = weight;
	    this.age = age;
	    this.climb = climb;
	    this.vegetarian = vegetarian;
	    }
	
	
	public boolean isClimb() {
		return climb;
	}

	public void setClimb(boolean climb) {
		this.climb = climb;
	}


	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}


	public String getColour() {
		return colour;
	}


	public double getWeight() {
		return weight;
	}


	public int getAge() {
		return age;
	}


	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isVegetarian() {
		return vegetarian;
	}


	abstract public void sound();

}
