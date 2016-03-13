package hu.schonherz.java.training.hw2.creationalpattern;

public class ZebraPen extends Pen {

	@Override
	public String write() {
		return "Writing like a Zebra!";
	}

	@Override
	public void refillInk(int inkColor) {
		System.out.println("Ink refilled in a ZebraPen!" + inkColor);
	}

}
