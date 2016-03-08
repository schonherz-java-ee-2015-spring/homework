package hu.schonherz.java.training.hw.builder.part;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.material.Material;
import hu.schonherz.java.training.hw.builder.material.Metal;

public class ExpensiveEngineTest {

	@Test
	public void testName() {
		Part p = new ExpensiveEngine();
		assertThat(p, instanceOf(Part.class));
		assertThat(p, instanceOf(Engine.class));
		assertEquals("Expensive Engine", p.name());
	}

	@Test
	public void testPrice() {
		Part p = new ExpensiveEngine();
		assertEquals(String.valueOf(400.0f), String.valueOf(p.price()));
	}

	@Test
	public void testMaterial() {
		Part p = new ExpensiveEngine();
		assertNotNull(p.material());
		assertThat(p.material(), instanceOf(Material.class));
		assertThat(p.material(), instanceOf(Metal.class));
	}
}
