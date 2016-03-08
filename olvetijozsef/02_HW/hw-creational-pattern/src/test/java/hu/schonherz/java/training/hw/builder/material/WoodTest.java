package hu.schonherz.java.training.hw.builder.material;

import static org.junit.Assert.*;

import org.junit.Test;

public class WoodTest {

	@Test
	public void testClothMaterial() {
		Material wood = new Wood();
		assertEquals("Wood", wood.material());
	}
}
