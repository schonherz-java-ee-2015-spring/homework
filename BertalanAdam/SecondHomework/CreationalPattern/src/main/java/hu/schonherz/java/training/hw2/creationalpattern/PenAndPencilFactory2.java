package hu.schonherz.java.training.hw2.creationalpattern;

public class PenAndPencilFactory2 implements AbstractFactory {

	@Override
	public Pen createPen() {
		return new ParkerPen();
	}

	@Override
	public Pencil createPencil() {
		return new AdelPencil();
	}

}
