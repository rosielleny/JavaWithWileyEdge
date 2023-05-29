package com.rosie.shapes;

public class Circle implements Drawable, Fillable {

	@Override
	public void fillingColour() {
		System.out.println("Filling colour.");

	}

	@Override
	public void size() {
		System.out.println("Filling at this size.");

	}

	@Override
	public void drawingColour() {
		System.out.println("Drawing circle of this colour.");

	}

	@Override
	public void thickness() {
		System.out.println("Drawing circle at this thickness.");

	}

}
