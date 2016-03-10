package hu.schonherz.java.training.hw.builder.material;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClothTest {

	@Test
	public void testClothMaterial() {
		Material cloth = new Cloth();
		assertEquals(Cloth.CLOTH, cloth.material());
	}
}
