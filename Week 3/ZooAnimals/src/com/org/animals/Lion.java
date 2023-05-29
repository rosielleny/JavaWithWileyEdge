package com.org.animals;

public class Lion extends Animal {
	
	public Lion(String colour, double weight, int age) {
        super(colour, weight, age, true, false);
    }

	@Override
	public void sound() {
		
		System.out.println("Roar");
	}
	
}
