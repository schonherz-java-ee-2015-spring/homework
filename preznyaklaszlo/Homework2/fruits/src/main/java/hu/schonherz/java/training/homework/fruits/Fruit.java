package hu.schonherz.java.training.homework.fruits;

//Fruit class is an abstract class which uses the Eatable interface
public abstract class Fruit {

	protected Eatable eatable;

	protected Fruit(Eatable eatable) {
		this.eatable = eatable;
	}

	public abstract String name();

	public abstract boolean isItTasty();

}
