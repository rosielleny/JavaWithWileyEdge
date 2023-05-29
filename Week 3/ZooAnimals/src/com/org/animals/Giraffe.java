package com.org.animals;

public class Giraffe extends Animal {
	
	public Giraffe(String colour, double weight, int age) {
        super(colour, weight, age, false, true);
    }

	@Override
	public void sound() { // Overriding Animal
		
		System.out.println("Hum");
	}
	

}