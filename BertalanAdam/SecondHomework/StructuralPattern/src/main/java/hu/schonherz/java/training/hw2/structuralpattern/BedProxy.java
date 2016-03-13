package hu.schonherz.java.training.hw2.structuralpattern;

public class BedProxy implements Sleepable {

	private boolean homeworkIsDone = true;
	private Bed bed;

	@Override
	public void layDownAndSleep() {
		if (bed == null) {
			bed = new Bed();
		}
		if (homeworkIsDone) {
			bed.layDownAndSleep();
		}
	}

}
