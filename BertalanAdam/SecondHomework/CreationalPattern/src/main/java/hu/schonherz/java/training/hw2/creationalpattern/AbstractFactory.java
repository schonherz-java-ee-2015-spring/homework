package hu.schonherz.java.training.hw2.creationalpattern;

// I think this functionality violates the Single Responsibility Principle
public interface AbstractFactory {
	Pen createPen();
	Pencil createPencil();
}
