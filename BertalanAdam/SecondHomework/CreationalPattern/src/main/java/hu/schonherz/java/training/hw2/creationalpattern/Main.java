package hu.schonherz.java.training.hw2.creationalpattern;
/**
 * Abstract Factory Creational Pattern.
 * The main thing about this pattern is that there is a Super Factory
 * (in my code it is the AbstractFactory) which creates other factories.
 * (PenAndPencilFactory1 and PenAndPencilFactory2) These sub-factories creates
 * different kind of objects for the client.
 * There is 4 different Items in my code: ParkerPen and ZebraPen which are Pens,
 * and LintonPencil and AdelPencil which are Pencils.
 *
 * There is also a FactoryMaker here, and it's purpose is to give back an
 * appropriate Factory. In this way you do not have to deal with the factories, just use them.
 */
public class Main {
	
	/**
	 * The code's enter point.
	 * */
	public static void main(String[] args) {
		// Our factory that will give us Objects
		AbstractFactory factory = FactoryMaker.getFactory('1');

		// Get a pen from the factory
		Pen myPen = factory.createPen();
		System.out.println(myPen.write());
		
		// Now get a pencil from the factory
		Pencil myPencil = factory.createPencil();
		System.out.println(myPencil.sharpen(1));
	}
}
