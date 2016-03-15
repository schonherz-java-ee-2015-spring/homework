package hu.schonherz.java.training.hw.builder.material;

import static org.junit.Assert.*;

import org.junit.Test;

public class MetalTest {

	@Test
	public void testClothMaterial() {
		Material metal = new Metal();
		assertEquals(Metal.METAL, metal.material());
	}
}
