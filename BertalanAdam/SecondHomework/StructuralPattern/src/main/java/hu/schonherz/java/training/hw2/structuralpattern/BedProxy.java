package hu.schonherz.java.training.hw2.structuralpattern;

/**
 * Class to check and control the usage of a {@link Bed}.
 * */
public class BedProxy implements Sleepable {

	private boolean homeworkIsDone = true;
	private Bed bed;

	/**
	 * Defines how to lay down an sleep in a {@link Bed}.
	 * */
	@Override
	public void layDownAndSleep() {
		if (bed == null) {
			bed = new Bed();
		} else {
			if (homeworkIsDone) {
				bed.layDownAndSleep();
			}
		}
	}

}
