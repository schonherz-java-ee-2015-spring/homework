package hu.schonherz.java.training.hw2.creationalpattern;

/**
 * Class for creating {@link ParkerPen} or a {@link AdelPencil}
 * */
public class PenAndPencilFactory2 implements AbstractFactory {

	/**
	 * Creates a new {@link ParkerPen} object.
	 * @return A {@link ParkerPen} object.
	 * */
	@Override
	public Pen createPen() {
		return new ParkerPen();
	}

	/**
	 * Creates a new {@link AdelPen} object.
	 * @return A {@link AdelPen} object.
	 * */
	@Override
	public Pencil createPencil() {
		return new AdelPencil();
	}

}
