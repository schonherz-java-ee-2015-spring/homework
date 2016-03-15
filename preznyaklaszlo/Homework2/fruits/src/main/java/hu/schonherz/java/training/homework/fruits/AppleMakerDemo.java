package hu.schonherz.java.training.homework.fruits;

public class AppleMakerDemo {

	public static void main(String[] args) {
		Fruit goldenApple = new Apple(300, 25, new GoldenApple());
		Fruit alfristonApple = new Apple(425, 40, new AlfristonApple());

		System.out.println(goldenApple.name());
		System.out.println(alfristonApple.name());

	}

}
