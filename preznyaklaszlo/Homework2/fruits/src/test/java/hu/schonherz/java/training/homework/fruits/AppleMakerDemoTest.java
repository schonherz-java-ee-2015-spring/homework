package hu.schonherz.java.training.homework.fruits;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppleMakerDemoTest {

	@Test
	public void GoldenAppleTest() {
		Fruit golden = new Apple(300, 30, new GoldenApple());
		assertEquals("Golden Apple", golden.name());
	}

	@Test
	public void AlfristonAppleTest() {
		Fruit alfriston = new Apple(200, 25, new AlfristonApple());
		assertEquals("Alfriston Apple", alfriston.name());
	}

}
