package com.org.animals;

public class Monkey extends Animal {
	
	public Monkey(String colour, double weight, int age) {
        super(colour, weight, age, true, false);
    }

	@Override
	public void sound() { // Overriding Animal
		
		System.out.println("Squeak/Grunt/Howl");
	}
	

}