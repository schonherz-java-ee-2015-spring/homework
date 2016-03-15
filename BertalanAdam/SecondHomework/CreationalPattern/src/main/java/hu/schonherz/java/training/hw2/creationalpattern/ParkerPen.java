package hu.schonherz.java.training.hw2.creationalpattern;

/**
 * A class for Parker type Pens.
 * */
public class ParkerPen extends Pen {

	/**
	 * Writes a {@link String}.
	 * @return The written {@link String} literal.
	 * */
	@Override
	public String write() {
		return "Writing like a ParkerPen!";
	}

	/**
	 * ParkerPen's implementation for refilling the ink.
	 * @param A color of the ink as an int.
	 * @return A message of the operation result.
	 * */
	@Override
	public String refillInk(int inkColor) throws NotAnInkException {
		if (inkColor > 10 || inkColor < 1) {
			throw new NotAnInkException();
		} else {
			return "Ink refilled in a ParkerPen! Color: " + inkColor;
		}

	}

}
