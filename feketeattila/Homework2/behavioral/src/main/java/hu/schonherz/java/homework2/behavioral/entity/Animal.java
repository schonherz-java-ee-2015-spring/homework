package hu.schonherz.java.homework2.behavioral.entity;

import hu.schonherz.java.homework2.behavioral.ai.Ai;

/**
 * @author Atka
 *
 */
public class Animal {
	/**
	 * The AI of the animal
	 */
	private Ai ai;

	public Animal(Ai ai) {
		super();
		this.ai = ai;
	}

	public void look() {
		this.ai.lookCommand();
	}

	public void talk() {
		this.ai.talkCommand();
	}

	public void move() {
		this.ai.moveCommand();
	}
}
