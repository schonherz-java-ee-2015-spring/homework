package hu.schonherz.java.training.hw2.structuralpattern;

/**
 * Proxy Structural Pattern.
 * This pattern's purpose is to create a layer between the client and
 * the object used by the client. In this way we can check and control
 * the usage of the object.
 * */
public class Main {
	
	/**
	 * The enter point of the program.
	 * */
	public static void main(String[] args) {
		BedProxy bp = new BedProxy();
		bp.layDownAndSleep();
		
		System.out.println();
		
		bp.layDownAndSleep();
	}
}
