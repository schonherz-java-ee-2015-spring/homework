package hu.schonherz.java.training.hw.builder.part;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.material.Cloth;
import hu.schonherz.java.training.hw.builder.material.Material;

public class ClothSeatTest {

	@Test
	public void testName() {
		Part p = new ClothSeat();
		assertEquals("Cloth Seat", p.name());
	}

	@Test
	public void testPrice() {
		Part p = new ClothSeat();
		assertEquals(String.valueOf(25.0f), String.valueOf(p.price()));
	}

	@Test
	public void testMaterial() {
		Part p = new ClothSeat();
		assertNotNull(p.material());
		assertThat(p.material(), instanceOf(Material.class));
		assertThat(p.material(), instanceOf(Cloth.class));
	}
}
