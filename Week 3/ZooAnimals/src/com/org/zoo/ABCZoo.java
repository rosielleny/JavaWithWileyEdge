package com.org.zoo;

import com.org.animals.*;

public class ABCZoo {

	public static void main(String[] args) {
		
        Lion lion = new Lion("tawny", 200, 5);
        Tiger tiger = new Tiger("orange with black stripes", 180, 4);
        Deer deer = new Deer("brown", 120, 3);
        Monkey monkey = new Monkey("brown", 50, 2);
        Elephant elephant = new Elephant("grey", 4000, 10);
        Giraffe giraffe = new Giraffe("yellow with brown spots", 800, 6);

        System.out.print("\nLions "); 
        lion.sound();
        System.out.print("Tigers ");
        tiger.sound();
        System.out.print("Deer ");
        deer.sound();
        System.out.print("Monkeys ");
        monkey.sound();
        System.out.print("Elephants ");
        elephant.sound();
        System.out.print("Giraffes ");
        giraffe.sound();
        
        System.out.println("\nGiraffes are vegetarian: " + giraffe.isVegetarian());
        System.out.println("Elephants can climb: "+ elephant.isClimb());
        System.out.println("Tigers are vegetarian: "+ tiger.isVegetarian());
        System.out.println("Monkeys can climb: "+ monkey.isClimb());

        System.out.println("\nThe tiger is "+ tiger.getColour() + ", weighs " + tiger.getWeight() + "kg and is " + tiger.getAge() + " years old.");
	}

}
