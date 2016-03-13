package hu.schonherz.java.training.hw2.structuralpattern;

// Proxy Structural Pattern
public class Main {
	public static void main(String[] args) {
		BedProxy bp = new BedProxy();
		bp.layDownAndSleep();
		
		System.out.println();
		
		bp.layDownAndSleep();
	}
}
