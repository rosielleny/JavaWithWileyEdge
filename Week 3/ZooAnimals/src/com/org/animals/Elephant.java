package com.org.animals;

public class Elephant extends Animal {
	
	public Elephant(String colour, double weight, int age) {
        super(colour, weight, age, false, true);
    }

	@Override
	public void sound() { // Overriding Animal
		
		System.out.println("Trumpet");
	}
	
	

}