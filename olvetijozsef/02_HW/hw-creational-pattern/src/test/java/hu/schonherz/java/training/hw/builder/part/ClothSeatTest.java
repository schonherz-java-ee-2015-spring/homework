package hu.schonherz.java.training.hw.builder.part;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.material.Cloth;
import hu.schonherz.java.training.hw.builder.material.Material;

public class ClothSeatTest {
	private static Part p = new ClothSeat();

	@Test
	public void testName() {
		assertEquals(ClothSeat.CLOTH_SEAT, p.name());
	}

	@Test
	public void testPrice() {
		assertEquals(String.valueOf(25.0f), String.valueOf(p.price()));
	}

	@Test
	public void testMaterial() {
		assertNotNull(p.material());
		assertThat(p.material(), instanceOf(Material.class));
		assertThat(p.material(), instanceOf(Cloth.class));
		assertEquals(Cloth.CLOTH, p.material().material());
	}
}
