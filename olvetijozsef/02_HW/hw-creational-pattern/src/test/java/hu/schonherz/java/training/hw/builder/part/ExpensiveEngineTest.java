package hu.schonherz.java.training.hw.builder.part;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import hu.schonherz.java.training.hw.builder.material.Material;
import hu.schonherz.java.training.hw.builder.material.Metal;

public class ExpensiveEngineTest {
	private static Part p = new ExpensiveEngine();

	@Test
	public void testName() {
		assertThat(p, instanceOf(Part.class));
		assertThat(p, instanceOf(Engine.class));
		assertEquals(ExpensiveEngine.EXPENSIVE_ENGINE, p.name());
	}

	@Test
	public void testPrice() {
		assertEquals(String.valueOf(400.0f), String.valueOf(p.price()));
	}

	@Test
	public void testMaterial() {
		assertNotNull(p.material());
		assertThat(p.material(), instanceOf(Material.class));
		assertThat(p.material(), instanceOf(Metal.class));
		assertEquals(Metal.METAL, p.material().material());
	}
}
