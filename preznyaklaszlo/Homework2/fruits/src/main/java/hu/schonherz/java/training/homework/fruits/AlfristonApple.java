package hu.schonherz.java.training.homework.fruits;

//AlfristonApple class implements Eatable interface
public class AlfristonApple implements Eatable {

	@Override
	public String name() {
		return "Alfriston Apple";
	}

	@Override
	public boolean isItTasty() {
		return false;
	}

}
