package hu.schonherz.java.training.hw.builder.part;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.material.Material;
import hu.schonherz.java.training.hw.builder.material.Metal;

public class CheapEngineTest {

	@Test
	public void testName() {
		Part p = new CheapEngine();
		assertThat(p, instanceOf(Part.class));
		assertThat(p, instanceOf(Engine.class));
		assertEquals("Cheap Engine", p.name());
	}

	@Test
	public void testPrice() {
		Part p = new CheapEngine();
		assertEquals(String.valueOf(100.0f), String.valueOf(p.price()));
	}

	@Test
	public void testMaterial() {
		Part p = new CheapEngine();
		assertNotNull(p.material());
		assertThat(p.material(), instanceOf(Material.class));
		assertThat(p.material(), instanceOf(Metal.class));
	}
}
