package hu.schonherz.java.training.hw2.structuralpattern;

/**
 * Class to represent a Bed object.
 * */
public class Bed implements Sleepable {

	public Bed(){
		System.out.println("Prepare for sleep!");
	}
	
	/**
	 * Defines how to lay down an sleep in a {@link Bed}.
	 * */
	@Override
	public void layDownAndSleep() {
		System.out.println("Sleeping in 3...2...1... zzZzZzZzZZzz");
	}

}
