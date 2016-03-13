package hu.schonherz.java.training.hw2.creationalpattern;

public class ParkerPen extends Pen {

	@Override
	public String write() {
		return "Writing like a ParkerPen!";
	}

	@Override
	public void refillInk(int inkColor) {
		System.out.println("Ink refilled in a ParkerPen! Color: " + inkColor);

	}

}
