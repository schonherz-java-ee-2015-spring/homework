package hu.schonherz.java.training.hw2.creationalpattern;

// Because of the AbstractFactory, this class also violates the srp
/**
 * Class for creating {@link ZebraPen} or a {@link LintonPencil}
 * */
public class PenAndPencilFactory1 implements AbstractFactory {

	/**
	 * Creates a new {@link ZebraPen} object.
	 * @return A {@link ZebraPen} object.
	 * */
	@Override
	public Pen createPen() {
		return new ZebraPen();
	}

	/**
	 * Creates a new {@link LintonPencil} object.
	 * @return A {@link LintonPencil} object.
	 * */
	@Override
	public Pencil createPencil() {
		return new LintonPencil();
	}

}
