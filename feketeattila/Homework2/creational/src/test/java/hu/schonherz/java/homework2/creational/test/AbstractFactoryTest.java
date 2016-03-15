package hu.schonherz.java.homework2.creational.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hu.schonherz.java.homework2.creational.factory.AbstractHeroFactory;
import hu.schonherz.java.homework2.creational.factory.StrengthHeroFactory;
import hu.schonherz.java.homework2.creational.product.Hero;

public class AbstractFactoryTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		AbstractHeroFactory testStrengthHeroFactory = new StrengthHeroFactory();
		Hero testHero = testStrengthHeroFactory.createHero("Test");
		String testHeroWelcomeText = testHero.welcomeText();
		String expectedWelcomeText = "My name is Test, and I'm a Strength hero.";
		assertEquals(testHeroWelcomeText, expectedWelcomeText);
	}

}
