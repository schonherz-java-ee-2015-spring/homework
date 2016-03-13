package hu.schonherz.java.training.hw2.creationalpattern;

public class AdelPencil extends Pencil {

	@Override
	public void draw() {
		System.out.println("Drawing with an AdelPencil.");
	}

	@Override
	public void sharpen(int sharpener) {
		System.out.println("Sharpening with the " + sharpener + ". type sharpener.");

	}

}
