package hu.schonherz.java.training.hw.builder.part;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.material.Material;
import hu.schonherz.java.training.hw.builder.material.Wood;

public class LeatherSeatTest {

	@Test
	public void testName() {
		Part p = new WoodSeat();
		assertEquals("Wood Seat", p.name());
	}

	@Test
	public void testPrice() {
		Part p = new WoodSeat();
		assertEquals(String.valueOf(5.0f), String.valueOf(p.price()));
	}

	@Test
	public void testMaterial() {
		Part p = new WoodSeat();
		assertNotNull(p.material());
		assertThat(p.material(), instanceOf(Material.class));
		assertThat(p.material(), instanceOf(Wood.class));
	}
}
