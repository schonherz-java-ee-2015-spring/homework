package hu.schonherz.java.training.hw.builder.part;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.material.Material;
import hu.schonherz.java.training.hw.builder.material.Wood;

public class WoodSeatTest {
	private static Part p = new WoodSeat();

	@Test
	public void testName() {
		assertEquals(WoodSeat.WOOD_SEAT, p.name());
	}

	@Test
	public void testPrice() {
		assertEquals(String.valueOf(5.0f), String.valueOf(p.price()));
	}

	@Test
	public void testMaterial() {
		assertNotNull(p.material());
		assertThat(p.material(), instanceOf(Material.class));
		assertThat(p.material(), instanceOf(Wood.class));
		assertEquals(Wood.WOOD, p.material().material());
	}
}
