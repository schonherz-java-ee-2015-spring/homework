package hu.schonherz.java.training.hw2.creationalpattern;

public class Main {
	
	// Abstract Factory creational pattern.
	
	public static void main(String[] args) {
		AbstractFactory factory = FactoryMaker.getFactory('1');

		Pen myPen = factory.createPen();
		System.out.println(myPen.write());
		
		Pencil myPencil = factory.createPencil();
		myPencil.sharpen(1);
	}
}
