package org.DesignPatternTemplate;

public abstract class Manufacturing {
	abstract void prepareParts();
	abstract void assembly();
	abstract void sell();

	// template method
	public final void produce() {

		// initialize the game
		prepareParts();

		// start game
		assembly();

		// end game
		sell();
	}
}
