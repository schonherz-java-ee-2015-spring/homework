package hu.schonherz.java.training.hw2.structuralpattern;

public class Bed implements Sleepable {

	public Bed(){
		System.out.println("Prepare for sleep!");
	}
	
	@Override
	public void layDownAndSleep() {
		System.out.println("Sleeping in 3...2...1... zzZzZzZzZZzz");
	}

}
