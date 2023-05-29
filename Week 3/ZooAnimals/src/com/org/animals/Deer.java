package com.org.animals;

public class Deer extends Animal {
	
	public Deer(String colour, double weight, int age) {
        super(colour, weight, age, false, true);
    }

	@Override
	public void sound() { // Overriding Animal
		
		System.out.println("Bleat");
	}

}