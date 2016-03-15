package hu.schonherz.java.training.hw.builder.part;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.material.Leather;
import hu.schonherz.java.training.hw.builder.material.Material;

public class LeatherSeatTest {
	private static Part p = new LeatherSeat();

	@Test
	public void testName() {
		assertEquals(LeatherSeat.LEATHER_SEAT, p.name());
	}

	@Test
	public void testPrice() {
		assertEquals(String.valueOf(50.0f), String.valueOf(p.price()));
	}

	@Test
	public void testMaterial() {
		assertNotNull(p.material());
		assertThat(p.material(), instanceOf(Material.class));
		assertThat(p.material(), instanceOf(Leather.class));
		assertEquals(Leather.LEATHER, p.material().material());
	}
}
