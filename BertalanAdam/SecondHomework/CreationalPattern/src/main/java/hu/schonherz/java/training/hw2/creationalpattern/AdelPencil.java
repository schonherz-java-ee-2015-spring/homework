package hu.schonherz.java.training.hw2.creationalpattern;

/**
 * A class for Adel Pencils.
 * */
public class AdelPencil extends Pencil {

	/**
	 * Draws a text.
	 * */
	@Override
	public void draw() {
		System.out.println("Drawing with an AdelPencil.");
	}
	
	/**
	 * Adel Pencil's implementation for sharpening.
	 * @param A sharpener type as an int.
	 * @return A message of the operation result.
	 * */
	@Override
	public String sharpen(int sharpener) throws NotSharpenerException{
		if (sharpener < 1) {
			throw new NotSharpenerException();
		} else {
			return "Sharpening with the " + sharpener + ". type sharpener.";
		}

	}
}
