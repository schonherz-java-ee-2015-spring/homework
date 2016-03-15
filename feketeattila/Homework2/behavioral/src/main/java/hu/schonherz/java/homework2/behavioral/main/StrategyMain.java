package hu.schonherz.java.homework2.behavioral.main;

import hu.schonherz.java.homework2.behavioral.ai.SnailAi;
import hu.schonherz.java.homework2.behavioral.ai.WolfAi;
import hu.schonherz.java.homework2.behavioral.entity.Animal;

/**
 * @author Atka
 *
 */
public class StrategyMain {

	public static void main(String[] args) {
		Animal testAnimal = new Animal(new WolfAi());
		// Our current test-animal is a wolf, let's test its functions
		testAnimal.look();
		testAnimal.talk();
		testAnimal.move();

		testAnimal = new Animal(new SnailAi());
		// Our current test-animal is a snail now, let's test its functions
		testAnimal.look();
		testAnimal.talk();
		testAnimal.move();
	}
}
