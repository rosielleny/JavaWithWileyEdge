package com.org.animals;

public class Tiger extends Animal {
	
	public Tiger(String colour, double weight, int age) {
        super(colour, weight, age, true, false);
    }
	
	@Override
	public void sound() { 
		
		System.out.println("Growl");
	}
	

}