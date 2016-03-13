package hu.schonherz.java.training.hw2.creationalpattern;

// Because of the AbstractFactory, this class also violates the srp
public class PenAndPencilFactory1 implements AbstractFactory {

	@Override
	public Pen createPen() {
		return new ZebraPen();
	}

	@Override
	public Pencil createPencil() {
		return new LintonPencil();
	}

}
