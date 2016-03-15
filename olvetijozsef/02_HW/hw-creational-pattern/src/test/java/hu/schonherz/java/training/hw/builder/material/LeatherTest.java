package hu.schonherz.java.training.hw.builder.material;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeatherTest {

	@Test
	public void testClothMaterial() {
		Material leather = new Leather();
		assertEquals(Leather.LEATHER, leather.material());
	}
}
