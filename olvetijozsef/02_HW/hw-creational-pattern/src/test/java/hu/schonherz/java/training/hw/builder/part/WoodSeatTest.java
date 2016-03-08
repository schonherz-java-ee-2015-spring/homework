package hu.schonherz.java.training.hw.builder.part;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.material.Leather;
import hu.schonherz.java.training.hw.builder.material.Material;

public class WoodSeatTest {

	@Test
	public void testName() {
		Part p = new LeatherSeat();
		assertEquals("Leather Seat", p.name());
	}

	@Test
	public void testPrice() {
		Part p = new LeatherSeat();
		assertEquals(String.valueOf(50.0f), String.valueOf(p.price()));
	}

	@Test
	public void testMaterial() {
		Part p = new LeatherSeat();
		assertNotNull(p.material());
		assertThat(p.material(), instanceOf(Material.class));
		assertThat(p.material(), instanceOf(Leather.class));
	}
}
